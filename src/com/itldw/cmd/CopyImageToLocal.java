package com.itldw.cmd;

import com.itldw.uitl.AdbCommandOpretion;

/**
 * 复制手机图片到本地电脑
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
	 * 返回复制到本地电脑命令
	 * @param path 本地路径
	 * @return
	 */
	public void setCopyStr(String path) {
		
		cmd=String.format(AdbCommandOpretion.SCREENTOLOCAL, path);
	}
	
}
