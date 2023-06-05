public enum MenuOperacoes{
    CADASTRAR(1),
    LISTAR(2),
    EXCLUIR(3),
    TRANSFERIR_SEGURO(4),
    CALCULAR_RECEITA_SEGURADORA(5),
    AUTORIZACAO_CONDUTOR(6),
    SAIR(0);

    public final int operacao;

    MenuOperacoes(int operacao){
        this.operacao = operacao;
    }

    public int getOperacaoValor(){
        return this.operacao;
    }

    public static MenuOperacoes getOperacao(int valor){
        for(MenuOperacoes operacao : MenuOperacoes.values()){
            if(valor == operacao.getOperacaoValor()){
                return operacao;
            }
        }
        return null;
    }

}