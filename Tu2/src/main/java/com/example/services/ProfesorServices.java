package com.example.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.models.Profesor;
import com.example.repositories.ProfesorRepository;

@Service
public class ProfesorServices {
	@Autowired
	ProfesorRepository profesorRepository;
	
	public ArrayList<Profesor> obtenerProfesor() {
	    return (ArrayList<Profesor>)profesorRepository.findAll();
	}
	
	public Profesor guardarProfesor(Profesor profesor) throws Exception {

	    // Obtenemos el profesor con el mismo tipo de documento y número de cédula
	    Profesor profesorExistente = profesorRepository.findByTipoDocumentoAndNumeroDoc(profesor.getTipoDocumento(), profesor.getNumeroDoc());

	    // Si el profesor existe, lanzamos una excepción
	    if (profesorExistente != null) {
	        throw new Exception("Ya existe un profesor con el mismo tipo de documento y número de cédula.");
	    }

	    // Si el profesor no existe, lo guardamos en la base de datos
	    return profesorRepository.save(profesor);
	}
	
	public Profesor actualizarProfesor(Long id, Profesor profesor) throws Exception {

	    // Verificamos si el profesor existe
	    Profesor profesorExistente = profesorRepository.findById(id).orElse(null);
	    if (profesorExistente == null) {
	        throw new Exception("El profesor con el id " + id + " no existe.");
	    }

	    // Actualizamos los datos del profesor
	    profesorExistente.setNombres(profesor.getNombres());
	    profesorExistente.setApellidos(profesor.getApellidos());
	    profesorExistente.setTipoDocumento(profesor.getTipoDocumento());
	    profesorExistente.setNumeroDoc(profesor.getNumeroDoc());
	    profesorExistente.setMateria(profesor.getMateria());

	    // Guardamos los cambios en la base de datos
	    profesorRepository.save(profesorExistente);

	    return profesorExistente;
	}
	
	public void eliminarProfesor(Long id) throws Exception {

	    // Verificamos si el profesor existe
	    Profesor profesor = profesorRepository.findById(id).orElse(null);
	    if (profesor == null) {
	        throw new Exception("El profesor con el id " + id + " no existe.");
	    }

	    // Eliminamos el profesor de la base de datos
	    profesorRepository.delete(profesor);
	}
}
