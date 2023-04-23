package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringSchemaTest {

    private StringSchema stringSchema;
    private Validator v;

    @BeforeEach
    void beforeEach() {

        v = new Validator();
        stringSchema = v.string();

    }

    @Test
    void isValidPlainTest() {

        boolean actual = stringSchema.isValid("");
        boolean actual2 = stringSchema.isValid(null);
        boolean actual3 = stringSchema.isValid("word");

        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual2);
        Assertions.assertTrue(actual3);
    }

    @Test
    void isValidWithRequired() {

        stringSchema.required();

        boolean actual1 = stringSchema.isValid("word");
        boolean actual2 = stringSchema.isValid("");
        boolean actual3 = stringSchema.isValid(null);

        Assertions.assertTrue(actual1);
        Assertions.assertFalse(actual2);
        Assertions.assertFalse(actual3);
    }

    @Test
    void isValidWIthLength() {

        stringSchema.minLength(5);

        boolean actual1 = stringSchema.isValid("What does the fox says?");
        boolean actual2 = stringSchema.isValid("Word!");
        boolean actual3 = stringSchema.isValid("");
        boolean actual4 = stringSchema.isValid(null);
        boolean actual5 = stringSchema.isValid("Word");

        stringSchema.minLength(0);

        boolean actual6 = stringSchema.isValid("");

        Assertions.assertTrue(actual1);
        Assertions.assertTrue(actual2);
        Assertions.assertTrue(actual6);
        Assertions.assertFalse(actual3);
        Assertions.assertFalse(actual4);
        Assertions.assertFalse(actual5);
    }


}
