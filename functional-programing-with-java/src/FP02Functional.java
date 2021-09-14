import java.util.List;

public class FP02Functional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		int sum = addListFunctional(numbers);
		System.out.println(sum);
		
//		int max = findMaximumNumberInList(numbers);
//		System.out.println(max);
		
		int min = findMinimumNumberInList(numbers);
		System.out.println(min);

	}
	
    private static int findMinimumNumberInList(List<Integer> numbers) {
		// TODO Auto-generated method stub
    	return numbers.stream().reduce(Integer.MAX_VALUE, (x,y)-> x>y? y:x);
	}

	private static int findMaximumNumberInList(List<Integer> numbers) {
		// TODO Auto-generated method stub
    	return numbers.stream().reduce(Integer.MIN_VALUE, (x,y)-> x>y? x:y);
		
	}

//	a- aggregate, b- nextNumber
	private static int sum(int a, int b) {
		return a+b;
	}

	private static int addListFunctional(List<Integer> numbers) {
		// TODO Auto-generated method stub
		//Reduce - It performs a reduction on the elements of this stream, 
//		using the provided identity value and an accumulation 
//		function, and returns the reduced value.
		
		
		//reduction stream operations allow us to produce one single result from a sequence of elements, 
		//by repeatedly applying a combining operation to the elements in the sequence.
		
//		1st method
//		return numbers.stream()
//		.reduce(0, FP02Functional::sum);
		
//		2nd method
//		return numbers.stream()
//		.reduce(0, (x,y)-> x+y);
		
//		3rd method
		return numbers.stream()
		.reduce(0, Integer::sum);
		
	}

}
