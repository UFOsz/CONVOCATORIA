package com.example.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.Estudiante;
import com.example.services.EstudianteServices;

@RequestMapping("/estudiante")
@Controller
public class EstudianteController {
	@Autowired
	private EstudianteServices estudianteService;
	
	@GetMapping
	public ResponseEntity<ArrayList<Estudiante>> getAll(){
		return ResponseEntity.ok(estudianteService.getAll());
	}
	@PostMapping
	public ResponseEntity<Estudiante> save (Estudiante estudiante){
		return ResponseEntity.ok(estudianteService.save(estudiante));
	}
	@PutMapping("/estudiantes/{id}")
	public ResponseEntity<Estudiante> update(@PathVariable Long id, Estudiante estudiante) {
	    Estudiante estudianteActualizado = estudianteService.update(id, estudiante);
	    return ResponseEntity.ok(estudianteActualizado);
	}
}
