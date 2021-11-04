/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.services;

/**
 *
 * @author rcarballo
 */
public interface MutantServices extends Service{
    boolean isMutant(String[] dna) throws Exception;    
}
