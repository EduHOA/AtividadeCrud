package com.edu.EduAguiar.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
public class ItemMagico {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        private String nome;
        private int forca;
        private int defesa;

    @ManyToOne
    @JoinColumn(name = "personagem_id")
    @JsonBackReference
    private Personagem personagem;

    public enum TipoItem { Arma, Armadura, Amuleto }

    @Enumerated(EnumType.STRING)
    private TipoItem tipo_item;

    @PrePersist
    @PreUpdate
    private void validarRegras() {

        if (forca < 0 || forca > 10) {
            throw new IllegalArgumentException("Força deve estar entre 0 e 10.");
        }
        if (defesa < 0 || defesa > 10) {
            throw new IllegalArgumentException("Defesa deve estar entre 0 e 10.");
        }

        if (forca == 0 && defesa == 0) {
            throw new IllegalArgumentException("Item não pode ter força e defesa zeradas.");
        }


        if (tipo_item == TipoItem.Arma && defesa != 0) {
            throw new IllegalArgumentException("Armas devem ter defesa igual a zero.");
        }

        if (tipo_item == TipoItem.Armadura && forca != 0) {
            throw new IllegalArgumentException("Armaduras devem ter força igual a zero.");
        }
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoItem getTipo_item() {
        return tipo_item;
    }

    public void setTipo_item(TipoItem tipo_item) {
        this.tipo_item = tipo_item;
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

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }




}

