/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutuofinanciera.smsadministrator1.dataaccess;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import com.mutuofinanciera.smsadministrator1.constants.SMSOperations;

/**
 *
 * @author Oni-sama
 */
public class Cellphone {
    
    private String mIP;
    private int mPort;
    
    private int mNumberOfMessages;
    
    public Cellphone(String ip, int port){
        mIP = ip;
        mPort = port;
    }
    
    public boolean sendMessage(String number, String message){
        sendCommand(SMSOperations.SEND_MESSAGE.ordinal());
           
        sendText(number);    
        
        sendText(message);        
                        
        mNumberOfMessages++;
        return true;
    }
    
    public boolean sendCommand(int command){
        boolean result = true;
        try{
            Socket socket = new Socket(mIP, mPort);
            
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            
            dataOutputStream.writeInt(command);

            socket.close();
        }
        catch(IOException error){
            error.printStackTrace();
            result =  false;
        }
        
        return result;
    }
    
    public int getmNumberOfMessages() {
        return mNumberOfMessages;
    }

    public void setmNumberOfMessages(int mNumberOfMessages) {
        this.mNumberOfMessages = mNumberOfMessages;
    }

    public String getmIP() {
        return mIP;
    }   

    public boolean sendText(String text) {
        boolean result = true;
        
        try{
            Socket socket = new Socket(mIP, mPort);
            
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            
            dataOutputStream.writeUTF(text+"\n");

            socket.close();
        }
        catch(IOException error){
            error.printStackTrace();
            result =  false;
        }
        
        return result;
    }
    
}
