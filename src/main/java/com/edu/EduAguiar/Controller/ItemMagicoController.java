package com.edu.EduAguiar.Controller;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.edu.EduAguiar.Model.ItemMagico;
import com.edu.EduAguiar.Services.ItemMagicoService;

import java.util.List;


@RestController
@RequestMapping("/item")
public class ItemMagicoController {

@Autowired
    private ItemMagicoService itemMagicoService;

    @PostMapping
    public ItemMagico criarPersonagem(@RequestBody ItemMagico itemMagico){
        return itemMagicoService.insertItem(itemMagico);
    }

    @GetMapping
    public List<ItemMagico> listarOrcamento(){
        return itemMagicoService.selectAllItem();
    }

    @GetMapping("/{id}")
    public ItemMagico buscarById(@PathVariable int id){
        return itemMagicoService.selectItemById(id);
    }

    @DeleteMapping("deletar/{id}")
    public void deletar(@PathVariable int id){
        itemMagicoService.deletarItem(id);
    }
    
}
