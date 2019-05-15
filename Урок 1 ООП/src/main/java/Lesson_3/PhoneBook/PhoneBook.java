package Lesson_3.PhoneBook;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    private HashMap<String, HashSet<String>> phoneBook = new HashMap<String, HashSet<String>>();

    public void add(String name, String phone) {

        HashSet<String> phoneArr = phoneBook.get(name);
        if (phoneArr == null) {
            phoneArr = new HashSet<String>();
        }

        phoneArr.add(phone);
        phoneBook.put(name, phoneArr);

    }

    public HashSet<String> get(String name) {
        return phoneBook.get(name);
    }
}
