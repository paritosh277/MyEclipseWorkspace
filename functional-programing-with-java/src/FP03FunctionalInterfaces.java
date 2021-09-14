import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import com.sun.jdi.Method;

public class FP03FunctionalInterfaces {
	
	//Refactor-> Extract Local Variable
	
//	An Interface that contains exactly one abstract method is known as functional interface. 
//	It can have any number of default, static methods but can contain only one abstract method. 
//	It can also declare methods of object class.
//
//	Functional Interface is also known as Single Abstract Method Interfaces or SAM Interfaces. 
//	It is a new feature in Java, which helps to achieve functional programming approach.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
//		Java Predicate Interface
//		It is a functional interface which represents a predicate (boolean-valued function) of one argument.
//		It is defined in the java.util.function package and contains test() a functional method.
		
		Predicate<Integer> isEvenPredicate = x-> x%2==0;
		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				return t%2==0;
			}

			
		};
		
		Function<Integer, Integer> squareFunction = x-> x*x;
		Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>(){
			
			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return t*t;
			}
		};
		
		Consumer<Integer> sysoutConsumer = System.out::println;
		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println(t);
				
			}
		};
		
		//Behind each lambda expression there is one functional interface
//		numbers.stream()
//		.filter(isEvenPredicate2)
//		.map(squareFunction2)
//		.forEach(sysoutConsumer2);
		
//		Find Functional Interface behind the second argument of reduce Method.
//		Create an implementation of the functional interface.
//		int sum = numbers.stream().reduce(0, Integer::sum);
		
		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
		//BinaryOperator<Integer> sumBinaryOperator = (x,y) => x + y;
		BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				// TODO Auto-generated method stub
				return t+u;
			}
		};
		
		numbers.stream()
		.reduce(0, sumBinaryOperator);
		
		//Supplier---- No input > Return Something
//		Supplier<Integer> randomIntegerSupplier = () -> 2;
		Supplier<Integer> randomIntegerSupplier = () ->{
			Random random = new Random();
			return random.nextInt(1000);
		};
//		System.out.println(randomIntegerSupplier.get());
		
		//UnaryOperator Functional Interfaces
		UnaryOperator<Integer> unaryOperator = (x)->3*x;
		System.out.println(unaryOperator.apply(10));
		
		//BiPredicate - output is boolean
		BiPredicate<Integer, String> biPredicate = (number, str) -> {
			return number<10 && str.length()>5;
		};
		
		System.out.println(biPredicate.test(5, "paritosh"));
		
		//BiFunction
		BiFunction<Integer, String, String> biFunction = (number,str) -> {
			return number+ " "+ str;
		};
		
		System.out.println(biFunction.apply(2, "Paritosh"));
		
		//BiConsumer
		BiConsumer<Integer, String> biConsumer = (number, str) -> {
			System.out.println(number);
			System.out.println(str);
		};
		
		biConsumer.accept(277, "Paritosh");
		
		

	}

}
