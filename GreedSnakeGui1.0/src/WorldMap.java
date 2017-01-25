import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
	private Food  food = new Food();
	
	private boolean hasFood = false;
	
//	private int foodNum = 0;
	
	Image offScreenImage = null;

	
	
	// 双缓冲 降噪
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(MAP_MASH_W * MASH_COLUMN, MAP_MASH_H * MASH_ROW);
			
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage,0,0,null);
	}

	
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		
		
		// 设置背景色
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, MAP_MASH_W * MASH_COLUMN, MAP_MASH_H * MASH_ROW);
		
		// 画网格
		g.setColor(Color.cyan);
		for	(int i = 0; i < MASH_COLUMN; ++i) {
			g.drawLine(i * MAP_MASH_W, 0, i*MAP_MASH_W, MAP_MASH_H * MASH_ROW);
		}
		for	(int i = 0; i < MASH_ROW; ++i) {
			g.drawLine(0, i * MAP_MASH_H, MAP_MASH_W * MASH_COLUMN, i * MAP_MASH_H);
		}
		
		// 画出蛇身
		g.setColor(Color.red);
		for (Iterator<Node> it = snake.snakeBody.iterator(); it.hasNext();) {
			Node t = (Node)it.next();
			g.fillRect(t.gety()*MAP_MASH_W, t.getx()*MAP_MASH_H, MAP_MASH_W, MAP_MASH_H);
		}
		
		// 画蛇头
		g.setColor(Color.GRAY);
		g.fillRect(snake.snakeBody.getFirst().gety()*MAP_MASH_W, snake.snakeBody.getFirst().getx()*MAP_MASH_H, MAP_MASH_W, MAP_MASH_H);
		
		// 画食物
		if(hasFood) {
			g.setColor(Color.orange);
			g.fillRect(food.y*MAP_MASH_W, food.x*MAP_MASH_H, MAP_MASH_W, MAP_MASH_H);
		}
		
		if (snake.move(food)) {
			this.generateOne();
		}
		if (!snake.isAlive()) {
			gameState = true;
			this.win();
		}
		
		g.setColor(c);
	}
	
	
	void win() {
		
		
		
	}
	
	
	
	//  游戏是否结束
	private static boolean gameState = false;
	
	public static boolean getGameState() {
		return gameState;
	}
	
	public void generateOne() {
		int tempx = (int)(Math.random()*WorldMap.MASH_COLUMN);
		int tempy = (int)(Math.random()*WorldMap.MASH_ROW);
		
		while (conflict(tempx, tempy)) {
			tempx = (int)(Math.random()*WorldMap.MASH_COLUMN);
			tempy = (int)(Math.random()*WorldMap.MASH_ROW);	
		}
		food.x = tempx;
		food.y = tempy;
		hasFood = true;
	}
	
	
	private boolean conflict(int x, int y) {
		for (Iterator<Node> it = snake.snakeBody.iterator(); it.hasNext();) {
			Node t = (Node)it.next();
			if (t.getx() == x && t.gety() == y) return true;
		}
		return false;
	}
	
	public void launch() {
		
		this.generateOne();
		
		this.setLocation(100, 100);
		this.setSize(MAP_MASH_H * MASH_COLUMN, MAP_MASH_W * MASH_ROW);
		
		this.setResizable(false);
		// 类似Qt中的connect 和event 注册监听
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		this.addKeyListener(new KeyMonitor());
		
		
		this.setVisible(true);
		
		new Thread(new PaintThread()).start();
		
	}
	
	private class PaintThread implements Runnable {
		@Override
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(300);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	private class KeyMonitor extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
	 		int dircode = e.getKeyCode();
	 		switch (dircode) {
			case KeyEvent.VK_W:
				snake.setHeadDir(Snake.DIRECTION.UP);
				break;
			case KeyEvent.VK_A:
				snake.setHeadDir(Snake.DIRECTION.LEFT);
				System.out.println("LEFT############");
				break;
			case KeyEvent.VK_S:
				snake.setHeadDir(Snake.DIRECTION.DOWN);
				break;
			case KeyEvent.VK_D:
				snake.setHeadDir(Snake.DIRECTION.RIGHT);
				break;
			default:
				break;
			}
		}
		
	}
	
	
	
	
}