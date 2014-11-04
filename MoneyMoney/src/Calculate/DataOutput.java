package Calculate;

import java.io.IOException;
import InputAndOutput.Output;

public class DataOutput {
	public static void PrintAllData( ) throws ClassNotFoundException {
		Output printAllData = new Output() ;
		try {
			printAllData.PrintAllData() ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}