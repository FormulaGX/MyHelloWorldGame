package GamePKG.level.tile;

import GamePKG.graphics.Screen;
import GamePKG.graphics.Sprite;

public class Tile {
	public int x,y;
	public Sprite sprite;
	
	//voids
	public static Tile voidTile=new VoidTile(Sprite.voidSprite);
	//barriers
	//clay
	public static Tile clayWall0=new ClayWall0Tile(Sprite.clayWall0);
	public static Tile clayWall1=new ClayWall0Tile(Sprite.clayWall1);
	public static Tile clayWall2=new ClayWall0Tile(Sprite.clayWall2);
	public static Tile clayWall3=new ClayWall0Tile(Sprite.clayWall3);
	public static Tile clayWall4=new ClayWall0Tile(Sprite.clayWall4);
	public static Tile clayWall5=new ClayWall0Tile(Sprite.clayWall5);
	public static Tile clayWall6=new ClayWall0Tile(Sprite.clayWall6);
	public static Tile clayWall7=new ClayWall0Tile(Sprite.clayWall7);
	//grasses
	public static Tile grass=new GrassTile(Sprite.grass);
	public static Tile flowers0=new Flowers0Tile(Sprite.flowers0);
	public static Tile flowers1=new Flowers1Tile(Sprite.flowers1);
	public static Tile rocks0_grass=new Rocks0Tile(Sprite.rocks0_grass);
	public static Tile rocks1_grass=new Rocks1Tile(Sprite.rocks1_grass);
	public static Tile pebbles0_grass=new pebbles0Tile(Sprite.pebbles0_grass);
	//dirt
	public static Tile dirt=new DirtTile(Sprite.dirt);
	//water
	public static Tile water0=new Water0Tile();
	
	public static final int col_grass=0xff007C00;
	public static final int col_flowers0=0xff147C00;
	public static final int col_flowers1=0xff287C00;
	public static final int col_rocks0_grass=0xff567532;
	public static final int col_rocks1_grass=0xff667753;
	public static final int col_pebbles0_grass=0xff5D7A3F;
	public static final int col_clayWall0=0xffE1AA6D;
	public static final int col_clayWall1=0xffE0A94A;
	public static final int col_dirt=0xff2D1200;
	
	public Tile (Sprite sprite){
		this.sprite=sprite;
	}
	public Tile(){
		
	}
	public void render(int x,int y,Screen screen){
		
	}
	public boolean solid(){
		return false;
	}
	public boolean breakable(){
		return false;
	}
	public boolean liquid(){
		return false;
	}
	public boolean deep_liquid(){
		return false;
	}
}
