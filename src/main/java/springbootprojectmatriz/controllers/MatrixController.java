package springbootprojectmatriz.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springbootprojectmatriz.services.IServicio;

@RestController
public class MatrixController {
	
	//Factory
	@Autowired
	private IServicio servicio;

	// Endpoint
	@PostMapping(value= "/rotate-matrix",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> rotateMatrix(@RequestBody int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return ResponseEntity.badRequest().body("La matriz es nula o vacía");
		}
		int rows = matrix.length;
		int columns = matrix[0].length;
		if (rows != columns) {
			return ResponseEntity.badRequest().body("La matriz no es cuadrada");
		}
		if (Arrays.stream(matrix).flatMapToInt(Arrays::stream).anyMatch(e -> !isNumeric(e))) {
			return ResponseEntity.badRequest().body("La matriz contiene valores no numéricos");
		}

		int[][] rotatedMatrix = servicio.rotateMatrix(matrix);
		return ResponseEntity.ok(rotatedMatrix);
	}

	private boolean isNumeric(int value) {
		try {
			Integer.parseInt(String.valueOf(value));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	
	//otros Endpoints
}
