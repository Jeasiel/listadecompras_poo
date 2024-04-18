package principal;

import java.util.Scanner;

import listas.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //Aqui estará a classe do menu principal com as funções
        Lista lista = new Lista("Lista Exemplo", "Mercado");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Opções:\n1- Adicionar produto\n2- Remover produto\n3- Atualizar produto\n4- Ver lista\n0- Sair\n=======");
            int escolha = -1;

            String nome = "Nenhum";
            double precoEstimado = 0;
            int quantidade = 0;
            try {
                escolha = Integer.parseInt(scanner.nextLine());
            } catch (Exception e){
            }
            switch (escolha) {
                case 1:
                    try {
                        System.out.println("Adicionando produto...\nDigite o nome do produto:");
                        nome = scanner.nextLine();
                        System.out.println("Digite o preço estimado do produto:");
                        precoEstimado = Double.parseDouble(scanner.nextLine());
                        System.out.println("Digite a quantidade desejada:");
                        quantidade = Integer.parseInt(scanner.nextLine());
                        lista.adicionarProduto(nome, precoEstimado, quantidade);
                    } catch (Exception e){
                        System.out.println("Algo deu errado. Voltando para o menu...");
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do produto para remover:");
                    nome = scanner.nextLine();
                    if(lista.removerProduto(nome)){
                        System.out.println("Produto removido com sucesso.");
                    } else {
                        System.out.println("Produto não removido.");
                    }
                    break;
                case 3:
                    System.out.println("Digite o nome do produto para atualizar:");
                    nome = scanner.nextLine();
                    System.out.println("Digite o preço estimado do produto:");
                    precoEstimado = Double.parseDouble(scanner.nextLine());
                    System.out.println("Digite a quantidade desejada do produto:");
                    quantidade = Integer.parseInt(scanner.nextLine());
                    if(!lista.atualizarProduto(nome, precoEstimado, quantidade)){
                        System.out.println("Item não atualizado.");
                    }
                    break;
                case 4:
                    System.out.println("Lista: " + lista.getNome() + ". Tipo da lista: " + lista.getTipo() + ". Tamanho: " + lista.getListaProdutos().size());
                    System.out.println("Produtos na lista:");
                    for(int i = 0; i < lista.getListaProdutos().size(); i++){
                        System.out.println(lista.getListaProdutos().get(i).toString());
                    }
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Escolha um número válido.");
                    break;
            }
        }
    }
}