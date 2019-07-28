package com.codecool.thehistory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] splitStr = text.split("\\s+");
        String [] tempArray = new String [splitStr.length+wordsArray.length];
        System.arraycopy(wordsArray, 0, tempArray, 0, wordsArray.length);
        System.arraycopy(splitStr, 0, tempArray, wordsArray.length, splitStr.length);
        wordsArray = Arrays.copyOf(tempArray, tempArray.length);
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        for (int i = 0; i < wordsArray.length; i++){
            if (wordsArray[i].equals(wordToBeRemoved)){
                wordsArray[i] = null;
            }
        }
        wordsArray = Arrays.stream(wordsArray)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);

//        List<String> helperList = new ArrayList<>();
//        for (String s : wordsArray){
//            if (s !=null){
//                helperList.add(s);
//            }
//         wordsArray = helperList.toArray(new String[helperList.size()]);
//        }
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArray = Arrays.copyOf(wordsArray, 0);
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
      for (int i = 0; i < wordsArray.length; i++) {
          if (wordsArray[i].equals(from)) {
            wordsArray[i] = to;
          }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        String originalArray = String.join(" ", wordsArray);
        String from = String.join(" ", fromWords);
        String to = String.join(" ", toWords);
        String result = originalArray.replaceAll("\\b"+from+"\\b", to);
        wordsArray = result.split("\\s+");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
