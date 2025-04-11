package com.edu.EduAguiar.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String nome_aventureiro;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemMagico> itens_magicos = new ArrayList<>();

    public enum classe {Guerreiro,Mago,Arqueiro,Ladino,Bardo }

    @Enumerated(EnumType.STRING)
    private Personagem.classe classe;


    private int level;
    private int defesa;
    private int forca;

    public int getForcaTotal() {
        return forca + (itens_magicos != null
                ? itens_magicos.stream().mapToInt(ItemMagico::getForca).sum()
                : 0);
    }

    public int getDefesaTotal() {
        return defesa + (itens_magicos != null
                ? itens_magicos.stream().mapToInt(ItemMagico::getDefesa).sum()
                : 0);
    }

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

    public Personagem.classe getClasse() {
        return classe;
    }

    public void setClasse(Personagem.classe classe) {
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

    public List<ItemMagico> getItens_magicos() {
        return itens_magicos;
    }

    public void setItens_magicos(List<ItemMagico> itens_magicos) {
        this.itens_magicos = itens_magicos;
    }
}
