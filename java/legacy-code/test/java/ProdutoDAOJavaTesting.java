import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
    import org.junit.runners.Parameterized;
import tdc2015.legacy.produto.ProdutoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class ProdutoDAOJavaTesting {

    private String dadosProduto;
    private String generatedSQL;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"nome_produto;descricao_produto;100;marca_produto;ean_produto;apelido_produto;UN", "INSERT INTO PRODUTOS VALUES(NULL, \"nome_produto\", \"descricao_produto\", 100, \"marca_produto\", \"ean_produto\", \"apelido_produto\", \"UN\");"},
                {"a;b;c;d;e", "INSERT INTO PRODUTOS VALUES(NULL, \"a\", \"b\", c, \"d\", \"e\");"},
                {"", "INSERT INTO PRODUTOS VALUES(NULL, \"\");"},
        });
    }

    public ProdutoDAOJavaTesting(String dadosProduto, String generatedSQL) {
        this.dadosProduto = dadosProduto;
        this.generatedSQL = generatedSQL;

    }
    @Test
    public void testIfYouCanCreateAProdutoDAOInstance() {
        assertThat(new ProdutoDAO(mock(Connection.class)), is(not(nullValue())));
    }

    @Test
    public void testDifferentCreateProductCalls() throws SQLException {
        Connection mockedConn = mock(Connection.class);
        PreparedStatement mockedStatement = mock(PreparedStatement.class);
        ResultSet mockedResultSet = mock(ResultSet.class);
        when(mockedConn.createStatement()).thenReturn(mockedStatement);
        when(mockedStatement.getGeneratedKeys()).thenReturn(mockedResultSet);

        ProdutoDAO dao = new ProdutoDAO(mockedConn);
        is(dao.createProduct(dadosProduto).getClass()).equals(Integer.class);
        verify(mockedStatement, times(1)).executeUpdate(generatedSQL);

    }
    @Test
    public void testCallingCreateProductWithNull() throws SQLException {
        Connection mockedConn = mock(Connection.class);
        PreparedStatement mockedStatement = mock(PreparedStatement.class);
        ResultSet mockedResultSet = mock(ResultSet.class);
        when(mockedConn.createStatement()).thenReturn(mockedStatement);
        when(mockedStatement.getGeneratedKeys()).thenReturn(mockedResultSet);

        ProdutoDAO dao = new ProdutoDAO(mockedConn);
        thrown.expect(NullPointerException.class);
        dao.createProduct(null);

    }
    /*
    criar um caso de teste para:
    - createProduct("")
    - createProduct(null)
    - createProduct("a;b;c;d;e")
    - createProduct("um que funcione de verdade")
     */


}