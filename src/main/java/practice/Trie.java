package practice;

public class Trie {

  private class Node {
    char character;
    boolean isEndOfWord = false;
    Node[] children = new Node[26];

    Node(char character) {
      this.character = character;
    }
  }

  int OFFSET = 97;
  Node root = new Node('\0');

  public Node insert(Node node, String word, int i) {
    char character = word.charAt(i);
    int index = character - OFFSET;
    if(node.children[index] == null) {
      node.children[index] = new Node(character);
      if(word.length()-1 == i) {
        node.isEndOfWord = true;
        return node.children[index];
      }
    }
    node.children[index] = insert(node.children[index], word, ++i);
    return node.children[index];
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert(trie.root, "al", 0);
    trie.insert(trie.root, "all", 0);
    trie.insert(trie.root, "ball", 0);
  }

}
