/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutuofinanciera.smsadministrator1.business.operators;

import com.mutuofinanciera.smsadministrator1.business.Cellphones;
import com.mutuofinanciera.smsadministrator1.constants.AdministratorOperations;

/**
 *
 * @author Oni-sama
 */
public class SMSRemove extends Operator{
    private static final int IP_PARAM_INDEX = 1;
    
    private static SMSRemove mInstance = null;
    
    private Cellphones mCellphones;
    
    public static SMSRemove getInstance(){
        if(mInstance == null)
            mInstance = new SMSRemove();
                    
        return mInstance;
    }
    
    private SMSRemove(){
        super(AdministratorOperations.REMOVE_A_DEVICE, "remove");
        
        mCellphones = Cellphones.getInstance();
    }
    
    @Override
    public void printHelp() {
        System.out.println("Remove the device from available devices");
        System.out.println("Command: remove <ip>");
        System.out.println("Result: ok when success");
        System.out.println("\tnay when error");
        
    }

    @Override
    public void execOperator(String[] params) {
        if(params.length < 2){
            printHelp();
            return;
        }
        
        var cellphone = mCellphones.findDevice(params[IP_PARAM_INDEX]);
        
        if(cellphone == null){
            
           System.out.println("nay");
        }
        else{
            
            mCellphones.removeDevice(params[IP_PARAM_INDEX]);
            System.out.println("ok");
        }
    }
    

    @Override
    public void printCommand() {
         System.out.println("remove: Remove the device from available devices");
    }   
}
