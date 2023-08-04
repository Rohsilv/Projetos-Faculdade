package sistemabanco;
import java.util.Scanner;

public class Banco {
    //static int proxbanco;
    Scanner ler = new Scanner(System.in);
    String nome;
    int codigo;
    Conta[] prox_conta = new Conta[5];
    boolean existe;

    public Banco(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
    }

    Conta AddConta (int cod, int i){
        Double lim;
        String nome;
        Conta novaConta = null;
         
        System.out.print("Digite seu nome: ");
        nome = ler.next();

        System.out.print("Digite o limite que deseja:");
        lim = ler.nextDouble();
        System.out.print("\n");
        cod = i+1;

        novaConta = new Conta(nome, i+1, lim, cod);
        prox_conta[i] = novaConta;
        existe = true;
        System.out.println("Cadastro realizado com sucesso, codigo da sua conta é: " + novaConta.codigo + "\n");
            
        return novaConta;
    }

    void EncontrarConta(){
        int senha;
        if(existe){
            System.out.println("Digite o numro da conta:");
            senha = ler.nextInt();
            for(int i=0;i<prox_conta.length; i++){
                if(senha == prox_conta[i].codigo){
                    System.out.println("Titular:" + prox_conta[i].titular);
                    System.out.println("Saldo atual:" + prox_conta[i].saldo);
                    System.out.println("Limite:" + prox_conta[i].limite);

                }else{
                    if(i == prox_conta.length-1){
                        System.out.println("\nConta não encontrada!\n");
                    }
                }
            }

        }else{
            System.out.println("\nBanco não há contas cadastradas!\n");
        }
    }

    public void verificarExistencia(Conta[] contas) {
        int num;
        boolean consegui = false;
        int cod;
        while(consegui == false){
            System.out.print("Digite o código da sua conta: ");
            num = ler.nextInt();
            for(int i=0; i<5; i++){
                cod = contas[i].codigo;
                if(cod == num){
                    consegui=true;
                }
            }    
        }
    }
}


