package GamePKG.graphics;

public class Sprite {
	public final int SIZE;
	private int x,y;
	private int width,height;
	public int[] pixels;
	private SpriteSheet sheet;
	
	//Tiles:
	//voids
	public static Sprite voidSprite=new Sprite(18,0x1b87e0);
	//barriers
	//clay
	public static Sprite clayWall0=new Sprite(16,7,3,SpriteSheet.tiles);
	public static Sprite clayWall1=new Sprite(16,0,3,SpriteSheet.tiles);
	public static Sprite clayWall2=new Sprite(16,1,3,SpriteSheet.tiles);
	public static Sprite clayWall3=new Sprite(16,2,3,SpriteSheet.tiles);
	public static Sprite clayWall4=new Sprite(16,3,3,SpriteSheet.tiles);
	public static Sprite clayWall5=new Sprite(16,4,3,SpriteSheet.tiles);
	public static Sprite clayWall6=new Sprite(16,5,3,SpriteSheet.tiles);
	public static Sprite clayWall7=new Sprite(16,6,3,SpriteSheet.tiles);
	//grasses
	public static Sprite grass=new Sprite(16,0,0,SpriteSheet.tiles);
	public static Sprite flowers0=new Sprite(16,1,0,SpriteSheet.tiles);
	public static Sprite flowers1=new Sprite(16,2,0,SpriteSheet.tiles);
	public static Sprite rocks0_grass=new Sprite(16,3,0,SpriteSheet.tiles);
	public static Sprite rocks1_grass=new Sprite(16,4,0,SpriteSheet.tiles);
	public static Sprite pebbles0_grass=new Sprite(16,5,0,SpriteSheet.tiles);
	//dirt
	public static Sprite dirt=new Sprite(16,0,1,SpriteSheet.tiles);
	//water
	public static Sprite water0P0=new Sprite(16,0,2,SpriteSheet.tiles);
	public static Sprite water0P1=new Sprite(16,1,2,SpriteSheet.tiles);
	public static Sprite water0P2=new Sprite(16,2,2,SpriteSheet.tiles);
	
	//Mobs
	//Player
	public static Sprite playerNorth0=new Sprite(16,0,0,SpriteSheet.player);
	public static Sprite playerNorth1=new Sprite(16,1,0,SpriteSheet.player);
	public static Sprite playerNorth2=new Sprite(16,2,0,SpriteSheet.player);
	
	public static Sprite playerEast0=new Sprite(16,0,1,SpriteSheet.player);
	public static Sprite playerEast1=new Sprite(16,1,1,SpriteSheet.player);
	public static Sprite playerEast2=new Sprite(16,2,1,SpriteSheet.player);
	
	public static Sprite playerSouth0=new Sprite(16,0,2,SpriteSheet.player);
	public static Sprite playerSouth1=new Sprite(16,1,2,SpriteSheet.player);
	public static Sprite playerSouth2=new Sprite(16,2,2,SpriteSheet.player);
	
	public static Sprite playerWest0=new Sprite(16,0,3,SpriteSheet.player);
	public static Sprite playerWest1=new Sprite(16,1,3,SpriteSheet.player);
	public static Sprite playerWest2=new Sprite(16,2,3,SpriteSheet.player);
	
	public static Sprite playerNorthEast0=new Sprite(16,0,5,SpriteSheet.player);
	public static Sprite playerNorthEast1=new Sprite(16,1,5,SpriteSheet.player);
	public static Sprite playerNorthEast2=new Sprite(16,2,5,SpriteSheet.player);
	
	public static Sprite playerNorthWest0=new Sprite(16,0,4,SpriteSheet.player);
	public static Sprite playerNorthWest1=new Sprite(16,1,4,SpriteSheet.player);
	public static Sprite playerNorthWest2=new Sprite(16,2,4,SpriteSheet.player);
	
	public static Sprite playerSouthEast0=new Sprite(16,0,6,SpriteSheet.player);
	public static Sprite playerSouthEast1=new Sprite(16,1,6,SpriteSheet.player);
	public static Sprite playerSouthEast2=new Sprite(16,2,6,SpriteSheet.player);
	
	public static Sprite playerSouthWest0=new Sprite(16,0,7,SpriteSheet.player);
	public static Sprite playerSouthWest1=new Sprite(16,1,7,SpriteSheet.player);
	public static Sprite playerSouthWest2=new Sprite(16,2,7,SpriteSheet.player);
	
	//Particles
	//Energy Bolt
	
	public static Sprite particle_EnergyBoltCollide=new Sprite(3,0xE6AE2C);
	
	//Projectiles
	//energy bolt
	public static Sprite energyBolt0=new Sprite(16,0,0,SpriteSheet.energyBolt);
	
	public Sprite(int size,int x,int y,SpriteSheet sheet){
		SIZE=size;
		this.width=size;
		this.height=size;
		pixels=new int[SIZE*SIZE];
		this.x=x*size;
		this.y=y*size;
		this.sheet=sheet;
		load();
	}
	public Sprite(int width,int height,int color){
		SIZE=-1;
		this.width=width;
		this.height=height;
		pixels=new int[width*height];
		setColor(color);
	}
	public Sprite(int size, int color){
		SIZE=size;
		this.width=size;
		this.height=size;
		pixels=new int [SIZE*SIZE];
		setColor(color);
	}
	private void setColor(int color){
		for(int i=0;i<width*height;i++){
			pixels[i]=color;
		}
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	private void load(){
		for(int y=0;y<SIZE;y++){
			for(int x=0;x<SIZE;x++){
				pixels[x+y*SIZE]=sheet.pixels[(x+this.x)+(y+this.y)*sheet.SIZE];
			}
		}
	}
}
