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

    public void setNoEsq(BinNode<T> noEsq) {
        this.noEsq = noEsq;
    }

    public void setNoDir(BinNode<T> noDir) {
        this.noDir = noDir;
    }

    public BinNode<T> getNoEsq() {
        return noEsq;
    }

    public BinNode<T> getNoDir() {
        return noDir;
    }

    @Override
    public String toString() {
        return "BinNode{" +
                "conteudo=" + conteudo +
                '}';
    }
}