package robot.programming.core;

public class RobotImpl implements Robot {

	private Position currentPosition;

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public boolean setCurrentPosition(Position currentPosition) {
		if (currentPosition == null)
			return false;
		
		this.currentPosition = currentPosition;
		return true;
	}

    public boolean setPosition(Position position) {
        if (position == null)
            return false;

        this.currentPosition = position;
        return true;
    }
    
	@Override
	public Position move() {
		switch (currentPosition.getDirection()) {
		case NORTH:
			currentPosition.move1Step(0, 1);
			break;
		case EAST:
			currentPosition.move1Step(1, 0);
			break;
		case SOUTH:
			currentPosition.move1Step(0, -1);
			break;
		case WEST:
			currentPosition.move1Step(-1, 0);
			break;
		default:
			System.out.println("Invalid command");
		}
		return currentPosition;
	}

	@Override
	public Direction turn(TurnTo turn) {
		if (currentPosition.getDirection().equals(Direction.NORTH) && turn.equals(TurnTo.LEFT)) {
			currentPosition.setDirection(Direction.WEST);
		} else if (currentPosition.getDirection().equals(Direction.NORTH) && turn.equals(TurnTo.RIGHT)) {
			currentPosition.setDirection(Direction.EAST);
		} else if (currentPosition.getDirection().equals(Direction.SOUTH) && turn.equals(TurnTo.LEFT)) {
			currentPosition.setDirection(Direction.EAST);
		} else if (currentPosition.getDirection().equals(Direction.SOUTH) && turn.equals(TurnTo.RIGHT)) {
			currentPosition.setDirection(Direction.WEST);
		} else if (currentPosition.getDirection().equals(Direction.WEST) && turn.equals(TurnTo.LEFT)) {
			currentPosition.setDirection(Direction.SOUTH);
		} else if (currentPosition.getDirection().equals(Direction.WEST) && turn.equals(TurnTo.RIGHT)) {
			currentPosition.setDirection(Direction.NORTH);
		} else if (currentPosition.getDirection().equals(Direction.EAST) && turn.equals(TurnTo.LEFT)) {
			currentPosition.setDirection(Direction.NORTH);
		} else if (currentPosition.getDirection().equals(Direction.EAST) && turn.equals(TurnTo.RIGHT)) {
			currentPosition.setDirection(Direction.SOUTH);
		}
		return currentPosition.getDirection();
	}

	@Override
	public String report() {
		return currentPosition.getX() + "," + currentPosition.getY() + "," + currentPosition.getDirection().toString();
	}

}
