import java.util.Iterator;

public class Food {
	private int x = -1;
	private int y = -1;
	private boolean hasSnake = false;
	Snake s;
	
	Food() {
		x = y = -1;
		hasSnake = false;
	}
	
	public void setSnake(Snake s) {
		this.s = s;
	}
	
	Food(Snake s) {
		this.s = s;
	}
	
	public void generateOne() {
		int tempx = (int)(Math.random()*WorldMap.MASH_COLUMN);
		int tempy = (int)(Math.random()*WorldMap.MASH_ROW);
		
		while (conflict(tempx, tempy)) {
			tempx = (int)(Math.random()*WorldMap.MASH_COLUMN);
			tempy = (int)(Math.random()*WorldMap.MASH_ROW);	
		}
		x = tempx;
		y = tempy;
	}
	
	private boolean conflict(int x, int y) {
		for (Iterator<Node> it = s.snakeBody.iterator(); it.hasNext();) {
			Node t = (Node)it.next();
			if (t.getx() == x && t.gety() == y) return false;
		}
		return true;
	}
	
}
