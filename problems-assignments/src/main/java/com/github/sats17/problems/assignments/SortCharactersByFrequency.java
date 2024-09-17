public java.util.*;

// https://leetcode.com/problems/sort-characters-by-frequency/
public class SortCharactersByFrequency {
    	public List<String> mergeSort(List<String> arr) {
		
		if(arr.size() == 1) {
			return arr;
		} else {
			List<String> arr1 = arr.subList(0, arr.size() / 2);
			List<String> arr2 = arr.subList(arr.size() / 2, arr.size());
			
			List<String> mergedArr1 = mergeSort(arr1);
			List<String> mergedArr2 = mergeSort(arr2);
			
			return sort(mergedArr1, mergedArr2);
			
			
		}
		
	}
	
	public List<String> sort(List<String> arr1, List<String> arr2) {
		
		
		List<String> arr3 = new ArrayList<>();
		
		int index1 = 0;
		int index2 = 0;
		
		while(index1 < arr1.size() && index2 < arr2.size()) {
			if(arr1.get(index1).compareTo(arr2.get(index2)) == 0) {
				arr3.add(arr1.get(index1));
				arr3.add(arr2.get(index2));
				index1++;
				index2++;
			} else if (arr1.get(index1).compareTo(arr2.get(index2)) < 0) {
				arr3.add(arr1.get(index1));
				index1++;
			} else {
				arr3.add(arr2.get(index2));
				index2++;
			}
		}
		
		while(index1 < arr1.size()) {
			arr3.add(arr1.get(index1));
			index1++;
		}
		
		while(index2 < arr2.size()) {
			arr3.add(arr2.get(index2));
			index2++;
		}
		System.out.println("Sort arr" + arr3.toString());
		return arr3;
		
	}
	
	
	public String frequencySort(String s) {

        List<String> splittedString = List.of(s.split(""));
        // Using custom sort
        List<String> sortedString = mergeSort(splittedString);
        System.out.println(sortedString);
        // Using stream
        return sortedString.stream().collect(Collectors.joining());
        
    }
}
