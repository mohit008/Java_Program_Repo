package com.mohit.program.topic.threading;


/**
 * Author @ Mohit Soni on 09-05-2018 07:51 PM.
 */

public class Thread1 extends Thread{
    Message message;

    public Thread1(Message message){
        this.message =message;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            synchronized (message) {
                message.setMsg(" Notifier work done");
                message.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
