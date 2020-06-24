package br.com.mastertech.ProducerConsPorta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorizaController {

    //@Autowired
    //private Autoriza autoriza;

    @Autowired
    private AutorizaProducer autorizaProducer;

    @PostMapping("/acesso/{nome}/{porta}")
    public void create(@PathVariable String nome, @PathVariable String porta) {
        Autoriza autoriza = new Autoriza(nome, porta);
        autoriza.setNome(nome);
        autoriza.setPorta(porta);

        autorizaProducer.enviarAoKafka(autoriza);
    }

}
