package botFarm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TerminalBotv2 {
	public Process startTerminal() throws InterruptedException {
        ProcessBuilder builder = new ProcessBuilder( "/bin/bash" );
        Process p=null;
        try {
            p = builder.start();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        Thread.sleep(100);
        runProcess(p,"echo Hello I'm alive");
        return p;
	}
	
	public void runProcess(Process currentTerminal,String command) throws InterruptedException {
		System.out.println("Running command: " + command);

		BufferedWriter p_stdin = 
		          new BufferedWriter(new OutputStreamWriter(currentTerminal.getOutputStream()));
		try {
			p_stdin.write(command);
			p_stdin.newLine();
			p_stdin.flush();
//			Thread.sleep(500);
			
//			getOutput(currentTerminal);
//			p_stdin.write("ls");
//			p_stdin.newLine();
//			p_stdin.flush();
//			System.out.println("Trying to Run process");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
			System.out.println("Process Exception");
		}
//		System.out.println("After  Process ran ");

	}
	
	public void getOutput(Process currentTerminal) {

		Scanner s = new Scanner( currentTerminal.getInputStream() );

	    while (s.hasNext()){
	    	System.out.println("Inside while");
	        System.out.println( s.next() );
	    }
	       s.close();
    }
	
	
	public void killTerminal(Process currentTerminal) throws InterruptedException {
		String kill = "exit";
		runProcess(currentTerminal, kill);
		getOutput(currentTerminal);
		System.out.println("Terminal shutdown");
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		String testCommand = "echo Hello";
		TerminalBotv2 terminal = new TerminalBotv2();
		Process currentTerminal = terminal.startTerminal();
		terminal.runProcess(currentTerminal,testCommand);
		terminal.runProcess(currentTerminal, "ls");
		terminal.getOutput(currentTerminal);
		terminal.killTerminal(currentTerminal);
	}
}
