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

	
	private int head_x, head_y;
	
	private int length;
	
	public LinkedList<Node> snakeBody = new LinkedList<Node>();
	
	Snake() {
		snakeBody.addFirst(new Node(WorldMap.MASH_COLUMN/2, WorldMap.MASH_ROW/2));
		head_x = WorldMap.MASH_COLUMN/2;
		head_y = WorldMap.MASH_ROW/2;
		length++;
	}
	
	
	
	
	
}
