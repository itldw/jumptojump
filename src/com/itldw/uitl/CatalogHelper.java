package com.itldw.uitl;

import java.io.File;

/**
 * 目录工具类
 * @author 
 *
 */
public  class CatalogHelper {

	/**
	 * 返回当前bin目录
	 * @return
	 */
	 public static String getWorkDirectory() {
		 
		 return CatalogHelper.class.getResource("/").getPath().replaceFirst("/", "");
	 }
}
