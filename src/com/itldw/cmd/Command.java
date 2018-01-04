package com.itldw.cmd;

import com.itldw.uitl.CatalogHelper;
import com.itldw.uitl.ProcessHelper;

public abstract class Command {

	  //adb·��
	  private final static String  EXE_PATH="\\platform-tools-latest-windows\\platform-tools\\adb.exe";
	
	  /**
	   * ��ȡcmd����
	   * @return adb shell
	   */
	  protected  abstract String getCmdStr(); 
	
	  
	  /**
	   * ִ��adb shell ����
	   * @return
	   */
	  public  String excuteCmd() {
		  
		  //��ȡ���� ��ʽ��...adb.exe cmdStr
		  String cmdStr=getExcutePath()+" "+getCmdStr();
		  
		  System.out.println(cmdStr);
		  return  ProcessHelper.processComand(cmdStr);
		  
		
	  }
	  
	  /**
	   * ��ȡadbִ��Ŀ¼
	   * @return
	   */
	  private static String getExcutePath() {
		  
		  String dir=CatalogHelper.getWorkDirectory();
		  
		  
		  return dir+EXE_PATH;
	  }
	  
}
