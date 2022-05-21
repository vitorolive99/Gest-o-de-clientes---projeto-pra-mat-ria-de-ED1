class Tree {
  private No root; // raiz

  public Tree() {
    root = null;
  } // inicializa arvore

  public void inserir(String nome, String cpf) {
    No novo = new No(); // cria um novo Nó
    novo.nome = nome;
    novo.cpf = cpf;
    novo.divida = 0;
    novo.dir = null;
    novo.esq = null;


    if (root == null)
      root = novo;
    else { // se nao for a raiz
      No atual = root;
      No anterior;
      while (true) {
        anterior = atual;
        if (nome.compareTo(novo.nome) <= 0) { // ir para esquerda
          atual = atual.esq;
          if (atual == null) {
            anterior.esq = novo;
            return;
          }
        } // fim da condição ir a esquerda
        else { // ir para direita
          atual = atual.dir;
          if (atual == null) {
            anterior.dir = novo;
            return;
          }
        } // fim da condição ir a direita
      } // fim do laço while
    } // fim do else não raiz

  }

  public No buscar(String cpf, String nome) { //busca o nó através do cpf e do nome
    if (root == null)
      return null; // se arvore vazia
    No atual = root; // começa a procurar desde raiz
    while (!atual.cpf.equals(cpf)) { // enquanto nao encontrou
      if (nome.compareTo(atual.nome) < 0)
        atual = atual.esq; // caminha para esquerda
      else
        atual = atual.dir; // caminha para direita
      if (atual == null)
        return null; // encontrou uma folha -> sai
    }// fim laço while
    
    if(!atual.cpf.equals(cpf))
      return null;

    return atual; // terminou o laço while e chegou aqui é pq encontrou item
  }

  public boolean remover(String cpf, String nome) {
    if (root == null)
      return false; // se arvore vazia

    No atual = root;
    No pai = root;
    boolean filho_esq = true;

    // ****** Buscando o valor **********
    while (!atual.cpf.equals(cpf)) { // enquanto nao encontrou
      pai = atual;
      if (nome.compareTo(atual.nome) < 0) { // caminha para esquerda
        atual = atual.esq;
        filho_esq = true; // é filho a esquerda? sim
      } else { // caminha para direita
        atual = atual.dir;
        filho_esq = false; // é filho a esquerda? NAO
      }
      if (atual == null)
        return false; // encontrou uma folha -> sai
    } // fim laço while de busca do valor

    // **************************************************************
    // se chegou aqui quer dizer que encontrou o valor (v)
    // "atual": contem a referencia ao No a ser eliminado
    // "pai": contem a referencia para o pai do No a ser eliminado
    // "filho_esq": é verdadeiro se atual é filho a esquerda do pai
    // **************************************************************

    // Se nao possui nenhum filho (é uma folha), elimine-o
    if (atual.esq == null && atual.dir == null) {
      if (atual == root)
        root = null; // se raiz
      else if (filho_esq)
        pai.esq = null; // se for filho a esquerda do pai
      else
        pai.dir = null; // se for filho a direita do pai
    }

    // Se é pai e nao possui um filho a direita, substitui pela subarvore a direita
    else if (atual.dir == null) {
      if (atual == root)
        root = atual.esq; // se raiz
      else if (filho_esq)
        pai.esq = atual.esq; // se for filho a esquerda do pai
      else
        pai.dir = atual.esq; // se for filho a direita do pai
    }

    // Se é pai e nao possui um filho a esquerda, substitui pela subarvore a
    // esquerda
    else if (atual.esq == null) {
      if (atual == root)
        root = atual.dir; // se raiz
      else if (filho_esq)
        pai.esq = atual.dir; // se for filho a esquerda do pai
      else
        pai.dir = atual.dir; // se for filho a direita do pai
    }

    // Se possui mais de um filho, se for um avô ou outro grau maior de parentesco
    else {
      No sucessor = no_sucessor(atual);
      // Usando sucessor que seria o Nó mais a esquerda da subarvore a direita do No
      // que deseja-se remover
      if (atual == root)
        root = sucessor; // se raiz
      else if (filho_esq)
        pai.esq = sucessor; // se for filho a esquerda do pai
      else
        pai.dir = sucessor; // se for filho a direita do pai
      sucessor.esq = atual.esq; // acertando o ponteiro a esquerda do sucessor agora que ele assumiu
                                // a posição correta na arvore
    }

    return true;
  }

  // O sucessor é o Nó mais a esquerda da subarvore a direita do No que foi
  // passado como parametro do metodo
  public No no_sucessor(No apaga) { // O parametro é a referencia para o No que deseja-se apagar
    No paidosucessor = apaga;
    No sucessor = apaga;
    No atual = apaga.dir; // vai para a subarvore a direita

    while (atual != null) { // enquanto nao chegar no Nó mais a esquerda
      paidosucessor = sucessor;
      sucessor = atual;
      atual = atual.esq; // caminha para a esquerda
    }
    // *********************************************************************************
    // quando sair do while "sucessor" será o Nó mais a esquerda da subarvore a
    // direita
    // "paidosucessor" será o o pai de sucessor e "apaga" o Nó que deverá ser
    // eliminado
    // *********************************************************************************
    if (sucessor != apaga.dir) { // se sucessor nao é o filho a direita do Nó que deverá ser eliminado
      paidosucessor.esq = sucessor.dir; // pai herda os filhos do sucessor que sempre serão a direita
      // lembrando que o sucessor nunca poderá ter filhos a esquerda, pois, ele sempre
      // será o
      // Nó mais a esquerda da subarvore a direita do Nó apaga.
      // lembrando também que sucessor sempre será o filho a esquerda do pai

      sucessor.dir = apaga.dir; // guardando a referencia a direita do sucessor para
                                // quando ele assumir a posição correta na arvore
    }
    return sucessor;
  }

  public void caminhar(){
    System.out.println("Ficha Geral de Clientes");
    inOrder(root);
  }

  public void inOrder(No atual) {
    if (atual != null) {
      inOrder(atual.esq);
      System.out.println("************************");
      System.out.println("* NOME "+ atual.nome);
      System.out.println("* CPF "+ atual.cpf);
      System.out.println("* R$ "+ atual.divida);
      System.out.println("************************");
      inOrder(atual.dir);
    }
  }
}