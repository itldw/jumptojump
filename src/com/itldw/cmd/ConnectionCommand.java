package com.itldw.cmd;

import com.itldw.uitl.AdbCommandOpretion;

/**
 * �����ֻ�
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
