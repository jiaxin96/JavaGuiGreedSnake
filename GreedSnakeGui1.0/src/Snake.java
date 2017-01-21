import java.awt.event.KeyEvent;
import java.util.*;

class Node {
	int x = 0, y = 0;
	Node() {
		
	}
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
}

public class Snake {
	
	public enum DIRECTION  {
			UP, DOWN, LEFT, RIGHT
	};
	
	private int head_x, head_y;
	
	private int length;
	
	private DIRECTION headDir = DIRECTION.UP;
	
	public LinkedList<Node> snakeBody = new LinkedList<Node>();
	

	private boolean alive = true;
	
	public void isAlive() {
		
	}
	
	Snake() {
		snakeBody.addFirst(new Node(WorldMap.MASH_COLUMN/2, WorldMap.MASH_ROW/2));
		head_x = WorldMap.MASH_COLUMN/2;
		head_y = WorldMap.MASH_ROW/2;
		length++;
	}
	
	
 	// 吃了食物返回true 没有吃返回false
 	public boolean move(KeyEvent e, Food food) {
 		boolean eat = false;
 		int tempx = head_x, tempy = head_y;
 		int dircode = e.getKeyCode();
 		switch (dircode) {
		case KeyEvent.VK_W:
			headDir = DIRECTION.UP;
			tempx--;
			break;
		case KeyEvent.VK_A:
			headDir = DIRECTION.LEFT;
			tempy--;
			break;
		case KeyEvent.VK_S:
			headDir = DIRECTION.DOWN;
			tempx++;
			break;
		case KeyEvent.VK_D:
			headDir = DIRECTION.RIGHT;
			tempy++;
			break;
		default:
			break;
		}
 		
 		if (tempy > WorldMap.MASH_COLUMN || tempx > WorldMap.MASH_ROW || tempx < 0 || tempy < 0) {
 			this.alive = false;
 		}
 		head_x = tempx;
 		head_y = tempy;
 		
 		if (head_x != food.getx() || head_y != food.gety()) {
 			snakeBody.removeLast();
 			eat = true;
 		}
 		snakeBody.addFirst(new Node(head_x, head_y));
 		return eat;
 	}
	
	
}
