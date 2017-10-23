package robot.programming.core;

import java.util.ArrayList;
import java.util.List;

public class TableImpl extends Table {

	private List<Position> listOfValidPosition = new ArrayList<Position>();

	public List<Position> getListOfValidPosition() {
		return listOfValidPosition;
	}


	@Override
	public boolean create(int rows, int cols) {
		if (rows > 0 && cols > 0) {
			for (int i = 0; i <= rows; i++) {
				for (int j = 0; j <= cols; j++) {
					Position tempPosition = new Position(i, j);
					System.out.println(tempPosition);
					//System.out.println(" " + tempPosition.getX() + ", " + tempPosition.getY());
					listOfValidPosition.add(tempPosition);
					System.out.println(listOfValidPosition);
				}
			}
			return true;
		}
		return false;
	};

	@Override
	public boolean isValidPosition(Position position) {
		Position validPosition = new Position(position.getX(), position.getY());

		if (listOfValidPosition.contains(validPosition))
			return true;
		return false;
	}

}
