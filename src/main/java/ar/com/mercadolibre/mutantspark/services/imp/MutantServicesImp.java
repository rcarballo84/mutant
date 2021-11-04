/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.services.imp;

import ar.com.mercadolibre.mutantspark.detector.DetectorDna;
import ar.com.mercadolibre.mutantspark.model.DnaPOJO;
import ar.com.mercadolibre.mutantspark.services.DBServices;
import ar.com.mercadolibre.mutantspark.services.MutantServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcarballo
 */
public class MutantServicesImp implements MutantServices{
    private static final Logger logger = LoggerFactory.getLogger(MutantServicesImp.class);
    
    private DBServices db;
    
    public MutantServicesImp(){
        this.db = new DBServicesImp();
    }

    public MutantServicesImp(DBServices dbService) {
        this.db = dbService;
    }
    
    @Override
    public boolean isMutant(String[] dna) throws Exception{
        boolean isMutant = false;
        
        logger.info("Verificando DNA");
        
        try{            
            DetectorDna detectorDna = new DetectorDna();
            isMutant = detectorDna.isMutant(dna);
            
            logger.info("Instanciando DB para almacenar el ADN");            
            db.registrarAdn(new DnaPOJO(dna, isMutant));
            logger.info("DNA registrado OK");                      
        }catch(Exception e){
            logger.info("Error en el servicio mutant mientras se verificaba si es mutante");
            e.printStackTrace();
            logger.error("Error en el servicio mutant mientras se verificaba si es mutante", e.getMessage());
        }      
        return isMutant;
    }
}
