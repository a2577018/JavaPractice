
public class TestConstructor {

	public static void main(String[] args) {
		Book[] books = new Book[3] ; // �}�C�i�x�s�j�q����
		books[0] = new Book(); // �I�s�w�]�غc�l
		books[1] = new Book( "Thinking in Java", 580.0, "Allen" ) ; // �I�s�D�w�]�غc�l
		books[2] = new Book( "���x����", 100.0, "���W����" ) ; // �I�s�D�w�]�غc�l
		for ( Book book : books ) {
			book.show() ;
			System.out.println("=========") ;
		} // end for

	}

}
