package br.com.attornatus.controller;

import br.com.attornatus.dto.PessoaDTO;
import br.com.attornatus.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping(value="/v1/endereco")
public class EnderecoController {


    @Autowired
    private PessoaService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<PessoaDTO>> findAll(){
        List<PessoaDTO> dtos = service.findAll();
        if(dtos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(dtos);
        }
    }

    @GetMapping(value = "/{idPessoa}")
    @ResponseBody
    public ResponseEntity<List<PessoaDTO>> findByIdPessoa(@PathVariable Long idPessoa){
        List<PessoaDTO> dtos = service.findAll();
        if(dtos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(dtos);
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaDTO pessoa){
        PessoaDTO saved = service.create(pessoa);
        if(saved == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(saved);
    }

    @PutMapping(value = "/{idPessoa}")
    @ResponseBody
    public ResponseEntity<Void> update(@PathVariable Long idPessoa,@RequestBody @Valid PessoaDTO pessoa){
        service.update(idPessoa,pessoa);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(value = "/{idPessoa}")
    @ResponseBody
    public ResponseEntity<Void> delete(@PathVariable Long idPessoa){
        service.delete(idPessoa);
        return ResponseEntity.ok().build();
    }

}
