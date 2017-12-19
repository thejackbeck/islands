import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class IslandFinderTest {
    private static final Logger LOGGER = Logger.getLogger( IslandFinderTest.class.getName() );
    private Set<Islet> islets_1;
    private Set<Islet> islets_2;

    @Before
    public void setUp() {
        /* There are 4 islands in this structure
        *  0,0,0,0,0,X,X,0,X
        *  X,0,X,0,0,X,0,0,X
        *  X,0,X,0,0,0,0,0,X
        *  0,X,0,0,X,X,X,0,X
        *  0,X,0,0,X,0,X,0,0
        *  0,0,0,0,X,X,X,0,0
        */

        islets_1 = new HashSet<Islet>();
        islets_1.add(new Islet(5,0));
        islets_1.add(new Islet(6,0));
        islets_1.add(new Islet(8,0));

        islets_1.add(new Islet(0,1));
        islets_1.add(new Islet(2,1));
        islets_1.add(new Islet(5,1));
        islets_1.add(new Islet(8,1));

        islets_1.add(new Islet(0,2));
        islets_1.add(new Islet(2,2));
        islets_1.add(new Islet(8,2));

        islets_1.add(new Islet(1,3));
        islets_1.add(new Islet(4,3));
        islets_1.add(new Islet(5,3));
        islets_1.add(new Islet(6,3));
        islets_1.add(new Islet(8,3));

        islets_1.add(new Islet(1,4));
        islets_1.add(new Islet(4,4));
        islets_1.add(new Islet(6,4));

        islets_1.add(new Islet(4,5));
        islets_1.add(new Islet(5,5));
        islets_1.add(new Islet(6,5));

        /* There are 2 islands in this structure
        *  X,0,0,X
        *  0,X,0,X
        */
        islets_2 = new HashSet<Islet>();
        islets_2.add(new Islet(0,0));
        islets_2.add(new Islet(3,0));
        islets_2.add(new Islet(1,1));
        islets_2.add(new Islet(3,1));
    }

    @Test
    public void findIslands() throws Exception {
        Map<Integer, Set<Islet>> islands = new IslandFinder().findIslands(islets_1);
        Assert.assertEquals(4l, islands.size());

        for (Set<Islet> island : islands.values()) {
            LOGGER.info("Island -> " + island);
        }
    }

}