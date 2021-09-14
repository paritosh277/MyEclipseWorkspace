import java.util.ArrayList;
import java.util.List;

public class IterateAListUsingStreamApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<>();
		
		list.add("KL");
		list.add("Mayank");
		list.add("Gayle");
		list.add("Pooran");
		list.add("Moonis");
		
		list.stream().forEach(System.out::println);
		
		
		System.out.println("Print those name which starts with M");
		list.stream().filter(s->s.startsWith("M")).forEach(System.out::println);

	}

}
