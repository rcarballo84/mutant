/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.model;

/**
 *
 * @author rcarballo
 */
public class DnaPOJO {
 
    private String[] dna;    
    
    private boolean isMutant;

    public DnaPOJO(){
        
    }
    
    public DnaPOJO(String[] dna, boolean mutant){
        this.dna = dna;
        this.isMutant = mutant;        
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{[ dna: ");
        
        for (String dnaItem : dna) {
            sb.append(dnaItem).append(" ");
        }
        sb.append("]}");

        return sb.toString();
    }
    
    /**
     * @return the dna
     */
    public String[] getDna() {
        return dna;
    }

    /**
     * @param dna the dna to set
     */
    public void setDna(String[] dna) {
        this.dna = dna;
    }

    /**
     * @return the isMutant
     */
    public boolean isIsMutant() {
        return isMutant;
    }

    /**
     * @param isMutant the isMutant to set
     */
    public void setIsMutant(boolean isMutant) {
        this.isMutant = isMutant;
    }    
}
