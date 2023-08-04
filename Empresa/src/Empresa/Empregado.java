package Empresa;
public class Empregado {
    private String nome;
    private Double salario;
    private int ano;

    public String getNome() {
        return nome;
    }
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
    public int getAno() {
        return ano;
    }
    public void PrintDados (Empregado empregado){
        System.out.println("Nome: " + empregado.nome + "\nSalario: " + empregado.salario + "\nAno de contratação: " + empregado.ano);
    }
}
