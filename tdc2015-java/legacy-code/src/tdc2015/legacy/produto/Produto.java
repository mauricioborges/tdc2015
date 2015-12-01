package tdc2015.legacy.produto;

import java.math.BigDecimal;

/**
 * Created by mauricio on 18/09/15.
 */
public class Produto {

    private Integer id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String marca;
    private String ean;
    private String apelido;
    private String unidadeMedida;

    public static Produto createInstance(Integer id, String nome, String descricao, BigDecimal preco, String marca, String ean, String apelido, String unidadeMedida) {
        Produto produto = new Produto();
        produto.id = id;
        produto.nome = nome;
        produto.descricao = descricao;
        produto.preco = preco;
        produto.marca = marca;
        produto.ean = ean;
        produto.apelido = apelido;
        produto.unidadeMedida = unidadeMedida;
        return produto;
    }

    @Override
    public String toString() {
        StringBuffer produtoTexto = new StringBuffer();
        produtoTexto.append("id: " + id);
        produtoTexto.append(" apelido: " + apelido);
        produtoTexto.append(" preço: " + preco);
        produtoTexto.append(" EAN: " + ean);
        return produtoTexto.toString();

    }
}
