package fil.car;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void maxOccuTest() {
        App a = new App();
        String test = "Je pense que le nombre d'occurence d'un mot dans une phrase devrait être le mot le plus impressionant dans cette phrase pour les bienfaits du test ! C'est pourquoi j'ai jeté mon dévolu sur le le le le le le le ";
        String[] result = test.split("\\s");

        Assert.assertEquals("le", a.maxOccu(result));
    }
}
