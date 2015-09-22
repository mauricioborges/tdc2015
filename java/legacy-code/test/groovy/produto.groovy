import static org.mockito.Mockito.*
import static org.mockito.Matchers.*
import tdc2015.legacy.produto.ProdutoController
import tdc2015.legacy.produto.ProdutoDAO

import static org.mockito.Mockito.*

class ProdutoControllerGroovyTesting extends GroovyTestCase {
    void "test if it's possible to create a ProdutoController instance"() {
        assert new ProdutoController(null) != null
    }

    void "test if it's possible to create a ProdutoController instance with a mocked DAO"() {
        def mockedDAO = mock(ProdutoDAO.class)
        new ProdutoController(mockedDAO).listar()
        verify(mockedDAO, times(1)).list()

    }
}
