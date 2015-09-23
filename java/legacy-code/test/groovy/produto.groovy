import groovy.mock.interceptor.MockFor
import tdc2015.legacy.produto.ProdutoController
import tdc2015.legacy.produto.ProdutoDAO

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

import static org.mockito.Matchers.anyInt
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
        shouldFail(ArrayIndexOutOfBoundsException) {
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

class ProdutoDAOGroovyTesting extends GroovyTestCase {
    void "test if you can create an instance"() {
        assert new ProdutoDAO({} as Connection) != null;
    }

    void testDifferentCreateProductCalls() {

        def mockConnection = new MockFor(Connection.class)
        def mockStatement = new MockFor(PreparedStatement.class)
        def mockResultSet = new MockFor(ResultSet.class)
        mockConnection.demand.with {
            createStatement { mockStatement.proxyDelegateInstance() }

        }
        mockStatement.demand.with {
            executeUpdate(1..1) { String sql -> 0 }
            getGeneratedKeys(1..1) { -> return mockResultSet.proxyDelegateInstance() }
        }
        mockResultSet.demand.with {
            getInt { Integer col -> return 0 }
        }
        def conn = mockConnection.proxyDelegateInstance()
        new ProdutoDAO(conn).createProduct("")
        mockConnection.verify(conn)


    }

    void testDifferentCreateProductCalls2() {

        def mockConnection = new MockFor(Connection.class)
        def mockStatement = new MockFor(PreparedStatement.class)
        def mockResultSet = new MockFor(ResultSet.class)
        mockConnection.demand.with {
            createStatement { mockStatement.proxyDelegateInstance() }

        }
        mockStatement.demand.with {
            executeUpdate(1..1) { String sql -> 0 }
            getGeneratedKeys(1..1) { -> return mockResultSet.proxyDelegateInstance() }
        }
        mockResultSet.demand.with {
            getInt { Integer col -> return 0 }
        }
        def conn = mockConnection.proxyDelegateInstance()
        new ProdutoDAO(conn).createProduct("")
        mockConnection.verify(conn)


    }

    void testCallingCreateProductWithNull() {
        shouldFail(NullPointerException) {
            new ProdutoDAO({} as Connection).createProduct(null)
        }


    }


}
