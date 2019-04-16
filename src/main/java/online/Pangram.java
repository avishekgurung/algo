package online;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pangram {

  public static String isPangram(List<String> strings) {
    String result = "";
    String output = "";
    for(String string : strings) {
      Set<Character> characters = new HashSet<Character>();
      for(int i=0; i < string.length(); i++) {
        if(string.charAt(i) != ' ')
        characters.add(string.charAt(i));
      }
      if(characters.size() == 26) {
        result = "1";
      }
      else {
        result = "0";
      }
      output = output + result;
    }
    return output;
  }

  public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    list.add("we promptly judged antique ivory buckles for the next prize");
    System.out.println(isPangram(list));
  }

}
