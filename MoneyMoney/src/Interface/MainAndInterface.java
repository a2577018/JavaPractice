package Interface;

import java.io.IOException;
import java.util.TreeSet;

import InputAndOutput.InputAndOutput;
import MyAccount.MyAccount;

public class MainAndInterface {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		TreeSet<MyAccount> myAccounts = new TreeSet<MyAccount>() ;
		String filename = "data.dat" ;
		InputAndOutput io = new InputAndOutput() ;
		
		io.InputData( myAccounts, filename ) ;
		
		io.OutputData( myAccounts, filename ) ;
	}

}
