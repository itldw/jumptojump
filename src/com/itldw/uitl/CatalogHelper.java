package com.itldw.uitl;

import java.io.File;

/**
 * Ŀ¼������
 * @author 
 *
 */
public  class CatalogHelper {

	/**
	 * ���ص�ǰbinĿ¼
	 * @return
	 */
	 public static String getWorkDirectory() {
		 
		 return CatalogHelper.class.getResource("/").getPath().replaceFirst("/", "");
	 }
}
