package botFarm;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;



public class AccountLogger {
//	This class provides logging functionality since passwords and username are randomly generated.
//	
	public void logAccount(String username,String password) {
		final String FILENAME = "/home/daniel/eclipse-workspace/GithubBot/accounts.txt";
		
	
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {

			String content = username + "  " + "password is:" + password + "\n";

			bw.write(content);

			// no need to close it.
			//bw.close();
			System.out.println("Added" + content);
			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}


