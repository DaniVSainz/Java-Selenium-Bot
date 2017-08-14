package botFarm;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TerminalBotv3 {
	public static String myIp ;
	public int counter = 0;
	public Process startTerminal() {
        ProcessBuilder builder = new ProcessBuilder( "/bin/bash" );
        Process p=null;
        try {
            p = builder.start();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        counter ++;
        System.out.println("Terminal :" + counter +  " Created" );
        return p;
	}
	
	public void runProcess(Process terminalInstance, String command) throws InterruptedException {
		BufferedWriter p_stdin = 
		          new BufferedWriter(new OutputStreamWriter(terminalInstance.getOutputStream()));
		try {
			p_stdin.write(command);
			p_stdin.newLine();
			p_stdin.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}

	}
	
	public void getOutput(Process newP) throws InterruptedException {
	    Scanner s = new Scanner( newP.getInputStream() );
	    while (s.hasNext())
	    {
	        System.out.println( s.next() );
	    }
	       s.close();
	       System.out.println("**** STREAM CLOSED ****");
	    }
	
	public void returnIp(Process newP) throws InterruptedException {
		Scanner s = new Scanner( newP.getInputStream() );
	    while (s.hasNext())
	    {	
	    	myIp = s.next();
	    }
	       s.close();
    }
	
	

	
	public void killTerminal(Process newP) throws InterruptedException {
		String kill = "exit";
		runProcess(newP, kill);
	
		System.out.println("Terminal shutdown");
	}	
	
	public void homeIp(Process newP) throws InterruptedException {
		runProcess(newP, "echo ip");
		runProcess(newP, "curl http://ipecho.net/plain; echo");
		killTerminal(newP);
		returnIp(newP);
	}
	
	
	public static void main(String[] args) throws InterruptedException, AWTException {

		TerminalBotv3 terminal = new TerminalBotv3();
		Process newP = terminal.startTerminal();
		terminal.homeIp(newP);
		System.out.println(myIp);
		if (myIp == "73.205.194.186") {
			MrRobot mrRobot = new MrRobot();
			Robot mouseBot = new Robot();
			mrRobot.clickNextVpn(mouseBot);
		}
//		Thread.sleep(30000);
		if (myIp == "73.205.194.186") {
			MrRobot mrRobot = new MrRobot();
			Robot mouseBot = new Robot();
			mrRobot.clickNextVpn(mouseBot);
		} 
		System.out.println(myIp == "73.205.194.186");
	}
}