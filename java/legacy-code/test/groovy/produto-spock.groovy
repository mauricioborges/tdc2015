import spock.lang.Specification
import tdc2015.legacy.produto.ProdutoController

class ProdutoControllerTestingSpock extends Specification {

    def "should i stay"(){
        given:
            def controller = new ProdutoController();
        when:
            def produtoCriado = controller.criar(null);
        then:
        produtoCriado is(null)
    }

}