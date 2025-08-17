import java.time.LocalDateTime;

import service.ReservaService;
import service.SalaService;

public class App {
    public static void main(String[] args) throws Exception {
        
        SalaService salaService = new SalaService();
        ReservaService reservaService = new ReservaService(salaService);

        // Adicionando salas
        salaService.adicionarSalaDeReuniao("Sala A", 10, true);
        salaService.adicionarSalaDeReuniao("Sala B", 20, false);

        // Listando salas
        salaService.listarSalas();

        // Reservando uma sala
        reservaService.fazerReserva(1L, "João", 5, LocalDateTime.now(), LocalDateTime.now().plusHours(2));

        // Listando reservas por ID da sala
        reservaService.listarReservasPorId(1L);

        // Cancelando uma reserva
        reservaService.cancelarReserva(1);

        // Buscando reservas por nome do responsável
        reservaService.buscarPorNomeResponsavel("João");

        // Listando salas por capacidade
        salaService.listarSalasPorCapacidade();









    }
}
