package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super();
    }

    @Override
    public BaseSchema required() {
        super.required();
        super.addCondition("classCondition", Integer.class::isInstance);
        return null;
    }

    public void range(int min, int max) throws Exception {

        if (max < min) {
            throw new Exception("Incorrect range. The second value should be "
                    + "greater or equal to the first one!");
        }

        Predicate<Integer> predicate = (x -> x >= min && x <= max);
        this.addCondition("range", predicate);
    }

    public BaseSchema positive() {
        Predicate<Integer> predicate = (x -> x > 0);
        this.addCondition("positive", predicate);
        this.addCondition("classCondition", Integer.class::isInstance);
        return this;
    }
}
