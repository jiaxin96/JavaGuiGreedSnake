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
	
	
 	public void eat(Food f) {
 		
 	}
 	
 	public void move(KeyEvent e) {
 		int dircode = e.getKeyCode();
 		switch (dircode) {
		case KeyEvent.VK_W:
			headDir = DIRECTION.UP;
			break;
		case KeyEvent.VK_A:
			headDir = DIRECTION.LEFT;
			break;
		case KeyEvent.VK_S:
			headDir = DIRECTION.DOWN;
			break;
		case KeyEvent.VK_D:
			headDir = DIRECTION.RIGHT;
			break;
		default:
			break;
		}
 		
 		
 		
 	}
	
	
}
