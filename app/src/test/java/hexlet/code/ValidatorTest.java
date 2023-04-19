package hexlet.code;

import hexlet.code.Schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    private StringSchema stringSchema;
    private Validator v;

    @BeforeEach
    void beforeEach() {

        v = new Validator();
        stringSchema = v.string();

    }

    @Test
    void requiredTest() {

        var expected = false;
        var actual = stringSchema.isRequiredStatus();

        stringSchema.required();

        var expected2 = true;
        var actual2 = stringSchema.isRequiredStatus();

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    void isValidTestPlain() {

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

        stringSchema.minLength(0);

        boolean actual5 = stringSchema.isValid("");

        Assertions.assertTrue(actual1);
        Assertions.assertTrue(actual2);
        Assertions.assertTrue(actual5);
        Assertions.assertFalse(actual3);
        Assertions.assertFalse(actual4);
    }


}
