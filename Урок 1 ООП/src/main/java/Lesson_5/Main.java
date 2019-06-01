package Lesson_5;

/*
1. Необходимо написать два метода, которые делают следующее:
1) Создают одномерный длинный массив, например:
static final int size = 10000000;
static final int h = size / 2;
float[] arr = new float[size];
2) Заполняют этот массив единицами;
3) Засекают время выполнения: long a = System.currentTimeMillis();
4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
5) Проверяется время окончания метода System.currentTimeMillis();
6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
Отличие первого метода от второго:
Первый просто бежит по массиву и вычисляет значения.
Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.

Пример деления одного массива на два:
System.arraycopy(arr, 0, a1, 0, h);
System.arraycopy(arr, h, a2, 0, h);

Пример обратной склейки:
System.arraycopy(a1, 0, arr, 0, h);
System.arraycopy(a2, 0, arr, h, h);

Примечание:
System.arraycopy() копирует данные из одного массива в другой:
System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
По замерам времени:
Для первого метода надо считать время только на цикл расчета:
for (int i = 0; i < size; i++) {
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
}
 */

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        System.out.println("Метод №1. Просто бежим по массиву и вычисляет значения");

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Время вычисления массива: " + (System.currentTimeMillis() - a) + " мс\n");

    }

    public static void secondMethod() {
        System.out.println("Метод №2. Разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.");

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        final float[] arrA = new float[h];
        final float[] arrB = new float[h];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arrA, 0, h);
        System.arraycopy(arr, h, arrB, 0, h);


        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrA.length; i++) {
                    arrA[i] = (float) (arrA[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        threadA.start();

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrB.length; i++) {
                    arrB[i] = (float) (arrB[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        threadB.start();

        System.arraycopy(arrA, 0, arr, 0, h);
        System.arraycopy(arrB, 0, arr, h, h);

        System.out.println("Время вычисления массива: " + (System.currentTimeMillis() - a) + " мс\n");
    }
}
