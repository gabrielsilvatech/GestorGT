package br.com.gt.gestor.controller;

import br.com.gt.gestor.model.produto.DadosCadastroProduto;
import br.com.gt.gestor.model.produto.Produto;
import br.com.gt.gestor.model.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/formulario")
    public String exibeFormularioCadastrarProduto() {
        return "produtos/formulario";
    }

    @GetMapping
    public String exibeListaProduto(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "produtos/lista";
    }

    @PostMapping
    public String cadastrarProduto(DadosCadastroProduto dados) {
        var produto = new Produto(dados);
        repository.save(produto);
        return "redirect:/produtos";
    }

}
