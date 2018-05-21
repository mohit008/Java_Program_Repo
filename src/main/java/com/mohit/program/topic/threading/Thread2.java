package com.mohit.program.topic.threading;


/**
 * Author @ Mohit Soni on 09-05-2018 07:51 PM.
 */

public class Thread2 extends Thread{
    Message message;

    public Thread2(Message message){
        this.message =message;
    }

    @Override
    public void run() {
        synchronized (message){
            try {
                log("message"," waiter thread got notified at time:"+System.currentTimeMillis());
                message.wait();
                log("message"," waiter thread got notified at time:"+System.currentTimeMillis());
                //process the message now
                log("message"," processed: "+message.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void log(String tag, String msg) {
        System.out.println(tag +", "+ msg);
    }
}
