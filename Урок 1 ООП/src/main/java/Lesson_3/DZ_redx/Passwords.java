package Lesson_3.DZ_redx;

/*
                        Создать метод для проверки пароля

             (?=.*[0-9]) 1 Обязательно есть хоть 1 цифра
                  {8,20} 2 Не менее 8 символов и не более 20
  (?=.*[a-z])(?=.*[A-Z]) 3 Должны быть большие и маленькие буквы
(?=.*[@#$%^&+=])(?=\S+$) 4 Обязательно дожен быть спец символ

*/

import java.util.regex.Pattern;

public class Passwords {
    public static void main(String[] args){

        String passwords = "1asAAAZXA+=g824nm$@/"; // введите пароль

        if (passwordCheck(passwords)) {
            System.out.println("Password matches.");
        } else {
            System.out.println("Password does not match.");
        }
    }

    public static boolean passwordCheck(String passwords){
        String regexp ="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}";
        return Pattern.matches(regexp, passwords);
    }
}
