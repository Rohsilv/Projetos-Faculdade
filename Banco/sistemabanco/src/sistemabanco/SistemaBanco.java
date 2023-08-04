package sistemabanco;
import java.util.Scanner;

public class SistemaBanco {
    public static void main(String[] args) {
        boolean consegui;
        double valEntra;
        double valSaida;
        int num=0;
        int cod=0;
        int aux=0;
        int opcao = 0;
        int i=0;
        

        Scanner ler = new Scanner(System.in);
       
        Banco[] bancos = new Banco[3];
        bancos[0] = new Banco("Nubank", 1);
        bancos[1] = new Banco("Bradesco", 2);
        bancos[2] = new Banco("Caixa", 3);


        Conta[] contas = new Conta[5];
    
        while(opcao!=2){
            System.out.print("1-adicionar conta\n2-finalizar \n");
            System.out.print("Digite sua opção: ");
            opcao = ler.nextInt();
            if(opcao == 1){
                System.out.print("Digite o código do seu Banco: ");
                cod = ler.nextInt();
                if(cod<1 || cod>3){
                    System.out.print("banco não encontrado, tente novamente!");
                }else{
                    if(i<5){
                        contas[i] = bancos[cod].AddConta(cod,i);
                        i++;
                    }else{
                       System.out.print("Limite de contas cadastradas atingido"); 
                    }                 
                }
            } 
        }
        
        consegui = false;
        while (!consegui) {
            System.out.print("Digite o código da sua conta: ");
            num = ler.nextInt();
            for (i = 0; i < contas.length; i++) {
                cod = contas[i].codigo;
                if (cod == num) {
                    consegui = true;
                    break;
                }else{
                    System.out.print("conta não encontrada!");
                    break;
                }
             }
        }
        num--;
        System.out.print("Conta em nome do(a) titular " + contas[num].titular + "acessada com sucesso!\n");

        while(opcao!=9){
           
            System.out.println("\n\n*********************\n1- Depositar\n2- Sacar\n3- Trasferencia\n4- Saldo atual\n5- Titular da conta\n6- mostar dados da conta\n7- Mudar o acesso para outra conta\n8- pesquisar conta no banco\n9- sair\n*********************");
            System.out.print("Opção: ");
            opcao = ler.nextInt();
            System.out.print("\n");
            switch(opcao){
                case 1:
                    System.out.println("Digite o valor a depositar: ");
                    valEntra = ler.nextDouble();
                    System.out.print("\n");
                    contas[num].deposita(valEntra, num, contas);

                    break;

                case 2:
                 
                    System.out.println("Digite o valor a sacar: ");
                    valSaida = ler.nextDouble();
                    System.out.print("\n");
                    consegui = contas[num].saca(valSaida);
                    
                    if(consegui == true){
                        System.out.println("Saque realizado om sucesso!\n");
                    } else {
                        System.out.println("Crédito insuficiente\n");
                    }
                    break;
                
                case 3:
                    
                    consegui = false;
                    while (!consegui) {
                        System.out.println("Digite o código da conta que deseja transferir: ");
                        cod = ler.nextInt();
                        System.out.print("\n");
                        for (i = 0; i < contas.length; i++) {
                            aux = contas[i].codigo;
                            if (cod == aux) {
                                consegui = true;
                                cod--;
                                System.out.print("tranferir para o(a) titular " + contas[cod].titular + "\n");
                                break;
                            }
                        }
                    }

                    System.out.println("Digite o valor a tranferir: ");
                    valSaida = ler.nextDouble();
                    System.out.print("\n");
                    
                    contas[num].transferir(cod ,contas , valSaida);
        

                    break;

                case 4:
                    System.out.println("Saldo atual:" + contas[num].saldo);

                    break;
                
                case 5:
                    System.out.println("Titular:" + contas[num].titular);
            
                    break;
                

                case 6:
                    
                    System.out.println("Titular:" + contas[num].titular);
                    System.out.println("Saldo atual:" + contas[num].saldo);
                    System.out.println("Limite:" + contas[num].limite);
                    
                    break;
                
                case 7:
                   
                consegui = false;
                    while (!consegui) {
                        System.out.print("Digite o código da sua conta: ");
                        num = ler.nextInt();
                        for (i = 0; i < contas.length; i++) {
                            cod = contas[i].codigo;
                            if (cod == num) {
                                consegui = true;
                                num--;
                                System.out.print("Conta em nome do(a) titular " + contas[num].titular + "acessada com sucesso!\n");
                                break;
                            }
                        }
                    }
                    break;

                case 8:
                    
                    consegui=false;
                    while(!consegui){
                        System.out.println("Digite o código do seu banco: ");
                        cod = ler.nextInt();
                       
                        for(i=0;i<bancos.length;i++){
                            if(cod == bancos[i].codigo){
                                bancos[cod-1].EncontrarConta();
                                consegui=true;
                                break;
                            }else{
                                if(i==4){
                                    System.out.print("\nBanco não encontrado!");
                                }
                            }
                        }
                    }
                    break;

                case 9:
                    System.out.println("Obrigada por utilizar nosso banco, até mais!");
                    break;
                
             }
        }
        ler.close();
    }

}