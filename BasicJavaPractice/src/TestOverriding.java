
public class TestOverriding {

	public static void main(String[] args) {
		ComputerBook cBook = new ComputerBook() ;
		cBook.name = "Thinking in Java" ;
		cBook.price = 580.0 ;
		cBook.author = "Allen" ;
		cBook.hasDisk = true ;
		cBook.show(); // cBook物件屬於ComputerBook()，所以呼叫ComputerBook()的show()方法

	}

}
