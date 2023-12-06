package com.example.repositories;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
import com.example.models.Estudiante;

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante,Long> {

}
	