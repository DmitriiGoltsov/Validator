package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        super();
    }

    @Override
    public StringSchema required() {
        super.required();
        super.addCondition("required", String.class::isInstance);
        return this;
    }

    public BaseSchema contains(String str) {
        this.required();
        Predicate<String> predicate = (x -> x.contains(str));
        this.addCondition("contains", predicate);
        minLength(str.length());
        return this;
    }

    public void minLength(int min) {
        this.required();
        Predicate<String> predicate = (x -> x.length() >= min);
        this.addCondition("minLength", predicate);
    }
}
