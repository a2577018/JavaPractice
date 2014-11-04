package InputAndOutput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.TreeSet;

import MyAccount.MyAccount;

public class Input{
	public void InputData( TreeSet<MyAccount> myAccounts ) throws IOException {
		Scanner scanner = new Scanner(System.in) ;
		TreeSet<MyAccount> tempAccounts = new TreeSet<MyAccount>() ;
		String fatherCategory = null;
		String sonCategory = null ;
		Integer cost = 0 ;
		String date = null ;
		
		System.out.println("�п�J�����O�W��:(��J-1�����s�W���J)") ;
		fatherCategory = scanner.next() ;		
		while ( !fatherCategory.equals("-1") ) {
		  System.out.println("�п�J�l���O�W��:") ;
		  sonCategory = scanner.next() ;
			
		  System.out.println("�п�J��O:") ;
		  cost = scanner.nextInt() ;		
		
		  System.out.println("�п�J���:(�榡yyyy-mm-dd)") ;
		  date = scanner.next() ;			
		  
		  MyAccount newData = new MyAccount( fatherCategory, sonCategory, cost, date ) ;
		  myAccounts.add(newData) ;
		  tempAccounts.add(newData) ;

		  System.out.println("�п�J�����O�W��:(��J-1�����s�W���J)") ;
		  fatherCategory = scanner.next() ;		
		} // end while
		
		Input.WriteDataToFile( tempAccounts ) ;
	} // InputData()
	
	private static void WriteDataToFile( TreeSet<MyAccount> tempAccounts ){
		String filename = "data.dat" ;
		File file = new File( filename ) ;
		
        try {
            ObjectOutputStream objOutputStream = 
               new ObjectOutputStream(
                  new FileOutputStream(file,true)) { 
                // �p�G�n���[������ɮ׫�
                // �������s�w�q�o�Ӥ�k
                protected void writeStreamHeader() 
                                 throws IOException { } 
           };  

       		for ( MyAccount myAccount : tempAccounts ) {
       			objOutputStream.writeObject(myAccount) ;
    		} // for
            
            objOutputStream.close(); 
        } // try
        catch(IOException e) { 
            e.printStackTrace(); 
        } // catch 
	} // OutputToFile()
} // Input()