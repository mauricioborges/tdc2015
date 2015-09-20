package tdc2015.legacy.produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauricio on 18/09/15.
 */
public class ProdutoController {

    private ProdutoDAO dao = new ProdutoDAO(Env.CONNECTION_DATA);

    public List<Produto> listar() {
        return dao.list();
    }

    public Produto criar(String dadosProduto) {
        Integer codigo = dao.createProduct(dadosProduto);

        return dao.getProduct(codigo);
    }
}
