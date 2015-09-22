import spock.lang.Specification
import tdc2015.legacy.produto.ProdutoController

class ProdutoControllerSpockTesting extends Specification {

    def "should be able to create a controller's instance when needed"(){
        given: "that I try to create a ProdutoController instance"
            def controller = new ProdutoController();
        expect: "that the controller instance is not null"
            controller is.not(null)
    }

}
