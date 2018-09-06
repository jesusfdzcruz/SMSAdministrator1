/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutuofinanciera.smsadministrator1.business.operators;

import com.mutuofinanciera.smsadministrator1.business.Cellphones;
import com.mutuofinanciera.smsadministrator1.constants.AdministratorOperations;
import com.mutuofinanciera.smsadministrator1.dataaccess.Cellphone;

/**
 *
 * @author Oni-sama
 */
public class SMSCleanMessages extends Operator {
    private static final int IP_PARAM_INDEX = 1;
    
    private static SMSCleanMessages mInstance = null;
    
    private Cellphones mCellphones;
    
    public static SMSCleanMessages getInstance(){

        if(mInstance == null)
            mInstance = new SMSCleanMessages();
                    
        return mInstance;
    }

    private SMSCleanMessages() {
        super(AdministratorOperations.CLEAN_MESSAGE, "clcounter");
        
        mCellphones = Cellphones.getInstance();
    }

    @Override
    public void printCommand() {
        System.out.println("clcounter: Clear the number of messages send");
    }

    @Override
    public void printHelp() {
        System.out.println("Clean the number of messages send");
        System.out.println("Command: clcounter <ip>");
        System.out.println("Result: ok when success");
        System.out.println("\tnay when error");
    }

    @Override
    public void execOperator(String[] params) {
        if(params.length < 2 ){
            printHelp();
            return;
        }
        Cellphone cellphone = mCellphones.findDevice(params[IP_PARAM_INDEX]);
        
        if(cellphone == null){
            
            System.out.println("nay");            
        }
        else{
            
            cellphone.setmNumberOfMessages(0);
            System.out.println("ok");            
        }
    }
    
    
}
