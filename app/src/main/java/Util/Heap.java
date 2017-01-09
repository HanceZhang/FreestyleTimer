package Util;

import Models.Artifact;
import Models.MinHeap;

/**
 * Created by Hance on 2016-12-23.
 */
public class Heap {
    private static Heap ourHeap = new Heap();
    public MinHeap TheHeap = new MinHeap(64);

    public static Heap getInstance() {
        return ourHeap;
    }

    private Heap() {
    }
}
