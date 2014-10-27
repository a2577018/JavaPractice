package InputAndOutput;
import java.io.*;
import java.util.*;

import MyAccount.MyAccount;

public class InputAndOutput {
	public void InputData( TreeSet<MyAccount> myAccounts, String filename ) throws IOException {
		Scanner scanner = new Scanner(System.in) ;
		String name = null ;
		Integer cost = 0 ;
		String date = null ;
		
		System.out.println("請輸入類別名稱:(輸入-1結束)") ;
		name = scanner.next() ;		
		while ( !name.equals("-1") ) {

		  System.out.println("請輸入花費:") ;
		  cost = scanner.nextInt() ;		
		
		  System.out.println("請輸入日期:") ;
		  date = scanner.next() ;			
		  
		  MyAccount newData = new MyAccount( name, cost, date ) ;
		  myAccounts.add(newData) ;

		  System.out.println("請輸入類別名稱:(輸入-1結束)") ;
		  name = scanner.next() ;		
		} // end while
		
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

       		for ( MyAccount myAccount : myAccounts ) {
       			objOutputStream.writeObject(myAccount) ;
    		}
            
            objOutputStream.close(); 
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        } 
	}
	
	public void OutputData( TreeSet<MyAccount> myAccounts, String filename ) throws IOException, ClassNotFoundException{
		File file = new File( filename ) ;
		
        FileInputStream fis = new FileInputStream( file );
        ObjectInputStream ois = new ObjectInputStream( fis ){
            protected void readStreamHeader ()
                             throws IOException { }
       };

        System.out.println(file.getName() + "檔案內容如下:");
        try{
            while(true){
                ((MyAccount)ois.readObject()).show();
            }
        }
        catch(EOFException e){
            System.out.println("資料讀取完畢");
        }
        ois.close();
        fis.close();
	}
	
	
}
