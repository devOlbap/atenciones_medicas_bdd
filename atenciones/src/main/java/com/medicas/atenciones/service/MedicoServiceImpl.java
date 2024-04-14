package com.medicas.atenciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicas.atenciones.model.Medico;
import com.medicas.atenciones.repository.MedicoRepository;

import java.util.List;
import java.util.Optional;


@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public List<Medico> getMedicos(){
        return medicoRepository.findAll();
    }

    @Override
    public Medico getMedicoById(Long id){
        Optional<Medico> MedicoOP = medicoRepository.findById(id);
        if (MedicoOP.isPresent()) {
            return MedicoOP.get(); 
        } else {
            return null; 
        }
    }
    @Override
    public Medico createMedico(Medico medico){
        return medicoRepository.save(medico);
    }
    @Override
    public Medico updateMedico(Long id, Medico medico){

        if(medicoRepository.existsById(id)){
            medico.setId(id);
            return medicoRepository.save(medico);
        }
        return null;
    }
    @Override
    public Boolean deleteMedico(Long id){
        if(medicoRepository.existsById(id)){
            medicoRepository.deleteById(id);
            return true;
        }
        return false;
    }
   


}
