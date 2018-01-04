package com.itldw.uitl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Windows 进程工具类
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		runtime=null;
		return sb.toString();

	}
}
