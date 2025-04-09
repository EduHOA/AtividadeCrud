package com.edu.EduAguiar.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.EduAguiar.Model.ItemMagico;
import com.edu.EduAguiar.Repository.Item_MagicoRepository;

@Service
public class ItemMagicoService {
    
     @Autowired
    private Item_MagicoRepository itemMagicoRepository;

    public ItemMagico insertItem(ItemMagico itemMagico){
        return itemMagicoRepository.save(itemMagico);
    }

    public List<ItemMagico> selectAllItem(){
        return itemMagicoRepository.findAll();
    }

    // select * from orcamento where "id"=id
    public ItemMagico selectItemById(int id){
        Optional<ItemMagico> oc = itemMagicoRepository.findById(id);
        if(oc.isPresent()){
            return oc.get();
        }else{
            throw new RuntimeException("Personagem nao encotrado.");
        }
    }

    public void deletarItem(int id){
        itemMagicoRepository.deleteById(id);
    }
}
