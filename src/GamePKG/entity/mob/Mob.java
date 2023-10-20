package GamePKG.entity.mob;

import java.util.ArrayList;
import java.util.List;

import GamePKG.entity.Entity;
import GamePKG.entity.particle.Particle;
import GamePKG.entity.projectile.EnergyBolt;
import GamePKG.entity.projectile.Projectile;
import GamePKG.graphics.Sprite;
import GamePKG.level.Level;

public abstract class Mob extends Entity{
	protected Sprite sprite;
	protected int dir=-1;
	protected boolean movement=false;
	protected boolean walking=false;
	
	public void move(int xa,int ya){
		
		if(xa>0)dir=1;//east
		if(xa<0)dir=3;//west
		
		if(xa<0&&ya<0)dir=5;//northwest
		else if(xa>0&&ya<0)dir=6;//northeast
		else if(ya<0)dir=0;//north
		
		if(xa>0&&ya>0)dir=4;//southeast
		else if(xa<0&&ya>0)dir=7;//southwest
		else if(ya>0)dir=2;//south
		
		if(!collision(xa,0)){
			x+=xa;
		}
		if(!collision(0,ya)){
			y+=ya;
		}
	}
	public void update(){
		
	}
	protected void shoot(int x,int y,double dir){
		//dir*=(180/Math.PI);
		Projectile energyBolt=new EnergyBolt(x,y,dir);
		level.addEntity(energyBolt);
	}
	protected boolean collision(int xa,int ya){
		boolean solid=false;
		for(int c=0;c<4;c++){
			int xt=((x+xa)+c%2*11+2)/16;
			int yt=((y+ya)+c/2*8+7)/16;
			if(level.getTile(xt,yt).solid())solid=true;
		}
		return solid;
	}
	public void render(){
		
	}
}
