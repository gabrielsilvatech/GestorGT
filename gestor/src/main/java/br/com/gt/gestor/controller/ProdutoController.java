package br.com.gt.gestor.controller;

import br.com.gt.gestor.model.produto.DadosCadastroProduto;
import br.com.gt.gestor.model.produto.DadosEditarProduto;
import br.com.gt.gestor.model.produto.Produto;
import br.com.gt.gestor.model.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/formulario")
    public String exibeFormularioCadastrarProduto(Long id, Model model) {
        if (id != null) {
            var produto = repository.getReferenceById(id);
            model.addAttribute("produto", produto);

        }
        return "produtos/formulario";
    }

    @GetMapping
    public String exibeListaProduto(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "produtos/lista";
    }

    @PostMapping
    @Transactional
    public String cadastrarProduto(DadosCadastroProduto dados) {
        var produto = new Produto(dados);
        repository.save(produto);
        return "redirect:/produtos";
    }

    @DeleteMapping
    @Transactional
    public String excluirProduto(Long id) {
        repository.deleteById(id);
        return "redirect:/produtos";
    }

    @PutMapping
    @Transactional
    public String editarProduto(DadosEditarProduto dados) {
        var produto = repository.getReferenceById(dados.id());
        produto.atualizaDados(dados);
        return "redirect:/produtos";
    }

}
