package one.digitalinnovation;

public class ArvoreBinaria<T extends comparable<T>> {
    private BinNode<T> raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    private BinNode<T> inserir(BinNode<T> atual, BinNode<T> NovoNo){
        if(atual == null){
            return NovoNo;
        }
    }
}