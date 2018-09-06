/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutuofinanciera.smsadministrator1.business.operators;

import com.mutuofinanciera.smsadministrator1.business.SMSMessageQueue;
import com.mutuofinanciera.smsadministrator1.constants.AdministratorOperations;
import com.mutuofinanciera.smsadministrator1.dataaccess.SMSMessage;

/**
 *
 * @author Oni-sama
 */
public class SMSSend extends Operator {
    private SMSMessageQueue mSMSMessageQueue = null;
    private static SMSSend mInstance = null;
    
    public static SMSSend getInstance(){
        if(mInstance == null)
            mInstance = new SMSSend();
                    
        return mInstance;
    }

    private SMSSend() {
        super(AdministratorOperations.ENQUE_A_MESSAGE, "send");
        
        mSMSMessageQueue = SMSMessageQueue.getInstance();
    }

    @Override
    public void printCommand() {
        System.out.println("send: Queue a message to be send");
    }

    @Override
    public void printHelp() {
        System.out.println("Enqueue a message");
        System.out.println("Command: send <number> <message>");
        System.out.println("Result: ok when success");
        System.out.println("\tnay when error");
    }

    @Override
    public void execOperator(String[] params) {
        if(params.length < 3){
            printHelp();
            return;
        }
        
        mSMSMessageQueue.addMessage(params[1], params[2]);
    }    
}
