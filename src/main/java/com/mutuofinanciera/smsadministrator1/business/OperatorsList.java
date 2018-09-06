/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutuofinanciera.smsadministrator1.business;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mutuofinanciera.smsadministrator1.business.operators.Operator;

/**
 *
 * @author Oni-sama
 */
public class OperatorsList {
    private static OperatorsList mInstance = null;
    
    public Map <String, Operator> mValidOperators;
    
    private OperatorsList(){
        mValidOperators = new HashMap<>();
    }
    
    public static OperatorsList getInstance(){
        if(mInstance == null)
            mInstance = new OperatorsList();
        
        return mInstance;
    }
    
    public void addOperator(String command, Operator operator){
        
        mValidOperators.put(command, operator);
    }   
    
    public Operator getOperator(String command){
        
        return mValidOperators.getOrDefault(command, null);
    }

    public void printHelp() {
        mValidOperators.forEach((k, v)->{
            v.printCommand();
        });
    }
}
