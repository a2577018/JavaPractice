package MainAndInterface;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import Calculate.Count;
import Calculate.DataInput;
import Calculate.DataOutput;
import MyAccount.MyAccount;

public class MainAndInterface {

	public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
		System.out.println("�w��ϥ�MoneyMoney!!!") ;
		TreeSet<MyAccount> myAccounts = new TreeSet<MyAccount>() ;
		UpdateDataFromFile(myAccounts) ;
		Scanner scanner = new Scanner(System.in) ;
		int caseNum = -1 ;
		int countCaseNum = -1 ;
		
		System.out.println("�п�J�Ʀr�G0.�����{��1.�s�W��X2.�έp3.�d�߸��") ;
		caseNum = scanner.nextInt() ;
		
		while ( caseNum != 0 ) {
			if ( caseNum == 1 ) {
				DataInput.AddCost( myAccounts ) ;
			} // end if
			
			else if ( caseNum == 2 ) {
				System.out.println("�п�J�Ʀr�G1.����έp2.���g�έp3.����έp") ;
				countCaseNum = scanner.nextInt() ;
				if ( countCaseNum == 1 ) 
					Count.TodayCount( myAccounts ) ;
				else if ( countCaseNum == 2 )
					Count.WeekCount(myAccounts) ;
				else if ( countCaseNum == 3 )
					Count.MonthCount(myAccounts) ;
			} // end else if
			
			else if ( caseNum == 3 ) {
				DataOutput.PrintAllData( ) ;
			} // end else if
			
			System.out.println("�п�J�Ʀr�G0.�����{��1.�s�W��X2.�έp3.�d�߸��") ;
			caseNum = scanner.nextInt() ;
		} // end while
		
		scanner.close();
		System.out.println("���¨ϥΡA�A��!!!") ;
	}
	
	public static void UpdateDataFromFile( TreeSet<MyAccount> myAccounts ) throws IOException, ClassNotFoundException{
		String filename = "data.dat" ;
		File file = new File( filename ) ;
		try {
			FileInputStream fis = new FileInputStream( file );
			
	        ObjectInputStream ois = new ObjectInputStream( fis ){
	            protected void readStreamHeader ()
	                             throws IOException { }
	       };
			
	        try{
	            while(true){
	            	MyAccount tempMyAccount = ((MyAccount)ois.readObject()) ;
	            	myAccounts.add(tempMyAccount) ;
	            }
	        }
	        catch(EOFException e){
	            System.out.println("��Ƹ��J����!");
	        }
	        ois.close();
	        fis.close();
		}
        catch (FileNotFoundException e ) {
        	System.out.println("�ثe�S������O��! " ) ;
        } // catch
	} // UpdateDataFromFile()
}