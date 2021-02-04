package com.app.developframework.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class IntentUtils {
    /**
     * 获取当前设备安装的应用商店列表
     *
     * @param context
     * @return
     */
    public List<String> getInstallAppMarkets(Context context) {
        List<String> pkgInstallList = new ArrayList<String>();
        if (context == null)
            return pkgInstallList;
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.APP_MARKET");
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> infos = pm.queryIntentActivities(intent, 0);
        int count = infos.size();
        if (infos == null || count == 0)
            return pkgInstallList;
        for (int i = 0; i < count; i++) {
            String pkgName = "";
            try {
                ActivityInfo activityInfo = infos.get(i).activityInfo;
                pkgName = activityInfo.packageName;
            } catch (Exception ex) {

            }
            if (!TextUtils.isEmpty(pkgName)) {
                pkgInstallList.add(pkgName);
            }
        }
        return pkgInstallList;
    }

    /**
     * 跳转应用市场详情
     *
     * @param context
     * @param marketPkg
     */
    public void appDetail(Context context, String marketPkg) {
        try {
            Uri uri = Uri.parse("market://detail?id=" + context.getPackageName());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            if (!TextUtils.isEmpty(marketPkg))
                intent.setPackage(marketPkg);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception ex) {
        }
    }
}
