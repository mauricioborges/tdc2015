import junit.framework.TestCase;
import org.junit.Test;
import tdc2015.legacy.produto.ProdutoController;
import tdc2015.legacy.produto.ProdutoDAO;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ProdutoControllerJavaTesting extends TestCase {

    @Test
    public void testIfYouCanCreateAProdutoControllerInstance() {
        assertThat(new ProdutoController(null), is(not(nullValue())));
    }

    @Test
    public void testIfYouCanCreateAProdxutoControllerInstanceWithAMockedDAO() {
        ProdutoDAO mockedDAO = mock(ProdutoDAO.class);
        new ProdutoController(mockedDAO).listar();
        verify(mockedDAO, times(1)).list();

    }
}
