package graduacao;
import java.util.Calendar;
import java.util.Scanner;

public class Aluno {
    private static int numeroBase = 1000;
    private String matricula;
    private String nome;
    private String curso;
    
    static Scanner ler = new Scanner(System.in);

    Aluno(){}

    Aluno(String nome, String curso){
        this.nome = nome;
        this.curso = curso;
        setMatricula();
        
    }

    public void setMatricula(){
        
        int proximo =  numeroBase;
        String concatenado, semestre;
        Calendar calendar = Calendar.getInstance();
        int mes = calendar.get(Calendar.MONTH) + 1;
        int ano = calendar.get(Calendar.YEAR);
        if(mes<6){
            semestre = "A";
        }else{
            semestre = "B";
        }
        String sAno = Integer.toString(ano);
        String sProximo = Integer.toString(proximo);
        concatenado = sProximo + sAno + semestre;
        numeroBase++;
        this.matricula = concatenado;
    }
    
    public String getMatricula() {
        return matricula;
    }
    public String getNome() {
        return nome;
    }
    public String getCurso() {
        return curso;
    }

    public void printDados(){
        System.out.println("Nome: " + getNome());
        System.out.println("Curso: " + getCurso());
        System.out.println("Matricula: " + getMatricula());
    }

    

}
