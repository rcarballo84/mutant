/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.functions;

import java.util.Random;

/**
 *
 * @author rcarballo
 */
public class RandomMatrix {
    final static private String letrasDNA = "ATCG";
    
    public static String[] ArrayRandomMatrix(int size){        
        String[] array = new String[size];
        
        Random rnd = new Random();
        for(int j = 0 ; j < size ; j++){
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < size ; i++){
                sb.append(letrasDNA.charAt(rnd.nextInt(letrasDNA.length())));
            }
            array[j] = sb.toString();
        }        
        
        return array;
    }
    
}
