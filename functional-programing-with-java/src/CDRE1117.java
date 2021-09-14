import java.math.BigDecimal;
import java.util.Objects;
import java.util.stream.Stream;



//Validate Parameters
public class CDRE1117 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean ans = DataPopulationProcessType.isValidEnum("TRANSFORM");
		System.out.println(ans);
		System.out.println("he   " +BigDecimal.ZERO.longValue());
		

	}
	
//	Every enum constant represents an object of type enum
//	An enum is a special "class" that represents a group of constants 
	public enum DataPopulationProcessType{
		IMPORT, METADATA, TRANSFORM;
	
	
	
		public static boolean isValidEnum(String enumName) {
//		if(Objects.isNull(enumName)) {
//			return false;
//		}
		
			if(enumName == null) {
				return false;
			}
		
//		values() method can be used to return all values present inside enum.
			return Stream.of(DataPopulationProcessType.values()).peek(System.out::println)
				.anyMatch(v -> v.toString().equals(enumName));
		}
	}
	

}
