package programing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalProgramingExampleKS {
	
	public static void main(String[] args) {
		
		List<String> courses = List.of("Java", "Nava", "Spring Core", "Spring JPA", "Spring Boot", "Spring Cloud", "Java Functional Programing", "Java Multi Threading");
		
		simpleStream(courses);
		
		streamAllMatch(courses);
		
		streamAnyMatch(courses);
		
		streamBuilder();
		
		streamCount(courses);
		
		streamDistinct(courses);
		
		streamFilter(courses);
		
		streamFindAny(courses);
		
		streamFindFirst(courses);
		
		streamMap(courses);
		
		streamFlatMap(courses);
		
		streamReduce(courses);
		
		streamSkip(courses);
		
		streamCollector(courses);
		
	}

	private static void streamSkip(List<String> courses) {
		printLabel("Stream Skip");
		
		courses.stream().skip(3).forEach(System.out::println);
	}

	private static void streamReduce(List<String> courses) {
		
		printLabel("Stream Reduce");
		
		System.out.println(courses.stream().reduce((x,y)-> x + "-" + y).get());
		
	}

	private static void streamFlatMap(List<String> courses) {
		printLabel("Stream Flat Map");
		
		courses.stream().flatMap(x-> Stream.of(x, x.toUpperCase())).forEach(x->System.out.println(x));
	}

	private static void streamMap(List<String> courses) {
		printLabel("Stream Map");
		
		courses.stream().map(x->x.toUpperCase()).forEach(x->System.out.println(x));
	}

	private static void streamFindAny(List<String> courses) {
		printLabel("Stream Find Any");
		
		System.out.println(courses.stream().findAny().get()); 
	}
	
	private static void streamFindFirst(List<String> courses) {
		printLabel("Stream Find First");
		
		System.out.println(courses.stream().findFirst().get()); 
	}

	private static void streamFilter(List<String> courses) {
		printLabel("Stream Filter");
		
		courses.stream().filter(course-> course.length() > 12).forEach(System.out::println);
	}

	private static void streamDistinct(List<String> courses) {
		printLabel("Stream Distinct");
		
		courses.stream().distinct().forEach(System.out::println);
	}

	private static void streamCount(List<String> courses) {
		
		printLabel("Stream Count");
		
		System.out.println(courses.stream().count());
	}

	private static void streamCollector(List<String> courses) {
		
		printLabel("Stream Collector");
		
		System.out.println(courses.stream().filter(course-> course.contains("Java")).collect(Collectors.toList()));

		System.out.println(courses.stream().collect(Collectors.filtering(course->course.contains("Spring"), Collectors.toList())));
		
		System.out.println(courses.stream().collect(Collectors.groupingBy(course-> course.length())));
		
		System.out.println(courses.stream().collect(ArrayList::new, ArrayList::add,
                ArrayList::addAll));
		
		System.out.println(courses.stream().collect(Collectors.joining(" ")));
		
		System.out.println(courses.stream().collect(Collectors.counting()));
	}
	

	private static void streamBuilder() {
		
		printLabel("Stream Building");
		
		Stream.Builder<String> streamBuilder = Stream.builder();
		
		streamBuilder.add("A").add("B");
		
		streamBuilder.build().forEach(System.out::println);
		
	}

	private static void streamAllMatch(List<String> courses) {
		
		printLabel("Stream All Match::::Spring");
		
		System.out.println(courses.stream().allMatch(course->course.contains("Spring")));
	}
	
	private static void streamAnyMatch(List<String> courses) {
		
		printLabel("Stream Any Match::::Spring");
		
		System.out.println(courses.stream().anyMatch(course->course.contains("Spring")));
	}

	private static void simpleStream(List<String> courses) {
		
		printLabel("Stream Example");
		
		courses.stream().forEach(System.out::println);
	}
	
	private static void printLabel(String lable) {
		System.out.println("----------"+lable+"----------- ");
	}
}
