package rotbot.programming;

import java.util.Scanner;

import robot.programming.core.Robot;
import robot.programming.core.RobotImpl;
import robot.programming.core.SimulationService;
import robot.programming.core.SimulationServiceImpl;
import robot.programming.core.Table;
import robot.programming.core.TableImpl;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		TableImpl table = new TableImpl();
		table.create(4, 4);
		
//		int i = 0;
//		while (i < table.getListOfValidPosition().size()) {
//			System.out.println(table.getListOfValidPosition().get(i));
//		}

		
		RobotImpl robot = new RobotImpl();
		
		SimulationService game = new SimulationServiceImpl(table, robot);

		System.out.println("Robot Programming Puzzle");

		boolean keepRunning = true;
		while (keepRunning) {
			String inputString = scanner.nextLine();
			if ("EXIT".equals(inputString)) {
				keepRunning = false;
			} else {
				try {
					String outputVal = game.takeCommand(inputString);
					System.out.println(outputVal);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
