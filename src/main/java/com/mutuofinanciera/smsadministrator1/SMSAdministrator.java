
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutuofinanciera.smsadministrator1;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;
import com.mutuofinanciera.smsadministrator1.business.OperatorsList;
import com.mutuofinanciera.smsadministrator1.business.SMSWorker;

import com.mutuofinanciera.smsadministrator1.constants.StringConstants;

import com.mutuofinanciera.smsadministrator1.business.operators.SMSCleanMessages;
import com.mutuofinanciera.smsadministrator1.business.operators.SMSSend;
import com.mutuofinanciera.smsadministrator1.business.operators.SMSAdd;
import com.mutuofinanciera.smsadministrator1.business.operators.SMSHelp;
import com.mutuofinanciera.smsadministrator1.business.operators.SMSRemove;
import com.mutuofinanciera.smsadministrator1.business.operators.SMSRequestMessage;

/**
 *
 * @author Oni-sama
 */
public class SMSAdministrator {
    
    private static OperatorsList operators;
    
    private static SMSWorker mSMSWorker;
    
    private static boolean stopApplication;

    private static void initialize() {
        operators = OperatorsList.getInstance();        
        
        mSMSWorker = SMSWorker.getInstance();
        
        operators.addOperator(SMSAdd.getInstance().getCommand(), SMSAdd.getInstance());
        operators.addOperator(SMSSend.getInstance().getCommand(), SMSSend.getInstance());
        operators.addOperator(SMSCleanMessages.getInstance().getCommand(), SMSCleanMessages.getInstance());
        operators.addOperator(SMSRemove.getInstance().getCommand(), SMSRemove.getInstance());
        operators.addOperator(SMSHelp.getInstance().getCommand(), SMSHelp.getInstance());
        operators.addOperator(SMSRequestMessage.getInstance().getCommand(), SMSRequestMessage.getInstance());
        
    }

    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Locale locale = new Locale("es", "ES");
        String command;
        stopApplication = true;
        
        initialize();
        
        DataInputStream terminal = new DataInputStream(System.in);
        
        //start thread for receiving messages to the queue
        //configure until time
        while(stopApplication){
            System.out.print(CURSOR_STRING);
            command = terminal.readLine();
            

            runCommand(command);
        }
    }
    private static final String CURSOR_STRING = ">";

    private static void runCommand(String command) {
        var commandAndParameters = command.split(StringConstants.COMMAND_SEPARATOR);
        
        evaluator(commandAndParameters[0], commandAndParameters);
    }

    private static void evaluator(String command, String[] parameters) {
        
        var operator = operators.getOperator(command);
        
        if(operator == null)
            printHelp();
        else
            operator.execOperator(parameters);
    }   

    private static void printHelp() {
        
        operators.printHelp();
    }
}
