/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.services;

import ar.com.mercadolibre.mutantspark.model.StatsPOJO;

/**
 *
 * @author rcarballo
 */
public interface StatsServices extends Service{
    StatsPOJO getStats() throws Exception;    
}
