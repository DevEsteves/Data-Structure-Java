package one.digitalinnovation.app;

public class BinNode<T extends Comparable<T>>{

    private T conteudo;
    private BinNode<T> noEsq;
    private BinNode<T> noDir;

    public BinNode(T conteudo){
        this.conteudo = conteudo;
        this.noEsq = this.noDir = null;
    }

    public BinNode() {

    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public BinNode<T> getNoEsq(T conteudo) {
        return noEsq;
    }
}