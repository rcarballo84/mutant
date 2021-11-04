/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.services.imp;

import ar.com.mercadolibre.mutantspark.model.DnaPOJO;
import ar.com.mercadolibre.mutantspark.services.DBServices;
//import com.mongodb.MongoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcarballo
 */
public class DBServicesImp implements DBServices {
    private static final Logger logger = LoggerFactory.getLogger(DBServicesImp.class);

    //private Datastore ds;    

    public DBServicesImp(){
        //this.createDataStore("localhost", 27017, "mutants");
    }
    /*
    private void createDataStore(String host, int port, String database) {
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.writeConcern(WriteConcern.MAJORITY);

        ServerAddress address = new ServerAddress(host, port);

        MongoClient client = new MongoClient(address, builder.build());
        
        Morphia mapPackage = new Morphia().mapPackage("ar.com.mercadolibre.mutantspark.model");
        Datastore ds = mapPackage.createDatastore(client, database);
        ds.ensureIndexes();

        this.ds = ds;
    }*/
    
    /**
     * Registra un adn en la base de datos.
     * Si el adn ya se analizo -> no se guarda.
     *
     * @param dna adn que se quiere registrar.
     */
    @Override
    public void registrarAdn(DnaPOJO dna) throws Exception {
        try{
            logger.info("Registrando el ADN ");

            /*Key<DnaPOJO> save = ds.save(dna);
            logger.debug("ADN registrado: " + save.getId());            */
            logger.info("ADN registrado: 10");   
        }catch(Exception me){
            logger.info("Error registrando el adn: " + me.getMessage());
            logger.error("Error registrando el adn ", me);  
            
            throw new Exception("Error on database connection: " + me.getMessage());
        }
    }

    @Override
    public long getCountMutantDNA() throws Exception {
        logger.debug("Obteniendo la cantidad de ADN mutantes");
        long count = 50;
        /*        long count = 0;

        try {
            Query<DnaPOJO> query = ds.createQuery(DnaPOJO.class);
            query.field("mutant").equal(Boolean.TRUE);

            count = query.count();
        } catch(MongoException me) {
            logger.info("Error obteniendo la cantidad de adn mutantes: " + me.getMessage());
            me.printStackTrace();
            
            throw new Exception("Error obteniendo la cantidad de adn mutantes: " + me.getMessage());
        }
*/
        logger.info("Cantidad de ADN mutantes encontrados: " + count);

        return count;
    }

    @Override
    public long getTotal() throws Exception {
        logger.debug("Obteniendo el Total de ADN analizados");
        long count = 30;
        /*long count = 0;

        try {
            Query<DnaPOJO> query = ds.createQuery(DnaPOJO.class);
            count = query.count();

        } catch (MongoException me) {
            logger.error("Error obteniendo la cantidad de adn analizados: " + me.getMessage());
            me.printStackTrace();
            throw new Exception("Error obteniendo la cantidad de adn analizados: " + me.getMessage());
        }*/

        return count;
    }
    
}
