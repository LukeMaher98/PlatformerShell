package com.luke.platformer.intermediary;

import com.luke.platformer.gui.*;

public class Main {

	public static void main(String[] args) {
		
		GamePanel gamePanel = new GamePanel();
		GameManager gameManager = new GameManager(gamePanel);
		gameManager.start();
		GameFrame gameFrame = new GameFrame(gamePanel);
		
	}
	
}
