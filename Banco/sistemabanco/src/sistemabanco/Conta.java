package sistemabanco;

public class Conta {
    String titular;
    double saldo;
    double limite;
    int codigo;
    int banco;

    public Conta(String nome, int codigo, Double limite, int banco){
        this.titular = nome;
        this.codigo = codigo;
        this.limite = limite;
        this.banco = banco;
    }

    boolean saca(double valor){

        if(this.saldo < valor){
            if( this.limite < valor){
                return false;
            }else{
                this.saldo = this.saldo - valor;
                this.limite = this.limite + saldo;
                return true;
            }
            
        }else{
            this.saldo = this.saldo - valor;
            return true; 
        }
    }
    void deposita(double valor, int cod, Conta[] destino) {
        destino[cod].saldo += valor;
    }

    void transferir(int cod, Conta destino[], double valor) {
        if (this.saldo + this.limite < valor) {
            System.out.println("Crédito insuficiente");
        } else {
            if (this.saldo >= valor) {
                this.saldo -= valor;
                deposita(valor, cod, destino);
                System.out.println("Transferência realizada com sucesso!");
            } else {
                double saldoRestante = valor - this.saldo;
                this.saldo = 0;
                this.limite -= saldoRestante;
                deposita(valor, cod, destino);
                System.out.println("Transferência realizada com sucesso!");
            }
        }
    }
    
    public int getCodigo() {
        return codigo;
    }
    
   
}