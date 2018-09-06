/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutuofinanciera.smsadministrator1.business;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mutuofinanciera.smsadministrator1.dataaccess.Cellphone;
import com.mutuofinanciera.smsadministrator1.dataaccess.SMSMessage;

/**
 *
 * @author Oni-sama
 */
public class SMSWorker {    
    
    private static SMSWorker mInstance = null;
    
    private final SMSMessageQueue mMessageQueue;
    
    private final Cellphones mCellphones;
    
    private final Thread mThread;
    
    private final boolean mIsRunning;
    
    private SMSWorker(){
        
        mCellphones = Cellphones.getInstance();
        
        mThread = new Thread(new BatchWorker());
        
        mMessageQueue = SMSMessageQueue.getInstance();
        
        mIsRunning = true;
        
        mThread.start();
    }
    
    public static SMSWorker getInstance(){
        if(mInstance == null)
            mInstance = new SMSWorker();
        
        return mInstance;
    }
    
    private class BatchWorker implements Runnable{

        private static final int SECONDS_TO_WAIT = 1;
        
        @Override
        public void run() {
            SMSMessage message;
            Cellphone currentCellphone;
            while(mIsRunning){

                message = mMessageQueue.getNextMessage();
                
                if(message != null){
                    System.out.println("Message read, sending to: "+message.getmDestinationNumber()+"\nwith message: "+message.getmMessage());
                    currentCellphone = mCellphones.selectNextPhone();
                    
                    if(currentCellphone != null)
                        currentCellphone.sendMessage(message.getmDestinationNumber(), message.getmMessage());
                }
                
                waitNSeconds(SECONDS_TO_WAIT);
            }
        }      
        
        public void waitNSeconds(int n){
        
            try {
                
                TimeUnit.SECONDS.sleep(n);
            } catch (InterruptedException ex) {
                
                Logger.getLogger(SMSWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
