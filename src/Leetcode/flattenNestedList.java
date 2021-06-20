package Leetcode;

import java.util.*;

public class flattenNestedList {
}
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
class NestedIterator implements Iterator<Integer> {

    private List<Integer> flatList = new ArrayList<Integer>();
    int currIndex =0;

    public NestedIterator(List<NestedInteger> nestedList) {
        constructFlatList(nestedList);
    }

    private void constructFlatList(List<NestedInteger> nestedList){
        for(int i=0; i<nestedList.size(); i++){
            NestedInteger currVal = nestedList.get(i);
            if(currVal.isInteger()){
                flatList.add(currVal.getInteger());
            }else{
                constructFlatList(currVal.getList());
            }
        }
    }

    @Override
    public Integer next() {
        Integer nextVal = flatList.get(currIndex);
        currIndex++;
        return nextVal;
    }

    @Override
    public boolean hasNext() {
        return currIndex < flatList.size();
    }
}


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */