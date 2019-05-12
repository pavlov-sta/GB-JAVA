package Lesson_3.PhoneBook;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<String, ArrayList<String>>();

    public void add(String name, String phone) {

        ArrayList<String> phoneArr = phoneBook.get(name);
        if (phoneArr == null) {
            phoneArr = new ArrayList<String>();
        }

        phoneArr.add(phone);
        phoneBook.put(name, phoneArr);

    }

    public ArrayList<String> get(String name) {
        return phoneBook.get(name);
    }
}
