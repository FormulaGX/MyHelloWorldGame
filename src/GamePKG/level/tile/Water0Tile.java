package GamePKG.level.tile;

import GamePKG.graphics.Screen;
import GamePKG.graphics.Sprite;

public class Water0Tile extends Tile {
	public Water0Tile() {
		sprite=Sprite.water0P0;
	}
	public void render(int x,int y,Screen screen){
		screen.renderTile(x<<4, y<<4, this);
	}
	public boolean solid(){
		return true;
	}
}
