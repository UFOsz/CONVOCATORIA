package com.example.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.models.Profesor;
import com.example.repositories.ProfesorRepository;

@Service
public class ProfesorServices {
	@Autowired
	private ProfesorRepository profesorRepository;
	
	public ArrayList<Profesor> getAll() {
	    return (ArrayList<Profesor>)profesorRepository.findAll();
	}
	
	public Profesor save(Profesor profesor) throws Exception {

	    Profesor profesorEncontrado = profesorRepository.findByTipoDocumentoAndNumeroDoc(profesor.getTipoDocumento(), profesor.getNumeroDoc());
	    if (profesorEncontrado != null) {
	        throw new Exception("Ya existe un profesor con el mismo tipo de documento y cédula");
	    }
	    return profesorRepository.save(profesor);
	}
	
	public Profesor update(Long id, Profesor profesor) {

	    Profesor profesorEncontrado = profesorRepository.findById(id).orElse(null);

	    if (profesorEncontrado != null) {

	        // Actualizar los datos del profesor
	        profesorEncontrado.setNombres(profesor.getNombres());
	        profesorEncontrado.setApellidos(profesor.getApellidos());
	        profesorEncontrado.setTipoDocumento(profesor.getTipoDocumento());
	        profesorEncontrado.setNumeroDoc(profesor.getNumeroDoc());
	        profesorEncontrado.setMateria(profesor.getMateria());

	        return profesorRepository.save(profesorEncontrado);
	    } else {
	        return null;
	    }
	}
	public boolean delete(Long id) {

	    Profesor profesor = profesorRepository.findById(id).orElse(null);

	    if (profesor != null) {
	        profesorRepository.delete(profesor);
	        return true;
	    } else {
	        return false;
	    }
	}
}
