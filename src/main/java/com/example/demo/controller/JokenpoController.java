package com.example.demo.controller;

import com.example.api.PlayApi;
import com.example.demo.services.JokenpoService;
import com.example.model.JogadaDTO;
import com.example.model.ResultadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokenpoController implements PlayApi {
    @Autowired
    JokenpoService jokenpoService;

    @Override
    public ResponseEntity<ResultadoDTO> playGame(JogadaDTO jogadaDTO) {

        ResultadoDTO resultado = jokenpoService.playGame(jogadaDTO);
        return ResponseEntity.ok(resultado);
    }
}
