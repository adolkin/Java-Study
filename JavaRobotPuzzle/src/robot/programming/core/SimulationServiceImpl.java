package robot.programming.core;

public class SimulationServiceImpl implements SimulationService {
	
	private Table table;
	private Robot robot;
	
	public SimulationServiceImpl(Table table, Robot robot) {
		this.table = table;
		this.robot = robot;
	}

	@Override
	public String takeCommand(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}
