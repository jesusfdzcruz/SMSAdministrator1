/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutuofinanciera.smsadministrator1.business.operators;

import com.mutuofinanciera.smsadministrator1.business.operators.web.SMSMessageBusiness;
import com.mutuofinanciera.smsadministrator1.constants.AdministratorOperations;

/**
 *
 * @author Oni-sama
 */
public class SMSRequestMessage extends Operator {

    private static final int MINIMUM_PARAMETER_SIZE = 1;
    
    private static SMSRequestMessage mInstance = null;    
    
    public static SMSRequestMessage getInstance(){
        if(mInstance == null)
            mInstance = new SMSRequestMessage();
                    
        return mInstance;
    }
    private SMSRequestMessage(){
        super(AdministratorOperations.REQUEST_TO_SERVER, "get");
        
    }
    
    
    @Override
    public void printCommand() {
        System.out.println("get: Request sms messages from server");
    }

    @Override
    public void printHelp() {
        System.out.println("Request sms messages from server");
        System.out.println("Command: remove <ip>");
        System.out.println("Result: ok when success");
        System.out.println("\tnay when error");
    }

    @Override
    public void execOperator(String[] params) {
        
        if(params.length < MINIMUM_PARAMETER_SIZE){
            printCommand();
            return;
        }
        
        SMSMessageBusiness business = new SMSMessageBusiness();
        
        business.retrieveMessages();
    }    
}
