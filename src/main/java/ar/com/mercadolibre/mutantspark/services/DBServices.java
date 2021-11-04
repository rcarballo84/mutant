/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.services;

import ar.com.mercadolibre.mutantspark.model.DnaPOJO;

/**
 *
 * @author rcarballo
 */
public interface DBServices extends Service{
    public void registrarAdn(DnaPOJO dna) throws Exception;   
    
    public long getCountMutantDNA() throws Exception;
    
    long getTotal() throws Exception;
}
