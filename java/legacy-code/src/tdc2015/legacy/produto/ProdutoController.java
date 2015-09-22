package tdc2015.legacy.produto;

import java.util.List;

public class ProdutoController {

    private ProdutoDAO dao;

    public ProdutoController(ProdutoDAO dao) {
        this.dao = dao;
    }

    public ProdutoController() {
        this.dao = new ProdutoDAO(Env.CONNECTION_DATA);
    }

    public List<Produto> listar() {
        return dao.list();
    }

    private String pegaEAN(String dadosProduto) {
        return dadosProduto.split(";")[4];
    }

    private String pegaNome(String dadosProduto) {
        return dadosProduto.split(";")[0];
    }

    public Produto criar(String dadosProduto) throws ProdutoException {
        if (dao.buscaPorEAN(pegaEAN(dadosProduto)).size() > 0) {
            throw new ProdutoException("EAN duplicado!");
        }
        if (dao.buscaPorNome(pegaNome(dadosProduto)).size() > 0) {
            throw new ProdutoException("Nome duplicado!");
        }
        Integer codigo = null;
        codigo = dao.createProduct(dadosProduto);

        return dao.getProduct(codigo);
    }
}
