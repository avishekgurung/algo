package practice;

import java.util.*;

public class Reference {

    private List<List<Integer>> mergeIntervals(List<List<Integer>> intervals) {
        List<Integer> start = intervals.get(0);
        List<Integer> end = intervals.get(0);
        List<Integer> current;

        List<List<Integer>> result = new ArrayList<>();

        for(int i=1; i < intervals.size(); i++) {
            current = intervals.get(i);
            if(end.get(1) >= current.get(0)) {
                end = current;
            } else {
                List<Integer> aux = new ArrayList<>();
                aux.add(Math.min(start.get(0), end.get(0)));
                aux.add(Math.max(start.get(1), end.get(1)));
                result.add(aux);
                start = current;
                end = current;
            }
        }

        List<Integer> aux = new ArrayList<>();
        aux.add(Math.min(start.get(0), end.get(0)));
        aux.add(Math.max(start.get(1), end.get(1)));
        result.add(aux);

        return result;
    }

    private List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String string : strings) {
            String key = sort(string);
            if(map.containsKey(key)) {
                map.get(key).add(string);
            } else {
                map.put(key, new ArrayList<>(Arrays.asList(string)));
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    private String sort(String string) {
        char arr[] = string.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    private String integerToRoman(int number) {
        SortedMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        String result = "";

        while(number != 0) {

            for(Integer e : map.keySet()) {
                if(number >= e) {
                    result = result + map.get(e);
                    number = number - e;
                    break;
                }
            }

        }
        return result;
    }

}
