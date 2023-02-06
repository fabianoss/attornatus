package br.com.attornatus.controller;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "API de estudo attornatus")
@RestController
@RequestMapping(value="/v1/hello-world")
public class AttornatusController {

    @GetMapping
    public ResponseEntity<?> helloWorld(){
       return ResponseEntity.ok("hello-world");
    }
}
