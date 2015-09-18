import tdc2015.legacy.produto.ProdutoView;

import java.io.Console;
import java.util.Scanner;

public class Main {
    public static final void main(String... aArgs){
        Console console = System.console();
        if (console == null){
            throw new RuntimeException("Sem console, já eras");
        }
        console.printf("Bem vindo ao Legacy System: desde o começo criando um legado\n");
        Integer opcao = 99;
        while(opcao != 0) {
            try {
                opcao = Integer.parseInt(console.readLine("informe a opção: 1-produto, 2-pedido, 0-sair "));
                if (opcao == 1){
                    new ProdutoView(console).menu();
                }
            }catch(NumberFormatException e){
                console.printf("opção inválida!\n");
            }
        }
    }
}
