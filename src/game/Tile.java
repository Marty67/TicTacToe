package game;

public class Tile {
	
	private int type,x,y;//0 is nought,1 is cross, 2 is blank,xy are coordinates
	
	public Tile(int x, int y) {
		type = 2;
		this.x = x;
		this.y = y;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

}
