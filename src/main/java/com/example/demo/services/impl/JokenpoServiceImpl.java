package com.example.demo.services.impl;

import com.example.demo.model.MoveEnum;
import com.example.demo.services.JokenpoService;
import com.example.model.JogadaDTO;
import com.example.model.ResultadoDTO;
import org.springframework.stereotype.Service;

@Service
public class JokenpoServiceImpl implements JokenpoService {
    @Override
    public ResultadoDTO playGame(JogadaDTO jogadaDTO) {
        try {

            JogadaDTO.JogadaOpcaoEnum jogadaUsuario = JogadaDTO.JogadaOpcaoEnum.valueOf(
                    jogadaDTO.getJogadaOpcao().name().toUpperCase());


            JogadaDTO.JogadaOpcaoEnum jogadaComputador = JogadaDTO.JogadaOpcaoEnum.valueOf(
                    MoveEnum.getRandom().name());


            ResultadoDTO resultadoDTO = new ResultadoDTO();
            resultadoDTO.setJogadaUsuario(jogadaUsuario.getValue());
            resultadoDTO.setJogadaComputador(jogadaComputador.getValue());
            resultadoDTO.setResultado(this.validarResult(jogadaUsuario, jogadaComputador));

            return resultadoDTO;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Jogada inválida! Use PEDRA, PAPEL ou TESOURA.");
        }
    }


    private String validarResult(JogadaDTO.JogadaOpcaoEnum usuario, JogadaDTO.JogadaOpcaoEnum computador) {
        if (usuario == computador) return "EMPATE";

        switch (usuario) {
            case PEDRA: return (computador == JogadaDTO.JogadaOpcaoEnum.TESOURA) ? "VENCEU" : "PERDEU";
            case PAPEL: return (computador == JogadaDTO.JogadaOpcaoEnum.PEDRA) ? "VENCEU" : "PERDEU";
            case TESOURA: return (computador == JogadaDTO.JogadaOpcaoEnum.PAPEL) ? "VENCEU" : "PERDEU";
            default: return "ERRO";
        }
    }



}
