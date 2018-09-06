/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutuofinanciera.smsadministrator1.business.operators;

import com.mutuofinanciera.smsadministrator1.constants.AdministratorOperations;

/**
 *
 * @author Oni-sama
 */
public abstract class Operator {
    public final AdministratorOperations mOperation;
    
    private final String mCommand;
    
    protected Operator(AdministratorOperations operation, String command){
        mOperation = operation;
        mCommand = command;
    }
    
    public abstract void printCommand();
    
    public abstract void printHelp();
    
    public abstract void execOperator(String[] params);
    
    public int getOperatorId(){
        return mOperation.ordinal();
    }
    
    public String getCommand(){
        return mCommand;
    }    
}
