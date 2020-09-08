package br.com.bandtec.demo.models;

public abstract class Jogador {

    private String nome;
    private String apelido;
    private Double altura;
    private Double salario;

    public Jogador(String nome, String apelido, Double altura, Double salario) {
        this.nome = nome;
        this.apelido = apelido;
        this.altura = altura;
        this.salario = salario;
    }

    public abstract Double calculaRendimento();
    public abstract Double calcBonus();

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public Double getAltura() {
        return altura;
    }

    public Double getSalario() {
        return salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", altura=" + altura +
                ", salario=" + salario +
                '}';
    }
}
