package InputAndOutput;
import java.io.*;
import java.util.TreeSet;

import MyAccount.MyAccount;

public class Output {
	public void PrintAllData( ) throws IOException, ClassNotFoundException{
		String filename = "data.dat" ;
		int countData = 0 ;
		File file = new File( filename ) ;
		try {
			FileInputStream fis = new FileInputStream( file );
			
	        ObjectInputStream ois = new ObjectInputStream( fis ){
	            protected void readStreamHeader ()
	                             throws IOException { }
	       };
			
	        System.out.println("目前所有資料內容如下:");
	        try{
	            while(true){
	            	countData++ ;
	            	MyAccount tempMyAccount = ((MyAccount)ois.readObject()) ;
	            	System.out.println("=================") ;
	        		System.out.println("父類名稱：" + tempMyAccount.getFatherCategory()) ;
	        		System.out.println("子類名稱：" + tempMyAccount.getSonCategory()) ;
	        		System.out.println("花費:" + tempMyAccount.getCost()) ;
	        		System.out.println("日期:" + tempMyAccount.getDate()) ;
	            } // while
	        } // try
	        catch(EOFException e){
	        	System.out.println("=================") ;
	            System.out.println("總共有" + countData + "筆資料" );
	        } // catch
	        ois.close();
	        fis.close();
		} // try
        catch (FileNotFoundException e ) {
        	System.out.println("找不到檔案 " + file.getName() ) ;
        } // catch
	} // PrintAllData( )
	
	public static void PrintCountData() {
		
	} //  PrintCountData()

	public static void PrintCountData(int totalCount, TreeSet<MyAccount> tempAccounts) {
		System.out.println("總共花費" + totalCount ) ;
		System.out.println("明細如下:" ) ;
		
		for (MyAccount myAccount : tempAccounts) {
        	System.out.println("=================") ;
    		System.out.println("父類名稱：" + myAccount.getFatherCategory()) ;
    		System.out.println("子類名稱：" + myAccount.getSonCategory()) ;
    		System.out.println("花費:" + myAccount.getCost()) ;
    		System.out.println("日期:" + myAccount.getDate()) ;
		} // for each
		
	}
} // Output()
