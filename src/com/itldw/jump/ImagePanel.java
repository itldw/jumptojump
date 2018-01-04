package com.itldw.jump;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.itldw.uitl.CatalogHelper;

public class ImagePanel extends JPanel {
    Image image=null;
    
    public void paint(Graphics g){
        try {
        	
        	String path=CatalogHelper.getWorkDirectory()+"tyt.png";
        	
            image=ImageIO.read(new File(path));
            g.drawImage(image, 0, 0, 340, 550,0,0,1080,1920, null);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
