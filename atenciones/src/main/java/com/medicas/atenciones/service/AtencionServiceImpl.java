package com.medicas.atenciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicas.atenciones.model.Atencion;
import com.medicas.atenciones.repository.AtencionRepository;

import java.util.List;
import java.util.Optional;


@Service
public class AtencionServiceImpl implements AtencionService {

    @Autowired
    private AtencionRepository atencionRepository;

    @Override
    public List<Atencion> getAtenciones(){
        return atencionRepository.findAll();
    }

    @Override
    public Atencion getAtencionById(Long id){
        Optional<Atencion> atencionOP = atencionRepository.findById(id);
        if (atencionOP.isPresent()) {
            return atencionOP.get(); 
        } else {
            return null; 
        }
    }
    @Override
    public Atencion createAtencion(Atencion atencion){
        return atencionRepository.save(atencion);
    }
    @Override
    public Atencion updateAtencion(Long id, Atencion atencion){

        if(atencionRepository.existsById(id)){
            atencion.setId(id);
            return atencionRepository.save(atencion);
        }
        return null;
    }
    @Override
    public Boolean deleteAtencion(Long id){
        if(atencionRepository.existsById(id)){
            atencionRepository.deleteById(id);
            return true;
        }
        return false;
    }
   


}
