package br.com.bandtec.demo.models;

public class Ala extends Jogador{

    private Integer qtdTentativasChute;
    private Integer qtdAcertos;

    public Ala(String nome, String apelido, Double altura, Double salario, Integer qtdTentativasChute, Integer qtdAcertos) {
        super(nome, apelido, altura, salario);
        this.qtdTentativasChute = qtdTentativasChute;
        this.qtdAcertos = qtdAcertos;
    }

    @Override
    public Double calculaRendimento() {
        return (qtdAcertos / qtdTentativasChute) * 100.0;
    }

    public Double calcBonus() {
        if(calculaRendimento() > 90.0){
            setSalario(getSalario() * 1.45);

        }else if(calculaRendimento() > 70.0){
            setSalario(getSalario() * 1.35);

        }else if(calculaRendimento() > 50.0){
            setSalario(getSalario() * 1.1);
        }
        return getSalario();
    }

    public Double getRendimento(){
        return calculaRendimento();
    }

    public Double getBonus(){
        return calcBonus();
    }

    public Integer getQtdTentativasChute() {
        return qtdTentativasChute;
    }

    public Integer getQtdAcertos() {
        return qtdAcertos;
    }

    public void setQtdTentativasChute(Integer qtdTentativasChute) {
        this.qtdTentativasChute = qtdTentativasChute;
    }

    public void setQtdAcertos(Integer qtdAcertos) {
        this.qtdAcertos = qtdAcertos;
    }

    @Override
    public String toString() {
        return "Ala{" +
                "qtdTentativasChute=" + qtdTentativasChute +
                ", qtdAcertos=" + qtdAcertos +
                ", rendimento=" + calculaRendimento() +
                ", bonus=" + calcBonus() +
                '}';
    }
}
