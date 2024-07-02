package string.trie;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Node {
    private char ch;
    public boolean isEnd;
    public Map<Character, Node> children;
    Node(char ch) {
        this.ch = ch;
        this.isEnd = false;
        children = new HashMap<>();
    }
}
