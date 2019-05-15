package Lesson_3.PhoneBook;


public class Main {
    public static void main(String[] args){

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Вова", "+79154698752");
        phoneBook.add("Вова", "+78945236214");
        phoneBook.add("Иван", "+78934112585");
        phoneBook.add("Кузя", "+78941258793");
        phoneBook.add("Кузя", "+78417857963");


        String name = "Кузя"; // кого найти?

        System.out.println(" У  имя: '" + name + "' номера: " + phoneBook.get(name));
    }
}
