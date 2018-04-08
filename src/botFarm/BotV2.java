/**
 * 
 */
package botFarm;

import botFarm.com.Github.ExecuteLoginPage;
import botFarm.com.Github.ExecuteVerifyPage;


public class BotV2 {
	static FakestUser myUser;
	public static void main(String[] args) throws Exception {
		ExecuteLoginPage Script = new ExecuteLoginPage();
		myUser = Script.run();
		ExecuteVerifyEmailPage ScriptVerify = new ExecuteVerifyPage();
	}
}
