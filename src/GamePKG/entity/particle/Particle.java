package GamePKG.entity.particle;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import GamePKG.entity.Entity;
import GamePKG.graphics.Screen;
import GamePKG.graphics.Sprite;

public class Particle extends Entity{
	
	private Sprite sprite;
	private int life;
	private int time=0;
	
	protected double xx,yy,zz;
	protected double xa,ya,za;
	
	public Particle(int x,int y,int life){
		this.x=x;
		this.y=y;
		this.xx=x;
		this.yy=y;
		this.life=life+(random.nextInt(20)-10);
		sprite=Sprite.particle_EnergyBoltCollide;
		
		this.xa=random.nextGaussian();
		this.ya=random.nextGaussian();
		this.zz=random.nextFloat()+6.0;
	}
	
	public void update(){
		time++;
		if(time>30000)time=0;
		if(time>life)remove();
		za-=0.1;
		if(zz<0){
			zz=0;
			za*=-0.5;
			xa*=0.4;
			ya*=0.4;
		}
		
		//move(xx+xa,(yy+ya)+(zz+za));
		this.xx+=xa;
		this.yy+=ya;
		this.zz+=za;
	}
	public void render(Screen screen){
		screen.renderSprite((int)xx,(int)yy-(int)zz,sprite,true);
	}
}
