package string.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * The disdvantage of trie is that it takes lot of space.
 */
public class Trie {

  private class Node {
    char character;
    boolean isEndOfWord = false;
    Node[] children;

    Node(char character) {
      this.character = character;
      children = new Node[26];
    }
  }

  Node root = new Node('\0');
  int OFFSET = 97;


  /**
   * Add words to trie
   * @param word
   */
  public void add(String word) {
    Node node = root;
    for(int i=0; i < word.length(); i++) {
      char character = word.charAt(i);
      int index = character - OFFSET;
      if(node.children[index] == null) {
        node.children[index] = new Node(character);
        if(i == word.length() - 1) {
          node.children[index].isEndOfWord = true;
        }
      }
      node = node.children[index];
    }
  }

  public void addBulk(String[] words) {
    for(String word : words) add(word);
  }

  /**
   * This is same as root to leaf path.
   */
  public void nodeToLeaf(Node node, int index, char[] word, List<String> words) {
    if(node == null) return;
    word[index] = node.character;
    if(node.isEndOfWord) {
      String temp = "";
      for(int i=1; i <= index; i++) {
        temp = temp + word[i];
      }
      words.add(temp);
    }
    index++;
    for(Node child : node.children) {
      if(child != null) {
        nodeToLeaf(child, index, word, words);
      }
    }
  }

  /**
   * Displays all the words in dictionary in alphabetical orders.
   */
  public void showAllWords() {
    List<String> allWords = new ArrayList<String>();
    nodeToLeaf(root, 0, new char[25], allWords);
    System.out.println(allWords);
  }

  /**
   * We perform DFS here.
   * @param word is the word to check
   * @param i is the ith index in the word to verify
   * @param node is the trie node
   * @return
   */
  private boolean hasWord(String word, int i, Node node) {
    if(node == null) return false;
    if(i == word.length() && node.isEndOfWord) return true;
    char character = word.charAt(i);
    i++;
    int index = character - OFFSET;
    return hasWord(word, i, node.children[index]);

  }
  public boolean checkIfWordExists(String word) {
    return hasWord(word, 0, root);
  }

  private Node getLastNodeForAWord(Node node, String word, int i) {
    if(node == null) return null;
    if(word.length() == i) return node;
    int index = word.charAt(i) - OFFSET;
    return getLastNodeForAWord(node.children[index], word, ++i);
  }

  public List<String> autoCompletion(String prefix) {
    Node nodeToStart = getLastNodeForAWord(root, prefix, 0);
    List<String> autoCompleteString = new ArrayList<String>();
    nodeToLeaf(nodeToStart, 0, new char[25], autoCompleteString);

    List<String> result = new ArrayList<String>();
    for(String word : autoCompleteString) {
      String completeWord = prefix + word;
      result.add(completeWord);
    }
    return result;
  }

  public static void main(String[] args) {
    Trie dict = new Trie();
    dict.addBulk(new String[]{"ball","adobe","balloon","cum","cumming","avi","coming","bad",
        "baton","balli","avishek","avinash","avinan"});

    System.out.println("All the words in dictionary in alphabetical order");
    dict.showAllWords();

    System.out.println();
    String word = "coming";
    System.out.println("Dictory has the word '" + word +"' ?: "+ dict.checkIfWordExists(word));
    System.out.println();

    String prefix = "ballo";
    List<String> autoCompletionWords = dict.autoCompletion(prefix);
    System.out.println("The words in dictionary start with " + prefix);
    System.out.println(autoCompletionWords);
  }

}
