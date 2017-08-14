package botFarm;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MrRobot {
	
	
	
	public static void clickNextVpn(Robot myRobot) throws InterruptedException {
		myRobot.mouseMove(1671, 9);
		Thread.sleep(50);
		click(myRobot);
		Thread.sleep(50);
		myRobot.mouseMove(1706, 85);
		Thread.sleep(200);
		click(myRobot);
	}
	
	public static void closeConnection(Robot myRobot) throws InterruptedException {
		myRobot.mouseMove(1710, 118);
		Thread.sleep(50);
		click(myRobot);
	}
	
	public static void click(Robot myRobot) {
		myRobot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		myRobot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		 Robot myRobot = new Robot();
		 clickNextVpn(myRobot);
//		 closeConnection(myRobot);
	}
}
