import junit.framework.TestCase;
import org.junit.Test;
import tdc2015.legacy.produto.ProdutoController;

/**
 * Created by mauricio on 21/09/15.
 */
public class ProdutoControllerTest extends TestCase {

    @Test
    public void testIfYouCanCreateAProdutoControllerInstance() {
        assertNotNull(new ProdutoController());
    }
}
