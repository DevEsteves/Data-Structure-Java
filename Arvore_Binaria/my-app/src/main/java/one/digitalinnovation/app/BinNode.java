package one.digitalinnovation;

public class BinNode<T extends Comparable<T>>{

    private T conteudo;
    private BinNode<T> noEsq;
    private BinNode<T> noDir;

    public BinNode(T conteudo){
        this.conteudo = conteudo;
        this.noEsq = this.noDir = null;
    }
}