package tdc2015.legacy.produto;

import java.io.Console;
import java.util.List;

/**
 * Created by mauricio on 18/09/15.
 */
public class ProdutoView {
    private final Console console;
    private final ProdutoController controller;

    public ProdutoView(Console console) {
        this.console = console;
        this.controller = new ProdutoController();
    }

    public void menu() {
        console.printf("Produtos\n");
        console.printf("========\n");
        Integer opcao = 99;
        while (opcao != 0) {
            try {
                opcao = Integer.parseInt(console.readLine("informe a opção: 1-listar, 2-criar, 3-alterar, 4-remover, 0-voltar "));
                if (opcao == 1) {
                    listar();
                } else if (opcao == 2) {
                    criar();
                } else if (opcao == 3) {
                    alterar();
                } else if (opcao == 4) {
                    remover();
                }

            } catch (NumberFormatException e) {
                console.printf("opção inválida!\n");
            }
        }

    }


    private void listar() {
        List<Produto> produtos = controller.listar();
        for (int i = 0; i < produtos.size(); i++) {
            console.printf("produto " + produtos.get(i).toString() + "\n");

        }

    }

    private void criar() {
        Produto produto = controller.criar(criarDialog());
        console.printf(produto.toString());
    }

    private void alterar() {
    }

    private void remover() {
    }

    public String criarDialog() {
        console.printf("Criando um produto...\n");
        //Nome descrição preco marca ean apelido unidademedida
        StringBuffer dadosProduto = new StringBuffer();
        dadosProduto.append(console.readLine("informe o nome do produto")).append(";");
        dadosProduto.append(console.readLine("informe a descrição do produto")).append(";");
        dadosProduto.append(console.readLine("informe o preço do produto no formato 99,99")).append(";");
        dadosProduto.append(console.readLine("informe a marca do produto")).append(";");
        dadosProduto.append(console.readLine("informe o código EAN do produto")).append(";");
        dadosProduto.append(console.readLine("informe o apelido do produto")).append(";");
        dadosProduto.append(console.readLine("informe a unidade de medida do produto").toUpperCase());
        return dadosProduto.toString();
    }
}
