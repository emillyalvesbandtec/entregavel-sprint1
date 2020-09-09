package br.com.bandtec.demo.models;

public class Pivo extends Jogador {

    private Integer rebote;
    private Integer perdaPosseBola;
    private Integer toco;
    private Integer faltas;

    public Pivo(String nome, String apelido, Double altura, Double salario, Integer rebote, Integer perdaPosseBola, Integer toco, Integer faltas) {
        super(nome, apelido, altura, salario);
        this.rebote = rebote;
        this.perdaPosseBola = perdaPosseBola;
        this.toco = toco;
        this.faltas = faltas;
    }

    @Override
    public Double calculaRendimento() {
        Double total = 0.0;
        total = ((toco / faltas) * 100.0) + ((rebote / perdaPosseBola) * 100.0);
        return total;
    }

    public Double calcBonus() {
        if(calculaRendimento() > 90.0){
            setSalario(getSalario() * 1.3);

        }else if(calculaRendimento() > 70.0){
            setSalario(getSalario() * 1.25);

        }else if(calculaRendimento() > 50.0){
            setSalario(getSalario() * 1.15);
        }
        return getSalario();
    }

    public Double getRendimento(){
        return calculaRendimento();
    }

    public Double getBonus(){
        return calcBonus();
    }

    public Integer getRebote() {
        return rebote;
    }

    public Integer getPerdaPosseBola() {
        return perdaPosseBola;
    }

    public Integer getToco() {
        return toco;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setRebote(Integer rebote) {
        this.rebote = rebote;
    }

    public void setPerdaPosseBola(Integer perdaPosseBola) {
        this.perdaPosseBola = perdaPosseBola;
    }

    public void setToco(Integer toco) {
        this.toco = toco;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    @Override
    public String toString() {
        return "Pivo{" +
                "\nrebote=" + rebote +
                "\n, perdaPosseBola=" + perdaPosseBola +
                "\n, toco=" + toco +
                "\n, faltas=" + faltas +
                "\n, rendimento=" + getRendimento() +
                "\n, bonus=" + getBonus() +
                '}';
    }
}
