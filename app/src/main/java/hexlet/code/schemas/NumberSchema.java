package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super();
    }

    @Override
    public BaseSchema required() {
        super.required();
        super.addConditions("classCondition", Integer.class::isInstance);
        return null;
    }

    public void range(int min, int max) throws Exception {

        if (max < min) {
            throw new Exception("Incorrect range. The second value should be "
                    + "greater or equal to the first one!");
        }

        this.required();
        Predicate<Integer> predicate = (x -> x >= min && x <= max);
        this.addConditions("range", predicate);
    }

    public BaseSchema positive() {
        Predicate<Integer> predicate = (x -> x > 0);
        this.addConditions("positive", predicate);
        this.addConditions("classCondition", Integer.class::isInstance);
        return this;
    }

    public <T> boolean isValid(T number) {
        return super.isValid(number);
    }
}
