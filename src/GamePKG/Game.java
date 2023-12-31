package GamePKG;

import GamePKG.entity.mob.Player;
import GamePKG.graphics.*;
import GamePKG.input.Keyboard;
import GamePKG.input.Mouse;
import GamePKG.level.Level;
import GamePKG.level.RandomLevel;
import GamePKG.level.SpawnLevel;
import GamePKG.level.TileCoordinate;
import GamePKG.level.tile.Water0Tile;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	private static int width=300;
	private static int height=width/16*9;
	private static int scale=6;
	public static String title="GamePKG |";
	
	private Thread thread;
	private JFrame frame;
	private Keyboard key=new Keyboard();
	private Level level;
	private Player player;
	private boolean running=false;
	
	private Screen screen;
	
	private BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels=((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public Game(){
		Dimension size=new Dimension(width*scale,height*scale);
		setPreferredSize(size);
		
		screen=new Screen(width,height);
		frame=new JFrame();
		key=new Keyboard();
		level=Level.spawn;
		TileCoordinate playerSpawn=new TileCoordinate(18, 18);
		player=new Player(playerSpawn.x(),playerSpawn.y(),key);
		player.init(level);
		
		addKeyListener(key);
		
		Mouse mouse=new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	public static int getCanvasWidth(){
		return width*scale;
	}
	
	public static int getCanvasHeight(){
		return height*scale;
	}
	
	public synchronized void start(){
		running=true;
		thread=new Thread(this, "Display");
		thread.start();
	}
	public synchronized void stop(){
		try{
			thread.join();
		}catch(InterruptedException IE){
			IE.printStackTrace();
		}
	}
	public void run(){
		long lastTime=System.nanoTime();
		long timer=System.currentTimeMillis();
		final double ns=1000000000.0/60.0;
		double delta=0;
		int frames=0;
		int updates=0;
		requestFocus();
		while(running){
			long now=System.nanoTime();
			delta+=(now-lastTime)/ns;
			lastTime=now;
			while(delta>=1){
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis()-timer>1000){
				timer+=1000;
				frame.setTitle(title+" UPS: "+updates+" FPS: "+frames);
				updates=0;
				frames=0;
			}
		}
		stop();
	}
	public void update(){
		key.update();
		player.update();
		level.update();
	}
	public void render(){
		BufferStrategy bs=getBufferStrategy();
		if(bs==null){
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		int xScroll=player.x-screen.width/2;
		int yScroll=player.y-screen.height/2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		
		for(int i=0;i<pixels.length;i++){
			pixels[i]=screen.pixels[i];
		}
		
		Graphics g=bs.getDrawGraphics();
		g.drawImage(image,0,0,getWidth(),getHeight(),null);
		g.setColor(Color.white);
		g.setFont(new Font("Verdana",0,20));
		g.setColor(Color.white);
		/*g.fillOval(Mouse.getX()-8*scale,Mouse.getY()-8*scale,16*scale,16*scale);
		g.drawString("Mouse Position: X: "+Mouse.getX()+" Y: "+Mouse.getY(),2, 20);
		g.drawString("Mouse Button: "+Mouse.getButton(),2,40);*/
		g.dispose();
		bs.show();
	}
	public static void main(String[] args){
		Game game=new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
}
