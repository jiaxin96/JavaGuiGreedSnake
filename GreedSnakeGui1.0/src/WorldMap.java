import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Iterator;


public class WorldMap extends Frame {
	


	public static final int MAP_MASH_W = 30;
	public static final int MAP_MASH_H = 30;
	
	public static final int MASH_ROW = 20;
	
	public static final int MASH_COLUMN = 20;
	
	
	private Snake  snake = new Snake();
	
	private int foodNum = 0;

	
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		
		g.setColor(Color.BLACK);
		
		g.fillRect(0, 0, MAP_MASH_W * MASH_COLUMN, MAP_MASH_H * MASH_ROW);
		
		
		g.setColor(Color.cyan);
		for	(int i = 0; i < MASH_COLUMN; ++i) {
			g.drawLine(i * MAP_MASH_W, 0, i*MAP_MASH_W, MAP_MASH_H * MASH_ROW);
		}
		for	(int i = 0; i < MASH_ROW; ++i) {
			g.drawLine(0, i * MAP_MASH_H, MAP_MASH_W * MASH_COLUMN, i * MAP_MASH_H);
		}
		
		
		g.setColor(Color.red);
		for (Iterator<Node> it = snake.snakeBody.iterator(); it.hasNext();) {
			Node t = (Node)it.next();
			g.fillRect(t.gety()*MAP_MASH_W, t.getx()*MAP_MASH_H, MAP_MASH_W, MAP_MASH_H);
		}
		g.setColor(Color.GRAY);
		g.fillRect(snake.snakeBody.getFirst().gety()*MAP_MASH_W, snake.snakeBody.getFirst().getx()*MAP_MASH_H, MAP_MASH_W, MAP_MASH_H);
		
		
		
		g.setColor(c);
	}
	
	
	
	
	//  游戏是否结束
	private static boolean gameState = false;
	
	public static boolean getGameState() {
		return gameState;
	}
	
	public void launch() {
		this.setLocation(100, 100);
		this.setSize(MAP_MASH_H * MASH_COLUMN, MAP_MASH_W * MASH_ROW);
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		
		this.setVisible(true);
		
	}
	
	
}