package com.codecool.thehistory;

import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] splitStr = text.split("\\s+");
        Collections.addAll( wordsLinkedList, splitStr);
        }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList.removeIf(wordToBeRemoved::equals);
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        ListIterator <String> iterator = wordsLinkedList.listIterator();
        while (iterator.hasNext()){
            if(iterator.next().equals(from)){
                iterator.set(to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        String originalArrayList = String.join(" ", wordsLinkedList);
        String from = String.join(" ", fromWords);
        String to = String.join(" ", toWords);
        String result = originalArrayList.replaceAll("\\b"+from+"\\b", to);
        wordsLinkedList.clear();
        wordsLinkedList.addAll(Arrays.asList(result.split("\\s+")));
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
