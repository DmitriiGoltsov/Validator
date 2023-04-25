package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super();
    }

    @Override
    public BaseSchema required() {
        super.required();
        return null;
    }

    public void range(int min, int max) throws Exception {

        if (max < min) {
            throw new Exception("Incorrect range. The second value should be "
                    + "greater or equal to the first one!");
        }

        this.required();
        Predicate<Integer> predicate = (x -> x >= min && x <= max);
        this.addConditions(predicate);
    }

    public BaseSchema positive() {
        Predicate<Integer> predicate = (x -> x > 0);
        this.addConditions(predicate);
        return this;
    }

    public boolean isValid(Integer number) {
       return super.isValid(number);
    }
}
