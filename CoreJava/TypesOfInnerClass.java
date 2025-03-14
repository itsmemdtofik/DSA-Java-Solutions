/*
Types of Inner Class :

(1)Nested Inner Class
(2)Method Local Inner Class
(3)Static Nested Class
(4)Anonymous Inner Class

*/

/*(1)Nested Inner Class*/

class OuterClass{
	class InnerClass{
		public void Display(){
			System.out.println("I am Nested Inner Class");
		}
	}
}

class TypesOfInner {
	public static void main(String[] args) {
		OuterClass.InnerClass inner = new OuterClass().new InnerClass();
		inner.Display();
	}
	
}

/*Method Local Inner Class*/

class Outer{
	public void OuterMethod(){
		System.out.println("I am inside OuterMethod");
		class Inner{
			public void innerMethod(){
				System.out.println("I am inside innerMethod");
			}
		}

		Inner inner = new Inner();
		inner.innerMethod();
	}
}

class TypesOfInnerClass {
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.OuterMethod();
	}
	
}


/*Static Nested Class*/