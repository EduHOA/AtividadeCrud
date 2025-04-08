package com.edu.EduAguiar.Controller;

import com.edu.EduAguiar.Model.Personagem;
import com.edu.EduAguiar.Services.PersonagemService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @PostMapping
    public Personagem criarPersonagem(@RequestBody Personagem personagem){
        return personagemService.insertPersonagem(personagem);
    }

    @GetMapping
    public List<Personagem> listarOrcamento(){
        return personagemService.selectAllPersonagem();
    }

    @GetMapping("/{id}")
    public Personagem buscarById(@PathVariable int id){
        return personagemService.selectPersonagemById(id);
    }

    @DeleteMapping("deletar/{id}")
    public void deletar(@PathVariable int id){
        personagemService.deletarPersonagem(id);
    }

}
