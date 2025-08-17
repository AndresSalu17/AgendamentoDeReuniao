package models;

import java.time.LocalDateTime;

public class ReservaModel {
    
    private static int contadorId = 1;

    private int id;
    private String nomeResponsavel;
    private SalaModel sala;
    private LocalDateTime inicioReuniao;
    private LocalDateTime fimReuniao;

    public ReservaModel(){}

    public ReservaModel(String nomeResponsavel, SalaModel sala, LocalDateTime inicioReuniao, LocalDateTime fimReuniao){
        this.id = contadorId++;
        this.nomeResponsavel = nomeResponsavel;
        this.sala = sala;
        this.inicioReuniao = inicioReuniao;
        this.fimReuniao = fimReuniao;
    }

    public int getId() {
        return id;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public SalaModel getSala() {
        return sala;
    }

    public void setSala(SalaModel sala) {
        this.sala = sala;
    }

    public LocalDateTime getInicioReuniao() {
        return inicioReuniao;
    }

    public void setInicioReuniao(LocalDateTime inicioReuniao) {
        this.inicioReuniao = inicioReuniao;
    }

    public LocalDateTime getFimReuniao() {
        return fimReuniao;
    }

    public void setFimReuniao(LocalDateTime fimReuniao) {
        this.fimReuniao = fimReuniao;
    }
}
