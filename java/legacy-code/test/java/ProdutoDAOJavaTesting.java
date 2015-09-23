import org.junit.Test;
import tdc2015.legacy.produto.ProdutoDAO;

import java.sql.Connection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

public class ProdutoDAOJavaTesting {
    @Test
    public void testIfYouCanCreateAProdutoDAOInstance() {
        assertThat(new ProdutoDAO(mock(Connection.class)), is(not(nullValue())));
    }

}