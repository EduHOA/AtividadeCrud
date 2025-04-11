package com.edu.EduAguiar.Controller;

import com.edu.EduAguiar.Dto.PersonagemDto;
import com.edu.EduAguiar.Model.Personagem;
import com.edu.EduAguiar.Service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("editar/{id}")
    public Personagem editarPersonagem(@RequestBody Personagem personagem, @PathVariable int id){
           return personagemService.atualizarPersonagem(id, personagem);
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

    @GetMapping("/{id}/detalhes")
    public ResponseEntity<PersonagemDto> detalhesPersonagem(@PathVariable int id) {
        Personagem personagem = personagemService.selectPersonagemById(id);

        PersonagemDto dto = new PersonagemDto(
                personagem.getNome(),
                personagem.getNome_aventureiro(),
                personagem.getClasse().name(),
                personagem.getLevel(),
                personagem.getForcaTotal(),
                personagem.getDefesaTotal(),
                personagem.getItens_magicos()
        );

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{idPersonagem}/item/{idItem}")
    public ResponseEntity<Void> adicionarItemMagicoAoPersonagem(
            @PathVariable int idPersonagem,
            @PathVariable int idItem) {

        personagemService.adicionarItemMagico(idPersonagem, idItem);
        return ResponseEntity.ok().build();
    }


}
