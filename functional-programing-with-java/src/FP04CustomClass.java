import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course{
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;
	
	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	@Override
	public String toString() {
//		return "Course [name=" + name + ", category=" + category + ", reviewScore=" + reviewScore
//				+ ", noOfStudents=" + noOfStudents + "]";
		
		return name +":"+reviewScore+":"+ noOfStudents;
	}
	
}

public class FP04CustomClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//refactor-> extract local variable
		
		List<Course> courses = List.of(
				new Course("Spring", "Framework", 98, 20000),
				new Course("SpringBoot", "Framework", 95, 18000),
				new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000),
				new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000),
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000)
				);
		
		
//		courses.stream().forEach(System.out::println);
		
		//allMatch , noneMatch, anyMatch
		
		//allMatch - it returns true if every(all) element in the stream matches the condition.
		Predicate<Course> reviewScoreGreaterThan95Predicate 
			= course -> course.getReviewScore()>95;
//		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
			System.out.println("ALL MATCH");
		System.out.println(courses.stream().allMatch(course-> course.getReviewScore()>90));
		
		//noMatch - it returns true if no element in the stream matches the condition.
		Predicate<Course> reviewScoreLessThan90predicate = course-> course.getReviewScore()<90;
		System.out.println("NO MATCH");
		System.out.println(courses.stream().noneMatch(course-> course.getReviewScore()<90));
//		System.out.println(courses.stream().noneMatch(reviewScoreLessThan90predicate));
		
		//anyMatch - it returns true if any element in the stream matches the condition.
//		Predicate<Course> reviewScoreLessThan90Predicate = course-> course.getReviewScore()<90;
//		System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
		System.out.println("ANY MATCH");
		System.out.println(courses.stream().anyMatch(course-> course.getReviewScore()<90));
		
		//Sorting Courses //Comparator
		
		Comparator<Course> comparingByNoOfStudentsIncreasing = 
				Comparator.comparing(Course::getNoOfStudents);
		
		Comparator<Course> comparingByNoOfStudentsDecreasing = 
				Comparator.comparing(Course::getNoOfStudents).reversed();
		
		Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = 
				Comparator.comparing(Course::getNoOfStudents)
				.thenComparing(Course::getReviewScore);
		
//		System.out.println(courses.stream().sorted(comparingByNoOfStudentsIncreasing)
//				.collect(Collectors.toList()));
//		
//		System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing)
//				.collect(Collectors.toList()));
//		
//		System.out.println("****" +courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews)
//				.collect(Collectors.toList()));
		
		System.out.println("Comparing by no. of students increasing");
		System.out.println(courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents))
				.collect(Collectors.toList()));
		
		System.out.println("Comparing by no. of students increasing in Primitive Way");
		System.out.println(courses.stream().sorted(Comparator.comparingInt(Course::getNoOfStudents))
				.collect(Collectors.toList()));
		
		
		System.out.println("Comparing by no. of students decreasing");
		System.out.println(courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents).reversed())
				.collect(Collectors.toList()));
		
		System.out.println("********************");
		System.out.println("Comparing by no. of students and no. of reviews");
		System.out.println(courses.stream().sorted(Comparator.comparingInt(Course::getNoOfStudents).thenComparing(Course::getReviewScore))
				.collect(Collectors.toList()));
		
		System.out.println("Comparing by no. of students and no. of reviews decreasing");
		System.out.println(courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed())
				.collect(Collectors.toList()));
		
		//Limit -> limit(N) => It returns first N elements in the encounter order of the stream.
		System.out.println("********************");
		System.out.println("LIMIT");
		System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews)
				.limit(5).collect(Collectors.toList()));
		
		//Skip -> skip(N) => It skips first N elements in the encounter order of the stream
		System.out.println("**************");
		System.out.println("SKIP");
		System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews)
				.skip(3).collect(Collectors.toList()));
		
		//takeWhile -> when an element is encountered that does not match the predicate,
