package GamePKG.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {
	private String path;
	public final int SIZE;
	public int[] pixels;
	
	public static SpriteSheet tiles=new SpriteSheet("/images/textures/tilesheet.png",256);
	public static SpriteSheet player=new SpriteSheet("/images/textures/mobs/playersheet.png", 256);
	public static SpriteSheet energyBolt=new SpriteSheet("/images/textures/projectiles/energybolt.png",48);
	
	public SpriteSheet(String path, int size){
		this.path=path;
		SIZE=size;
		pixels=new int [SIZE*SIZE];
		load();
	}
	private void load(){
		try {
			BufferedImage image=ImageIO.read(SpriteSheet.class.getResource(path));
			int w=image.getWidth();
			int h=image.getHeight();
			image.getRGB(0,0,w,h,pixels,0,w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
