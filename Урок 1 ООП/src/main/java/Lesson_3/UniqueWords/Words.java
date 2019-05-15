package Lesson_3.UniqueWords;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Words {
    public static void main(String[] args){

        String[] words = {
                "Hello",
                "Hello",
                "World",
                "City",
                "Java",
                "Java",
                "JavaScript",
                "Hello",
                "City",
                "Star",
                "Git",
                };

        HashMap<String, Integer> uniqueWords = new HashMap<String, Integer>();
        HashSet<String> word = new HashSet<String>();

        for(String s: words) {
            Integer result = uniqueWords.get(s);
            word.add(s);
            uniqueWords.put(s, result == null ? 1 : result + 1);
        }

        System.out.println(word);
        System.out.println(uniqueWords);

    }
}
