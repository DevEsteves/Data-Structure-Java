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
            exibirPosOrdem(atual.getNoDir());
            System.out.println(atual.getConteudo() + ", ");
        }
    }

    public void exibirPreOrdem(){
        System.out.println("\n Exibindo Pre Ordem");
        exibirPreOrdem(this.raiz);
    }

    private void exibirPreOrdem(BinNode<T> atual){
        if(atual != null){
            System.out.println(atual.getConteudo() + ", ");
            exibirPreOrdem(atual.getNoEsq());
            exibirPreOrdem(atual.getNoDir());
        }
    }

    public void remover(T conteudo){
        try{
            BinNode<T> atual = this.raiz;
            BinNode<T> pai = null;
            BinNode<T> filho = null;
            BinNode<T> temp = null;

            while(atual != null && !atual.getConteudo().equals(conteudo)){
                pai = atual;
                if(conteudo.compareTo(atual.getConteudo()) < 0){
                    atual = atual.getNoEsq();
                }else{
                    atual = atual.getNoDir();
                }
            }

            if(atual == null){
                System.out.println("Conteudo nao encontrado. Bloco Try");
            }

            if(pai == null){
                if(atual.getNoDir() == null){
                    this.raiz = atual.getNoEsq();
                }else if(atual.getNoEsq() == null){
                    this.raiz = atual.getNoDir();
                }else{
                    for(temp = atual, filho = atual.getNoEsq();
                        filho.getNoDir() != null;
                        temp = filho, filho = filho.getNoEsq()
                        ){
                            if(filho != atual.getNoEsq()){
                                temp.setNoDir(filho.getNoEsq());
                                filho.setNoEsq(raiz.getNoEsq());
                            }
                        }
                        filho.setNoDir(raiz.getNoDir());
                        raiz = filho;
                }
            }else if(atual.getNoDir() == null){
                if(pai.getNoEsq() == atual){
                    pai.setNoEsq(atual.getNoEsq());
                }else{
                    pai.setNoDir(atual.getNoEsq());
                }
            }else if(atual.getNoEsq() == null){
                if(pai.getNoEsq() == atual){
                    pai.setNoEsq(atual.getNoDir());
                }else{
                    pai.setNoDir(atual.getNoDir());
                }
            }else{
                for(temp = atual, filho = atual.getNoEsq();
                    filho.getNoDir() != null;
                    temp = filho, filho = filho.getNoEsq()
                ){
                    if(filho != atual.getNoEsq()){
                        temp.setNoDir(filho.getNoEsq());
                        filho.setNoEsq(atual.getNoEsq());
                    }
                    filho.setNoDir(atual.getNoDir());
                    if(pai.getNoEsq() == atual){
                        pai.setNoDir(filho);
                    }else{
                        pai.setNoDir(filho);
                    }
                }
            }
        }catch(NullPointerException erro){
            System.out.println("Conteudo nao encontrado. Bloco Catch");
        }
    }
}