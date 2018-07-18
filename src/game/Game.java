package game;

import java.util.ArrayList;


public class Game {
	
	private Tile[][] board;
	
	public Game() {
		board = new Tile[3][3];
		for(int x=0;x<3;x++) {
			for(int y=0;y<3;y++) {
				board[x][y] = new Tile(x+1,y+1);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		return board[x][y];
	}
	
	public void clearBoard() {
		for(int x=0;x<3;x++) {
			for(int y=0;y<3;y++) {
				board[x][y].setType(2);
			}
		}
	}
	
	//checks for 3 adjacent pieces of the same type
	public boolean checkThree() {
		ArrayList<Tile> noughts = new ArrayList<Tile>();
		ArrayList<Tile> crosses = new ArrayList<Tile>();
		ArrayList<Tile> empty = new ArrayList<Tile>();
		int x1,x2,x3,y1,y2,y3,c1,c2,c3,c4,m;
		x1=x2=x3=y1=y2=y3=c1=c2=c3=c4=m=0;
		
		for(int x=0;x<3;x++) {
			for(int y=0;y<3;y++) {
				Tile tile = board[x][y];
				if(tile.getType()==0) {
					noughts.add(tile);
				}
				if(tile.getType()==1) {
					crosses.add(tile);
				} else {
					empty.add(tile);
				}
			}
		}
		
		for(Tile t:noughts) {
			if(t.getX()==1) {
				x1++;
			}
			if(t.getX()==2) {
				x2++;
			}
			if(t.getX()==3) {
				x3++;
			}
			if(t.getY()==1) {
				y1++;
			}
			if(t.getY()==2) {
				y2++;
			}
			if(t.getY()==3) {
				y3++;
			}
			
			if(t.getX()==1 && t.getY()==1) {
				c1++;
			}
			if(t.getX()==3 && t.getY()==1) {
				c2++;
			}
			if(t.getX()==1 && t.getY()==3) {
				c3++;
			}
			if(t.getX()==3 && t.getY()==3) {
				c4++;
			}
			
			if(t.getX()==2 && t.getY()==2) {
				m++;
			}
			
			//check horizonal 1
			if(x1==3) {
				return true;
			}
			//check horizonal 2
			if(x2==3) {
				return true;
			}
			//check horizonal 3
			if(x3==3) {
				return true;
			}
			//check vertical 1
			if(y1==3) {
				return true;
			}
			//check vertical 2
			if(y2==3) {
				return true;
			}
			//check vertical 3
			if(y3==3) {
				return true;
			}
			
			//check diagonal 1
			if((c1+m+c4)==3) {
				return true;
			}
			//check diagonal 2
			if((c2+m+c3)==3) {
				return true;
			}
			
		}
		
		x1=x2=x3=y1=y2=y3=c1=c2=c3=c4=m=0;
		
		for(Tile t:crosses) {
			if(t.getX()==1) {
				x1++;
			}
			if(t.getX()==2) {
				x2++;
			}
			if(t.getX()==3) {
				x3++;
			}
			if(t.getY()==1) {
				y1++;
			}
			if(t.getY()==2) {
				y2++;
			}
			if(t.getY()==3) {
				y3++;
			}
			
			if(t.getX()==1 && t.getY()==1) {
				c1++;
			}
			if(t.getX()==3 && t.getY()==1) {
				c2++;
			}
			if(t.getX()==1 && t.getY()==3) {
				c3++;
			}
			if(t.getX()==3 && t.getY()==3) {
				c4++;
			}
			
			if(t.getX()==2 && t.getY()==2) {
				m++;
			}
			
			//check horizonal 1
			if(x1==3) {
				return true;
			}
			//check horizonal 2
			if(x2==3) {
				return true;
			}
			//check horizonal 3
			if(x3==3) {
				return true;
			}
			//check vertical 1
			if(y1==3) {
				return true;
			}
			//check vertical 2
			if(y2==3) {
				return true;
			}
			//check vertical 3
			if(y3==3) {
				return true;
			}
			
			//check diagonal 1
			if((c1+m+c4)==3) {
				return true;
			}
			//check diagonal 2
			if((c2+m+c3)==3) {
				return true;
			}
			
		}
		return false;
	}
}
