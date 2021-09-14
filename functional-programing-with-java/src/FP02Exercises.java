import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Exercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
//		int sum = printSumOfSquaresOfNumbersInList(numbers);
//		int sum = printSumOfOddNumbersInList(numbers);
//		System.out.println(sum);
//		printDistinctNumbersInList(numbers);
		printSortedNumbersInList(numbers);
		printSortedAscendingCoursesUsingComparator(courses);
		printSortedDescendingCoursesUsingComparator(courses);
//		printCoursesOnStringLengthUsingComparator(courses);
		
//		List<Integer> doubledNumbers = doubleList(numbers);
//		System.out.println(doubledNumbers);
		
//		Create a list with Even Numbers filtered from the Numbers list
//		List<Integer> evenNumbers = evenList(numbers);
//		System.out.println(evenNumbers);
		
//		Create a list with length of all course titles
		List<Integer> courseLength = courseLengthList(courses);
		System.out.println(courseLength);

	}

    private static List<Integer> courseLengthList(List<String> courses) {
		// TODO Auto-generated method stub
    	
		return courses.stream().map(course-> course.length()).collect(Collectors.toList());
	}

	private static List<Integer> evenList(List<Integer> numbers) {
		// TODO Auto-generated method stub
		return numbers.stream().filter(number-> number%2 == 0)
				.collect(Collectors.toList());
	}

//	It allows you to accumulate the result into a choice for containers you want like a list, set, or a map.
//	Programmers often confuse that the collect() method belongs to the Collector class but that's not true. 

	//	It is defined in Stream class and that's why you can call it on Stream after doing any filtering or mapping. 
//	It accepts a Collector to accumulate elements of Stream into a specified Collection.

	//	The Collector class provides different methods like toList(), toSet(), toMap(), and toConcurrentMap() 
//	to collect the result of Stream into List, Set, Map, and ConcurrentMap in Java.

//It also provides a special toCollection() method which can be used to collect Stream elements into a specified Collection
//	like ArrayList, Vector, LinkedList, or HashSet.
	



    private static List<Integer> doubleList(List<Integer> numbers) {
		// TODO Auto-generated method stub
		return numbers.stream().map(number-> number*number)
				.collect(Collectors.toList()); //R
	}

//	Using Comparators To Sort Streams With Sorted
	private static void printCoursesOnStringLengthUsingComparator(List<String> courses) {
		// TODO Auto-generated method stub
		courses.stream().sorted(Comparator.comparing(str-> str.length()))
		.forEach(System.out::println);
		
	}

//	Using Comparators To Sort Streams With Sorted
	private static void printSortedDescendingCoursesUsingComparator(List<String> courses) {
		// TODO Auto-generated method stub
		System.out.println("printSortedDescendingCoursesUsingComparator");
		courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
	}

//	Using Comparators To Sort Streams With Sorted
	private static void printSortedAscendingCoursesUsingComparator(List<String> courses) {
		// TODO Auto-generated method stub
		System.out.println("printSortedAscendingCoursesUsingComparator");
		courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		
	}

//	Stream Operations-Sorted
	private static void printSortedNumbersInList(List<Integer> numbers) {
		// TODO Auto-generated method stub
		numbers.stream()  
		.sorted() //Stream<T>
		.forEach(System.out::println); //void
		
	}

	//Stream Operations - Distinct
	private static void printDistinctNumbersInList(List<Integer> numbers) {
		// TODO Auto-generated method stub
		numbers.stream()
		.distinct() //Stream<T>
		.forEach(System.out::println); //void
		
	}

	private static int printSumOfOddNumbersInList(List<Integer> numbers) {
		// TODO Auto-generated method stub
		return numbers.stream()
				.filter(number -> number%2!=0) //Stream<T>
				.reduce(0, (x,y)->x+y);
	}

	private static int printSumOfSquaresOfNumbersInList(List<Integer> numbers) {
		// TODO Auto-generated method stub
		return numbers.stream()
		.map(number -> number*number) //Stream<R>
		.reduce(0, (x,y)-> x+y);
		
	}

}
