package Leetcode;
import java.util.*;

public class WordFilter {
    class TrieNode {
        int index;
        Map<Character, TrieNode> child;
        public TrieNode() {
            child = new HashMap<>();
            index = 0;
        }
    }

    //Insert by iteration
    public void insert(String word, int index) {
        TrieNode curr = root;

        for(char ch: word.toCharArray()) {
            TrieNode node = curr.child.get(ch);
            if(node == null) {
                node = new TrieNode();
                curr.child.put(ch, node);
            }
            node.index = index;
            curr = node;
        }

        curr.index = index;
    }

    //Search by iteration
    public int search(String word) {
        TrieNode curr = root;

        for(char ch: word.toCharArray()) {
            TrieNode node = curr.child.get(ch);
            if(node == null)
                return -1;
            curr = node;
        }

        return curr.index;
    }


    //Constructor
    TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                insert(words[i].substring(j)+"#"+words[i], i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        return search(suffix+"#"+prefix);
    }
}
