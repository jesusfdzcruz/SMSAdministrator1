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
public class SMSAdd extends Operator{
    
    private static final int IP_PARAM_INDEX = 1;
    private static final int PORT_PARAM_INDEX = 2;    
    private static final int MINIMUM_PARAMETERS = 3;
    
    private static SMSAdd mInstance = null;
    
    private Cellphones mCellphones = null;
    
    public static SMSAdd getInstance(){
        
        if(mInstance == null)
            mInstance = new SMSAdd();
                    
        return mInstance;
    }
    
    private SMSAdd(){
        super(AdministratorOperations.ADD_NEW_DEVICE, "add");
        
        mCellphones = Cellphones.getInstance();
    }
    
    @Override
    public void printHelp() {
        System.out.println("Add a new device to the available devices");
        System.out.println("Command: add <ip> <port>");
        System.out.println("Result: added when success");
        System.out.println("\tnay when error");
        
    }

    public void execOperator(String[] params) {
        if(params.length < MINIMUM_PARAMETERS){
            printHelp();
        }
        
        try{
            
            mCellphones.addCellphones(new Cellphone(params[IP_PARAM_INDEX], Integer.parseInt(params[PORT_PARAM_INDEX])));        
            System.out.println("ok");
        }catch(Exception ex){
            printHelp();
        }        
    }    

    @Override
    public void printCommand() {
         System.out.println("add: Add a new device to the available devices");
    }   
    
}
