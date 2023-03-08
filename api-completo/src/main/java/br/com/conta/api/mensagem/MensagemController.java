package br.com.conta.api.mensagem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    public final static MensagemService mensagemService = MensagemService.getInstance();


    @GetMapping
    public String getMensagem() {
        return "Mensagem";
    }

    @PostMapping("/texto")
    public MensagemTexto createMensagemTexto(@PathVariable String userId, String receiverId, String data, String texto ) {
        return mensagemService.createTextMessage(userId, receiverId, data, texto);
    }
    
    @PostMapping("/arquivo")
    public MensagemArquivo creareMensagemArquivo(@PathVariable String userId, String receiverId, String data, String nomeArquivo, String linkArquivo ) {
        return mensagemService.createArquivoMessage(userId, receiverId, data, nomeArquivo, linkArquivo );
    }

    @GetMapping("/texto/{msgId}")
    public MensagemTexto getMensagemTexto(@PathVariable String msgId) {
        return mensagemService.getMensagensTexto(msgId);
    }

    @GetMapping("/arquivo/{msgId}")
    public MensagemArquivo getMensagemArquivo(@PathVariable String msgId) {
        return mensagemService.getMensagensArquivo(msgId);
    }

    @GetMapping("/texto")
    public List<MensagemTexto> getMensagensTexto() {
        return mensagemService.getMensagensTexto();
    }

    @GetMapping("/arquivo")
    public List<MensagemArquivo> getMensagensArquivo() {
        return mensagemService.getMensagensArquivo();
    }
    
}
