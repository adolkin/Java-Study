package robot.programming.core;

public interface Robot {
	Position move();
	String report();
	Direction turn(TurnTo turn);
	boolean setCurrentPosition(Position position);
}
