package com.luke.platformer.intermediary;

import java.util.HashSet;
import java.awt.event.KeyEvent;
import com.luke.platformer.gui.*;
import com.luke.platformer.logic.*;

public class GameManager extends Thread {
	
	private boolean gameIsRunning;
	private GamePanel gamePanel;
	private static final int MAIN_SLEEP_TIME = 21;
	private Entity entity;
	
	public GameManager(GamePanel gamePanel) {
		
		this.entity = new Entity();
		this.gamePanel = gamePanel;
		this.gamePanel.addEntity(entity);
		this.gameIsRunning = true;
		
	}
	
	@Override
	public void run() {
		
		while(gameIsRunning) {
			manageKeys();
			gamePanel.repaintGame();
			try {
				Thread.sleep(MAIN_SLEEP_TIME);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void manageKeys() {
		
		HashSet<Integer> currentKeys = KeyboardController.getActiveKeys();
		entity.checkState();
		if(currentKeys.contains(KeyEvent.VK_D)) {
			entity.move(KeyEvent.VK_D);
		}
		else if(currentKeys.contains(KeyEvent.VK_A)) {
			entity.move(KeyEvent.VK_A);
		}
		else if(currentKeys.isEmpty()) {
			entity.stop();
		}
		
		if(currentKeys.contains(KeyEvent.VK_SPACE)) {
			if(!entity.getJumping()) {
				entity.jump();
			}
		}
		
	}
	
	public Entity getEntity() {
		
		return entity;
		
	}	

}

