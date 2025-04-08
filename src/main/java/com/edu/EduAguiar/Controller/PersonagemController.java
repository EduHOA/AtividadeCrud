package com.edu.EduAguiar.Controller;

package com.edu.EduAguiar.Services.PersonagemService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @PostMapping
    public Orcamento criarOrcamento(@RequestBody Orcamento orcamento){
        return personagemService.insertOrcamento(orcamento);
    }

    @GetMapping
    public List<Orcamento> listarOrcamento(){
        return personagemService.selectAllOrcamento();
    }

    @PutMapping("/{id}/aprovar")
    public Orcamento aprovarOrcamento(@PathVariable int id){
        return personagemService.aprovarOrcamento(id);
    }

    @GetMapping("/{id}")
    public Orcamento buscarById(@PathVariable int id){
        return personagemService.selectOrcamentoById(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        personagemService.deletarOrcamento(id);
    }

}
