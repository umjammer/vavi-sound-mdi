package musicDriverInterface.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


class AutoExtendListTest {

    @Test
    void testSetExtendsListWithInteger() {
        AutoExtendList<Integer> list = new AutoExtendList<>(Integer.class);
        
        assertEquals(0, list.size(), "Initial size should be 0");
        
        // Setting a value at an index greater than the current size
        // should pad the list with default values (0 for Integer)
        list.set(5, 42);
        
        assertEquals(6, list.size(), "List should be extended to size 6");
        for (int i = 0; i < 5; i++) {
            assertEquals(0, list.get(i), "Padded value at index " + i + " should be 0");
        }
        assertEquals(42, list.get(5), "Value at index 5 should be the set value");
    }

    @Test
    void testSetExtendsListWithByte() {
        AutoExtendList<Byte> list = new AutoExtendList<>(Byte.class);
        
        list.set(2, (byte) 99);
        
        assertEquals(3, list.size());
        assertEquals((byte) 0, list.get(0));
        assertEquals((byte) 0, list.get(1));
        assertEquals((byte) 99, list.get(2));
    }

    static class Dummy {
        // Will be created via reflection using the default no-arg constructor
    }

    @Test
    void testSetExtendsListWithCustomClass() {
        AutoExtendList<Dummy> list = new AutoExtendList<>(Dummy.class);
        
        Dummy myDummy = new Dummy();
        list.set(2, myDummy);
        
        assertEquals(3, list.size());
        assertNotNull(list.get(0), "Padded element should be instantiated");
        assertNotNull(list.get(1), "Padded element should be instantiated");
        assertEquals(myDummy, list.get(2));
    }

    @Test
    void testSetExtendsListWithNoDefaultConstructor() {
        // Void class doesn't have a public constructor, so it will fail to instantiate
        AutoExtendList<Void> list = new AutoExtendList<>(Void.class);
        
        list.set(2, null);
        
        assertEquals(3, list.size());
        // The fallback mechanism in createInstance() catches exceptions and returns null
        assertNull(list.get(0));
        assertNull(list.get(1));
        assertNull(list.get(2));
    }
}
