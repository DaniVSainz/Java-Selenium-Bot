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
	
//	Creates a terminal for us to use with our other methods
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
	
//	Runs a process with the Terminal created above, you have to pass a command as a string to it.
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
	
//	Get's the output from the terminal,Currently hangs if you use this before shutting down the terminal
//	as it will infinitely wait for the next line, there's somethings to try here as passing in echo commands
//	with a specific trigger in which it closes the stream that i imagine is implementable but have yet had time.
	public void getOutput(Process newP) throws InterruptedException {
	    Scanner s = new Scanner( newP.getInputStream() );
	    while (s.hasNext())
	    {
	        System.out.println( s.next() );
	    }
	       s.close();
	       System.out.println("**** STREAM CLOSED ****");
	    }
	
//	This returns my current ip all in one convenient method as last line will have been the ip"
	public void returnIp(Process newP) throws InterruptedException {
		Scanner s = new Scanner( newP.getInputStream() );
	    while (s.hasNext())
	    {	
	    	myIp = s.next();
	    }
	       s.close();
    }
	
	

//	Poor terminal this shoots it multiple times and :*(
	public void killTerminal(Process newP) throws InterruptedException {
		String kill = "exit";
		runProcess(newP, kill);
	
		System.out.println("Terminal shutdown");
	}	
	
//	Yea... give me my current ip all bundled up, how convenient
	public void homeIp(Process newP) throws InterruptedException {
		runProcess(newP, "echo ip");
		runProcess(newP, "curl http://ipecho.net/plain; echo");
		killTerminal(newP);
		returnIp(newP);
	}
	
//	Purely for testing everything 
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
		if (myIp == "73.205.194.186") {
			MrRobot mrRobot = new MrRobot();
			Robot mouseBot = new Robot();
			mrRobot.clickNextVpn(mouseBot);
		} 
		System.out.println(myIp == "73.205.194.186");
	}
}