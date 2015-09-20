package tdc2015.legacy.produto;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauricio on 20/09/15.
 */
public class ProdutoDAO {
    private Connection conn = null;

    public ProdutoDAO(String connectionData) {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:./db/production.db");
        } catch (Exception e) {
            throw new RuntimeException(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public Integer createProduct(String dadosProduto) {
        String[] cols = dadosProduto.split(";");
        StringBuffer insertQuery = new StringBuffer("INSERT INTO PRODUTOS VALUES(NULL, ");
        for (int i = 0; i < cols.length; i++) {
            //is text
            if (i != 2) {
                insertQuery.append("\"");
            }
            insertQuery.append(cols[i]);
            //is text
            if (i != 2) {
                insertQuery.append("\"");
            }
            if (i < cols.length - 1) {
                insertQuery.append(", ");
            }
        }
        insertQuery.append(");");
        Statement statement = null;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(insertQuery.toString());
            ResultSet key = statement.getGeneratedKeys();
            return key.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(insertQuery.toString());
        }
    }

    public Produto getProduct(Integer codigo) {
        String query = "SELECT * FROM PRODUTOS WHERE ID = " + codigo.toString();
        ResultSet rs = null;
        try {
            Statement statement = null;
            statement = conn.createStatement();
            rs = statement.executeQuery(query.toString());

            Integer id = rs.getInt("id");
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            BigDecimal preco = rs.getBigDecimal("preco");
            String marca = rs.getString("marca");
            String ean = rs.getString("ean");
            String apelido = rs.getString("apelido");
            String unidadeMedida = rs.getString("unidademedida");
            return Produto.createInstance(id, nome, descricao, preco, marca, ean, apelido, unidadeMedida);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Produto> list() {
        String query = "SELECT * FROM PRODUTOS";
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<Produto>();
        try {
            Statement statement = null;
            statement = conn.createStatement();
            rs = statement.executeQuery(query.toString());
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                BigDecimal preco = rs.getBigDecimal("preco");
                String marca = rs.getString("marca");
                String ean = rs.getString("ean");
                String apelido = rs.getString("apelido");
                String unidadeMedida = rs.getString("unidademedida");
                produtos.add(Produto.createInstance(id, nome, descricao, preco, marca, ean, apelido, unidadeMedida));
            }
            return produtos;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}