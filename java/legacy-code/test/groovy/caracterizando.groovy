import spock.lang.Specification
import tdc2015.legacy.produto.ProdutoController

class CaracterizandoProduto extends Specification {

    def "deve ser possível instanciar o controller do produto sem nenhum argumento"() {
        expect:
        new ProdutoController() != null
    }

    def "deve conseguir executar a criação passando uma string vazia"() {
        expect: "que este teste falhe porque vai ocorrer uma exceção não tratada"
        new ProdutoController().criar("")
    }

    def "deve falhar ao executar a criação de produto passando string vazia"() {
        when:
        new ProdutoController().criar("")
        then:
        def ex = thrown(ArrayIndexOutOfBoundsException)
        ex.message == "4"
    }

    def "deve retornar um objeto não nulo quando utilizar um array separado por ; na chamada da criação"() {
        expect: "que este teste falhe porque vai ocorrer uma exceção não tratada"
        new ProdutoController().criar("a;b;c;d;e") != null
    }

    def "deve falhar ao executar a criação de produto passando uma string separada por ;"() {
        when:
        new ProdutoController().criar("a;b;c;d;e")
        then:
        def exception = thrown(RuntimeException)
        exception.message == 'INSERT INTO PRODUTOS VALUES(NULL, "a", "b", c, "d", "e");'
    }


}

/*
* 1. mesma lógica: cria o mais simples e roda
* 1. CORRIGE O BUG QUE tu encontrou lá no build.gradle! o caminho tava errado e por isso dava pau
*
* */
