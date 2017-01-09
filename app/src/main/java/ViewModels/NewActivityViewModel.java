package ViewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.CountDownTimer;
import android.os.SystemClock;

import com.example.application.myapplication.BR;

import java.util.List;

import Models.Artifact;
import Models.MinHeap;
import Util.Heap;

/**
 * Created by Hance on 2016-12-28.
 */

public class NewActivityViewModel extends BaseObservable{

    private Artifact[] heapHead;

    public NewActivityViewModel(){
        this.heapHead = Heap.getInstance().TheHeap.Peek8();
    }

    public void Restart ( int index)
    {
        Artifact temp = GetByIndex(index);
        Heap.getInstance().TheHeap.Dequeue(index);
        temp.ResetCountDown();
        Heap.getInstance().TheHeap.Enqueue(temp);
        setHeapHead();
    }

    public void Delete( int index){
        GetByIndex(index).countDown.cancel();
        Heap.getInstance().TheHeap.Dequeue(GetByIndex(index));
        setHeapHead();
    }

    public Artifact GetByIndex (int index)
    {
        return heapHead[index];
    }

    @Bindable
    public Artifact [] getHeapHead (){
        return heapHead;
    }

    public void setHeapHead() {
        heapHead = Heap.getInstance().TheHeap.Peek8();
        notifyPropertyChanged(BR.heapHead);
    }
}