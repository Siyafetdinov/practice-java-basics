package ru.test.JavaCollection.Utils;

import java.util.Arrays;
import java.util.Objects;

public class DynamicArray<E> {

    private Object[] data;
    private int sizeData = 0;

    public void addElement(E e) {
        dataCheckSize();
        data[sizeData] = e;
        sizeData++;
    }

    public DynamicArray() {
        data = new Object[10];
    }

    public DynamicArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Не может быть меньше 0");
        }
        data = new Object[size];
    }

    public void addElement(int index, E e) {
        if (index > sizeData - 1) {
            throw new IllegalArgumentException("Всего в массиве:" + (sizeData));
        }
        if (index < 0) {
            throw new IllegalArgumentException("Не может быть индекс меньше 0");
        }
        dataCheckSize();
        Object[] tmp = new Object[data.length + 1];

        for (int i = 0; i < index; i++) {
            tmp[i] = data[i];
        }

        tmp[index] = e;

        for (int i = index; i < data.length; i++) {
            tmp[i + 1] = data[i];
        }
        data = tmp;
        sizeData++;
    }

    public void setElement(int index, E e) {
        if (index > sizeData - 1) {
            throw new IllegalArgumentException("Всего в массиве:" + (sizeData));
        }
        if (index < 0) {
            throw new IllegalArgumentException("Не может быть индекс меньше 0");
        }
        data[index] = e;
    }

    public Object getElement(int index) {
        if (index > sizeData - 1) {
            throw new IllegalArgumentException("Всего в массиве:" + (sizeData));
        }
        if (index < 0) {
            throw new IllegalArgumentException("Не может быть индекс меньше 0");
        }
        return data[index];
    }

    public void removeElement(int index) {
        if (index > sizeData - 1) {
            throw new IllegalArgumentException("Всего в массиве:" + (sizeData));
        }
        if (index < 0) {
            throw new IllegalArgumentException("Не может быть индекс меньше 0");
        }

        Object[] tmp = new Object[data.length];
        for (int i = 0; i < data.length; i++) {
            if (i == index) {
                continue;
            }
            tmp[i] = data[i];
        }
        data = dataRef(tmp);
        sizeData--;
    }

    public boolean containsElement(E e)
    {
        for (Object element:data){
            if (e.equals(element))
            {
                return true;
            }
        }
        return false;
    }

    public int getSize(){
        return sizeData;
    }

    private void dataCheckSize() {
        if (data.length <= sizeData) {
            Object[] tmp = data;
            data = new Object[sizeData * 2];
            for (int i = 0; i < tmp.length; i++) {
                data[i] = tmp[i];
            }
        }
    }

    private Object[] dataRef(Object[] dt) {
        Object[] result = new Object[dt.length];
        int count = 0;

        for (Object element : dt) {
            if (element != null) {
                result[count] = element;
                count++;
            }
        }
        return result;
    }

    private Object[] dataRemoveEmpty(Object[] dt) {
        Object[] result = new Object[sizeData];
        for (int i=0; i < result.length; i++)
        {
            result[i] = dt[i];
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(dataRemoveEmpty(data));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicArray<?> that = (DynamicArray<?>) o;
        return sizeData == that.sizeData && Arrays.equals(dataRemoveEmpty(data), dataRemoveEmpty(that.data));
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(sizeData);
        result = 31 * result + Arrays.hashCode(dataRemoveEmpty(data));
        return result;
    }
}
