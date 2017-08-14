package botFarm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TerminalBotv3 {
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
		
		try {
			p_stdin.write("echo --------------------------------------------------------------------------------------------");
			p_stdin.newLine();
			p_stdin.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	

	
	public void killTerminal(Process newP) throws InterruptedException {
		String kill = "exit";
		runProcess(newP, kill);
	
		System.out.println("Terminal shutdown");
	}	
	
	public static void main(String[] args) throws InterruptedException {

		TerminalBotv3 terminal = new TerminalBotv3();
		Process newP = terminal.startTerminal();
		terminal.runProcess(newP,"cd");
		terminal.runProcess(newP,"ls");
		terminal.runProcess(newP,"cd vpngate-with-proxy");
		terminal.runProcess(newP,"./run tui");
//		Thread.sleep(10000);
		terminal.getOutput(newP);
	}
}