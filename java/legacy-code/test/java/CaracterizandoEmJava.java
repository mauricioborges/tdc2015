import org.junit.Test;
import tdc2015.legacy.produto.ProdutoController;
import tdc2015.legacy.produto.ProdutoException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CaracterizandoEmJava {

    @Test
    public void testaSeConsigoInstanciarOController() {
        assertNotNull(new ProdutoController());
    }

    @Test//este teste falha porque o parametro é uma string vazia
    public void testaSeConsigoChamarACriacaoDeProduto() throws ProdutoException {
        assertNotNull(new ProdutoController().criar(""));

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testaSeConsigoChamarACriacaoDeProduto2() throws ProdutoException {
        new ProdutoController().criar("");

    }

    @Test
    public void testaSeConsigoChamarACriacaoDeProduto3() throws ProdutoException {
        try {
            new ProdutoController().criar("");
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals(e.getMessage(), "4");
        }

    }

    @Test
    public void testaSeConsigoChamarACriacaoDeProduto4() throws ProdutoException {
        assertNotNull(new ProdutoController().criar("a;b;c;d;e"));
    }

    @Test
    public void testaSeConsigoChamarACriacaoDeProduto5() throws ProdutoException {
        try {
            new ProdutoController().criar("a;b;c;d;e");
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "INSERT INTO PRODUTOS VALUES(NULL, \"a\", \"b\", c, \"d\", \"e\");");
        }

    }

}


/**
 * 1. cria teste simples: new ProdutoController()
 * 2. mostra os imports
 * 3. roda: tem que falhar né
 * 4. corrige o runtimeexception: tem um erro no build.gradle
 * 6. tudo passa
 * 7. cria outro teste, agor achamando a função de criação
 * 8. vai dar um errão
 */