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
	
	public enum  DIRECTION  {
			UP, DOWN, LEFT, RIGHT
	};
	
	private int head_x, head_y;
	
	private int length;
	
	private DIRECTION headDir = DIRECTION.UP;
	
	public LinkedList<Node> snakeBody = new LinkedList<Node>();
	

	private boolean alive = true;
	
	public boolean isAlive() {
		return alive;
	}
	
	Snake() {
		snakeBody.addFirst(new Node(WorldMap.MASH_COLUMN/2, WorldMap.MASH_ROW/2));
		head_x = WorldMap.MASH_COLUMN/2;
		head_y = WorldMap.MASH_ROW/2;
		length++;
	}
	

		public void setHeadDir(DIRECTION d) {
 			headDir = d;
 		}
	
 	// 吃了食物返回true 没有吃返回false
 	public boolean move(Food food) {
 		boolean eat = false;
 		int tempx = head_x, tempy = head_y;
 		
 		switch (headDir) {
		case UP:
			tempx--;
			break;
		case LEFT:
			tempy--;
			break;
		case DOWN:
			tempx++;
			break;
		case RIGHT:
			tempy++;
			break;
		default:
			break;
		}
 		
 		if (tempy > WorldMap.MASH_COLUMN || tempx > WorldMap.MASH_ROW || tempx < 0 || tempy < 0) {
 			this.alive = false;
 			length = 0;
 		}
 		head_x = tempx;
 		head_y = tempy;
 		
 		if (head_x != food.getx() || head_y != food.gety()) {
 			snakeBody.removeLast();
 			eat = false;
 			length++;
 		} else {
 			eat = true;
 		}
 		snakeBody.addFirst(new Node(head_x, head_y));
 		return eat;
 	}
	
	
}
