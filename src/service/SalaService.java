package service;

import java.util.ArrayList;
import java.util.List;

import models.SalaModel;

public class SalaService {
    private List<SalaModel> salas = new ArrayList<>();

    public void adicionarSalaDeReuniao(String nome, int capacidade, boolean projetorDisponivel){
        SalaModel sala = new SalaModel(nome, capacidade, projetorDisponivel);
        salas.add(sala);
        System.out.println("Sala adicionada com sucesso!");
    }

    public void listarSalas(){
        if(salas.isEmpty()){
            System.out.println("Nenhuma sala foi adicionada!");
            return;
        }
        
        for(SalaModel sala : salas){
            System.out.println(sala);
        }
    }

    public SalaModel buscarPorId(Long id){
        for(SalaModel sala : salas){
            if(sala.getId().equals(id)){
                return sala;
            }
        }
        return null;
    }

    public void removerPorId(Long id){
        salas.removeIf(sala -> sala.getId().equals(id));
    }

    public void validarCapacidadeSala(Long id, int quantidadePessoas){
        SalaModel sala = buscarPorId(id);

        if(sala == null){
            throw new IllegalArgumentException("Sala não encontrada!");
        }

        if(quantidadePessoas > sala.getCapacidade()){
            throw new IllegalArgumentException("Quantidade de pessoas a cima da permitida!");
        }
    }

}
