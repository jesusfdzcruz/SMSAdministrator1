/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutuofinanciera.smsadministrator1.business.operators.web;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.mutuofinanciera.smsadministrator1.business.SMSMessageQueue;
import com.mutuofinanciera.smsadministrator1.business.web.interfaces.SMSServices;
import com.mutuofinanciera.smsadministrator1.dataaccess.SMSMessage;
import com.mutuofinanciera.smsadministrator1.dataaccess.web.SMSMessageResponse;

/**
 *
 * @author Oni-sama
 */
public class SMSMessageBusiness{
    SMSServices mSMSServices;
    SMSMessageQueue mMessageQueue;
    public SMSMessageBusiness(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BaseURL).addConverterFactory(GsonConverterFactory.create())
                .build();
        
        mSMSServices = retrofit.create(SMSServices.class);
        mMessageQueue = SMSMessageQueue.getInstance();
    }
    
    public void retrieveMessages(){
        try {
            List<SMSMessageResponse> response = mSMSServices.getMessages().execute().body();
            
            mMessageQueue.addMessages(SMSMessage.transformWebResponse(response));
        } catch (IOException ex) {
            Logger.getLogger(SMSMessageBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
