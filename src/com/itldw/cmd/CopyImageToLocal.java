package com.itldw.cmd;

import com.itldw.uitl.AdbCommandOpretion;

/**
 * �����ֻ�ͼƬ�����ص���
 * @author 
 *
 */
public class CopyImageToLocal extends Command {

	
	private  String cmd;
	@Override
	protected String getCmdStr() {
		// TODO Auto-generated method stub
		return cmd;
	}

	
	/**
	 * ���ظ��Ƶ����ص�������
	 * @param path ����·��
	 * @return
	 */
	public void setCopyStr(String path) {
		
		cmd=String.format(AdbCommandOpretion.SCREENTOLOCAL, path);
	}
	
}
