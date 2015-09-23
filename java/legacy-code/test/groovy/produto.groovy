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
    void "test if an exception is thrown when calling criar() with an empty string"() {
        def mockedDAO = mock(ProdutoDAO.class)
        shouldFail(ArrayIndexOutOfBoundsException){
            new ProdutoController(mockedDAO).criar("")
        }
    }
    void "test if I can simply call create using a semicolon separated list of any elements"() {
        def mockedDAO = mock(ProdutoDAO.class)
        new ProdutoController(mockedDAO).criar("a;b;c;d;e")
        verify(mockedDAO, times(1)).buscaPorEAN("e")
        verify(mockedDAO, times(1)).buscaPorNome("a")
        verify(mockedDAO, times(1)).createProduct("a;b;c;d;e")
        verify(mockedDAO, times(1)).getProduct(anyInt())
    }
}
