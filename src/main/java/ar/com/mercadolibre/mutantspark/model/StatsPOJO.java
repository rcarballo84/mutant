/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.model;

/**
 *
 * @author rcarballo
 */
public class StatsPOJO {
    private long count_mutant_dna;
    private long count_human_dna;
    private double ratio;
    
    public StatsPOJO(long count_mutants, long count_humans, double ratio){
        this.count_mutant_dna = count_mutants;
        this.count_human_dna = count_humans;
        this.ratio = ratio;        
    }
    
    public String toString(){
        return "[count_mutant_dna: " + count_mutant_dna + ", count_human_dna: " + count_human_dna + ", ratio: " + ratio + "]";
    }
    
    /**
     * @return the count_mutant_dna
     */
    public long getCount_mutant_dna() {
        return count_mutant_dna;
    }

    /**
     * @param count_mutant_dna the count_mutant_dna to set
     */
    public void setCount_mutant_dna(long count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    /**
     * @return the count_human_dna
     */
    public long getCount_human_dna() {
        return count_human_dna;
    }

    /**
     * @param count_human_dna the count_human_dna to set
     */
    public void setCount_human_dna(long count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    /**
     * @return the ratio
     */
    public double getRatio() {
        return ratio;
    }

    /**
     * @param ratio the ratio to set
     */
    public void setRatio(double ratio) {
        this.ratio = ratio;
    }    
}