import java.util.HashMap;
import java.util.Map;

public class IterateAMapUsingStreamApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, String> map = new HashMap<>();
		
		map.put(1, "Gill");
		map.put(2, "Rana");
		map.put(3, "Tripathi");
		map.put(4, "Morgan");
		
		System.out.println("1st method");
		map.forEach((key, value) -> System.out.println(key + ":" + value ));
		
		System.out.println("2nd method");
		map.entrySet().stream().forEach(System.out::println);
		
		System.out.println("Print Even Entries");
		map.entrySet().stream().filter(k -> k.getKey()%2==0).forEach(System.out::println);

	}

}
