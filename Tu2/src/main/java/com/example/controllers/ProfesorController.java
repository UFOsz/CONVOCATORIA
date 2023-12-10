package com.example.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Profesor;
import com.example.repositories.ProfesorRepository;
import com.example.services.ProfesorServices;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {
	@Autowired
	ProfesorServices profesorService;
	@Autowired
	ProfesorRepository profesorRepository;
	
	@GetMapping
	public ArrayList<Profesor> obtenerProfesor(){
		return profesorService.obtenerProfesor();
	}

	@PostMapping
	public Profesor guardarProfesor(@RequestBody Profesor profesor) throws Exception{
		return this.profesorService.guardarProfesor(profesor);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarProfesor(@PathVariable Long id, @RequestBody Profesor profesor) throws Exception {

        // Verificamos si el profesor existe
        Profesor profesorExistente = profesorRepository.findById(id).orElse(null);
        if (profesorExistente == null) {
            return new ResponseEntity<>("El profesor con el id " + id + " no existe.", HttpStatus.NOT_FOUND);
        }

        // Actualizamos los datos del profesor
        profesorExistente.setNombres(profesor.getNombres());
        profesorExistente.setApellidos(profesor.getApellidos());
        profesorExistente.setTipoDocumento(profesor.getTipoDocumento());
        profesorExistente.setNumeroDoc(profesor.getNumeroDoc());
        profesorExistente.setMateria(profesor.getMateria());

        // Guardamos los cambios en la base de datos
        profesorRepository.save(profesorExistente);

        return new ResponseEntity<>(profesorExistente, HttpStatus.OK);
    }
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<?> eliminarProfesor(@PathVariable Long id) throws Exception {

	        // Verificamos si el profesor existe
	        Profesor profesor = profesorRepository.findById(id).orElse(null);
	        if (profesor == null) {
	            return new ResponseEntity<>("El profesor con el id " + id + " no existe.", HttpStatus.NOT_FOUND);
	        }

	        // Eliminamos el profesor de la base de datos
	        profesorRepository.delete(profesor);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

}
