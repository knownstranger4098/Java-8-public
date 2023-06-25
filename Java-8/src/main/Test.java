package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {

	public static void main(String[] args) {

		String input = "eetuhbgetssoo";
		String[] strArr= input.split("");

		//Count the character in a String
		System.out.println(Arrays.stream(strArr)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));//{b=1, s=2, t=2, u=1, e=3, g=1, h=1, o=2}

		//Duplicate element in a string

		System.out.println(Arrays.stream(strArr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream().filter(k->k.getValue()>1).collect(Collectors.toList()));//[s=2, t=2, e=3, o=2]


		//Unique elements- k.getValue()==1

		//First non-repeated element of a given String 

		System.out.println(Arrays.stream(strArr)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream().filter(c->c.getValue()==1).findFirst().get().getKey());//l -not the first

		//tell groupingby to not to use hashmap rather Linkedhashmap 

		System.out.println(Arrays.stream(strArr)
				.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(c->c.getValue()==1).findFirst().get().getKey());// u -correct ans


		//Find  highest no from a given array

		int [] intArr = {12, 34,91, 0};

		System.out.println(Arrays.stream(intArr).boxed().sorted(Comparator.reverseOrder()).findFirst().get());



		//Find seond highest no from a given array

		System.out.println(Arrays.stream(intArr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());


		//Longest string froma given  array

		String [] randomArr = {"Amngoorrrrrrrrrrrrrrrrrrr", "Flamingo","Chicago", "Kangaroooo"};

		System.out.println(Arrays.stream(randomArr)
				.sorted((a,b)->a.length()>b.length()?-1:a.length()<b.length()?1:0).skip(1).findFirst().get());


		//Longest string froma given  array using map-reduce (Comparison logic)
		System.out.println(Arrays.stream(randomArr).reduce((a,b)->a.length()>b.length()?a:b).get());



		//All the element in the array which starts with 1

		int [] inArray2 = {12, 145, 11 ,89 , 0 };   // 0/p 12 and 11

		//Get a Stream
		//Convert them to String array
		//filter

		System.out.println(Arrays.stream(inArray2).boxed().map(s->Integer.toString(s)).filter(k->k.startsWith("7"))
				.collect(Collectors.toList()));


		//String join method -utility method {1,2,3,4} - 1-2-3-4

		String [] strArray = {"12", "145", "11" ,"89" , "0" };

		System.out.println(String.join(",", strArray));


		//skip and limit -csv file

		IntStream.rangeClosed(1,10).skip(1).limit(8).forEach(System.out::println);


		//Sort a map 

		HashMap<String ,Integer> myMap = new HashMap<String, Integer>();

		myMap.put("Ram", 1);
		myMap.put("Kanhaiaya", 2);
		myMap.put("Sorte", 3);
		myMap.put("Prachi", 4);
		myMap.put("Mumpa",5);

		ArrayList<Map.Entry> myList = new ArrayList(myMap.entrySet());


		myMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);















	}

}
