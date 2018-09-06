/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutuofinanciera.smsadministrator1.dataaccess.web;

/**
 *
 * @author Oni-sama
 */
public class SMSMessageResponse {
    
    public String sms_message_id;
    public String creditor_id; 
    public String sms_message_status_id;  
    public String sms_message_type_id; 
    public String message; 
    public String number;

    public String getSms_message_id() {
        return sms_message_id;
    }

    public void setSms_message_id(String sms_message_id) {
        this.sms_message_id = sms_message_id;
    }

    public String getCreditor_id() {
        return creditor_id;
    }

    public void setCreditor_id(String creditor_id) {
        this.creditor_id = creditor_id;
    }

    public String getSms_message_status_id() {
        return sms_message_status_id;
    }

    public void setSms_message_status_id(String sms_message_status_id) {
        this.sms_message_status_id = sms_message_status_id;
    }

    public String getSms_message_type_id() {
        return sms_message_type_id;
    }

    public void setSms_message_type_id(String sms_message_type_id) {
        this.sms_message_type_id = sms_message_type_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    
}
