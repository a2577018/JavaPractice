package Calculate;

import java.io.IOException;
import java.util.TreeSet;

import InputAndOutput.Input;
import MyAccount.MyAccount;

public class DataInput {
	public static void AddCost( TreeSet<MyAccount> myAccounts )   {
		Input readData = new Input() ;
		try {
			readData.InputData( myAccounts ) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}