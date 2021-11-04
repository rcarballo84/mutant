/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.detector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcarballo
 */
public class DetectorDna {
    private static final Logger logger = LoggerFactory.getLogger(DetectorDna.class);
    private static final int MUTANT_SEQUENCE = 2;
    
    private char[][] MatrixSquare;
    
    private boolean validateMatrix(String[] dna){        
        int lenMatrix  = dna.length;
        
        for(int i = 0 ; i < lenMatrix ; i++){
            String valor = dna[i];
            
            if(!dna[i].matches("[ATCGatcg]*")){
                logger.info("Error: La matriz tiene letras que no corresponden");
                return false;
            }
            if(dna[i].length() != lenMatrix){
                logger.info("Error: un valor tiene diferente tamaño al de la matriz");
                return false;
            }
            
            //Inserto la cadena del array en la matriz
            MatrixSquare[i] = dna[i].toCharArray();
        }
        
        return true;
    }
    
    public boolean isMutant(String[] dna){
        int cantCadenas = 0;
        MatrixSquare = new char[dna.length][dna.length];
        
        if(!validateMatrix(dna)){
            return false;
        }        
        
        /**
         * Obtengo la longitud de la matriz y recorro hasta que encuentra 2 secuencias mutantes
         */
        int lenMatrix = MatrixSquare.length;
        while(cantCadenas < MUTANT_SEQUENCE){
            for(int row = 0; row < lenMatrix ; row++){
                for(int col = 0; col < lenMatrix ; col++){
                    char currentCharacter = MatrixSquare[row][col];

                    //Busqueda VERTICAL
                    if(cantCadenas < MUTANT_SEQUENCE){
                        if((col + 4) <= lenMatrix){
                            if(findHorizontal(row, col, currentCharacter)){
                                logger.info("Se encontro la cadena " + currentCharacter);
                                cantCadenas++;
                            }
                        }
                    }else{
                        break;
                    }

                    //Busqueda VERTICAL
                    if(cantCadenas < MUTANT_SEQUENCE){
                        if((row + 4) <= lenMatrix){
                            if(findVertical(row, col, currentCharacter)){
                                logger.info("Se encontro la cadena " + currentCharacter);
                                cantCadenas++;
                            }
                        }
                    }else{
                        break;
                    }

                    //Busqueda DIAGONAL -> IZQUIERDA A DERECHA
                    if(cantCadenas < MUTANT_SEQUENCE){
                        if((col + 4) <= lenMatrix){
                            if((row + 4) <= lenMatrix){
                                if(findDiagonal(row, col, currentCharacter)){
                                    logger.info("Se encontro la cadena " + currentCharacter);
                                    cantCadenas++;
                                }
                            }     
                        }                            
                    }else{
                        break;
                    }

                    //Busqueda DIAGONAL INVERTIDA
                    if(cantCadenas < MUTANT_SEQUENCE){
                        if(col >= 3){
                            if((row + 4) <= lenMatrix){
                                if(findDiagonalInverted(row, col, currentCharacter)){
                                    logger.info("Se encontro la cadena " + currentCharacter);
                                    cantCadenas++;
                                }
                            }     
                        }                            
                    }else{
                        break;
                    }
                }                    
            }
            break;
        }
            
        if(cantCadenas >= MUTANT_SEQUENCE){            
            return true;
        }else{            
            return false;
        }
    }

    /**
     * En las proximas funciones busco de forma horizontal, vertical, diagonal y diagonal invertida.
     * Comparo que el caracter actual sea igual a los proximos 3 caracteres siguientes.
     */
    private boolean findHorizontal(int row, int col, char currentCharacter) {   
        if(currentCharacter == MatrixSquare[row][col + 1] &&
                currentCharacter == MatrixSquare[row][col + 2] &&
                currentCharacter == MatrixSquare[row][col + 3]) return true;
        
	return false;
    }

    private boolean findVertical(int row, int col, char currentCharacter) {
        if(currentCharacter == MatrixSquare[row + 1][col] &&
                currentCharacter == MatrixSquare[row + 2][col] &&
                currentCharacter == MatrixSquare[row + 3][col]) return true;	

	return false;
    }

    private boolean findDiagonal(int row, int col, char currentCharacter) {
        if(currentCharacter == MatrixSquare[row + 1][col + 1] &&
                currentCharacter == MatrixSquare[row + 2][col + 2] &&
                currentCharacter == MatrixSquare[row + 3][col + 3]) return true;	

	return false;
    }

    private boolean findDiagonalInverted(int row, int col, char currentCharacter) {
        if(currentCharacter == MatrixSquare[row + 1][col - 1] &&
                currentCharacter == MatrixSquare[row + 2][col - 2] &&
                currentCharacter == MatrixSquare[row + 3][col - 3]) return true;	

	return false;
    }
}
