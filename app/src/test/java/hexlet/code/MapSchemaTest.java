package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapSchemaTest {

    private MapSchema mapSchema;
    private Validator v;

    Map<String, String> data;

    @BeforeEach
    void beforeEach() {

        v = new Validator();
        mapSchema = v.map();
        data = new HashMap<>();
        data.put("key1", "value1");

    }

    @Test
    void isValidPlainTest() {

        boolean actual = mapSchema.isValid(null);
        boolean actual2 = mapSchema.isValid(new HashMap<>());
        boolean actual3 = mapSchema.isValid(data);

        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual2);
        Assertions.assertTrue(actual3);

    }

    @Test
    void isValidWithRequiredTest() {

        mapSchema.required();

        boolean actual = mapSchema.isValid(null);
        boolean actual2 = mapSchema.isValid(new HashMap<>());
        boolean actual3 = mapSchema.isValid(data);

        Assertions.assertFalse(actual);
        Assertions.assertTrue(actual2);
        Assertions.assertTrue(actual3);
    }

    @Test
    void isValidWithRequiredSizeTest() {

        mapSchema.sizeOf(2);

        boolean actual = mapSchema.isValid(data);

        data.put("key2", "value2");

        boolean actual2 = mapSchema.isValid(data);

        data.put("key3", "value3");

        boolean actual3 = mapSchema.isValid(data);

        Assertions.assertFalse(actual);
        Assertions.assertTrue(actual2);
        Assertions.assertFalse(actual3);

    }

}
