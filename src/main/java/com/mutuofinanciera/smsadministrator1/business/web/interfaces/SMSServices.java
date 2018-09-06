/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutuofinanciera.smsadministrator1.business.web.interfaces;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;

import com.mutuofinanciera.smsadministrator1.dataaccess.web.SMSMessageResponse;

/**
 *
 * @author Oni-sama
 */
public interface SMSServices {
    @GET("smsmessage") Call<List<SMSMessageResponse>> getMessages();
    
    @PUT("smsmessage") Call<Object> sendedMessages(@Body List<String> messages);
}
