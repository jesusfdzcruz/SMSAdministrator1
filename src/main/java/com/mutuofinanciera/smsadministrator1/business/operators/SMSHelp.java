/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutuofinanciera.smsadministrator1.business.operators;

import com.mutuofinanciera.smsadministrator1.business.OperatorsList;
import com.mutuofinanciera.smsadministrator1.constants.AdministratorOperations;

/**
 *
 * @author Oni-sama
 */
public class SMSHelp extends Operator {
    
    private static final int COMMAND_PARAM_INDEX = 1;
    
    private static final int MINIMUM_PARAMETER_SIZE = 2;
    
    private static SMSHelp mInstance = null;
    
    private final OperatorsList mOperators;
    
    public static SMSHelp getInstance(){
        
        if(mInstance == null)
            mInstance = new SMSHelp();
                    
        return mInstance;
    }
    
    private SMSHelp(){
        super(AdministratorOperations.HELP, "help");
        
        mOperators = OperatorsList.getInstance();
    }

    @Override
    public void printCommand() {
        System.out.println("help: Explain the information related with a command");
    }

    @Override
    public void printHelp() {
        System.out.println("Get the information of a command");
        System.out.println("Command: help <command>");
        System.out.println("Result: Information of the command ");
    }

    @Override
    public void execOperator(String[] params) {        
        if(params.length < MINIMUM_PARAMETER_SIZE){
            printCommand();
            return;
        }
        
        var operator = mOperators.getOperator(params[COMMAND_PARAM_INDEX]);
        
        if(operator == null)
            printCommand();
        else
            operator.printHelp();
    }     
    
}
