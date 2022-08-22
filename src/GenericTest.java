
public class GenericTest {

	public static void main(String[] args) {
		IntegerPrinter test = new IntegerPrinter(4444);
		
		test.print();
	}

}

class IntegerPrinter {
	Integer thingToPrint;
	
	public IntegerPrinter(Integer thingToPrint) {
		this.thingToPrint = thingToPrint;
	}
	
	public void print() {
		System.out.println(thingToPrint);
	}
}



