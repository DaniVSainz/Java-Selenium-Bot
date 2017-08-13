package botFarm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TerminalBotv2 {
	public Process startTerminal() {
        ProcessBuilder builder = new ProcessBuilder( "/bin/bash" );
        Process p=null;
        try {
            p = builder.start();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return p;
	}
	
	public void runProcess(Process terminalInstance) throws InterruptedException {
		BufferedWriter p_stdin = 
		          new BufferedWriter(new OutputStreamWriter(terminalInstance.getOutputStream()));
		try {
			p_stdin.write("cd");
			p_stdin.newLine();
			p_stdin.flush();
			Thread.sleep(500);
			p_stdin.write("ls");
			p_stdin.newLine();
			p_stdin.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}

	}
	
	public void getOutput(Process newP) {
	    Scanner s = new Scanner( newP.getInputStream() );
	    while (s.hasNext())
	    {
	        System.out.println( s.next() );
	    }
	       s.close();
	    }
	
	
	public static void main(String[] args) throws InterruptedException {

		TerminalBotv2 terminal = new TerminalBotv2();
		Process newP = terminal.startTerminal();
		terminal.runProcess(newP);
		terminal.getOutput(newP);
	}
}
