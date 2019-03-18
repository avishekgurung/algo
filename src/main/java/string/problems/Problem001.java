package string.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem001 {

  private static String prevPara[] = new String[]{};
  private static int maxWordCount = 0;
  private static String maxWord = "";
  private static Map<String, Integer> wordCountMap = new HashMap<String, Integer>();


  public static void maxWordOccurrence(String paragraph) {
    String[] currentPara = paragraph.split(" ");
    List<String> wordInPrevParaButNotInPresentPara = wordsPresentInPrevParaButNotInCurrentPara
        (currentPara);

    for(String word : wordInPrevParaButNotInPresentPara) {
      int count = wordCountMap.get(word) - 1;
      wordCountMap.put(word, count);
      if(word.equals(maxWord)) {
        maxWordCount--;
      }
    }

    for(String word : currentPara) {
      int count;
      if(wordCountMap.get(word) == null) {
        count = 1;
      }
      else {
        count = wordCountMap.get(word) + 1;
      }
      if(count > maxWordCount) {
        maxWordCount = count;
        maxWord = word;
      }
      wordCountMap.put(word, count);
    }
    prevPara = currentPara;
    System.out.println("Word '" + maxWord + "' appears maximum with count " + maxWordCount);
  }

  private static List<String> wordsPresentInPrevParaButNotInCurrentPara(String[] currentPara) {
    Set<String> set = new HashSet<String>();
    for(String word : currentPara) set.add(word);
    List<String> wordInPrevParaButNotInPresentPara = new ArrayList<String>();
    for(String word :  prevPara) {
      //if(!set.contains(word)) {
        wordInPrevParaButNotInPresentPara.add(word);
      //}
    }
    return wordInPrevParaButNotInPresentPara;
  }

  public static void main(String[] args) {
    maxWordOccurrence("one the way");
    maxWordOccurrence("in the bar");
    maxWordOccurrence("one one one");
    maxWordOccurrence("two one two");
  }

  /**
   * Looks like this problem is all about finding the max word in the current paragraph by simply
   * using hashMap because we are not bothered with the max word of the prev.
   */
}
