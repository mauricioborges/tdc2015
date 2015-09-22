
import tdc2015.legacy.produto.ProdutoController

class ProdutoControllerGroovyTesting extends GroovyTestCase {
    void "test if it's possible to create a ProdutoController instance"(){
        assert new ProdutoController() != null
    }
}
