package data_structure.heap;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Heap<Integer> heap = new Heap<>(Integer::compare);
        heap.add(4);
        heap.add(3);
        heap.add(7);
        heap.add(6);
        heap.add(8);
        heap.add(10);
        heap.add(3);
        heap.add(1);
        heap.add(6);
        heap.add(8);
        heap.add(10);
        heap.add(3);
        heap.add(1);
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
    }

}
