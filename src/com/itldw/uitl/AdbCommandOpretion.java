package com.itldw.uitl;

/**
 * adb 操作指令
 * 
 * @author
 *
 */
public class AdbCommandOpretion {

	// 显示当前连接设备列表
	public final static String DEVICES = "devices";

	// 手机截屏
	public final static String SCREENCAP = "shell /system/bin/screencap -p /sdcard/tyt.png";

	// 将手机图片复制到本地电脑
	public final static String SCREENTOLOCAL = "pull /sdcard/tyt.png  %styt.png";

	// 模拟按下
	public final static String SWIPE = "shell input swipe 300 300 300 300 %s";

	// 获取手机分辨率
	public final static String SIZE = "shell wm size";
}
