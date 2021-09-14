import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FP01Exercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List.of is introduced in Java 9
		//Arrays.asList is introduced in Java 8 
		//returns a fixed-size list backed by the specified array
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
		
//		printOddNumbersInList(numbers);
//		printCoursesInList(courses);
//		printSpringCoursesInList(courses);
//		printCoursesInListLengthFour(courses);
//		printCubesOfOddNumbersInList(numbers);
		printCharacterLengthOfCoursesInList(courses);
		String ans = null;
		String anss = "hello";
		
		//Optional is just a way to avoid returning nulls and to avoid null pointer exception 
		//Optional.ofNullable returns an optional describing the specified value if not null
		//returns an empty optional if null value is present 
		System.out.println(Optional.ofNullable(ans));
		System.out.println(Optional.ofNullable(anss));
		
		Map<Integer, String> map = new HashMap<>();
		
		map.put(1, "Dhawan");
		map.put(2, "Shaw");
		map.put(3, "Rishabh");
		map.put(4, "Iyer");
		
		//1st Method to print map
		map.forEach((key, value) -> System.out.println(key + " " + value));
		
		//2nd method to print map
		map.entrySet().stream().forEach(System.out::println);

	}

	private static void printCharacterLengthOfCoursesInList(List<String> courses) {
		// TODO Auto-generated method stub
		courses.stream()
		.map(course -> course+ " "+ course.length())
		.forEach(System.out::println);
		
		
	}

	private static void printCubesOfOddNumbersInList(List<Integer> numbers) {
		// TODO Auto-generated method stub
		numbers.stream()
		.filter(number -> number%2 != 0)
		.map(number -> number*number*number)
		.forEach(System.out::println);
		
	}

	private static void printCoursesInListLengthFour(List<String> courses) {
		// TODO Auto-generated method stub
		courses.stream()
		.filter(course -> course.length()>=4)
		.forEach(System.out::println);
		
	}

	private static void printSpringCoursesInList(List<String> courses) {
		// TODO Auto-generated method stub
		courses.stream()
		.filter(course -> course.contains("Spring"))
		.forEach(System.out::println);
		
	}

	private static void printCoursesInList(List<String> courses) {
		// TODO Auto-generated method stub
		courses.stream()
		.forEach(System.out::println);
		
	}

	private static void printOddNumbersInList(List<Integer> numbers) {
		// TODO Auto-generated method stub
		numbers.stream()
		.filter(number -> number%2 != 0)
		.forEach(System.out::println);
		
	}
	
	

}
