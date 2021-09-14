import java.util.List;

public class FP01Functional {
	
	//Filter -> This produces a new stream that contains elements of the original stream that passes
	//a given test

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		printAllNumbersInListFunctional(List.of(1,2,3,45,100,22,99));
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
//		printAllNumbersInListFunctional(numbers);
		printEvenNumbersInListFunctional(numbers);
//		printSquaresOfEvenNumbersInListFunctional(numbers);
		
		

	}
	
    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
		// TODO Auto-generated method stub
    	numbers.stream() //Convert to stream
    	.filter(number -> number%2 == 0) //Lambda Expression
    	.map(number -> number*number) //Mapping x -> x*x
    	.forEach(System.out::println); //Method Reference
		
	}

//	private static void print(int number) {
//		System.out.println(number);
//	}
	
	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
//		[1,2,3,45,100,22,99]
//		1
//		2
//		3
//		..
		//Convert list into stream // 1st method
//		numbers.stream()
//		.forEach(FP01Functional::print);  //Method Reference
		
		//2nd method
		numbers.stream()
		.forEach(System.out::println);
	}
	
	private static boolean isEven(int number) {
		return number%2==0;
	}
	
	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
//		numbers.stream()
//		.filter(FP01Functional::isEven) //Filter - only allow even numbers
//		.forEach(System.out::println); //Method Reference
		
		
//		Lambada Expression - It is a simplified way to represent method interface
//		using an expression
		
		numbers.stream() //Convert to stream
		.filter(number -> number%2==0) //Lambda Expression
		.forEach(System.out::println); //Method Reference
	}

}
