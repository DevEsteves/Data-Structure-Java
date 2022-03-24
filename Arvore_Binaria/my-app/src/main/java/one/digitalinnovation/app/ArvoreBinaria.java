package one.digitalinnovation.app;

public class ArvoreBinaria<T extends Comparable<T>> {
    private BinNode<T> raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void inserir(T conteudo){
        BinNode<T> novoNo = new BinNode<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }

    private BinNode<T> inserir(BinNode<T> atual, BinNode<T> novoNo){
        if(atual == null){
            return novoNo;
        }else if(novoNo.getConteudo().compareTo(atual.getConteudo()) < 0){
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));
        }else{
            atual.setNoDir(inserir(atual.getNoDir(), novoNo));
        }
        return atual;
    }

    public void exibirEmOrdem(){
        System.out.println("\n Exibindo Em Ordem");
        exibirEmOrdem(this.raiz);
    }

    private void exibirEmOrdem(BinNode<T> atual){
        if(atual != null){
            exibirEmOrdem(atual.getNoEsq());
            System.out.println(atual.getConteudo() + ", ");
            exibirEmOrdem(atual.getNoDir());
        }
    }

    public void exibirPosOrdem(){
        System.out.println("\n Exibindo Pos Ordem");
        exibirPosOrdem(this.raiz);
    }

    private void exibirPosOrdem(BinNode<T> atual){
        if(atual != null){
            exibirPosOrdem(atual.getNoEsq());
            System.out.println(atual.getConteudo() + ", ");
            exibirPosOrdem(atual.getNoDir());
        }
    }

}