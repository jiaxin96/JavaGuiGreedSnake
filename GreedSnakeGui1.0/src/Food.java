import java.util.Iterator;

public class Food {
	int x = -1;
	int y = -1;
//	private boolean hasSnake = false;
//	Snake s;
	
	Food() {
		x = y = -1;
	}
	
	
//	Food(Snake s) {
//		this.s = s;
//	}
	
//	public Food generateOne() {
//		int tempx = (int)(Math.random()*WorldMap.MASH_COLUMN);
//		int tempy = (int)(Math.random()*WorldMap.MASH_ROW);
//		
//		while (conflict(tempx, tempy)) {
//			tempx = (int)(Math.random()*WorldMap.MASH_COLUMN);
//			tempy = (int)(Math.random()*WorldMap.MASH_ROW);	
//		}
//		x = tempx;
//		y = tempy;
//	}
	
	public int getx() {
		return x;
	}
	
	public int gety() {
		return y;
	}
	
//	private boolean conflict(int x, int y) {
//		for (Iterator<Node> it = s.snakeBody.iterator(); it.hasNext();) {
//			Node t = (Node)it.next();
//			if (t.getx() == x && t.gety() == y) return false;
//		}
//		return true;
//	}
	
}
