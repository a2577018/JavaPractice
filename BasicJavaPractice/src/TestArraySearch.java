import java.util.Arrays;

public class TestArraySearch {

	public static void main(String[] args) {
		int[] books = { 500, 800, 600, 700 } ;
		
        Arrays.sort( books ) ; // 搜尋前必須排序
		
        int i1 = Arrays.binarySearch(books, 600) ;
        System.out.println( "排序後書價600元的index = " + i1 ) ;
        
        int i2 = Arrays.binarySearch(books, 900) ;
        System.out.println( "排序後書價900元的index = " + i2 ) ;       
	}

}
