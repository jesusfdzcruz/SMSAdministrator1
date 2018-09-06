/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutuofinanciera.smsadministrator1.business;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.mutuofinanciera.smsadministrator1.dataaccess.SMSMessage;

/**
 *
 * @author Oni-sama
 */
public class SMSMessageQueue {
    
    private static SMSMessageQueue mInstance= null;
    
    private final Queue<SMSMessage> mMessageQueue;
    
    private SMSMessageQueue(){
        
        mMessageQueue = new LinkedList<>();
    }
    
    public static SMSMessageQueue getInstance(){
        
        if(mInstance == null)
            mInstance = new SMSMessageQueue();
        
        return mInstance;
    }
    
    public void addMessage(String destinationAddress, String message){
        
        mMessageQueue.add(new SMSMessage(destinationAddress, message));
    }

    public SMSMessage getNextMessage(){
        
        return mMessageQueue.poll();
    }

    public void addMessages(List<SMSMessage> messages) {
        messages.forEach(x->{
            mMessageQueue.add(x);
        });
        
    }
}
