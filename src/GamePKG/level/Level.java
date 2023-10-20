package GamePKG.level;

import java.util.ArrayList;
import java.util.List;

import GamePKG.entity.Entity;
import GamePKG.entity.particle.Particle;
import GamePKG.entity.projectile.Projectile;
import GamePKG.entity.spawner.Spawner;
import GamePKG.graphics.Screen;
import GamePKG.level.tile.Tile;
import GamePKG.level.tile.VoidTile;

public class Level {
	
	protected int width,height;
	protected int[] tilesint;
	protected int[] tiles;
	protected int tile_size;
	
	private List<Entity> entities=new ArrayList<Entity>();
	private List<Projectile> projectiles=new ArrayList<Projectile>();
	private List<Particle> particles=new ArrayList<Particle>();
	
	public static Level spawn=new SpawnLevel("/images/mappers/testmap0.png");
	
	public Level(int width,int height){
		this.width=width;
		this.height=height;
		tilesint=new int[width*height];
		generateLevel();
	}
	public Level(String path){
		loadLevel(path);
		generateLevel();
	}
	protected void generateLevel(){
		
	}
	protected void loadLevel(String path){
		
	}
	public void update(){
		for(int i=0;i<entities.size();i++){
			entities.get(i).update();
		}
		for(int i=0;i<projectiles.size();i++){
			projectiles.get(i).update();
		}
		for(int i=0;i<particles.size();i++){
			particles.get(i).update();
		}
		remove();
	}
	private void remove(){
		for(int i=0;i<entities.size();i++){
			if(entities.get(i).isRemoved())entities.remove(i);
		}
		for(int i=0;i<projectiles.size();i++){
			if(projectiles.get(i).isRemoved())projectiles.remove(i);
		}
		for(int i=0;i<particles.size();i++){
			if(particles.get(i).isRemoved())particles.remove(i);
		}
	}
	public List<Projectile>getProjectiles(){
		return projectiles;
	}
	private void time(){
		
	}
	public boolean tileCollision(int x,int y,int size,int xOffset,int yOffset){
		boolean solid=false;
		for(int c=0;c<4;c++){
			int xt=(x-c%2*size+xOffset)>>4;
			int yt=(y-c/4*size+yOffset)>>4;
			if(getTile((int)xt,(int)yt).solid())solid=true;
		}
		return solid;
	}
	public void render(int xScroll,int yScroll,Screen screen){
		screen.setOffset(xScroll, yScroll);
		int x0=xScroll>>4;
		int x1=(xScroll+screen.width+16)>>4;
		int y0=yScroll>>4;
		int y1=(yScroll+screen.height+16)>>4;
		for(int y=y0;y<y1;y++){
			for(int x=x0;x<x1;x++){
				getTile(x, y).render(x, y, screen);
			}
		}
		for(int i=0;i<entities.size();i++){
			entities.get(i).render(screen);
		}
		for(int i=0;i<projectiles.size();i++){
			projectiles.get(i).render(screen);
		}
		for(int i=0;i<particles.size();i++){
			particles.get(i).render(screen);
		}
	}
	public void addEntity(Entity e){
		e.init(this);
		if(e instanceof Particle){
			particles.add((Particle)e);
		}else if(e instanceof Projectile){
			projectiles.add((Projectile) e);
		}else{
			entities.add(e);
		}
		
	}
	
	public Tile getTile(int x,int y){
		if(x<0||y<0||x>=width||y>=height)return Tile.voidTile;
		if(tiles[x+y*width]==Tile.col_grass)return Tile.grass;
		if(tiles[x+y*width]==Tile.col_flowers0)return Tile.flowers0;
		if(tiles[x+y*width]==Tile.col_flowers1)return Tile.flowers1;
		if(tiles[x+y*width]==Tile.col_rocks0_grass)return Tile.rocks0_grass;
		if(tiles[x+y*width]==Tile.col_rocks1_grass)return Tile.rocks1_grass;
		if(tiles[x+y*width]==Tile.col_pebbles0_grass)return Tile.pebbles0_grass;
		if(tiles[x+y*width]==Tile.col_clayWall0)return Tile.clayWall0;
		if(tiles[x+y*width]==Tile.col_clayWall1)return Tile.clayWall1;
		if(tiles[x+y*width]==Tile.col_dirt)return Tile.dirt;
		return Tile.voidTile;
	}
}
