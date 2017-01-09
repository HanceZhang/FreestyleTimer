package Models;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Hance on 2016-12-22.
 */

//heap for storing the ID numbers of artifacts
public class MinHeap {

    private Artifact [] heap;
    private int contentSize;
    private int maxSize;
    final private int split = 8;

    public MinHeap( int maxsize) {
        heap = new Artifact [maxsize + 1];
        maxSize = maxsize;
        contentSize = 0;

        this.Enqueue(new Artifact("hey", 5000));
        this.Enqueue(new Artifact("Kappa", 10000));
        this.Enqueue(new Artifact("Nani saur", 432000));
        this.Enqueue(new Artifact("FIRST", 63000));
        this.Enqueue(new Artifact("gg", 999000));
    }

    public Artifact Peek () {
        return heap[0];
    }

    public Artifact [] Peek8 () {
        if (contentSize < 8)
        {
            return Arrays.copyOf(heap, contentSize);
        }
        return Arrays.copyOf(heap, 8);
    }

    public Artifact getByIndex (int index){
        return heap[index];
    }

    //inserts artifact into heap and returns index;
    public int Enqueue ( Artifact artifact) {
        heap[contentSize++] = artifact;
        int cur = contentSize - 1;
        while (parent(cur) != -1 && heap[parent(cur)].getTimeRemaining() > heap[cur].getTimeRemaining()) {
            swap(parent(cur), cur);
            cur = parent(cur);
        }
        return cur - 1;
    }

    public void Dequeue ( int index) {
        int cur = index;
        if (cur != -1) {
            heap[cur] = heap[--contentSize];
            heap[contentSize] = null;

            while (parent(cur) != -1 && heap[parent(cur)].getTimeRemaining() > heap[cur].getTimeRemaining()) {
                swap(parent(cur), cur);
                cur = parent(cur);
            }
            while (leftChild(cur) != -1 && rightChild(cur) != -1 && (heap[leftChild(cur)].getTimeRemaining() < heap[cur].getTimeRemaining()
                    || heap[rightChild(cur)].getTimeRemaining() < heap[cur].getTimeRemaining())) {
                if (heap[leftChild(cur)].getTimeRemaining() < heap[cur].getTimeRemaining()) {
                    swap(leftChild(cur), cur);
                    cur = leftChild(cur);
                } else {
                    swap(rightChild(cur), cur);
                    cur = rightChild(cur);
                }
            }
        }
    }

    public void Dequeue ( Artifact artifact ) {
        int cur = find(artifact);
        if (cur != -1) {
            heap[cur] = heap[--contentSize];
            heap[contentSize] = null;

            if (parent(cur) != -1 ) {
                while (heap[parent(cur)].getTimeRemaining() > heap[cur].getTimeRemaining()) {
                    swap(parent(cur), cur);
                    cur = parent(cur);

                    if (parent(cur) == -1) {
                        break;
                    }
                }
            }

            if (leftChild(cur) != -1 && rightChild(cur) != -1){
                while (heap[leftChild(cur)].getTimeRemaining() < heap[cur].getTimeRemaining()
                        || heap[rightChild(cur)].getTimeRemaining() < heap[cur].getTimeRemaining()) {
                    if (heap[leftChild(cur)].getTimeRemaining() < heap[cur].getTimeRemaining()) {
                        swap(leftChild(cur), cur);
                        cur = leftChild(cur);
                    }
                    else {
                        swap(rightChild(cur), cur);
                        cur = rightChild(cur);
                    }

                    if (leftChild(cur) == -1 || rightChild(cur) == -1){
                        return;
                    }
                }
            }
        }
    }
    // Returns parent index, if no parent then return -1
    private int parent (int index) {
        if (index == 0) {
            return -1;
        }
        if (index < split - 1) {
            return --index;
        }
        else {
            return index / 2;
        }
    }

    private int leftChild (int index) {
        int temp;

        if (index < split - 1)
        {
            temp = ++index;
        }
        else {
            temp = index * 2 - split + 2;
        }
        if (temp >= contentSize) {
            return -1;
        }
        return temp;
    }

    private int rightChild (int index) {
        int temp;

        if (index < split - 1)
        {
            temp = ++index;
        }
        else {
            temp = index * 2 - split + 3;
        }
        if (temp >= contentSize) {
            return -1;
        }
        return temp;
    }

    private void swap (int index1, int index2) {
        Artifact temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private int find(Artifact artifact) {
        for (int i = 0; i < contentSize; i++) {
            if (artifact.getId() == heap[i].getId()) {
                return i;
            }
        }
        return -1;
    }
}
