package com.itldw.cmd;

import com.itldw.uitl.AdbCommandOpretion;

/**
 * 连接手机
 * @author 
 *
 */
public class ConnectionCommand extends Command{

	@Override
	protected String getCmdStr() {
		// TODO Auto-generated method stub
		return AdbCommandOpretion.DEVICES;
	}

}
