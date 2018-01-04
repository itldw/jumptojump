package com.itldw.uitl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Windows ���̹�����
 * 
 * @author
 *
 */
public class ProcessHelper {

	public static String processComand(String command) {

		String line = null;
		StringBuilder sb = new StringBuilder();
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec(command);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line + "\n");

			}
			
			process.destroy();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		runtime=null;
		return sb.toString();

	}
}
