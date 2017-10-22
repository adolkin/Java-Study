package robot.programming.core;

public class Position {
	
	private int x;
	private int y;
	private Direction direction;
	
	public Position(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
    public void move1Step(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }
}
