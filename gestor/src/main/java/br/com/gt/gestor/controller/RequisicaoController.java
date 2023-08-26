package br.com.gt.gestor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/requisicao")
public class RequisicaoController {

    @GetMapping
    public String criacaoRequisicao() {
        return "requisicao/compra";
    }

}
