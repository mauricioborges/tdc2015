import junit.framework.TestCase;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import tdc2015.legacy.produto.ProdutoController;

public class ProdutoControllerJavaTesting extends TestCase {

    @Test
    public void testIfYouCanCreateAProdutoControllerInstance() {
        assertThat(new ProdutoController(), is(not(nullValue())));
    }
}
