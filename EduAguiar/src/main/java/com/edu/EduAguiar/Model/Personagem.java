package com.edu.EduAguiar.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String Nome;
    private String Nome_Aventureiro;
    private String Classe;
    private int Level;
    private List<String> Itens_Mágicos;
    private int Forca;
    private int Defesa;

    public int getDefesa() {
        return Defesa;
    }

    public void setDefesa(int defesa) {
        Defesa = defesa;
    }

    public int getForca() {
        return Forca;
    }

    public void setForca(int forca) {
        Forca = forca;
    }

    public List<String> getItens_Mágicos() {
        return Itens_Mágicos;
    }

    public void setItens_Mágicos(List<String> itens_Mágicos) {
        Itens_Mágicos = itens_Mágicos;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public String getClasse() {
        return Classe;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }

    public String getNome_Aventureiro() {
        return Nome_Aventureiro;
    }

    public void setNome_Aventureiro(String nome_Aventureiro) {
        Nome_Aventureiro = nome_Aventureiro;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

}


