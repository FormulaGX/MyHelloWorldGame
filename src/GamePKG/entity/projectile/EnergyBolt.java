package GamePKG.entity.projectile;

import GamePKG.entity.particle.Particle;
import GamePKG.entity.spawner.ParticleSpawner;
import GamePKG.entity.spawner.Spawner;
import GamePKG.graphics.Screen;
import GamePKG.graphics.Sprite;

public class EnergyBolt extends Projectile{
	
	public static final int RATE_OF_FIRE=11;
	
	public EnergyBolt(int x,int y,double dir) {
		super(x, y, dir);
		speed=4;
		range=84;
		damage=20;
		
		sprite=Sprite.energyBolt0;
		
		nx=speed*Math.cos(angle);
		ny=speed*Math.sin(angle);
	}
	public void update(){
		if(level.tileCollision((int)(x+nx),(int)(y+ny),6,11,8)){
			level.addEntity(new ParticleSpawner((int)x+(sprite.SIZE/2),(int)y+(sprite.SIZE/2),44,10,level));
			remove();
		}
		move();
	}
	protected void move(){
		x+=nx;
		y+=ny;
		
		distance();
		if(distance()>range)remove();
	}
	private double distance(){
		double dist=0;
		dist=Math.sqrt(Math.abs((xOrigin-x)*(xOrigin-x)+(yOrigin-y)*(yOrigin-y)));
		return dist;
	}
	public void render(Screen screen){
		screen.renderProjectile((int)x,(int)y,this);
	}
}
