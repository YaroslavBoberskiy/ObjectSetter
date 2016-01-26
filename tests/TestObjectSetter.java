import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestObjectSetter {

    Object object;

    @Before
    public void testSetup() {
        ObjectSetter objectCreator = new ObjectSetter();
        Map<String, Object> hm = new HashMap<String, Object>();

        hm.put("VIN", "VIN11909");
        hm.put("color", Color.black);
        hm.put("price", 12900);

        object = objectCreator.setPrivates(Car.class, hm);
    }

    @Test
    public void testAllFieldsIsPrivate() {
        boolean isPrivate = true;
        Field[] fs = Car.class.getFields();
        for (Field f : fs) {
            if (f.isAccessible() == false) {
                isPrivate = false;
            }
        }
        assertTrue(isPrivate);
    }

    @Test
    public void testObjectSetterReturnsRightObject() {
        assertEquals(Car.class, object.getClass());
    }

    @Test
    public void testObjectSetterSetsAllFields() throws IllegalAccessException {
        boolean isNull = false;
        Field[] fs = object.getClass().getDeclaredFields();
        for (Field f : fs) {
            f.setAccessible(true);
            if(f.get(object) == null) {
                isNull = true;
            }
        }
        assertFalse(isNull);
    }
}

