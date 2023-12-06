package com.example.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.models.Profesor;
import com.example.services.ProfesorServices;

@RequestMapping("/profesor")
@Controller
public class ProfesorController {
	@Autowired
	private ProfesorServices profesorService;
	
	@GetMapping
	public ResponseEntity<ArrayList<Profesor>> getAll(){
		return ResponseEntity.ok(profesorService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Profesor> save (Profesor profesor) throws Exception{
	    if (profesor == null){
	        throw new IllegalArgumentException("El objeto profesor no puede ser nulo");
	    }
	    return ResponseEntity.ok(profesorService.save(profesor));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Profesor> update(@PathVariable Long id, @RequestBody Profesor profesor) {

	    // Llamar al método update de la clase Services
	    Profesor profesorActualizado = profesorService.update(id, profesor);

	    // Devolver el profesor actualizado
	    return ResponseEntity.ok(profesorActualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

	    // Llamar al método delete de la clase Services
	    profesorService.delete(id);

	    // Devolver un código de respuesta 200
	    return ResponseEntity.ok().build();
	}

}
