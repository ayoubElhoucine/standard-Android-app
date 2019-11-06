package com.tofaha.baseapp.timer;

import android.os.Handler;
import android.os.Message;

/**
 * Created by Ayoubb on 08/12/2016.
 */
public class Timer {
    private thread t ;
    public boolean runTimer ;
    public long delay ;
    public int msg = 0;
    private Handler handler ;

    public Timer(Handler handler , long delay , int msg){
        this.handler = handler ;
        runTimer = true ;
        this.delay = delay ;
        this.msg = msg ;
        t = new thread();
        t.start();
    }

    public class thread extends Thread{

        @Override
        public void run(){
            while (runTimer){
                try{
                    thread.sleep(delay);
                }catch (Exception e){}

                Message message = handler.obtainMessage(msg);
                handler.sendMessage(message);
            }
        }
    }

    public void playTimer (boolean play){
        runTimer = play ;
    }

}