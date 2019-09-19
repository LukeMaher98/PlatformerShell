package com.luke.platformer.logic;

import com.luke.platformer.gui.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Entity {
	
	private int last_direction = KeyEvent.VK_D;
	private static final int MOVE_COUNTER_THRESH = 5;
	private int moveCounter = 0;
	private Rectangle boundingBox;
	private static final int  DISPLACEMENT = 10;
	private BufferedImage currentFrame;
	private static final int BUFFER_RUN_SIZE = 6;
	private BufferedImage idle_R;
	private BufferedImage idle_L;
	private BufferedImage[] run_R;
	private BufferedImage[] run_L;
	private int currentFrameNumber;
	private static final int ENTITY_START_X = 128;
	private final int ENTITY_HEIGHT = 64;
	private final int ENTITY_WIDTH = 40;
	private int currentX = ENTITY_START_X;
	private int currentY = GameFrame.HEIGHT - PlayPanel.TERRAIN_HEIGHT - ENTITY_HEIGHT;
	private int jump_count = 0;
	private boolean jumping;
	
	public Entity() {
		
		run_L = new BufferedImage[BUFFER_RUN_SIZE];
		run_R = new BufferedImage[BUFFER_RUN_SIZE];
		loadInformation();
		currentFrame = idle_R;
		boundingBox = new Rectangle(currentX, currentY, ENTITY_WIDTH, ENTITY_HEIGHT);
	
	}
	
	public void loadInformation() {
		
		try {
			idle_R = ImageIO.read(getClass().getResource("/images/idle_R.png"));
			idle_L = ImageIO.read(getClass().getResource("/images/idle_R.png"));
			run_R[0] = ImageIO.read(getClass().getResource("/images/run_R0.png"));
			run_L[0] = ImageIO.read(getClass().getResource("/images/run_L0.png"));
			run_R[1] = ImageIO.read(getClass().getResource("/images/run_R1.png"));
			run_L[1] = ImageIO.read(getClass().getResource("/images/run_L1.png"));
			run_R[2] = ImageIO.read(getClass().getResource("/images/run_R2.png"));
			run_L[2] = ImageIO.read(getClass().getResource("/images/run_L2.png"));
			run_R[3] = ImageIO.read(getClass().getResource("/images/run_R3.png"));
			run_L[3] = ImageIO.read(getClass().getResource("/images/run_L3.png"));
			run_R[4] = ImageIO.read(getClass().getResource("/images/run_R4.png"));
			run_L[4] = ImageIO.read(getClass().getResource("/images/run_L4.png"));
			run_R[5] = ImageIO.read(getClass().getResource("/images/run_R5.png"));
			run_L[5] = ImageIO.read(getClass().getResource("/images/run_L5.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void move(int direction) {
			
		switch(direction) {
		case KeyEvent.VK_D:
			currentX = currentX + DISPLACEMENT;
			boundingBox.setLocation(currentX, currentY);
			setFrameNumber();
			currentFrame = run_R[currentFrameNumber];
			last_direction = KeyEvent.VK_D;
			break;
		case KeyEvent.VK_A:
			currentX = currentX - DISPLACEMENT;
			boundingBox.setLocation(currentX, currentY);
			setFrameNumber();
			currentFrame = run_L[currentFrameNumber];
			last_direction = KeyEvent.VK_A;
			break;
		default:
			break;
		}
		moveCounter++;
		
	}
	
	public void checkState() {
		
		if(jumping) {
			if(jump_count < 20) {
				currentY -= 15;
				boundingBox.setLocation(currentX, currentY);
			}
			else {
				currentY += 15;
				boundingBox.setLocation(currentX, currentY);
			}
			jump_count++;
			if(jump_count >= 40) {
				jumping = false;
				jump_count = 0;
			}
		}
		
	}

	public void setFrameNumber() {
		
		if(moveCounter >= 0 && moveCounter <= MOVE_COUNTER_THRESH*1 ) {
			currentFrameNumber = 0;
		}
		else if(moveCounter > MOVE_COUNTER_THRESH*1 && moveCounter <= MOVE_COUNTER_THRESH*2){
			currentFrameNumber=1;
		} 
		else if(moveCounter > MOVE_COUNTER_THRESH*2 && moveCounter <= MOVE_COUNTER_THRESH*3){
			currentFrameNumber=2;
		} 
		else if(moveCounter > MOVE_COUNTER_THRESH*3 && moveCounter <= MOVE_COUNTER_THRESH*4){
			currentFrameNumber=3;
		} 
		else if(moveCounter > MOVE_COUNTER_THRESH*4 && moveCounter <= MOVE_COUNTER_THRESH*5){
			currentFrameNumber=4;
		} 
		else if(moveCounter > MOVE_COUNTER_THRESH*5 && moveCounter <= MOVE_COUNTER_THRESH*6){
			currentFrameNumber=5;
		} 
		
		if(moveCounter > MOVE_COUNTER_THRESH*6) {
			moveCounter = 0;
		}
		
	}
	
	public void jump() {
		
		this.jumping = true;
		this.jump_count = 0;
		
	}
	
	public boolean getJumping() {
		
		return jumping;
		
	}

	public BufferedImage getCurrentFrame() {
		
		return currentFrame;
		
	}
	
	public int getCurrentX() {
		
		return currentX;
		
	}
	
	public int getCurrentY() {
		
		return currentY;
		
	}
	
	public Rectangle getBoundingBox() {
		
		return boundingBox;
		
	}
	
	public void stop() {
		
		if(last_direction == KeyEvent.VK_D) {
			currentFrame = idle_R;
		}
		else {
			currentFrame = idle_L;
		}
		
	}
	
}
