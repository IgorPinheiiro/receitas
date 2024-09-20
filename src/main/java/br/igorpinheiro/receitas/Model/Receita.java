package br.igorpinheiro.receitas.Model;

import java.util.List;
import java.util.Objects;

public class Receita {
    private Long id;
    private String nome;
    private List<String> ingredientes;

    // Construtor padrão
    public Receita() {}

    public Receita(Long id, String nome, List<String> ingredientes) {
        this.id = id;
        this.nome = nome;
        this.ingredientes = ingredientes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receita receita = (Receita) o;
        return Objects.equals(id, receita.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
