package com.example.repositories;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
import com.example.models.Profesor;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor,Long>{

	Profesor findByTipoDocumentoAndNumeroDoc(String tipoDocumento, Long numeroDoc);

}
