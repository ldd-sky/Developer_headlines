package com.example.developer_headlines.entity;


/**
 * @ClassName EquipmentInfo
 * @Description 设备信息类
 * @Author liuyuhan
 * @Date 2024/4/28 19:12
 * @Version 1.0
 **/
public class EquipmentInfo {
    int screenWidth;
    int screenHeight;

    public EquipmentInfo(){ };

    public EquipmentInfo(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }
}
