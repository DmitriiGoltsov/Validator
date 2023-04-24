package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class NumberSchemaTest {
    private NumberSchema numberSchema;
    private Validator v;
    @BeforeEach
    void beforeEach() {

        v = new Validator();
        numberSchema = v.number();

    }

    @Test
    void isValidPlainTest() {

        boolean actual = numberSchema.isValid(10);
        boolean actual2 = numberSchema.isValid(null);
        boolean actual3 = numberSchema.isValid(-10);
        boolean actual4 = numberSchema.isValid("10");

        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual2);
        Assertions.assertTrue(actual3);
        Assertions.assertFalse(actual4);
    }

    @Test
    void isValidWithRequiredTest() {

        numberSchema.required();

        boolean actual = numberSchema.isValid(10);
        boolean actual2 = numberSchema.isValid(null);
        boolean actual3 = numberSchema.isValid(-10);
        boolean actual4 = numberSchema.isValid("10");

        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual3);
        Assertions.assertFalse(actual2);
        Assertions.assertFalse(actual4);
    }

    @Test
    void isValidWithPositiveTest() {

        numberSchema.positive();

        boolean actual = numberSchema.isValid(10);
        boolean actual2 = numberSchema.isValid(null);
        boolean actual3 = numberSchema.isValid(-10);
        boolean actual4 = numberSchema.isValid("10");

        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual2);
        Assertions.assertFalse(actual3);
        Assertions.assertFalse(actual4);

    }

    @Test
    void isValidWithRangeTest() throws Exception {

        numberSchema.range(1, 10);

        boolean actual = numberSchema.isValid(1);
        boolean actual2 = numberSchema.isValid(10);
        boolean actual3 = numberSchema.isValid(5);
        boolean actual4 = numberSchema.isValid(11);
        boolean actual5 = numberSchema.isValid(-1);
        boolean actual6 = numberSchema.isValid(null);

        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual2);
        Assertions.assertTrue(actual3);
        Assertions.assertFalse(actual4);
        Assertions.assertFalse(actual5);
        Assertions.assertFalse(actual6);
    }
}
