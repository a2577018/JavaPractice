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
		
		System.out.println("�п�J���O�W��:(��J-1����)") ;
		name = scanner.next() ;		
		while ( !name.equals("-1") ) {

		  System.out.println("�п�J��O:") ;
		  cost = scanner.nextInt() ;		
		
		  System.out.println("�п�J���:") ;
		  date = scanner.next() ;			
		  
		  MyAccount newData = new MyAccount( name, cost, date ) ;
		  myAccounts.add(newData) ;

		  System.out.println("�п�J���O�W��:(��J-1����)") ;
		  name = scanner.next() ;		
		} // end while
		
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

        System.out.println(file.getName() + "�ɮפ��e�p�U:");
        try{
            while(true){
                ((MyAccount)ois.readObject()).show();
            }
        }
        catch(EOFException e){
            System.out.println("���Ū������");
        }
        ois.close();
        fis.close();
	}
	
	
}
