import spock.lang.Specification
import tdc2015.legacy.produto.ProdutoController

class ProdutoControllerSpockTesting extends Specification {

    def "should be able to create a controller's instance when needed"() {
        expect: new ProdutoController() is not null
    }

}