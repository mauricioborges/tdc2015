import org.junit.Test;
import tdc2015.legacy.produto.ProdutoController;
import tdc2015.legacy.produto.ProdutoDAO;
import tdc2015.legacy.produto.ProdutoException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ProdutoControllerJavaTesting {

    @Test
    public void testIfYouCanCreateAProdutoControllerInstance() {
        assertThat(new ProdutoController(null), is(not(nullValue())));
    }

    @Test
    public void testIfYouCanCreateAProdutoControllerInstanceWithAMockedDAO() {
        ProdutoDAO mockedDAO = mock(ProdutoDAO.class);
        new ProdutoController(mockedDAO).listar();
        verify(mockedDAO, times(1)).list();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testCreateParametersBehaviour1() throws ProdutoException {
        ProdutoDAO mockedDAO = mock(ProdutoDAO.class);
        new ProdutoController(mockedDAO).criar("");
    }

    @Test
    public void testCreateParametersBehaviour2() throws ProdutoException {
        ProdutoDAO mockedDAO = mock(ProdutoDAO.class);
        new ProdutoController(mockedDAO).criar("a;b;c;d;e");
        verify(mockedDAO, times(1)).buscaPorEAN("e");
        verify(mockedDAO, times(1)).buscaPorNome("a");
        verify(mockedDAO, times(1)).createProduct("a;b;c;d;e");
        verify(mockedDAO, times(1)).getProduct(anyInt());

    }
}