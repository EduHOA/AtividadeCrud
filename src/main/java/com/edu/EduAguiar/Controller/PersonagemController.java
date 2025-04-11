package com.edu.EduAguiar.Controller;
import com.edu.EduAguiar.Repository.Item_MagicoRepository;
import com.edu.EduAguiar.Repository.PersonagemRepository;
import com.edu.EduAguiar.Dto.NomeAventureiroDTO;
import com.edu.EduAguiar.Dto.PersonagemDto;
import com.edu.EduAguiar.Model.ItemMagico;
import com.edu.EduAguiar.Model.Personagem;
import com.edu.EduAguiar.Service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @Autowired
    private PersonagemRepository personagemRepository;


    @PostMapping
    public Personagem criarPersonagem(@RequestBody Personagem personagem){
        return personagemService.insertPersonagem(personagem);
    }

    @PatchMapping("editar/{id}")
    public ResponseEntity<Personagem> atualizarNomeAventureiro(
            @PathVariable int id,
            @RequestBody NomeAventureiroDTO dto) {

        Personagem personagem = personagemService.selectPersonagemById(id);
        personagem.setNome_aventureiro(dto.getNome_aventureiro());
        return ResponseEntity.ok(personagemRepository.save(personagem));
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
    public ResponseEntity<Void> adicionarItem(
            @PathVariable int idPersonagem,
            @PathVariable int idItem) {
        personagemService.adicionarItemAoPersonagem(idPersonagem, idItem);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}/itens")
    public ResponseEntity<List<ItemMagico>> listarItensDoPersonagem(@PathVariable int id) {
        return ResponseEntity.ok(personagemService.listarItensPorPersonagem(id));
    }

    @DeleteMapping("/{idPersonagem}/itens/{idItem}")
    public ResponseEntity<Void> removerItemDoPersonagem(@PathVariable int idPersonagem, @PathVariable int idItem) {
        personagemService.removerItemDoPersonagem(idPersonagem, idItem);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/amuleto")
    public ResponseEntity<ItemMagico> buscarAmuleto(@PathVariable int id) {
        return ResponseEntity.ok(personagemService.buscarAmuleto(id));
    }


}
