
import java.util.*; 

class ArvoreBinariaApp {
	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		Tree arv = new Tree();
		int opcao;
		float valor;
		String nome, cpf;
		No ficha_pessoa;
		do {
			System.out.println("***********************************");
			System.out.println("Entre com a opcao:");
			System.out.println(" ----1: Cadastrar novo cliente");
			System.out.println(" ----2: Exibir");
			System.out.println(" ----3: Excluir ficha"); // pagar divida ou excluir
			System.out.println(" ----4: Atualizar Ficha");
			System.out.println(" ----5: Sair do programa");
			System.out.println("***********************************");
			System.out.print("-> ");
			opcao = le.nextInt();
			switch(opcao) {
				case 1: {
					System.out.print(" Informe nome do cliente -> ");
					nome = le.next();
					System.out.print(" Informe cpf do cliente -> ");
					cpf = le.next();
					arv.inserir(nome, cpf);
					System.out.println("Cliente cadastrado com sucesso.");
					break;
				}
				case 2: {
					
					arv.caminhar();
					break;
					
				}
				case 3: {
					// pega o dados do cliente
					System.out.print(" Informe nome do cliente -> ");
					nome = le.next();
					System.out.print(" Informe cpf do cliente -> ");
					cpf = le.next();
					// pega o no da ficha
					ficha_pessoa = arv.buscar(cpf, nome);
						if( ficha_pessoa != null ){
							// se a pessoa nao tiver mais divida o no e apagado
							if(ficha_pessoa.divida <=0){
								arv.remover(ficha_pessoa.cpf, ficha_pessoa.nome);
								System.out.println("Cliente excluido com sucesso.");
							}else{
								System.out.println("Nao pode pois ainda tem débito na casa.");
								System.out.println("Valor da divida: R$ "+ficha_pessoa.divida);
							}
						// caso os dados inseridos estejam errados
						}else{
							System.out.println(" Esse Cliente nao esta cadastrado, verifique se os dados foram digitados corretamente.");
						}
						
					break;
				}	 
				case 4: {
					// pega o dados do cliente
					System.out.print(" Informe nome do cliente -> ");
					nome = le.next();
					System.out.print(" Informe cpf do cliente -> ");
					cpf = le.next();
					ficha_pessoa = arv.buscar(cpf, nome);
					
					if (ficha_pessoa != null) {
						do{

							System.out.println("***********************************");
							System.out.println(" ----1: Fazer Compras");
							System.out.println(" ----2: Pagar Divida");
							System.out.println(" ----0: Voltar");
							System.out.println("***********************************");
							System.out.print("-> ");
							opcao = le.nextInt();
								
							if(opcao == 1){
							System.out.println("Qual o valor da compra efetuada ? "); 
								valor = le.nextFloat();
								ficha_pessoa.divida += valor;
								System.out.println("Compra efetuada com sucesso!");
								System.out.println("Débito atual: R$" + ficha_pessoa.divida);
							}
							if(opcao == 2){
								System.out.println("Qual o valor de pagamento ? "); 
								valor = le.nextFloat();
								ficha_pessoa.divida -= valor;
								System.out.println("Pagamento efetuado com sucesso!");
								System.out.println("Débito atual: R$" + ficha_pessoa.divida);
							}

						}while(opcao != 0);
					} else {
						System.out.println("Cliente não encontrado, verifique se os dados foram digitados corretamente.");
					}

					break; 
				}
				case 5:
					System.out.println("Encerrando...");
					break;
				default:{
					System.out.println("Opcao invalida");
				}
			} // fim switch
		} while(opcao != 5);
		le.close();
	}
}