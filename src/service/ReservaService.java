package service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import models.ReservaModel;
import models.SalaModel;

public class ReservaService {
    private List<ReservaModel> reserva = new ArrayList<>();
    private SalaService salaService;

    public ReservaService(SalaService salaService) {
        this.salaService = salaService;
    }

    public boolean verificarConflitoReserva(ReservaModel novaReserva) {
        for (ReservaModel reservaExistente : reserva) {
            if (reservaExistente.getInicioReuniao().equals(novaReserva.getInicioReuniao())) {
                return true;
            }
        }
        return false;
    }

    public void fazerReserva(Long salaId, String nomeResponsavel, int quantidadePessoas, LocalDateTime inicioReuniao, LocalDateTime fimReuniao) {
        salaService.validarCapacidadeSala(salaId, quantidadePessoas);

        SalaModel sala = salaService.buscarPorId(salaId);

        ReservaModel reservaModel = new ReservaModel(
                                        nomeResponsavel, 
                                        sala, 
                                        inicioReuniao, 
                                        fimReuniao
                                        );

        if (verificarConflitoReserva(reservaModel)) {
            throw new IllegalArgumentException("Conflito de reserva!");
        }

        reserva.add(reservaModel);
        System.out.println("Reserva feita com sucesso!");
    }

    public void listarReservasPorId(Long salaId){
        SalaModel sala = salaService.buscarPorId(salaId);
        
        if(sala == null){
            throw new IllegalArgumentException("Sala não encontrada!");
        }

        boolean encontrouReservas = false;
        for(ReservaModel reserva : reserva){
            if(reserva.getSala().getId().equals(salaId)){
                System.out.println("ID: " + reserva.getId() +
                                   ", Responsável: " + reserva.getNomeResponsavel() +
                                   ", Início: " + reserva.getInicioReuniao() +
                                   ", Fim: " + reserva.getFimReuniao());
                encontrouReservas = true;
            }
        }

        if (!encontrouReservas) {
            System.out.println("Nenhuma reserva encontrada para esta sala.");
        }
    }

    public void cancelarReserva(int id){
        reserva.removeIf(reserva -> reserva.getId() == id);
    }

    public List<ReservaModel> listarReservas() {
        return reserva;
    }

    public void buscarPorNomeResponsavel(String nomeResposavel){
        boolean encontrou = false;
        for(ReservaModel reserva : reserva){
            if(reserva.getNomeResponsavel().equalsIgnoreCase(nomeResposavel)){
                System.out.println("ID: " + reserva.getId() +
                                   ", Sala: " + reserva.getSala().getNome() +
                                   ", Início: " + reserva.getInicioReuniao() +
                                   ", Fim: " + reserva.getFimReuniao());
                encontrou = true;
            }
        }
        if(!encontrou){
            System.out.println("Nenhuma reserva encontrada para o responsável: " + nomeResposavel);
        }
    }

}
