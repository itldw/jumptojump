package com.itldw.uitl;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageHelper {

	/**
	 * 计算两个物体间距离
	 * 
	 * @param path
	 * @return
	 */
	public static void getLengthFromImage(String path) {

		int[] rgb = getColorFromImagePosition(new Point(10, 10), path);

	    Point point=	getCenterPoint(rgb, path);

	}

	private static int[] getColorFromImagePosition(Point p, String path) {

		File file = new File(path);

		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int[] rgb = new int[3];
		int pixel = bi.getRGB(10, 10); // 下面三行代码将一个数字转换为RGB数字
		rgb[0] = (pixel & 0xff0000) >> 16;
		rgb[1] = (pixel & 0xff00) >> 8;
		rgb[2] = (pixel & 0xff);
		System.out.println("i=" + 10 + ",j=" + 10 + ":(" + rgb[0] + "," + rgb[1] + "," + rgb[2] + ")");

		return rgb;
	}

	private static Point getCenterPoint(int[] rgb, String path) {

		Point point = null;
		File file = new File(path);

		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int width = bi.getWidth();
		int height = bi.getHeight();
		
		for (int i = 0; i < width; i++) {
			for (int j =100; j < height; j++) {
				int pixel = bi.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字
				int r = (pixel & 0xff0000) >> 16;
				int g = (pixel & 0xff00) >> 8;
				int b = (pixel & 0xff);
				
				if(r!=rgb[0]&&g!=rgb[1]&&b!=rgb[2]) {
					
					System.out.println(r+" "+g+" "+b);
				}
			}
		}
		return point;
	}

}
