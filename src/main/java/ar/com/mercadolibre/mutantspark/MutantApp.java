/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ar.com.mercadolibre.mutantspark;

import ar.com.mercadolibre.mutantspark.controller.MutantController;
import ar.com.mercadolibre.mutantspark.controller.StatsController;
import ar.com.mercadolibre.mutantspark.exceptions.CustomExceptionHandler;
import ar.com.mercadolibre.mutantspark.response.ErrorResponse;
import ar.com.mercadolibre.mutantspark.services.imp.MutantServicesImp;
import ar.com.mercadolibre.mutantspark.services.imp.StatsServicesImp;
import com.google.gson.Gson;
import spark.Spark;
import static spark.Spark.exception;
import static spark.Spark.port;

/**
 *
 * @author rcarballo
 */
public class MutantApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here                     
        port(8080);
           
        new MutantController(new MutantServicesImp());        
        new StatsController(new StatsServicesImp());        
        
        Spark.exception(NullPointerException.class, new CustomExceptionHandler(500, "server.error.nullpointer1"));
        
        exception(IllegalArgumentException.class, (e, req, res) -> {
            res.status(400);
            res.body(new Gson().toJson((new ErrorResponse(e))));
        });
    }    
}