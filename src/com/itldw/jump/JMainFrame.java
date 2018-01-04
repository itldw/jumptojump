package com.itldw.jump;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itldw.cmd.Command;
import com.itldw.cmd.ConnectionCommand;
import com.itldw.cmd.CopyImageToLocal;
import com.itldw.cmd.ScreenSizeCommand;
import com.itldw.cmd.ScreenshotCommand;
import com.itldw.cmd.SwipeCommand;
import com.itldw.uitl.CatalogHelper;
import com.itldw.uitl.ImageHelper;
import com.itldw.uitl.ProcessHelper;

import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.Font;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class JMainFrame {

	// adb目录
	private static final String ADB_DIRECTORY = "platform-tools-latest-windows\\platform-tools";

	private JFrame frame;
	
	//
	private int xSize;
	
	private int ySize;
	ImagePanel panel = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMainFrame window = new JMainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JMainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u8DF3\u4E00\u8DF3");
		frame.setBounds(100, 100, 575, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Button button = new Button("\u8FDE\u63A5");
		Button button_1 = new Button("\u5F00\u59CB");

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Command command = new ConnectionCommand();

				String result = command.excuteCmd();

				if (result.trim().endsWith("device")) {

					

					Command sizeCommand=new ScreenSizeCommand();
					String sizeResult=sizeCommand.excuteCmd();
					
					
					String tmp=sizeResult.split(":")[1].trim();
					
					xSize=Integer.parseInt((tmp.split("x")[0]));
					ySize=Integer.parseInt((tmp.split("x")[1]));
					
					System.out.println(xSize);
					button.setEnabled(false);
					button_1.setEnabled(true);
					JOptionPane.showMessageDialog(null, "手机已连接请打开跳一跳后执行开始！", "连接成功", JOptionPane.YES_OPTION);
				} else {
					System.out.println("连接手机失败...");
					JOptionPane.showMessageDialog(null, "手机未连接请连接您的手机！", "连接错误", JOptionPane.YES_OPTION);

				}

			}
		});

		button.setBounds(442, 35, 76, 23);
		frame.getContentPane().add(button);

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				loadImgeFromWeixin();
			}
		});
		button_1.setEnabled(false);
		button_1.setBounds(442, 83, 76, 23);
		frame.getContentPane().add(button_1);

		panel=new ImagePanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 10, 350, 550);
		frame.getContentPane().add(panel);
		panel.revalidate();
		panel.addMouseListener(new MouseListener() {
			int bx = 0;
			int by = 0;

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y = e.getY();

				float bscreenX = xSize / 350;
				float bscrenny = ySize / 550;

				int xl = (int) (Math.abs(x - bx) * bscreenX);
				int xy = (int) (Math.abs(y - by) * bscrenny);

				// 获取距离
				int length = (int) Math.sqrt(xl * xl + xy * xy);

				// 获取按下时间

				int downSpanTime = (int) (length / (0.7));
				System.out.println(downSpanTime);

				SwipeCommand sc = new SwipeCommand();
				sc.setSubCmdStr(String.valueOf(downSpanTime));
				sc.excuteCmd();
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				loadImgeFromWeixin();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				bx = e.getX();
				by = e.getY();

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}
	
	private void loadImgeFromWeixin() {
		Command command = new ScreenshotCommand();

		command.excuteCmd();

		CopyImageToLocal localCommand = new CopyImageToLocal();
		localCommand.setCopyStr(CatalogHelper.getWorkDirectory());
		localCommand.excuteCmd();

		panel.repaint();
		
		
	}
}
