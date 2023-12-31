package GamePKG.graphics;

import java.util.Random;

import GamePKG.entity.mob.Player;
import GamePKG.entity.projectile.Projectile;
import GamePKG.level.tile.Tile;

public class Screen {
	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE=8;
	public final int MAP_SIZE_MASK=MAP_SIZE-1;
	public int[] tiles=new int[MAP_SIZE*MAP_SIZE];
	
	public int xOffset,yOffset;
	
	private Random random=new Random();
	
	public Screen(int width,int height){
		this.width=width;
		this.height=height;
		pixels=new int[width*height];
		
		for(int i=0;i<MAP_SIZE*MAP_SIZE;i++){
			tiles[i]=random.nextInt(0xffffff);
		}
	}
	public void clear(){
		for(int i=0;i<pixels.length;i++){
			pixels[i]=0;
		}
	}
	public void renderSprite(int xp,int yp,Sprite sprite,boolean fixed){
		if(fixed){
			xp-=xOffset;
			yp-=yOffset;
		}
		for(int y=0;y<sprite.getHeight();y++){
			int ya=y+yp;
			for(int x=0;x<sprite.getWidth();x++){
				int xa=x+xp;
				if(xa<0||xa>=width||ya<0||ya>=height)continue;
				pixels[xa+ya*width]=sprite.pixels[x+y*sprite.getWidth()];
			}
		}
	}
	public void renderTile(int xp,int yp,Tile tile){
		xp-=xOffset;
		yp-=yOffset;
		for(int y=0;y<tile.sprite.SIZE;y++){
			int ya=y+yp;
			for(int x=0;x<tile.sprite.SIZE;x++){
				int xa=x+xp;
				if (xa<-tile.sprite.SIZE||xa>=width||ya<0||ya>=height)break;
				if(xa<0)xa=0;
				pixels[xa+ya*width]=tile.sprite.pixels[x+y*tile.sprite.SIZE];
			}
		}
	}
	public void renderProjectile(int xp,int yp,Projectile projectile){
		xp-=xOffset;
		yp-=yOffset;
		for(int y=0;y<projectile.getSpriteSize();y++){
			int ya=y+yp;
			for(int x=0;x<projectile.getSpriteSize();x++){
				int xa=x+xp;
				if (xa<-projectile.getSpriteSize()||xa>=width||ya<0||ya>=height)break;
				if(xa<0)xa=0;
				int col=projectile.getSprite().pixels[x+y*projectile.getSpriteSize()];
				if(col!=0xffff00ff)pixels[xa+ya*width]=col;
			}
		}
	}
	public void renderPlayer(int xp,int yp,Sprite sprite){
		xp-=xOffset;
		yp-=yOffset;
		for(int y=0;y<sprite.SIZE;y++){
			int ya=y+yp;
			for(int x=0;x<sprite.SIZE;x++){
				int xa=x+xp;
				if (xa<-16||xa>=width||ya<0||ya>=height)break;
				if(xa<0)xa=0;
				int col=sprite.pixels[x+y*sprite.SIZE];
				if(col!=0xffff00ff)pixels[xa+ya*width]=col;
				
			}
		}
	}
	public void setOffset(int xOffset,int yOffset){
	this.xOffset=xOffset;
	this.yOffset=yOffset;
	}
}

