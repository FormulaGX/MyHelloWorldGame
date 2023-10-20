package GamePKG.level.tile;

import GamePKG.graphics.Screen;
import GamePKG.graphics.Sprite;

public class VoidTile extends Tile {
	
	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	public void render(int x,int y,Screen screen){
		screen.renderTile(x<<4, y<<4, this);
	}
	public boolean solid(){
		return true;
	}
}
