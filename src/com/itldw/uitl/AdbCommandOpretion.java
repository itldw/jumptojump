package com.itldw.uitl;

/**
 * adb ����ָ��
 * 
 * @author
 *
 */
public class AdbCommandOpretion {

	// ��ʾ��ǰ�����豸�б�
	public final static String DEVICES = "devices";

	// �ֻ�����
	public final static String SCREENCAP = "shell /system/bin/screencap -p /sdcard/tyt.png";

	// ���ֻ�ͼƬ���Ƶ����ص���
	public final static String SCREENTOLOCAL = "pull /sdcard/tyt.png  %styt.png";

	// ģ�ⰴ��
	public final static String SWIPE = "shell input swipe 300 300 300 300 %s";

	// ��ȡ�ֻ��ֱ���
	public final static String SIZE = "shell wm size";
}
