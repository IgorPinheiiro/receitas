package br.igorpinheiro.Service;

import org.springframework.stereotype.Service;

import br.igorpinheiro.receitas.Model.Receita;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceitaService {
    private List<Receita> receitas = new ArrayList<>(); // Aqui você pode usar um banco de dados

    public List<Receita> getAllReceitas() {
        return receitas;
    }

    public List<Receita> getReceitasByIngrediente(String ingrediente) {
        return receitas.stream()
                       .filter(receita -> receita.getIngredientes().contains(ingrediente))
                       .collect(Collectors.toList());
    }

    public Receita getReceitaById(Long id) {
        return receitas.stream()
                       .filter(receita -> receita.getId().equals(id))
                       .findFirst()
                       .orElse(null);
    }

    public void addReceita(Receita receita) {
        receitas.add(receita);
    }

    public boolean deleteReceita(Long id) {
        return receitas.removeIf(receita -> receita.getId().equals(id));
    }
}
