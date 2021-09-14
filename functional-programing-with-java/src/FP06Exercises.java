import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FP06Exercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initially we were creating stream like this
		//List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		
		//Create stream directly
		//Creating streams using stream of method and for arrays //reference pipeline
		System.out.println(Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
		
		
		//Creating streams with primitive values //int pipeline
		int[] numberArray = {12, 9, 13, 4, 6, 2, 4, 12, 15};
		System.out.println(Arrays.stream(numberArray)); //java.util.stream.IntPipeline$Head@9e89d68
		
		//Converting arrays into streams
		System.out.println(Stream.of(numberArray)); //java.util.stream.ReferencePipeline$Head@ed17bee
		
		char[] ch = { 'G', 'e', 'e', 'k', 's',
                'f', 'o', 'r',
                'G', 'e', 'e', 'k', 's' };
//		System.out.println(Arrays.stream(ch));
		System.out.println(Stream.of(ch));
		
		
		//On int pipeline we can use diirectly sum, average, min, max while we can't use this 
		//in reference pipeline //Primitive Streams
		System.out.println(Arrays.stream(numberArray).sum());
		
		System.out.println(Arrays.stream(numberArray).average());
		
		System.out.println(Arrays.stream(numberArray).min());
		
		System.out.println(Arrays.stream(numberArray).max());
		
		//exclude 10
		System.out.println(IntStream.range(1, 10).sum());
		
		
		//include 10
		System.out.println(IntStream.rangeClosed(1,10).sum());
		
		System.out.println(IntStream.iterate(1, e-> e+2).limit(10).sum());
		
		//peek is an intermediate operation which doesn't operate on the entire collection
//		until the terminal operation runs,
//		but forEach is indeed a terminal operation
		
		//Print first 10 odd numbers and finally print the sum
		System.out.println(IntStream.iterate(1, e-> e+2).limit(10).peek(System.out::println).sum());
		
		//Print first 10 even numbers and finally print the sum
		System.out.println("First 10 Even Numbers "+ IntStream.iterate(2, e-> e+2).limit(10).peek(System.out::println).sum());
		
		//Calculate first 10 powers of 2
		System.out.println("First 10 Powers of 2 "+ IntStream.iterate(2, e-> e*2).limit(10).peek(System.out::println).sum());
		
		//We cannot apply collect directly to a primitive stream
		//This is because the values in the stream are primitive
		//convert primitive stream to list
		System.out.println(IntStream.iterate(2, e->e*2).limit(10).boxed().collect(Collectors.toList()));
		
//		Doing Big Number Calculations with BigInteger
//		BigInteger class is used for mathematical operation 
//		which involves very big integer calculations that are outside
//		the limit of all available primitive data types.
		
		System.out.println(LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf)
				.reduce(BigInteger.ONE, BigInteger::multiply));
		

	}

}
