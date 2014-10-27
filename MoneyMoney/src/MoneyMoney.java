import java.io.*;
import java.util.*;

class MyAccount implements Comparable<MyAccount>, Serializable {
	private static final long serialVersionUID = 1L;
	String name ;
	Integer cost ;
	String date ;
	
	MyAccount( String inputName, Integer inputCost, String inputDate ) {
		this.name = inputName ;
		this.cost = inputCost ;
		this.date = inputDate ;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getCost() {
		return cost;
	}
	
	public String getDate() {
		return date;
	}
	
	public int compareTo( MyAccount obj ) {
		return this.cost.compareTo(obj.cost) ;
	}
	
	public void show(){
		System.out.println("=================") ;
		System.out.println("名稱：" + name) ;
		System.out.println("花費:" + cost) ;
		System.out.println("日期:" + date) ;
	}
	
} // class MyAccount

public class MoneyMoney {
	static void InputData( TreeSet<MyAccount> myAccounts, String filename ) throws IOException {
		Scanner scanner = new Scanner(System.in) ;
		String name = null ;
		Integer cost = 0 ;
		String date = null ;
		
		for ( int i = 0 ; i < 1 ; i++ ) {
		  System.out.println("請輸入類別名稱:") ;
		  name = scanner.next() ;

		  System.out.println("請輸入花費:") ;
		  cost = scanner.nextInt() ;		
		
		  System.out.println("請輸入日期:") ;
		  date = scanner.next() ;			
		  
		  MyAccount newData = new MyAccount( name, cost, date ) ;
		  myAccounts.add(newData) ;
		} // end while
		
		File file = new File( filename ) ;
		
        try {
            ObjectOutputStream objOutputStream = 
               new ObjectOutputStream(
                  new FileOutputStream(file,true)) { 
                // 如果要附加物件至檔案後
                // 必須重新定義這個方法
                protected void writeStreamHeader() 
                                 throws IOException { reset(); } 
           };  

       		for ( MyAccount myAccount : myAccounts ) {
       			objOutputStream.reset();
       			objOutputStream.writeObject(myAccount) ;
    		}
            
            objOutputStream.close(); 
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        } 
	}
	
	static void OutputData( TreeSet<MyAccount> myAccounts, String filename ) throws IOException, ClassNotFoundException{
		File file = new File( filename ) ;
		
        FileInputStream fis = new FileInputStream( file );
        ObjectInputStream ois = new ObjectInputStream( fis ){ 
            protected void readStreamHeader() 
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
	
	public static void main(String[] args) throws Exception{
		TreeSet<MyAccount> myAccounts = new TreeSet<MyAccount>() ;
		String filename = "data.dat" ;
		
		InputData( myAccounts, filename ) ;
		
		OutputData( myAccounts, filename ) ;
	}

}
