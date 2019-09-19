package com.luke.platformer.gui;

import java.awt.*;
import javax.swing.*;

public class StatsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static final int STATS_HEIGHT = 40;
	
	public StatsPanel() {
		
		this.setSize(GameFrame.WIDTH, STATS_HEIGHT);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
	}
	
}
