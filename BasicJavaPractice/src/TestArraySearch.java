import java.util.Arrays;

public class TestArraySearch {

	public static void main(String[] args) {
		int[] books = { 500, 800, 600, 700 } ;
		
        Arrays.sort( books ) ; // �j�M�e�����Ƨ�
		
        int i1 = Arrays.binarySearch(books, 600) ;
        System.out.println( "�Ƨǫ�ѻ�600����index = " + i1 ) ;
        
        int i2 = Arrays.binarySearch(books, 900) ;
        System.out.println( "�Ƨǫ�ѻ�900����index = " + i2 ) ;       
	}

}
