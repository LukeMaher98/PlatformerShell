package com.luke.platformer.gui;

import java.awt.*;
import javax.swing.*;
import com.luke.platformer.logic.*;

public class GamePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private KeyboardController keyboardController;
	private StatsPanel statsPanel = new StatsPanel();
	private PlayPanel playPanel = new PlayPanel();
	@SuppressWarnings("unused")
	private Entity entity;
	
	public GamePanel() {
		
		this.setRequestFocusEnabled(true);
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.add(statsPanel);
		statsPanel.setLocation(0, 0);
		this.add(playPanel);
		playPanel.setLocation(0, StatsPanel.STATS_HEIGHT);
		keyboardController = new KeyboardController();
		this.addKeyListener(keyboardController);
		
	}
	
	public void addEntity(Entity entity) {
		
		this.entity = entity;
		playPanel.addEntity(entity);
		
	}
	
	public void repaintGame() {
		
		playPanel.repaint();
		
	}
	
}
