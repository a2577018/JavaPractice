
public class TestMethod {

	public static void main(String[] args) {
		Book book1 = new Book();
		book1.name = "Thinking in Java" ;
		book1.price = 580.0 ;
		book1.author = "Allen" ;
		double p = 580.0 ;
		
		book1.show();
		System.out.println("°â»ù" + book1.getPrice(0.9)) ;
				
		book1.setPrice(p) ; // pass by value
		book1.setPrice(book1) ; // pass by reference
		
		System.out.println("p = " + p ) ;
		System.out.println("book1.price = " + book1.price ) ;

	}

}
