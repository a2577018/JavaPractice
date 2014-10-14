
class Book{
	String name ;
	double price ;
	String author ;
	Book() { // 預設建構子
		name = "不詳" ;
		price = 0.0 ;
		author = "不詳" ;
	}
	
	Book( String n, double p, String a ) { // 非預設建構子
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
		System.out.println("書名:"+name) ;
		System.out.println("定價:"+price) ;
		System.out.println("作者:"+author) ;
	} // show()
	
} // Book

class ComputerBook extends Book{
	boolean hasDisk ;
	void show() { // overriding show()
		System.out.println("書名:"+name) ;
		System.out.println("定價:"+price) ;
		System.out.println("作者:"+author) ;
		System.out.println("附光碟?:"+hasDisk) ;
	}
}

class ComicBook extends Book{
	boolean hasPoster ;
	ComicBook( String n, double p, String a, boolean h ) {
		super(n, p, a ) ; // 呼叫父類別(Book)建構子
		hasPoster = h ;
		this.show(); // 呼叫自己的show()方法
	}
	
	void show() {
		super.show(); // 呼叫父類別的show()方法
		System.out.println("附海報?:"+hasPoster) ;
	}
}

