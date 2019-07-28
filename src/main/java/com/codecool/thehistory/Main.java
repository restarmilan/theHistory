package com.codecool.thehistory;

public class Main {
    public static void main(String[] args) {
      TheHistoryLinkedList testLinkedList = new TheHistoryLinkedList();
      testLinkedList.add("foo bar baz");
      System.out.println(testLinkedList.toString());
      testLinkedList.add("bubb foo spam");
      System.out.println(testLinkedList);
      testLinkedList.removeWord("foo");
      System.out.println(testLinkedList);
      testLinkedList.replaceOneWord("bubb", "papp");
      System.out.println(testLinkedList);

      TheHistoryArray testArray = new TheHistoryArray();



    }
}
