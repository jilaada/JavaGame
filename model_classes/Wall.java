package model_classes;
import java.util.ArrayList;

public class Wall {

	private int numberOfBricks;
	private ArrayList<Point> brickCoordinates;
	private ArrayList<Brick> brickList;
	
	public Wall(int brickNo) {		
		this.numberOfBricks = brickNo;
	}

	public void setNumberOfBricks(int number) {
		this.numberOfBricks = number;
	}
	
	public int getNumberOfBricks() {
		return this.numberOfBricks;
	}
	
	public void addBrick(Brick brick) {
		this.brickList.add(brick);
	}
	
	public ArrayList<Brick> getBricks(Brick brick) {
		return this.brickList;
	}
	
	public void addBrickCoord(Point pos) {
		this.brickCoordinates.add(pos);
	}
	
	public ArrayList<Point> getBrickCoord() {
		if(this.brickCoordinates == null) {
			return null;
		} else {
			return this.brickCoordinates;
		}
	}
	
	public void constructWall(int brickNo, int quarter) {
		for(int i = 0; i < brickNo; i++) {
			//Brick b1 = new Brick(globalLength, globalHeight);
			Brick b1 = new Brick(40, 10);
			this.addBrick(b1);
		}




	}
}
