package robot.programming.core;

public class SimulationServiceImpl implements SimulationService {
	
	private Table table;
	private Robot robot;
	
	public SimulationServiceImpl(Table table, Robot robot) {
		this.table = table;
		this.robot = robot;
	}
	
	public boolean placeRobot(Position position) throws ToyRobotException {

        if (!table.isValidPosition(position))
        {
        	System.out.println("Invalid position object");
        	return false;
        }
        robot.setCurrentPosition(position);
        return true;
    }

    
	@Override
	public String takeCommand(String input) throws ToyRobotException {
		String[] args = input.split(" ");
		
		Command command;
		
		// check valid commands
        try {
            command = Command.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new ToyRobotException("Valid command 'PLACE MOVE LEFT RIGHT REPORT'");
        }
        if (command == Command.PLACE && args.length < 2) {
            throw new ToyRobotException("Valid PLACE command 'PLACE X,Y,F'");
        }
		
        String[] params;
        int x = 0;
        int y = 0;
        Direction commandDirection = null;
        if (command == Command.PLACE) {
            params = args[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                commandDirection = Direction.valueOf(params[2]);
            } catch (Exception e) {
            	throw new ToyRobotException("Valid PLACE command 'x,y: Integer'");
            }
        }

        String output = " ";

        switch (command) {
            case PLACE:
            	output = String.valueOf(placeRobot(new Position(x, y, commandDirection)));
                break;
            case MOVE:
                Position newPosition = robot.move();
                if (table.isValidPosition(newPosition))
                    output = "Invalid command";
                else
                    output = newPosition.getX() + "," + newPosition.getY();
                break;
            case LEFT:
                output = String.valueOf(robot.turn(TurnTo.LEFT));
                break;
            case RIGHT:
                output = String.valueOf(robot.turn(TurnTo.RIGHT));
                break;
            case REPORT:
                output = robot.report();
                break;
            default:
            	throw new ToyRobotException("Invalid command");
        }
        
        return output;
	}

}
