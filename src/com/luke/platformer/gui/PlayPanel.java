package com.luke.platformer.gui;

import com.luke.platformer.logic.*;
import java.awt.*;
import javax.swing.*;

public class PlayPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public static final int TERRAIN_HEIGHT = 192;
	public static final int PLAY_PANEL_HEIGHT = 640;
	private Entity entity;
	
	public PlayPanel() {
		
		this.setSize(GameFrame.WIDTH, PLAY_PANEL_HEIGHT);
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		this.setDoubleBuffered(true);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(int i = 0; i < 20; i++) {
			g2.drawLine(0, i*64, GameFrame.WIDTH, i*64);
			g2.drawLine(i*64, 0, i*64, GameFrame.HEIGHT);
		}
		g2.drawImage(entity.getCurrentFrame(), entity.getCurrentX(), entity.getCurrentY(), null);
		
	}
	
	public void addEntity(Entity entity) {
		
		this.entity = entity;
		
	}
	
	

}
