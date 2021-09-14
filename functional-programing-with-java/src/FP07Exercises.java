import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FP07Exercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
				"AWS", "PCF", "Azure", "Docker", "Kubernetes");
		
		 List<String> list = Arrays.asList("5.6", "7.4", "4", 
                 "1", "2.3"); 
		 
		 List<String> list2 = Arrays.asList("Geeks", "GFG", 
                 "GeeksforGeeks", "gfg"); 
		
		System.out.println(courses.stream().collect(Collectors.joining(" ")));
		
		System.out.println(courses.stream().collect(Collectors.joining(",")));
		
		System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream)
				.collect(Collectors.toList()));
		
		System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream)
			.distinct().collect(Collectors.toList()));
		
//		list.stream().flatMap(num -> Stream.of(num)).forEach(System.out::println);
		 
//		
//		System.out.println(courses.stream().flatMap(x-> x.stream()).collect(Collectors.toList()));
//		list.stream().flatMap(num -> Stream.of(num)).forEach(System.out::println);
		
//		System.out.println(courses.stream().map(course -> course.split("")).collect(Collectors.toList()));
 
	}

}