//		the rest of the stream is discarded
		
		//stream se cheeje lete raho jab tak first element ki condition meet nahi karti
		System.out.println("**************");
		System.out.println("TAKE WHILE");
		System.out.println(courses.stream().takeWhile(course -> course.getReviewScore()>=95)
				.collect(Collectors.toList()));
		
//		dropWhile is essentially the opposite of takeWhile. 
//		Instead of taking elements from the stream until the first element which does not match the predicate, 
//		dropWhile drops these elements and includes the remaining elements in the returned stream.
		//stream se cheeje skip karte raho jab tak first element ki condition meet nahi karti
		System.out.println("***************");
		System.out.println("DROP WHILE");
		System.out.println(courses.stream().dropWhile(course -> course.getReviewScore()>=95)
				.collect(Collectors.toList()));
		
		
		
//		As the name suggests, min() and max() return the minimum and maximum element in the stream 
//		respectively,
//		based on a comparator.
//		They return an Optional since a result may or may not exist (due to, say, filtering):
		System.out.println("******************");
		System.out.println("MAX");
		//max- it returns last element in the list of sorted comparator courses
		System.out.println(courses.stream().max(comparingByNoOfStudentsAndNoOfReviews));
		
		System.out.println("MAX 2");
		System.out.println(courses.stream().max(Comparator.comparing(Course::getNoOfStudents)));
		
		
		System.out.println("************");
		System.out.println("MIN");
		//min- it returns first element in the list of sorted comparator courses
		System.out.println(courses.stream().min(comparingByNoOfStudentsAndNoOfReviews)
				.orElse(new Course("Kubernetes", "Cloud", 91, 20000)));
		
		
//		System.out.println(courses.stream().filter(reviewScoreLessThan90predicate)
//				.max(comparingByNoOfStudentsAndNoOfReviews).orElseThrow(NoSuchElementException::new));
		
		//The findAny() method returns any element from a Stream
//		while the findFirst() method returns the first element in a Stream.
		System.out.println("*****************");
		System.out.println("FIND FIRST");
		System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate)
				.findFirst());
		
		
		System.out.println("*****************");
		System.out.println("FIND ANY");
		System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate)
				.findAny());
		
		//calculate total no. of students whose score is greater than 95
		
		System.out.println("CALCULATE TOTAL NO. OF STUDENTS WHOSE SCORE IS GREATER THAN 95");
		
		
		List<Integer> sample = courses.stream()
				.filter(course -> course.getReviewScore()>95).map(course-> course.getNoOfStudents())
			.collect(Collectors.toList());
		
		System.out.println(sample);
		
//		System.out.println(courses.stream()
//				.filter(reviewScoreGreaterThan95Predicate).map(course-> course.getNoOfStudents()));
//				.collect(Collectors.toList());
		
		System.out.println(courses.stream()
				.filter(reviewScoreGreaterThan95Predicate).mapToInt(course-> course.getNoOfStudents())
						.sum());
		
		
		
		//Average
		System.out.println("AVERAGE");
		System.out.println(courses.stream()
				.filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents)
						.average());
		
		//Count- 
		//Calculate no. of courses that met the criteria
		System.out.println(courses.stream()
				.filter(reviewScoreGreaterThan95Predicate).count());
		
		//Calculate the maximum value of no. of students of a course which has a review 
		//score greater than 95
		System.out.println("Calculate the maximum value of no. of students of a course "
				+ "which has a review score greater than 95");
		System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate)
				.mapToInt(Course::getNoOfStudents)
				.max());
		
	
		
		//Calculate the minimum value of no. of students of a course which has a review 
				//score greater than 95
		System.out.println("Calculate the minimum value of no. of students of a course "
				+ "which has a review score greater than 95");
		System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate)
				.mapToInt(Course::getNoOfStudents)
				.min());
		
		//Grouping courses into Map using groupingBy
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
		
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		
		
		//Course with the highest review score in the specific category
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory,
				Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory,
				Collectors.mapping(Course::getName, Collectors.toList()))));

	}

}
