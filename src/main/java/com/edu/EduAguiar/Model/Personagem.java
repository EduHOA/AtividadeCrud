package com.edu.EduAguiar.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String nome_aventureiro;
    private String classe;
    private int level;
    private int defesa;
    private int forca;
    private String itens_magicos;
}
