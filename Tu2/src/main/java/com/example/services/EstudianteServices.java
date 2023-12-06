package com.example.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Estudiante;
import com.example.repositories.EstudianteRepository;

@Service
public class EstudianteServices {
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	public ArrayList<Estudiante> getAll(){
		return (ArrayList<Estudiante>)estudianteRepository.findAll();
	}
	public Estudiante save(Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}
	
	public Estudiante update(Long id, Estudiante estudiante) {
        if(estudianteRepository.existsById(estudiante.getId())){
        	estudiante.setNombres(estudiante.getNombres());
            estudiante.setApellidos(estudiante.getApellidos());
            return estudianteRepository.save(estudiante);
        }else {
        	return null;
        }
	}
}
