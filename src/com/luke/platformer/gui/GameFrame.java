package com.luke.platformer.gui;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 640;
	
	public GameFrame(GamePanel gamePanel){
		
		this.setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - WIDTH)/2),
						((int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() - HEIGHT)/2));
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Game Shell");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.add(gamePanel);
		gamePanel.grabFocus();
		gamePanel.requestFocusInWindow();
	}
	
}
