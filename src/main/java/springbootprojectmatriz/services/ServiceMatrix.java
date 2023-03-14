package springbootprojectmatriz.services;

import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class ServiceMatrix implements IServicio {

	public  int[][] rotateMatrix(int[][] matrix) {
	    
		//Longitud del total de matrices
		int rows = matrix.length;
	
		//Longitud de la primera matriz
	    int columns = matrix[0].length;
	    
	    //Creamos una variable para no alterar el valor de entrada
	    int[][] result = new int[columns][rows];
    
	    //Creamos un rango e iteramos entre 0 y la longitud del total de matrices
	    IntStream.range(0, rows).forEach(i -> 
 	        IntStream.range(0, columns).forEach(j -> 
	            result[columns - j - 1][i] = matrix[i][j]
	        )
	    );
	    return result;
	}
}