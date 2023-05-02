package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapSchemaTest {

    private MapSchema mapSchema;
    private Validator v;
    Map<String, String> data;
    Map<String, BaseSchema> schemas;

    @BeforeEach
    void beforeEach() {

        v = new Validator();
        mapSchema = v.map();
        data = new HashMap<>();
        data.put("key1", "value1");
        schemas = new HashMap<>();

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

        mapSchema.sizeof(2);

        boolean actual = mapSchema.isValid(data);

        data.put("key2", "value2");

        boolean actual2 = mapSchema.isValid(data);

        data.put("key3", "value3");

        boolean actual3 = mapSchema.isValid(data);

        Assertions.assertFalse(actual);
        Assertions.assertTrue(actual2);
        Assertions.assertFalse(actual3);

    }

    @Test
    void isValidWithShapeTest() {

        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());

        mapSchema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        boolean actual = mapSchema.isValid(human1); // true

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        boolean actual2 = mapSchema.isValid(human2); // true

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        boolean actual3 = mapSchema.isValid(human3); // false

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        boolean actual4 = mapSchema.isValid(human4); // false

        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual2);
        Assertions.assertFalse(actual3);
        Assertions.assertFalse(actual4);


    }

}
