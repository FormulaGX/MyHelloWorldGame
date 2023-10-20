package GamePKG.entity;

import java.util.Random;

import GamePKG.graphics.Screen;
import GamePKG.level.Level;
import GamePKG.level.RandomLevel;

public abstract class Entity {
	public int x,y;
	private boolean removed=false;
	protected Level level;
	protected final Random random=new Random();
	public Screen screen;
	
	public void update(){
		
	}
	public void render(Screen screen){
		
	}
	public void remove(){
		removed=true;
	}
	public boolean isRemoved(){
		return removed;
	}
	public void init(Level level){
		this.level=level;
	}
}
