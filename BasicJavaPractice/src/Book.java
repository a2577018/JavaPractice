
class Book{
	String name ;
	double price ;
	String author ;
	Book() { // �w�]�غc�l
		name = "����" ;
		price = 0.0 ;
		author = "����" ;
	}
	
	Book( String n, double p, String a ) { // �D�w�]�غc�l
		name = n ;
		price = p ;
		author = a ;
	}
	
	double getPrice(double discount) {
		return price * discount ;
	}
	
	void setPrice( double d ) { d *= 0.9 ;} 
	void setPrice( Book b) { b.price *= 0.9 ;} // Overloading	
	
	void show() {
		System.out.println("�ѦW:"+name) ;
		System.out.println("�w��:"+price) ;
		System.out.println("�@��:"+author) ;
	} // show()
	
} // Book

class ComputerBook extends Book{
	boolean hasDisk ;
	void show() { // overriding show()
		System.out.println("�ѦW:"+name) ;
		System.out.println("�w��:"+price) ;
		System.out.println("�@��:"+author) ;
		System.out.println("������?:"+hasDisk) ;
	}
}

class ComicBook extends Book{
	boolean hasPoster ;
	ComicBook( String n, double p, String a, boolean h ) {
		super(n, p, a ) ; // �I�s�����O(Book)�غc�l
		hasPoster = h ;
		this.show(); // �I�s�ۤv��show()��k
	}
	
	void show() {
		super.show(); // �I�s�����O��show()��k
		System.out.println("������?:"+hasPoster) ;
	}
}

