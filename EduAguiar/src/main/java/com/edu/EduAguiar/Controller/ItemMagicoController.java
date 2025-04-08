package com.edu.EduAguiar.Controller;

import com.edu.EduAguiar.Model.ItemMagico;
import com.edu.EduAguiar.Model.Personagem;
import com.edu.EduAguiar.Service.PersonagemService;
import com.edu.EduAguiar.Service.itemMagicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemMagicoController {

    @Autowired
    private itemMagicoService itemService;

    @PostMapping
    public Personagem criarItemMagico(@RequestBody ItemMagico intem){
        return itemService.insertItem(item);
    }

    @GetMapping
    public List<Personagem> listarItemMagico(){
        return itemService.selectAllItem();
    }

    @GetMapping("/{id}")
    public Personagem buscarById(@PathVariable int id){
        return itemService.selectItemById(id);
    }

    @DeleteMapping("deletar/{id}")
    public void deletar(@PathVariable int id){
        itemService.deletarItem(id);
    }

}
