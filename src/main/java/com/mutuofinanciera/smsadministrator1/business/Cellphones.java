/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutuofinanciera.smsadministrator1.business;

import java.util.ArrayList;
import java.util.List;
import com.mutuofinanciera.smsadministrator1.dataaccess.Cellphone;

/**
 *
 * @author Oni-sama
 */
public class Cellphones {
    private List <Cellphone> mCellphones;
    
    private static Cellphones mInstance;
    
    private Cellphones(){
        mCellphones = new ArrayList<>();
    }
    
    public static Cellphones getInstance(){
        if(mInstance == null)
            mInstance = new Cellphones();
        
        return mInstance;
    }
    
    public void addCellphones(Cellphone cellphone){
        
        mCellphones.add(cellphone);
    }
    
    public Cellphone findDevice(String ip){
        
        for(var cellphone : mCellphones){
            if(cellphone.getmIP().equals(ip))
                return cellphone;
        }
        
        return null;
    }
    
    public Cellphone selectNextPhone() {
        if(mCellphones.size() <= 0)
            return null;
        
        return mCellphones.get(findCellphoneWithMinimumNumberOfMessages());
    }
    
    private int findCellphoneWithMinimumNumberOfMessages() {
        int i;
        int result = 0;
        
        for(i = 0;i != mCellphones.size(); i++){
            
            if(mCellphones.get(result).getmNumberOfMessages() > mCellphones.get(i).getmNumberOfMessages()){
                
                result = i;
            }
        }
        
        return result;
    }
    
    public Cellphone removeDevice(String ip){
        Cellphone result = findDevice(ip);
        
        if(result != null)
            mCellphones.remove(result);
        return result;
    }
    
}
