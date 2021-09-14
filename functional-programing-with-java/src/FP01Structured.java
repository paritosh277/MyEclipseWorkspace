import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ArrayList initialization through List.of()
		
//		printAllNumbersInListStructured(List.of(1,2,3,4,5));
		List<Integer> numbers = List.of(1,2,3,4,5);
		printAllNumbersInListStructured(numbers);
		printEvenNumbersInListStructured(numbers);

	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		// TODO Auto-generated method stub
		for(int number: numbers) {
			System.out.println(number);
		}
		
	}
	
	private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		// TODO Auto-generated method stub
		for(int number: numbers) {
			if(number%2==0) {
				System.out.println(number);
			}
			
		}
		
	}
	

}
