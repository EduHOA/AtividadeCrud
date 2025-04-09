package com.edu.EduAguiar.Service;


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
        int soma = personagem.getDefesa() + personagem.getForca();
        if(soma >10) {
            throw new RuntimeException("A soma de Força e Defesa não pode ser maior que 10.");
        }
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

    public Personagem atualizarPersonagem(int id, Personagem personagem) {

            Optional<Personagem> optional = personagemRepository.findById(id);
            if (optional.isPresent()) {
                Personagem personagemExistente = optional.get();

                personagemExistente.setNome_aventureiro(personagem.getNome());

                return personagemRepository.save(personagemExistente);
            } else {
                throw new RuntimeException("Personagem não encontrado com ID: " + id);
            }
        }


    }


