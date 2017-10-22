package robot.programming.core;

import java.util.List;

public abstract class Table {
	
	List<Position> listOfValidPosisition;
	
	public abstract boolean create(int a, int b);
	public abstract boolean isValidPosition(Position position);
	
}
