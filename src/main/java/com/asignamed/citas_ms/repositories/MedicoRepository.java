package com.asignamed.citas_ms.repositories;
import com.asignamed.citas_ms.models.Citas;
import com.asignamed.citas_ms.models.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MedicoRepository extends MongoRepository <Medico, String> {

    List<Medico> findByEspecialidad (String especialidad);
}
