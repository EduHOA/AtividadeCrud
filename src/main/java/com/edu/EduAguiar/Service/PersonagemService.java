package com.edu.EduAguiar.Service;

import com.edu.EduAguiar.Repository.Item_MagicoRepository;
import com.edu.EduAguiar.Model.Personagem;
import com.edu.EduAguiar.Repository.PersonagemRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.EduAguiar.Model.ItemMagico;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private Item_MagicoRepository itemMagicoRepository;

    public Personagem insertPersonagem(Personagem personagem){
        int soma = personagem.getDefesa() + personagem.getForca();
        if(soma >10) {
            throw new RuntimeException("A soma de Força e Defesa não pode ser maior que 10.");
        }

        long quantidadeAmuletos = personagem.getItens_magicos().stream()
                .filter(item -> item.getTipo_item() == ItemMagico.TipoItem.Amuleto)
                .count();

        if (quantidadeAmuletos > 1) {
            throw new RuntimeException("O personagem só pode ter 1 amuleto.");
        }

        return personagemRepository.save(personagem);
    }

    public List<Personagem> selectAllPersonagem(){
        return personagemRepository.findAll();
    }

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
            personagemExistente.setNome_aventureiro(personagem.getNome()); //
            return personagemRepository.save(personagemExistente);
        } else {
            throw new RuntimeException("Personagem não encontrado com ID: " + id);
        }
    }

    @Transactional
    public void adicionarItemMagico(int idPersonagem, int idItemMagico) {
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new EntityNotFoundException("Personagem não encontrado"));

        ItemMagico item = itemMagicoRepository.findById(idItemMagico)
                .orElseThrow(() -> new EntityNotFoundException("Item mágico não encontrado"));

        // Verifica se o item já está associado ao personagem
        if (personagem.getItens_magicos().contains(item)) {
            throw new IllegalArgumentException("Item mágico já está associado ao personagem");
        }

        // Regras do RPG
        if (item.getForca() == 0 && item.getDefesa() == 0) {
            throw new IllegalArgumentException("Item não pode ter força e defesa zeradas");
        }

        if (item.getForca() > 10 || item.getDefesa() > 10) {
            throw new IllegalArgumentException("Item não pode ter mais de 10 pontos em força ou defesa");
        }

        if (item.getTipo_item() == ItemMagico.TipoItem.Amuleto) {
            boolean jaTemAmuleto = personagem.getItens_magicos().stream()
                    .anyMatch(i -> i.getTipo_item() == ItemMagico.TipoItem.Amuleto);
            if (jaTemAmuleto) {
                throw new IllegalArgumentException("Personagem já possui um amuleto");
            }
        }

        if (item.getTipo_item() == ItemMagico.TipoItem.Arma && item.getDefesa() > 0) {
            throw new IllegalArgumentException("Armas não podem ter defesa");
        }

        if (item.getTipo_item() == ItemMagico.TipoItem.Armadura && item.getForca() > 0) {
            throw new IllegalArgumentException("Armaduras não podem ter força");
        }

        personagem.getItens_magicos().add(item);
        personagemRepository.save(personagem);
    }

    public List<ItemMagico> listarItensPorPersonagem(int idPersonagem) {
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new EntityNotFoundException("Personagem não encontrado"));
        return personagem.getItens_magicos(); // certifique-se de que não é null
    }

    public void removerItemDoPersonagem(int idPersonagem, int idItem) {
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new EntityNotFoundException("Personagem não encontrado"));

        ItemMagico item = itemMagicoRepository.findById(idItem)
                .orElseThrow(() -> new EntityNotFoundException("Item mágico não encontrado"));

        personagem.getItens_magicos().remove(item);
        personagemRepository.save(personagem);
    }

    public ItemMagico buscarAmuleto(int idPersonagem) {
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new EntityNotFoundException("Personagem não encontrado"));

        return personagem.getItens_magicos().stream()
                .filter(item -> item.getTipo_item() == ItemMagico.TipoItem.Amuleto)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Amuleto não encontrado para este personagem"));
    }

}


