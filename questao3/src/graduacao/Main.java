package graduacao;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int opcao=0, variavel=0, contDis=0, contProf=1,find=0, i=0;
        boolean verificado = false;
        String nome;

        Disciplina[] disciplina = new Disciplina[10];  
        Professor[] professor = new Professor[50];
        Aluno alunoAux = null;
        Professor professorAux = null;
        
        Scanner ler = new Scanner(System.in);
        professor[0] = new Professor("carlos", "fic", 123);

        while(opcao != 11){
            while(verificado==false){
                System.out.printf("Digite seu nome: ");
                nome = ler.nextLine();

                System.out.printf("Digite sua senha: ");
                variavel = ler.nextInt();

                for(i=0; i<professor.length; i++){
                    if(professor[find].autenticar(nome, variavel)){
                        System.out.println("Login efetuado com sucesso!");
                        verificado = true;
                        break;
                    }
                    if(find==professor.length-1){
                        System.out.println("Usuário ou senha incorreto!");
                        verificado = false;
                    }
                }
                
            }
            System.out.println("Digite a opção que deseja: ");
                System.out.println("__________________________________________\n1 - Adicionar disciplina\n2 - Adicionar professor\n3 - Adicionar Aluno\n4 - Remover professor\n5 - Remover aluno\n6 - Modificar/Adicionar professor ministrante\n7 - Imprir dados do aluno\n8 - Imprimir dados do professor\n9 - Imprimir dados da disciplina\n10 - fazer logof\n11 - finalizar programa.\n__________________________________________\n");
                opcao = ler.nextInt();
                ler.nextLine();
            if(opcao<1 || opcao>11){
                System.out.println("opção não existe, por favor tente novamente.");
            }

            while(opcao<1 || opcao>11){
                System.out.println("Digite a opção que deseja: ");
                System.out.println("__________________________________________\n1 - Adicionar disciplina\n2 - Adicionar professor\n3 - Adicionar Aluno\n4 - Remover professor\n5 - Remover aluno\n6 - Modificar/Adicionar professor ministrante\n7 - Imprir dados do aluno\n8 - Imprimir dados do professor\n9 - Imprimir dados da disciplina\n10 - fazer logof\n11 - finalizar programa.\n__________________________________________\n");
                opcao = ler.nextInt();
                ler.nextLine();
                if(opcao<1 || opcao>7){
                    System.out.println("\nopção não existe, por favor tente novamente.\n");
                }
            }

            switch(opcao){
            case 1:
            
                System.out.printf("\nDigite o nome da disciplina: ");
                nome = ler.nextLine();
                
                System.out.printf("\nDigite o número máximo de participantes: ");
                variavel = ler.nextInt();

                disciplina[contDis] = new Disciplina(nome, variavel);
                contDis++;
                break;

            case 2:
                find = getDisciplina(disciplina);
                
                if(find == -1){
                    System.out.println("\nDisciplina não encontrada!\n");
                }else{
                    System.out.printf("\nDigite o nome do(a) professor(a): ");
                    nome = ler.nextLine();
                        
                    System.out.printf("\nDigite a senha de login: ");
                    variavel = ler.nextInt();                    
                    professor[contProf] = disciplina[find].adicionarProfessor(nome, variavel);
                    contProf++;
                    break;
                    
                }

                break;
            case 3:
                find = getDisciplina(disciplina);
                System.out.printf("\nDigite o nome do aluno: ");
                nome = ler.nextLine();
                disciplina[find].adicionarAluno(nome);
                break;
            
            case 4:
                find = getDisciplina(disciplina);
                System.out.printf("\nDigite o nome do professor:");
                nome = ler.nextLine(); 
                disciplina[find].removerProfessor(nome);
               
                break;

            case 5: 
                find = getDisciplina(disciplina);
                System.out.printf("\nDigite a matricula do aluno: ");
                nome = ler.nextLine();
                disciplina[find].removerAluno(nome);
                break;
            case 6: 
                find = getDisciplina(disciplina);
                System.out.printf("\nDigite o nome do professor para encontrar ou adicionar: ");
                nome = ler.nextLine();
                for(i=0; i<professor.length; i++){
                    if(nome.equals(professor[i].getNome())){
                        disciplina[find].setProfMinistrante(professor[i]);
                        break;
                    }
                    if(i==professor.length-1){
                        System.out.printf("\nAdicione a senha para a nova conta criada: ");
                        variavel = ler.nextInt();
                        disciplina[find].setProfMinistrante(disciplina[find].adicionarProfessor(nome, variavel));
                        break; 
                    }
                }
                break;
            
            case 7:
                System.out.printf("\nDigite a matricula do aluno que deseja encontrar: ");
                nome = ler.nextLine();
                for (i=0; i<disciplina.length; i++){
                    alunoAux = disciplina[i].findAluno(nome);
                    if(alunoAux != null){
                        alunoAux.printDados();
                    }
                    if(i==disciplina.length-1){
                        System.out.printf("\nAluno não encontrado.\n");
                        
                    }
                }
                break;

            case 8: 
                System.out.printf("\nDigite o nome do professor: ");
                nome = ler.nextLine();
                variavel=-1;
                for (i=0; i<disciplina.length; i++){
                    professorAux = disciplina[i].findProfessor(nome);
                    if(disciplina[i].getProfMinistrante().getNome().equals(nome)){
                        variavel = i;
                    }
                    if(professorAux != null){
                        professorAux.printDados();
                    }
                }
                if(variavel!=-1){
                    System.out.printf("\nministra o curso de: " + disciplina[variavel].getCurso());
                }
            
            break;

            case 9:
                find = getDisciplina(disciplina);
                disciplina[i].printInformações();
                break;
            
            case 10:
                verificado=false;
                break;
            
            case 11:
                System.out.println("\n\nPrograma finalizado!\n\n");
                break;
            }
        }
        close(ler);
    }

    private static void close(Scanner ler) {
    }

    public static int getDisciplina(Disciplina[] disciplina){
        String nome;
        int i;
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Digite o nome da disciplina: ");
        nome = ler.nextLine();
        close(ler);
       

        for(i=0; i < disciplina.length; i++){
            if(nome.equals(disciplina[i].getCurso())){
                return i;
            }
            if(i == disciplina.length-1){
                System.out.println("Disciplina não encontrada!");
                return -1;
            }
        }
        return -1; 
    }
    
}
