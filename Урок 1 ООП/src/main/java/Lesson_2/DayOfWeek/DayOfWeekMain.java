package Lesson_2.DayOfWeek;

/*
Требуется реализовать enum DayOfWeek, который будет представлять дни недели.
С его помощью необходимо решить задачу определения кол-ва рабочих часов до конца недели по заднному текущему дню.

 Возвращает кол-во оставшихся рабочих часов до конца
 недели по заданному текущему дню. Считается, что
 текущий день ещё не начался, и рабочие часы за него
 должны учитываться.

public class DayOfWeekMain {

 public static void main(final String[] args) {
 System.out.println(getWorkingHours(DayOfWeek.MONDAY));
 }
*/


public class DayOfWeekMain {

    public static void main(final String[] args) {
        System.out.println("Working hours left: " + getWorkingHours(DayOfWeek.WEDNESDAY));

    }

    public static int getWorkingHours(DayOfWeek  dayOfWeek) {
        int result = 0;
        System.out.println("Today: "  + dayOfWeek);
        for(int i = dayOfWeek.ordinal(); i < dayOfWeek.values().length; i++ ) {
            result += dayOfWeek.values()[i].getHour();
        }
        return result;
    }
}
