package com.itldw.cmd;

import com.itldw.uitl.CatalogHelper;
import com.itldw.uitl.ProcessHelper;

public abstract class Command {

	  //adb路径
	  private final static String  EXE_PATH="\\platform-tools-latest-windows\\platform-tools\\adb.exe";
	
	  /**
	   * 获取cmd命令
	   * @return adb shell
	   */
	  protected  abstract String getCmdStr(); 
	
	  
	  /**
	   * 执行adb shell 命令
	   * @return
	   */
	  public  String excuteCmd() {
		  
		  //获取命令 格式：...adb.exe cmdStr
		  String cmdStr=getExcutePath()+" "+getCmdStr();
		  
		  System.out.println(cmdStr);
		  return  ProcessHelper.processComand(cmdStr);
		  
		
	  }
	  
	  /**
	   * 获取adb执行目录
	   * @return
	   */
	  private static String getExcutePath() {
		  
		  String dir=CatalogHelper.getWorkDirectory();
		  
		  
		  return dir+EXE_PATH;
	  }
	  
}
