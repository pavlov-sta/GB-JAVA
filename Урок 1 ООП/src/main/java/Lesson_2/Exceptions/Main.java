package Lesson_2.Exceptions;

/*
1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
и MyArrayDataException и вывести результат расчета.
*/

public class Main {

    public static void main(String[] args) throws MyArraySizeException {
        String[][] arr = initArray(4,4);


        try {
            try {
                int sum = sumArray(arr);
                System.out.println("Сумма массива = " + sum);
            } catch (MyArraySizeException e) {
                e.printStackTrace();
                return;
            }
        }
        catch (MyArrayDataException e) {
            System.out.println(" В ячейке: '" + e.i + "x" + e.j + "' значение: '" + e.x + "' это не целочисленное значение.");
        }
    }

    // считаем сумму массива
    public static int sumArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (arr.length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4x4");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Размер массива должен быть 4x4");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum +=  Integer.parseInt(arr[i][j]);

                }
                catch (RuntimeException e) {
                    String x = arr[i][j];
                    throw new MyArrayDataException(i, j, x);
                }
            }
        }
        return sum;
    }
    // проверяем что массив задан 4х4 и заполняем его.
    public static String[][] initArray(int row, int col) throws MyArraySizeException {
        if (row != 4 || col != 4) {
            throw new MyArraySizeException("Массив может быть размером 4х4, иначе никак.");
        }
        return new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2","3", "4"}, {"1", "2", "3", "4"}};
    }
}

