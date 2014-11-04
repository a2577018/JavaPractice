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
			
	        System.out.println("�ثe�Ҧ���Ƥ��e�p�U:");
	        try{
	            while(true){
	            	countData++ ;
	            	MyAccount tempMyAccount = ((MyAccount)ois.readObject()) ;
	            	System.out.println("=================") ;
	        		System.out.println("�����W�١G" + tempMyAccount.getFatherCategory()) ;
	        		System.out.println("�l���W�١G" + tempMyAccount.getSonCategory()) ;
	        		System.out.println("��O:" + tempMyAccount.getCost()) ;
	        		System.out.println("���:" + tempMyAccount.getDate()) ;
	            } // while
	        } // try
	        catch(EOFException e){
	        	System.out.println("=================") ;
	            System.out.println("�`�@��" + countData + "�����" );
	        } // catch
	        ois.close();
	        fis.close();
		} // try
        catch (FileNotFoundException e ) {
        	System.out.println("�䤣���ɮ� " + file.getName() ) ;
        } // catch
	} // PrintAllData( )
	
	public static void PrintCountData() {
		
	} //  PrintCountData()

	public static void PrintCountData(int totalCount, TreeSet<MyAccount> tempAccounts) {
		System.out.println("�`�@��O" + totalCount ) ;
		System.out.println("���Ӧp�U:" ) ;
		
		for (MyAccount myAccount : tempAccounts) {
        	System.out.println("=================") ;
    		System.out.println("�����W�١G" + myAccount.getFatherCategory()) ;
    		System.out.println("�l���W�١G" + myAccount.getSonCategory()) ;
    		System.out.println("��O:" + myAccount.getCost()) ;
    		System.out.println("���:" + myAccount.getDate()) ;
		} // for each
		
	}
} // Output()
