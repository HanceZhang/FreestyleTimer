package Models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.CountDownTimer;

import com.android.databinding.library.baseAdapters.BR;

import Util.Clock;
import Util.Id;

/**
 * Created by Hance on 2016-12-22.
 */

public class Artifact extends BaseObservable {
    private final int id;
    private String name;
    private long  loopTime; //loop time in seconds
    private long timeRemaining;
    public CountDownTimer countDown;

    public Artifact(String name, int loopTime){
        this.name = name;
        this.id = Id.ArtifactId++;
        this.loopTime = loopTime;
        this.timeRemaining = loopTime;

        countDown = new CountDownTimer(loopTime, 1000) {
            public void onTick(long millisUntilFinished) {
                setTimeRemaining(millisUntilFinished);
            }
            public void onFinish() {
                setTimeRemaining(0);
            }
        }.start();
    }

    @Bindable
    public String getName() {
        return this.name;
    }

    @Bindable
    public long getTimeRemaining () {
        return timeRemaining;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setTimeRemaining(long timeRemaining) {
        this.timeRemaining = timeRemaining;
        notifyPropertyChanged(BR.timeRemaining);
    }

    public int getId() {
        return this.id;
    }

    public void ResetCountDown (){
        countDown.cancel();
        timeRemaining = loopTime;
        countDown = new CountDownTimer(loopTime, 1000) {
            public void onTick(long millisUntilFinished) {
                setTimeRemaining(millisUntilFinished);
            }
            public void onFinish() {
                setTimeRemaining(0);
            }
        }.start();
    }
}
