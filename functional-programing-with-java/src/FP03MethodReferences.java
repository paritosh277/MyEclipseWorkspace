import java.util.List;

public class FP03MethodReferences {
	
	private static void print(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> iplTeams = List.of("Chennai Super Kings", "Delhi Capitals",
				"Kings XI Punjab", "Mumbai Indians", "Rajasthan Royals", "Royal Challengers Bangalore",
				"Sunrisers Hyderabad");
		
//		iplTeams.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
		
		//2nd Method
		iplTeams.stream().map(String::toUpperCase).forEach(FP03MethodReferences::print);

	}

}
