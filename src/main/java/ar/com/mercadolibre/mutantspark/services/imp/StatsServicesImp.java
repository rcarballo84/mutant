/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.services.imp;

import ar.com.mercadolibre.mutantspark.model.StatsPOJO;
import ar.com.mercadolibre.mutantspark.services.DBServices;
import ar.com.mercadolibre.mutantspark.services.StatsServices;
//import com.mongodb.MongoException;
import java.text.DecimalFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Casa
 */
public class StatsServicesImp implements StatsServices{
    private static final Logger logger = LoggerFactory.getLogger(StatsServicesImp.class);
    
    private DBServices db;
    
    public StatsServicesImp(){
        this.db = new DBServicesImp();
    }

    public StatsServicesImp(DBServices dbService) {
        this.db = dbService;
    }

    @Override
    public StatsPOJO getStats() throws Exception {
        logger.debug("Iniciando el servicio para obtener las estadisticas.");
        
        long countMutants = 0;
        long total = 0;
        double ratio = 0;
        
        try{
            total = db.getTotal();
            countMutants = db.getCountMutantDNA();
            
            if(total > 0){
                DecimalFormat df = new DecimalFormat("#.##");
                String ratioStr = df.format(countMutants/(double)total);

                ratio = Double.parseDouble(ratioStr);            
            }
            logger.debug("Estadistica obtenida: [Total ADN: " + total + ", mutants: " + countMutants + ", ratio: " + ratio + "]");
        }catch(Exception me){
            logger.info("Error en el servicio stats para obtener las estadisticas");
            me.printStackTrace();
            logger.error("Error en el servicio stats para obtener las estadisticas " + me.getMessage());
            
            throw new Exception("Error en el servicio stats para obtener las estadisticas");            
        }
        
        StatsPOJO stats = new StatsPOJO(countMutants, (total - countMutants), ratio);
        
        return stats;
    }    
}
