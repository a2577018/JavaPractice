import java.util.* ;

public class TestArraySort {

	public static void main(String[] args) {
		int[] books = { 500, 800, 600, 700 } ;
		System.out.print( "�Ƨǫe : ") ;
		for ( int price : books ) 
			System.out.println( price ) ;
		
        Arrays.sort( books ) ;
		
        System.out.println( "�Ƨǫ� : ") ;
        
		for ( int price : books ) 
			System.out.println( price ) ;        
	}

}
