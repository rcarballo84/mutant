/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.response;

/**
 *
 * @author rcarballo
 */
public class ErrorResponse {
    private String message;

    public ErrorResponse(String message, String... args) {
        this.message = String.format(message, args);
    }

    public ErrorResponse(Exception e) {
        this.message = e.getMessage();
    }

    public String getMessage() {
        return this.message;
    }
    
}
