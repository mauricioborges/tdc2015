import junit.framework.TestCase;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import tdc2015.legacy.produto.ProdutoController;

/**
 * Created by mauricio on 21/09/15.
 */
public class ProdutoControllerJavaTesting extends TestCase {

    @Test
    public void testIfYouCanCreateAProdutoControllerInstance() {
        assertThat(new ProdutoController(), is(not(nullValue())));
    }
}
