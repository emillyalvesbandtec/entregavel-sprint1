package br.com.bandtec.demo.contollers;

import br.com.bandtec.demo.models.*;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class ClubeController {

    private String nome;
    private List<Armador> listaArmadores = new ArrayList<>();
    private List<Pivo> listaPivos = new ArrayList<>();
    private List<Ala> listaAlas = new ArrayList<>();

    @PostMapping("/pivo/cadastrar")
    public ResponseEntity cadastrarPivo(@RequestBody Pivo p) {
        listaPivos.add(p);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/armador/cadastrar")
    public ResponseEntity cadastrarArmador(@RequestBody Armador a) {
        listaArmadores.add(a);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/ala/cadastrar")
    public ResponseEntity cadastrarAla(@RequestBody Ala ala) {
        listaAlas.add(ala);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/pivos/visualizar")
    public ResponseEntity exibePivos() {
        if (listaPivos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(listaPivos);
        }
    }

    @GetMapping("/armadores/visualizar")
    public ResponseEntity exibeArmadores() {
        if (listaArmadores.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(listaArmadores);
        }
    }

    @GetMapping("/ala/visualizar")
    public ResponseEntity exibeAlas() {
        if (listaAlas.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(listaAlas);
        }
    }

    @GetMapping("/pivo/{id}")
    public ResponseEntity recuperarPivo(@PathVariable int id) {
        if (listaPivos.size() >= id) {
            return ResponseEntity.ok().body(listaPivos.get(id - 1));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/armador/{id}")
    public ResponseEntity recuperarArmador(@PathVariable int id) {
        if (listaArmadores.size() >= id) {
            return ResponseEntity.ok().body(listaArmadores.get(id - 1));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/ala/{id}")
    public ResponseEntity recuperarAla(@PathVariable int id) {
        if (listaAlas.size() >= id) {
            return ResponseEntity.ok().body(listaAlas.get(id - 1));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/pivo/{id}")
    public ResponseEntity excluirPivo(@PathVariable int id) {
        if (listaPivos.size() >= id) {
            listaPivos.remove(id - 1);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/armador/{id}")
    public ResponseEntity excluirArmador(@PathVariable int id) {
        if (listaArmadores.size() >= id) {
            listaArmadores.remove(id - 1);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/ala/{id}")
    public ResponseEntity excluirAla(@PathVariable int id) {
        if (listaAlas.size() >= id) {
            listaAlas.remove(id - 1);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/pivo/{id}")
    public ResponseEntity atualizarDadosPivo(@PathVariable int id, @RequestBody Pivo p) {
        if (listaPivos.size() >= id) {
            listaPivos.set(id - 1, p);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/armador/{id}")
    public ResponseEntity atualizarDadosArmador(@PathVariable int id, @RequestBody Armador a) {
        if (listaArmadores.size() >= id) {
            listaArmadores.set(id - 1, a);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/ala/{id}")
    public ResponseEntity atualizarDadosPivo(@PathVariable int id, @RequestBody Ala a) {
        if (listaAlas.size() >= id) {
            listaAlas.set(id - 1, a);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/pivo/bonus/{id}")
    public ResponseEntity exibeBonusPivo(@PathVariable int id) {
        if (listaPivos.size() >= id) {
            return ResponseEntity.ok(listaPivos.get(id - 1).getBonus());

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/armador/bonus/{id}")
    public ResponseEntity exibeBonusArmador(@PathVariable int id) {
        if (listaArmadores.size() >= id) {
            return ResponseEntity.ok(listaArmadores.get(id - 1).getBonus());

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/ala/bonus/{id}")
    public ResponseEntity exibeBonusAla(@PathVariable int id) {
        if (listaAlas.size() >= id) {
            return ResponseEntity.ok(listaAlas.get(id - 1).getBonus());

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/pivo/maior-rendimento")
    public ResponseEntity exibeMaiorRendimentoPivo(){
        Double maior = 0.0;
        for(Pivo p : listaPivos){
            if(p.calculaRendimento()>maior){
                maior = p.getRendimento();
            }
        }
        return ResponseEntity.ok(maior);
    }

    @GetMapping("/armador/maior-rendimento")
    public ResponseEntity exibeMaiorRendimentoArmador(){
        Double maior = 0.0;
        for(Armador a : listaArmadores){
            if(a.calculaRendimento()>maior){
                maior = a.getRendimento();
            }
        }
        return ResponseEntity.ok(maior);
    }

    @GetMapping("/ala/maior-rendimento")
    public ResponseEntity exibeMaiorRendimentoAla(){
        Double maior = 0.0;
        for(Ala ala : listaAlas){
            if(ala.calculaRendimento()>maior){
                maior = ala.getRendimento();
            }
        }
        return ResponseEntity.ok(maior);
    }

}
