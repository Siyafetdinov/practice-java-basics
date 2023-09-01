package ru.test.JavaCollection.Task;

import ru.test.JavaCollection.Utils.DynamicArray;
import ru.test.Utils.UtilsMenu;

public class TaskDynamicArray {

    public static void main(String[] args) {
        DynamicArray<Integer> tst = new DynamicArray();

        tst.addElement(1);
        tst.addElement(2);
        tst.addElement(3);
        System.out.println("\nДобавили в конец массива, по очереди 1,2,3 " + tst + UtilsMenu.indent());

        tst.addElement(0, 10);
        System.out.println("Добавили на индекс 0 значение 10, с сохранением данных " + tst + UtilsMenu.indent());

        tst.addElement(3, 20);
        System.out.println("Добавили на индекс 3 значение 20, с сохранением данных " + tst + UtilsMenu.indent());

        tst.setElement(1, 200);
        System.out.println("Установили на 1 индекс значение 200 " + tst + UtilsMenu.indent());

        System.out.println("Эллемент по индексу 3: " + tst.getElement(3) + UtilsMenu.indent());

        tst.removeElement(0);
        System.out.println("Удалили значение под индексом 0 " + tst + UtilsMenu.indent());

        System.out.println("Ищем 200 в массиве и возвращаем boolean: " + tst.containsElement(200) + UtilsMenu.indent());

        System.out.println("Размер массива: " + tst.getSize() + UtilsMenu.indent());


        DynamicArray<Integer> tst2 = new DynamicArray();
        tst2.addElement(200);
        tst2.addElement(2);
        tst2.addElement(20);
        tst2.addElement(3);

        System.out.println("Хэш код первого массива: " + tst.hashCode() + " Хэш код второго массива: " + tst2.hashCode());

        if (tst.equals(tst2)) {
            System.out.println("Массивы верны! " + tst + " " + tst2 + UtilsMenu.indent());
        } else {
            System.out.println("Массивы увы не равны! "  + tst + " " + tst2 + UtilsMenu.indent());
        }

        DynamicArray<Integer> tst3 = new DynamicArray();
        tst3.addElement(200);
        tst3.addElement(2);
        tst3.addElement(20);
        tst3.addElement(10);

        System.out.println("Хэш код первого массива: " + tst.hashCode() + " Хэш код третьего массива: " + tst3.hashCode());

        if (tst.equals(tst3)) {
            System.out.println("Массивы верны! " + tst + " " + tst3 + UtilsMenu.indent());
        } else {
            System.out.println("Массивы увы не равны! "  + tst + " " + tst3 + UtilsMenu.indent());
        }
    }

}
