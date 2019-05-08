package Lesson_2.Exceptions;

public class MyArrayDataException  extends RuntimeException {
    public int i;
    public int j;
    public String x;

    MyArrayDataException(int i, int j, String x) {
        this.i = i;
        this.j = j;
        this.x = x;

    }
}
