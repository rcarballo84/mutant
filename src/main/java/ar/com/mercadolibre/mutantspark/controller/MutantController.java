/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.controller;

import ar.com.mercadolibre.mutantspark.exceptions.CustomExceptionHandler;
import ar.com.mercadolibre.mutantspark.exceptions.MutantServicesException;
import ar.com.mercadolibre.mutantspark.functions.RandomMatrix;
import ar.com.mercadolibre.mutantspark.model.DnaPOJO;
import ar.com.mercadolibre.mutantspark.services.imp.MutantServicesImp;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Spark;
import static spark.Spark.post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcarballo
 */

public class MutantController {
    private static final Logger logger = LoggerFactory.getLogger(MutantController.class);
    
    public MutantController(MutantServicesImp mutantService) { 
        
        post("/mutant/", (Request req, Response res) -> {
            logger.info("Recibio request en el path /mutants/");
            boolean isMutant = false;            
            
            String body = req.body();
            logger.info("BODY: " + body);            
            
            // Convertimos de JSON a objeto de la clase DnaPOJO
            DnaPOJO dnaPOJO = json2DnaPOJO(body);            
            
            //el servicio mutant verifica si el ADN es mutante.
            isMutant = mutantService.isMutant(dnaPOJO.getDna());            
            logger.info("ADN Procesado: " + (isMutant? "Mutante":"Humano"));
            
            if(isMutant){
                res.status(200);
                return "OK";
            }else{
                res.status(403);
                return "Forbbiden";                
            }            
        });
        
        Spark.exception(MutantServicesException.class, new CustomExceptionHandler(500, "server.error.mutant.service"));
    } 
    
    public DnaPOJO getTestMatrix(int dimension) {
        DnaPOJO dnaPOJO = new DnaPOJO();            

        dnaPOJO.setDna(RandomMatrix.ArrayRandomMatrix(dimension));
        return dnaPOJO;
    }
    
    /**
     * Convierte el objeto JSON en un objeto tipo DnaPOJO.
     * @param body body de la request con los datos enviados.
     * @return Objeto de tipo DnaPOJO.
     */
    private static DnaPOJO json2DnaPOJO(String body) {
        DnaPOJO dna = null;
        try {
            dna = new Gson().fromJson(body, DnaPOJO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dna;
    }
    
    /*
    @POST(/TestMutant/)
    public Response TestMutantApi(@QueryParam("dimension") int dimension) {
        DnaPOJO dna = new DnaPOJO();

        dna.setDna(RandomMatrix.ArrayRandomMatrix(dimension));

        DetectorDna detectorDna = new DetectorDna();
        if (detectorDna.isMutant(dna.getDna())) {
                return Response.ok().build();                
        } else {
                return Response.status(403).type("text/plain").entity("Forbidden").build();
        }
    }
    
    GET("ArrayTest")
    public DnaPOJO getTestMatrix(@QueryParam("dimension") int dimension) {
        DnaPOJO dnaPOJO = new DnaPOJO();            

        dnaPOJO.setDna(RandomMatrix.ArrayRandomMatrix(dimension));
        return dnaPOJO;
    }*/
}
