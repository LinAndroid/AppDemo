package com.app.developframework.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 注：在android6.0以后获取到文件访问权限才能操作
 */
public class ShareUtils {
    /**
     * 分享文字
     *
     * @param context
     * @param title
     * @param content
     */
    public static void shareText(Context context, String title, String content) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, content);
        shareIntent.setType("text/plain");
        //设置标题（弹出分享列表的界面标题），
        context.startActivity(Intent.createChooser(shareIntent, title));
    }

    /**
     * 分享一张图片
     *
     * @param context
     */
    public void shareSingleImage(Context context, String imagePath, String title) {
        File file = new File(imagePath);
        if (!file.exists()) return;
        //由文件得到uri
        Uri imageUri = Uri.fromFile(new File(imagePath));  //imagePath--本地的文件路径
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/*");
        context.startActivity(Intent.createChooser(shareIntent, title));
    }

    //分享多张图片（保存一个集合）
    public void shareMultipleImage(Context context, List<String> imagePaths, String title) {
        ArrayList<Uri> uriList = new ArrayList<>();
        if (imagePaths == null || imagePaths.size() == 0) return;
        for (String imagePath : imagePaths) {
            if (new File(imagePath).exists()) {
                uriList.add(Uri.parse(imagePath));
            }
        }
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
        shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uriList);
        shareIntent.setType("image/*");
        context.startActivity(Intent.createChooser(shareIntent, "分享到："));
    }

    /**
     * 分享文件
     *
     * @param context
     * @param filePath
     * @param title
     */
    public void shareFile(Context context, String filePath, String title) {
        File file = new File(filePath);
        if (!file.exists()) return;
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM,
                Uri.fromFile(new File(filePath)));
        shareIntent.setType("*/*");//此处可发送多种文件
        context.startActivity(Intent.createChooser(shareIntent, title));
    }
}
