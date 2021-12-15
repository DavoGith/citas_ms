package com.asignamed.citas_ms.repositories;
import com.asignamed.citas_ms.models.Citas;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Date;
import java.util.List;

public interface CitasRepository extends MongoRepository<Citas,String>{
    List<Citas> findByFechaCitaAndMedicoAndHoraCita (Date fechaCita,String medico,Integer horaCita);
    List<Citas> findByPaciente (String paciente);
}
