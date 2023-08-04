package graduacao;

class Professor extends Aluno implements Autenticavel{
    private int senha;
   
    Professor(){}
    

    Professor(String nome, String curso, int senha) {
        super(nome, curso);
        this.senha = senha;
    }
    
    public int getSenha() {
        return senha;
    }

    @Override
    public Boolean autenticar(String usuario, int senha){
        return this.getNome().equals(usuario) && this.senha == senha;
    }

    public void printDados(){
        System.out.println("Nome: " + getNome());
        System.out.println("Curso: " + getCurso());
        System.out.println("Senha " + getSenha());
    }

    
}
