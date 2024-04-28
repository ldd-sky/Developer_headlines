package com.example.developer_headlines.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

import com.example.developer_headlines.entity.EquipmentInfo;

/**
 * @ClassName EquipmentInfoUtil
 * @Description 获取设备信息的工具类
 * @Author liuyuhan
 * @Date 2024/4/28 19:10
 * @Version 1.0
 **/
public class EquipmentInfoUtil {

    private EquipmentInfo getScreenSize(Activity context) {
        EquipmentInfo equipmentInfo = new EquipmentInfo();
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        equipmentInfo.setScreenHeight(dm.heightPixels);
        equipmentInfo.setScreenWidth(dm.widthPixels);
        return equipmentInfo;
    }
}
