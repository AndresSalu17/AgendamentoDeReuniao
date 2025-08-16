package models;

public class SalaModel{
    
    private static long contadorId = 1;

    private Long id;
    private String nome;
    private int capacidade;
    private boolean projetorDisponivel;

    public SalaModel(){}

    public SalaModel(String nome, int capacidade, boolean projetorDisponivel){
        this.id = contadorId++;
        this.nome = nome;
        this.capacidade = capacidade;
        this.projetorDisponivel = projetorDisponivel;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        if(capacidade < 0){
            throw new IllegalArgumentException("O número de pessoas deve ser maior que 0!");
        }

        this.capacidade = capacidade;
    }

    public boolean isProjetorDisponivel() {
        return projetorDisponivel;
    }
    public void setProjetorDisponivel(boolean projetorDisponivel) {
        this.projetorDisponivel = projetorDisponivel;
    }

    @Override
    public String toString(){
        return "ID: " + id +
            ", Nome: " + nome +
            ", Capacidade " + capacidade +
            ", Projetor Disponível: " + (projetorDisponivel ? "Sim" : "Não");
    }
}
