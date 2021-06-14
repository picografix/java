package Leetcode;

import java.util.*;
import java.lang.reflect.Array;


public class WordLadder {

}

class SolutionWordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord) || !wordList.contains(endWord))
            return 0;

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        Set<String>  dictionary = new HashSet<>(wordList);

        return binaryBfs(beginSet, endSet, dictionary, 1);
    }

    private int binaryBfs(Set<String> beginSet, Set<String> endSet, Set<String> dictionary, int level) {
        if(beginSet.isEmpty() || endSet.isEmpty())
            return 0;

        level++;
        dictionary.removeAll(beginSet);
        Set<String> nextSet = new HashSet<>();

        for(String word: beginSet){
            char[] oldWord = word.toCharArray();
            for(int i=0;i<oldWord.length;i++){
                char oldChar = oldWord[i];

                for(char c='a';c<='z';c++){
                    oldWord[i] = c;

                    String newWord = new String(oldWord);

                    if(!dictionary.contains(newWord))
                        continue;

                    if(endSet.contains(newWord))
                        return level;

                    nextSet.add(newWord);
                }

                oldWord[i] = oldChar;
            }
        }

        return nextSet.size() > endSet.size() ? binaryBfs(endSet, nextSet, dictionary, level) :
                binaryBfs(nextSet, endSet, dictionary, level);
    }
}