package com.itldw.cmd;

import com.itldw.uitl.AdbCommandOpretion;

public class SwipeCommand  extends Command{

	
	private  String cmd;
	@Override
	protected String getCmdStr() {
		// TODO Auto-generated method stub
		return cmd;
	}

	/**
	 * Ä£Äâ°´ÏÂ
	 * @param path ºÁÃë
	 * @return
	 */
	public void setSubCmdStr(String milTime) {
		
		cmd=String.format(AdbCommandOpretion.SWIPE, milTime);
	}
}
