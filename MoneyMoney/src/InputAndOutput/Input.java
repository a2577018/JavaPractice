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
		
		System.out.println("請輸入父類別名稱:(輸入-1結束新增收入)") ;
		fatherCategory = scanner.next() ;		
		while ( !fatherCategory.equals("-1") ) {
		  System.out.println("請輸入子類別名稱:") ;
		  sonCategory = scanner.next() ;
			
		  System.out.println("請輸入花費:") ;
		  cost = scanner.nextInt() ;		
		
		  System.out.println("請輸入日期:(格式yyyy-mm-dd)") ;
		  date = scanner.next() ;			
		  
		  MyAccount newData = new MyAccount( fatherCategory, sonCategory, cost, date ) ;
		  myAccounts.add(newData) ;
		  tempAccounts.add(newData) ;

		  System.out.println("請輸入父類別名稱:(輸入-1結束新增收入)") ;
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
                // 如果要附加物件至檔案後
                // 必須重新定義這個方法
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