package string.trie;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * If m is an average size of word then the space complexity of Trie is O(m*n) where n is the number of words.
 */
public class Trie {
    private Node root;

    Trie() {
        root = new Node('\0');
    }


    /**
     * Time complexity = O(n) where n is the length of a word.
     * @param word
     */
    public void insert(String word) {
        Node pointer = root;
        for(int i=0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(pointer.children.containsKey(ch)) {
                pointer = pointer.children.get(ch);
            } else {
                Node node = new Node(ch);
                pointer.children.put(ch, node);
                pointer = node;
            }
            if(i == word.length() - 1) {
                pointer.isEnd = true;
            }
        }
    }

    public void insert(String words[]) {
        for(String word : words) insert(word);
    }


    /**
     *
     * Time complexity is O(n) where n is the size of the word.
     * @return
     */
    public boolean search(String word) {
        Node pointer = root;
        for(int i=0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!pointer.children.containsKey(ch)) return false;
            pointer = pointer.children.get(ch);
        }
        return pointer.isEnd;
    }

    /**
     * The suggestions should be lexicographically ordered.
     * @return
     */
    private List<String> autoSuggest(String word, int k) {
        List<String> result = new ArrayList<>();
        Node pointer = root;
        String aux = "";
        for(int i=0; i < word.length(); i++) {
            char ch = word.charAt(i);
            aux = aux + ch;
            if(!pointer.children.containsKey(ch)) break;
            pointer = pointer.children.get(ch);
        }

        autoSuggestHelper(pointer, aux, result, k);
        return result;
    }

    private void autoSuggestHelper(Node pointer, String aux, List<String> result, int k) {
        if(pointer == null || result.size() >= k) return;
        Set<Character> keys = pointer.children.keySet();
        List<Character> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        if(pointer.isEnd) result.add(aux);

        for(Character ch : sortedKeys) {
            Node nextPointer = pointer.children.get(ch);
            autoSuggestHelper(nextPointer, aux + nextPointer.getCh(), result, k);
        }
    }

    private List<String> regexSearch(String word) {
        List<String> result = new ArrayList<>();
        if(!word.contains("*")) {
            result.add(word);
            return result;
        }
        derivePotentialWords(root, result, 0, word, "");
        return result;
    }

    private void derivePotentialWords(Node pointer, List<String> result, int index, String word, String aux) {
        if(index >= word.length() || pointer == null) return;

        char ch = word.charAt(index);
        if(ch != '*') {
            Node node = pointer.children.get(ch);
            if(node == null) return;

            aux = aux + node.getCh();
            if(index == word.length() - 1) result.add(aux);
            derivePotentialWords(node, result, index + 1, word, aux);
        } else {
            Set<Character> keys = pointer.children.keySet();
            for(Character ch1 : keys) {
                Node node = pointer.children.get(ch1);
                String deriveAux = aux + node.getCh();
                if(index == word.length() - 1) result.add(deriveAux);
                derivePotentialWords(node, result, index + 1, word, deriveAux);
            }
        }
    }

    public static void main(String[] args) {

        new Trie().driver();

    }


    private void driver() {
        String words[] = {"abacus", "ball", "acure", "banana", "banned", "bane", "buni", "bent", "bae"};
        Trie trie = new Trie();
        trie.insert(words);


        String wordSearch = "banned";
        System.out.println("Search word " + wordSearch + " : " + trie.search(wordSearch));
        System.out.println("----------------------------");

        String prefix = "ba";
        System.out.println("Auto suggestion for: " + prefix);
        System.out.println(trie.autoSuggest(prefix, 5));
        System.out.println("----------------------------");

        String regex = "b*n***";
        System.out.println("Regex search for " + regex + ": ");
        System.out.println(trie.regexSearch(regex));
    }



}
