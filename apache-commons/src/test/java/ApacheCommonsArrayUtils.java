import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApacheCommonsArrayUtils {

    @Test
    public void whenCalledistoString_thenCorrect() {
     String[] array = {"a", "b", "c", "d"};
        assertEquals("{a,b,c,d}", ArrayUtils.toString(array));
    }
}
