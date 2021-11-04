/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.exceptions;

import spark.ExceptionHandler;
import spark.Request;
import spark.Response;

/**
 *
 * @author rcarballo
 */
public class CustomExceptionHandler implements ExceptionHandler{
    private final int status;
    private final String message;
    
    public CustomExceptionHandler(int status, String message){
        this.status = status;
        this.message = message;
    }            

    /**
     * Parameters:
     * @param t The exception that was thrown during routing
     * @param rqst The request object providing information about the HTTP request
     * @param rspns The response object providing functionality for modifying the response
     */
    @Override
    public void handle(Exception t, Request rqst, Response rspns) {
        rspns.status(status);
        rspns.body(message);
    }
    
}
