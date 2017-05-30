package hw1.task6;

public class MyArray {
    private Note[] data;
    private int size;

    public MyArray() {
        data = new Note[10];
    }

    public Note get(int idx) {
        if (idx > size) {
            return null;
        } else {
            return data[idx];
        }
    }

    public void put(int idx, Note value) {
        if (idx < data.length && idx >= 0) {
            data[idx] = value;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(Note value) {
        if (size + 1 < data.length) {
            data[size] = value;
            size++;
        } else {
            grow();
        }
    }

    public void delete(int idx) {
        if (size == 0) return;
        if (idx > size || idx < 0) return;

        Note[] tmpArray = new Note[size];

        System.arraycopy(data, 0, tmpArray, 0, idx);
        System.arraycopy(data, idx + 1, tmpArray, idx, size - idx - 1);
        data = tmpArray;
        size--;
    }

    private void grow() {
        Note[] tmpArray = new Note[size + 10];
        System.arraycopy(data, 0, tmpArray, 0, data.length);

        data = tmpArray;
    }

    public int getSize() {
        return size;
    }
}
