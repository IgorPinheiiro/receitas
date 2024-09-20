package br.igorpinheiro.receitas.Controller;

import br.igorpinheiro.Service.ReceitaService;
import br.igorpinheiro.receitas.Model.Receita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping
    public List<Receita> getAllReceitas(@RequestParam(required = false) String ingredientes) {
        if (ingredientes != null) {
            return receitaService.getReceitasByIngrediente(ingredientes);
        }
        return receitaService.getAllReceitas();
    }
    @GetMapping("/{id}")
    public Receita getReceitaById(@PathVariable Long id) {
        return receitaService.getReceitaById(id);
    }

    @PostMapping
    public ResponseEntity<Receita> addReceita(@RequestBody Receita receita) {
        receitaService.addReceita(receita);
        return new ResponseEntity<>(receita, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceita(@PathVariable Long id) {
        boolean isRemoved = receitaService.deleteReceita(id);
        if (isRemoved) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
