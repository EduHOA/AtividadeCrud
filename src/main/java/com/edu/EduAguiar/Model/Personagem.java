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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_aventureiro() {
        return nome_aventureiro;
    }

    public void setNome_aventureiro(String nome_aventureiro) {
        this.nome_aventureiro = nome_aventureiro;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public String getItens_magicos() {
        return itens_magicos;
    }

    public void setItens_magicos(String itens_magicos) {
        this.itens_magicos = itens_magicos;
    }
}
