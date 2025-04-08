package com.edu.EduAguiar.Repository;
import com.edu.EduAguiar.Model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Integer>{
    
}
