package com.edu.EduAguiar.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ItemMagico {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        private String nome;
        private String tipo_item;
        private int forca;
        private int defesa;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTipo_item() {
            return tipo_item;
        }

        public void setTipo_item(String tipo_item) {
            this.tipo_item = tipo_item;
        }

        public int getForca() {
            return forca;
        }

        public void setForca(int forca) {
            this.forca = forca;
        }

        public int getDefesa() {
            return defesa;
        }

        public void setDefesa(int defesa) {
            this.defesa = defesa;
        }
    }

