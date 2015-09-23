import spock.lang.Specification
import tdc2015.legacy.produto.Produto
import tdc2015.legacy.produto.ProdutoController
import tdc2015.legacy.produto.ProdutoDAO

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class ProdutoControllerSpockTesting extends Specification {

    def "should be able to create a controller's instance when needed"() {
        expect:
        new ProdutoController(null) != null
    }

    def "should be able to create a controller's instance using a mocked DAO"() {
        given:
        def mockedDAO = Mock(ProdutoDAO)
        when:
        new ProdutoController(mockedDAO).listar()
        then:
        1 * mockedDAO.list()
    }

    def "should be able to stub dao when calling criar()"() {
        given:
        def mockedDAO = Stub(ProdutoDAO)
        when:
        def produto = new ProdutoController(mockedDAO).criar("a;b;c;d;e")
        then:
        !produto.is(null)

    }

    def "should be able to mock dao when calling criar()"() {
        given:
        def mockedDAO = Mock(ProdutoDAO)
        when:
        def produto = new ProdutoController(mockedDAO).criar("a;b;c;d;e")
        then:
        produto.is(null)
        1 * mockedDAO.buscaPorEAN(_ as String) >> []
        1 * mockedDAO.buscaPorNome(_ as String) >> []
    }

    def "should be able to mock dao exceptions when calling criar() with other syntax"() {
        setup:
        def mockedDAO = Mock(ProdutoDAO) {
            1 * buscaPorEAN("e") >> []
            1 * buscaPorNome("a") >> []
            1 * createProduct("a;b;c;d;e") >> 1
            1 * getProduct(1) >> Mock(Produto)
        }
        when:
        def produto = new ProdutoController(mockedDAO).criar("a;b;c;d;e")
        then:
        !produto.is(null)

    }
}

class ProdutoDAOSpockTesting extends Specification {

    def "should be able to create a dao's instance when needed"() {
        expect:
        new ProdutoDAO({} as Connection) != null
    }

    def "caracterize createProduct according to string parameter"(String data, String sql) {
        given:
        def mockedStatement = Stub(PreparedStatement)
        def mockedConn = Mock(Connection) {
            createStatement() >> mockedStatement
        }
        when:

        new ProdutoDAO(mockedConn).createProduct(data)
        then:
        mockedStatement.executeUpdate(sql) >> 0

        where:
        data                                                                              | sql
        'nome_produto;descricao_produto;100;marca_produto;ean_produto;apelido_produto;UN' | 'INSERT INTO PRODUTOS VALUES(NULL, "nome_produto", "descricao_produto", 100, "marca_produto", "ean_produto", "apelido_produto", "UN");'
        'a;b;c;d;e'                                                                       | 'INSERT INTO PRODUTOS VALUES(NULL, "a", "b", c, "d", "e");'
        ""                                                                                | 'INSERT INTO PRODUTOS VALUES(NULL, "");'

    }


}