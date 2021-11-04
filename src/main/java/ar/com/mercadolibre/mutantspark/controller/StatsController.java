/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.controller;

import ar.com.mercadolibre.mutantspark.exceptions.CustomExceptionHandler;
import ar.com.mercadolibre.mutantspark.exceptions.StatsServicesException;
import ar.com.mercadolibre.mutantspark.model.StatsPOJO;
import ar.com.mercadolibre.mutantspark.services.StatsServices;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Spark;
import static spark.Spark.get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcarballo
 */
public class StatsController {
    private static final Logger logger = LoggerFactory.getLogger(StatsController.class);
    
    public StatsController(StatsServices statsServices){
        get("/stats/", (Request req, Response res) -> {
            logger.info("Recibio request en el path /stats/");
            StatsPOJO stats;
            
            try{
                stats = statsServices.getStats();
            }catch(StatsServicesException se){
                logger.error("Error durante el procesamiento del request stats ", se);
                throw new Exception(se.getMessage());                             
            }            
            logger.info("Se proceso satisfactoriamente el request " + stats);
            
            //Convierto el objeto statsPOJO a formato JSON para respuesta
            String toJson = new Gson().toJson(stats, StatsPOJO.class);
            
            res.status(200);
            res.type("application/json");
            
            return toJson;
        }); 

        Spark.exception(StatsServicesException.class, new CustomExceptionHandler(500, "server.error.statistics.service"));        
    }    
}