package GamePKG.entity.mob;

import GamePKG.Game;
import GamePKG.entity.projectile.EnergyBolt;
import GamePKG.entity.projectile.Projectile;
import GamePKG.graphics.Screen;
import GamePKG.input.Mouse;
import GamePKG.graphics.Sprite;
import GamePKG.input.Keyboard;

public class Player extends Mob{
	
	private Keyboard key;
	protected Sprite sprite;
	private float posDZ=0.50f;
	private float negDZ=-0.50f;
	private int posDZPerc=38;
	private int negDZPerc=-38;
	private float circularDZ;
	private float RightStickX;
	private float RightStickY;
	private boolean L1;
	private boolean R1;
	private int anim;
	Projectile projectile;
	private int fireRate=0;
	
	public Player(Keyboard key){
		this.key=key;
		sprite=Sprite.playerSouth0;
	}
	public Player(int x,int y,Keyboard key){
		this.x=x;
		this.y=y;
		this.key=key;
		sprite=Sprite.playerSouth0;
		fireRate=EnergyBolt.RATE_OF_FIRE;
	}
	public void update(){
		int xa=0,ya=0;
		
		if(fireRate>0)fireRate--;
		
		if(anim<7500)anim++;
		else anim=0;
		
		if(key.up&&key.left){xa-=!key.shift?1:2;ya-=!key.shift?1:2;}
		else if(key.up&&key.right){xa+=!key.shift?1:2;ya-=!key.shift?1:2;}
		else if(key.down&&key.left){xa-=!key.shift?1:2;ya+=!key.shift?1:2;}
		else if(key.down&&key.right){xa+=!key.shift?1:2;ya+=!key.shift?1:2;}
		else if(key.up)ya-=!key.shift?1:2;
		else if(key.down)ya+=!key.shift?1:2;
		else if(key.left)xa-=!key.shift?1:2;
		else if(key.right)xa+=!key.shift?1:2;
		
		if(xa!=0||ya!=0){
			move(xa, ya);
			walking=true;
			}else{	
			walking=false;		
		}
		clear();
		updateShooting();
		
	}
	private void clear(){
		for(int i=0;i<level.getProjectiles().size();i++){
			Projectile projectile=level.getProjectiles().get(i);
			if(projectile.isRemoved())level.getProjectiles().remove(i);
		}
	}
	private void updateShooting(){
		
		if(Mouse.getButton()==1&&fireRate<=0){
			double dx=Mouse.getX()-Game.getCanvasWidth()/2;
			double dy=Mouse.getY()-Game.getCanvasHeight()/2;
			double dir=Math.atan2(dy,dx);
			shoot(x,y,dir);
			fireRate=EnergyBolt.RATE_OF_FIRE;
		}
	}
	public void render(Screen screen){
		
		//Straight
		if(dir==0){
			sprite=Sprite.playerNorth0;
			if(walking){
				if(anim%20>10){
					sprite=Sprite.playerNorth1;
				}else{
					sprite=Sprite.playerNorth2;
				}
			}
		}
		if(dir==1){
			sprite=Sprite.playerEast0;
			if(walking){
				if(anim%20>10){
					sprite=Sprite.playerEast1;
				}else{
					sprite=Sprite.playerEast2;
				}
			}
		}
		if(dir==2){
			sprite=Sprite.playerSouth0;
			if(walking){
				if(anim%20>10){
					sprite=Sprite.playerSouth1;
				}else{
					sprite=Sprite.playerSouth2;
				}
			}
		}
		if(dir==3){
			sprite=Sprite.playerWest0;
			if(walking){
				if(anim%20>10){
					sprite=Sprite.playerWest1;
				}else{
					sprite=Sprite.playerWest2;
				}
			}
		}
		//Diagonal
		if(dir==4){
			sprite=Sprite.playerSouthEast0;
			if(walking){
				if(anim%20>10){
					sprite=Sprite.playerSouthEast1;
				}else{
					sprite=Sprite.playerSouthEast2;
				}
			}
		}
		if(dir==5){
			sprite=Sprite.playerNorthWest0;
			if(walking){
				if(anim%20>10){
					sprite=Sprite.playerNorthWest1;
				}else{
					sprite=Sprite.playerNorthWest2;
				}
			}
		}
		if(dir==6){
			sprite=Sprite.playerNorthEast0;
			if(walking){
				if(anim%20>10){
					sprite=Sprite.playerNorthEast1;
				}else{
					sprite=Sprite.playerNorthEast2;
				}
			}
		}
		if(dir==7){
			sprite=Sprite.playerSouthWest0;
			if(walking){
				if(anim%20>10){
					sprite=Sprite.playerSouthWest1;
				}else{
					sprite=Sprite.playerSouthWest2;
				}
			}
		}
		
		screen.renderPlayer(x,y,sprite);
	}
}
