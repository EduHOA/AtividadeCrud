package com.edu.EduAguiar.Dto;
import com.edu.EduAguiar.Model.ItemMagico;
import java.util.List;

public class PersonagemDto {


    private String nome;
    private String nome_aventureiro;
    private String classe;
    private int level;
    private int forca_total;
    private int defesa_total;
    private List<ItemMagico> itens_magicos;

    public PersonagemDto(String nome, String nome_aventureiro, String classe, int level, int forca_total, int defesa_total, List<ItemMagico> itens_magicos) {
        this.nome = nome;
        this.nome_aventureiro = nome_aventureiro;
        this.classe = classe;
        this.level = level;
        this.forca_total = forca_total;
        this.defesa_total = defesa_total;
        this.itens_magicos = itens_magicos;
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

    public int getForca_total() {
        return forca_total;
    }

    public void setForca_total(int forca_total) {
        this.forca_total = forca_total;
    }

    public int getDefesa_total() {
        return defesa_total;
    }

    public void setDefesa_total(int defesa_total) {
        this.defesa_total = defesa_total;
    }

    public List<ItemMagico> getItens_magicos() {
        return itens_magicos;
    }

    public void setItens_magicos(List<ItemMagico> itens_magicos) {
        this.itens_magicos = itens_magicos;
    }
}
