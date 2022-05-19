
import java.util.*; 

class ArvoreBinariaApp {
  public static void main(String[] args) {
    Scanner le = new Scanner(System.in);
    Tree arv = new Tree();
    int opcao;
	String nome, cpf;
    System.out.print("\n Programa Arvore binaria de long");
    do {
        System.out.print("\n***********************************");
        System.out.print("\nEntre com a opcao:");
		System.out.print("\n ----1: Cadastrar novo cliente");
		System.out.print("\n ----2: Excluir");
		System.out.print("\n ----3: Pesquisar");
		System.out.print("\n ----4: Exibir");
		System.out.print("\n ----5: Sair do programa");
		System.out.print("\n***********************************");
		System.out.print("\n-> ");
		opcao = le.nextInt();
		switch(opcao) {
			case 1: {
				System.out.print("\n Informe nome do cliete -> ");
				nome = le.nextLine();
				System.out.print("\n Informe cpf do cliete -> ");
				cpf = le.nextLine();
				arv.inserir(nome, cpf);
				break;
			}
			case 2: {
				System.out.print("\n Informe nome do cliete -> ");
				nome = le.nextLine();
				System.out.print("\n Informe cpf do cliete -> ");
				cpf = le.nextLine();
				if ( !arv.remover(cpf, nome) )
							System.out.print("\n Valor nao encontrado!");;
				break;
			}
			case 3: {
				System.out.print("\n Informe nome do cliete -> ");
				nome = le.nextLine();
				System.out.print("\n Informe cpf do cliete -> ");
				cpf = le.nextLine();
					if( arv.buscar(cpf, nome) != null )
					System.out.print("\n Valor Encontrado");
				else 
					System.out.print("\n Valor nao encontrado!");
				break;
			}	 
			case 4: {
				
				break; 
			}
			} // fim switch
		} while(opcao != 5);

  }
}