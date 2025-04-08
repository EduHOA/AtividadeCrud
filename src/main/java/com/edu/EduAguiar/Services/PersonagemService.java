package com.edu.EduAguiar.Services;


import com.edu.EduAguiar.Model.Personagem;
import com.edu.EduAguiar.Repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public Personagem insertPersonagem(Personagem personagem){
        return personagemRepository.save(personagem);
    }

    public List<Personagem> selectAllPersonagem(){
        return personagemRepository.findAll();
    }

    // select * from orcamento where "id"=id
    public Personagem selectPersonagemById(int id){
        Optional<Personagem> oc = personagemRepository.findById(id);
        if(oc.isPresent()){
            return oc.get();
        }else{
            throw new RuntimeException("Personagem nao encotrado.");
        }
    }

    public void deletarPersonagem(int id){
        personagemRepository.deleteById(id);
    }
}

