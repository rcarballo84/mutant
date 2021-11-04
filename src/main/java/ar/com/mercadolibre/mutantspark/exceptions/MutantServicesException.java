/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.exceptions;

/**
 *
 * @author rcarballo
 */
public class MutantServicesException extends Exception {    
    private int code;

    public MutantServicesException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }    
}
