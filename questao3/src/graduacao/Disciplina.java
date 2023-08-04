package graduacao;
public class Disciplina {
    private static int codi = 1;
    private int max, ref, ref2, cod;
    private Aluno[] aluno;
    private Professor[] professor;
    private Professor profMinistrante;
    private String curso;

    Disciplina(){}


    Disciplina (String curso, int max){
        this.cod = codi++;
        this.max = max;
        this.aluno = new Aluno[max];
        this.professor = new Professor[10];
        this.curso = curso;
        this.ref = 0;
        this.ref2 = 0;
    }

    public void setProfMinistrante(Professor profMinistrante) {
        profMinistrante = new Professor();
        this.profMinistrante = profMinistrante;
    }

    Aluno adicionarAluno(String nome){
        Aluno a;
        if(this.ref == this.max){
            System.out.println("O número máximo de alunos ja foi atingido!");
            a = null;
        }else{
            
            a = new Aluno(nome, curso);
            aluno[this.ref]= a;
            this.ref++;
            System.out.println("Aluno adicionado com sucesso!");
        }
        
        return a;
    }

    public void removerAluno(String matricula){
        int i;
        for(i=0; i<aluno.length; i++){
            if(aluno[i] != null && aluno[i].getMatricula().equals(matricula)){
                aluno[i] = null;
                organizarArrayAluno();
                System.out.println("Aluno removido com sucesso!");
                ref--;
                break;
            }
            if(i == aluno.length-1){
                System.out.println("Matricula não encontrada!");
                break; 
            }
        }
       
    }

    public Professor adicionarProfessor(String nome, int senha){
       if(this.ref2==10){
            System.out.println("Limite maximo de professores alcançado");
            return null;
       }
       
        professor[ref2] = new Professor(nome, curso, senha);
        this.ref2++;
        System.out.println("Professor adicionado com sucesso!");
        return professor[ref2--];
    }

    public void removerProfessor(String nome){
        
        
        for(int i=0; i<professor.length; i++){
            if(nome.equals(professor[i].getNome())){
                this.professor[i] = null;
                organizarArrayProfessor();
                System.out.println("Professor removido com sucesso!");
                this.ref2--;
                break;
            }
            if(i==professor.length-1){
                System.out.println("Professor não encontrado");
            }
        }
        
    }

    private void organizarArrayAluno(){
        int aux = 0;
        for (int i = 0; i<aluno.length; i++){
            if(aluno[i] != null){
                aluno[aux] = aluno[i];
                aux++;
            }
        }
        for(int i=aux;i<aluno.length;i++){
            aluno[i] = null;
        }
    }
     private void organizarArrayProfessor(){
        int aux = 0;
        for (int i = 0; i<professor.length; i++){
            if(professor[i] != null){
                professor[aux] = professor[i];
                aux++;
            }
        }
        for(int i=aux;i<professor.length;i++){
            professor[i] = null;
        }
    }

    public int getCod(){
        return cod;
    }

    public String getCurso(){
        return curso;
    }

    public Professor findProfessor(String nome){
        for(int i=0; i<professor.length; i++){
            if(nome.equals(professor[i].getNome())){
                return professor[i];
            }
            if(i==professor.length-1){
                System.out.println("Professor não encontrado");
            }
        }
        return null;
    }

    public Aluno findAluno(String matricula){
        for(int i=0; i<aluno.length; i++){
            if(matricula.equals(aluno[i].getNome())){
                return aluno[i];
            }
            if(i==aluno.length-1){
                return null;
            }
        }
        return null;
    }
    
    public Professor getProfMinistrante() {
        return profMinistrante;
    }

    public void printInformações(){
        int i;
        System.out.println("Código da disciplina: " + cod);

        if(profMinistrante != null){
            System.out.println("Professor minisrante: " + profMinistrante.getNome());
        }
        System.out.println("Professor(s): ");
        for(i=0; i<professor.length; i++){
            System.out.println(" - " + professor[i].getNome());
        }
        System.out.println("Aluno(s): ");
        for(i=0; i<aluno.length; i++){
            System.out.println(" - " + aluno[i].getNome());
        }

    }


}





