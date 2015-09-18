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
        while(opcao != 0) {
            try {
                opcao = Integer.parseInt(console.readLine("informe a opção: 1-listar, 2-criar, 3-alterar, 4-remover, 0-voltar "));
                if (opcao == 1){
                    listar();
                }
            }catch(NumberFormatException e){
                console.printf("opção inválida!\n");
            }
        }

    }

    private void listar() {
        List<Produto> produtos = controller.listar();
        for (int i = 0; i < produtos.size(); i++) {
            console.printf("produto %1", produtos.get(i).toString());

        }

    }
}
