package br.com.bandtec.demo.models;

public class Armador extends Jogador{

    private Integer assistencia;
    private Integer qtdPasses;
    private Integer qtdChutes3;
    private Integer qtdAcertos3;

    public Armador(String nome, String apelido, Double altura, Double salario, Integer assistencia, Integer qtdPasses, Integer qtdChutes3, Integer qtdAcertos3) {
        super(nome, apelido, altura, salario);
        this.assistencia = assistencia;
        this.qtdPasses = qtdPasses;
        this.qtdChutes3 = qtdChutes3;
        this.qtdAcertos3 = qtdAcertos3;
    }

    @Override
    public Double calculaRendimento() {
        Double total = 0.0;
        total = ((assistencia / qtdPasses) * 100.0) + ((qtdAcertos3 / qtdAcertos3) * 100.0);
         return total / 2;
    }

    public Double calcBonus() {
        if(calculaRendimento() > 90.0){
            setSalario(getSalario() * 1.25);

        }else if(calculaRendimento() > 70.0){
            setSalario(getSalario() * 1.20);

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

    public Integer getAssistencia() {
        return assistencia;
    }

    public Integer getQtdPasses() {
        return qtdPasses;
    }

    public Integer getQtdChutes3() {
        return qtdChutes3;
    }

    public Integer getQtdAcertos3() {
        return qtdAcertos3;
    }

    public void setAssistencia(Integer assistencia) {
        this.assistencia = assistencia;
    }

    public void setQtdPasses(Integer qtdPasses) {
        this.qtdPasses = qtdPasses;
    }

    public void setQtdChutes3(Integer qtdChutes3) {
        this.qtdChutes3 = qtdChutes3;
    }

    public void setQtdAcertos3(Integer qtdAcertos3) {
        this.qtdAcertos3 = qtdAcertos3;
    }

    @Override
    public String toString() {
        return "Armador{" +
                "assistencia=" + assistencia +
                ", qtdPasses=" + qtdPasses +
                ", qtdChutes3=" + qtdChutes3 +
                ", qtdAcertos3=" + qtdAcertos3 +
                ", rendimento=" + calculaRendimento() +
                ", bonus=" + calcBonus() +
                '}';
    }
}
