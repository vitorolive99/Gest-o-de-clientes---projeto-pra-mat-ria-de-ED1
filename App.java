
import java.util.*; 

class ArvoreBinariaApp {
  public static void main(String[] args) {
    Scanner le = new Scanner(System.in);
    Tree arv = new Tree();
    int opcao;
	String nome, cpf;
	No ficha_pessoa = new No();
    do {
        System.out.println("***********************************");
        System.out.println("Entre com a opcao:");
		System.out.println(" ----1: Cadastrar novo cliente");
		System.out.println(" ----2: Excluir");
		System.out.println(" ----3: excluir ficha"); // pagar divida ou excluir
		System.out.println(" ----4: Exibir");
		System.out.println(" ----5: Sair do programa");
		System.out.println("***********************************");
		System.out.print("-> ");
		opcao = le.nextInt();
		switch(opcao) {
			case 1: {
				System.out.print(" Informe nome do cliete -> ");
				nome = le.next();
				System.out.print(" Informe cpf do cliete -> ");
				cpf = le.next();
				arv.inserir(nome, cpf);
				break;
			}
			case 2: {
				System.out.println(" Informe nome do cliete -> ");
				nome = le.next();
				System.out.println(" Informe cpf do cliete -> ");
				cpf = le.next();
				if ( !arv.remover(cpf, nome) )
							System.out.println(" Valor nao encontrado!");;
				break;
			}
			case 3: {
				// pega o dados do cliente
				System.out.print(" Informe nome do cliete -> ");
				nome = le.next();
				System.out.print(" Informe cpf do cliete -> ");
				cpf = le.next();
				// pega o no da ficha
				ficha_pessoa = arv.buscar(cpf, nome);
					if( ficha_pessoa != null ){
					System.out.println("Cliente encontrado");
					System.out.println("Valor da divida  "+ficha_pessoa.divida);
					// se a pessoa nao tiver mais divida o no e apagado
					if(ficha_pessoa.divida <=0){
						arv.remover(ficha_pessoa.cpf, ficha_pessoa.nome);
						System.out.println("Cliente excluido");
					}else{
						System.out.println("Nao pode pois ainda deve na casa");
					}
					// caso os dados inseridos estejam errados
					}else{
						
						System.out.println(" Esse Cliente nao esta cadastrado.");
					}
					
				break;
			}	 
			case 4: {
				
				break; 
			}
			default:{
				System.out.println("Opcao invalida");
			}
			} // fim switch
		} while(opcao != 5);

  }
}