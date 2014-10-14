
public class TestConstructor {

	public static void main(String[] args) {
		Book[] books = new Book[3] ; // 陣列可儲存大量物件
		books[0] = new Book(); // 呼叫預設建構子
		books[1] = new Book( "Thinking in Java", 580.0, "Allen" ) ; // 呼叫非預設建構子
		books[2] = new Book( "灌籃高手", 100.0, "井上雄彥" ) ; // 呼叫非預設建構子
		for ( Book book : books ) {
			book.show() ;
			System.out.println("=========") ;
		} // end for

	}

}
