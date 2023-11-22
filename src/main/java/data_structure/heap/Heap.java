package data_structure.heap;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {
    private final Comparator<? super E> comparator; //비교 기준
    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private Object[] array;

    public Heap(Comparator<? super E> comparator) {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    private int getParent(int index) {
        return index / 2;
    }

    private int getLeftChild(int index) {
        return index * 2;
    }

    private int getRightChild(int index) {
        return index * 2 + 1;
    }

    private void resize(int newSize) {  //용적의 크기를 재할당한다.
        Object[] copy = new Object[newSize];
        for (int i = 1; i <= size; i++) {
            copy[i] = array[i];   // 배열 복사
        }
        this.array = null;    // GC 처리를 위함
        this.array = copy;
    }

    public void add(E e) {
        if (size + 1 == array.length) {   // 현재 합의 요소 개수가 배열의 용적과 같아지면 배열의 크기를 2배로 키운다.
            resize(array.length * 2);
        }
        array[size + 1] = e;    // 힙 말단에 새로운 요소를 추가한다.
        int currentIndex = size + 1;    // 새로 추가된 요소가 존재하는 index
        while (currentIndex > 1) {  // 새로 추가된 요소가 루트 노드가 되면 반복문은 종료된다.
            if (comparator.compare((E) array[getParent(currentIndex)], (E) array[currentIndex]) >= 0)
                break;    // 새로 추가된 요소가 그 부모 노드보다 우선순위가 작으면, 최대 힙의 규칙을 지키게 되므로 반복문을 종료한다.
            array[currentIndex] = array[getParent(currentIndex)];   // 새로 추가된 요소와 그 부모 노드를 교환
            currentIndex = getParent(currentIndex);
            array[currentIndex] = e;
        }
        size++; // 힙의 요소 개수를 1 늘린다.
    }

    public E remove() {
        if (size < 1) throw new NoSuchElementException();   // 요소 개수가 0개면 예외 반환
        E result = (E) array[1];    // 루트 노드를 제거 및 반환할 것이므로 변수로 할당해둔다.
        array[1] = array[size]; // 마지막 노드를  루트 노드로 가져온다.
        array[size] = null;

        int currentIndex = 1;   // (구) 마지막 노드가 존재하는 index
        while (getLeftChild(currentIndex) <= size) {    // (구) 마지막 노드의 왼쪽 자식 노드가 요소 개수보다 커진다는 것은 (구) 마지막 노드가 말단에 존재한다는 의미다.
            int toSwapIndex;    // 왼쪽 자식 노드와 오른쪽 자식 노드 중 값이 우선순위가 더 높은 노드의 index(최소 힙의 경우 더 작은 노드와 교환해야 함)
            if (comparator.compare((E) array[getLeftChild(currentIndex)], (E) array[getRightChild(currentIndex)]) >= 0) {
                toSwapIndex = getLeftChild(currentIndex);
            } else {
                toSwapIndex = getRightChild(currentIndex);
            }
            Object temp = array[currentIndex];  // (구) 마지막 노드와 자식 노드의 값을 교환
            array[currentIndex] = array[toSwapIndex];
            array[toSwapIndex] = temp;
            currentIndex = toSwapIndex;
        }
        size--; // 힙의 요소 개수를 1 줄인다.
        if (array.length > DEFAULT_CAPACITY && size < array.length / 4) {   // 힙의 노드 개수가  배열 용적의 1/4보다 적다면 용적을 반으로 줄인다.
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));   // 단, 용적은 최소 용적보다 작아질 수 없다.
        }
        return result;  // 처음 변수로 할당해둔 루트노드를 반환한다.
    }

    public int size() {
        return this.size;
    }

    public E peek() {
        if (size < 1) throw new NoSuchElementException();
        return (E) array[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
