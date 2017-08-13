package botFarm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TerminalBot {

	public static void main(String[] args) throws InterruptedException
    {
        //init shell
        ProcessBuilder builder = new ProcessBuilder( "/bin/bash" );
        Process p=null;
        try {
            p = builder.start();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        //get stdin of shell
        BufferedWriter p_stdin = 
          new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        
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

        // finally close the shell by execution exit command
        try {
            p_stdin.write("exit");
            p_stdin.newLine();
            p_stdin.flush();
            System.out.println("TERMINAL JUST EXITED");
        }
        catch (IOException e) {
            System.out.println(e);
        }

    // write stdout of shell (=output of all commands)
    Scanner s = new Scanner( p.getInputStream() );
    while (s.hasNext())
    {
        System.out.println( s.next() );
    }
       s.close();
    }

}