package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    private String stringContent;
    private int minLength;

    public StringSchema() {
        super();
    }

    @Override
    public StringSchema required() {
        super.required();
        super.addConditions("required", String.class::isInstance);
        return this;
    }

    public void contains(String str) {
        this.required();
        this.stringContent = str;
        Predicate<String> predicate = (x -> x.contains(stringContent));
        this.addConditions("contains", predicate);
        minLength(str.length());
    }

    public void minLength(int min) {
        this.required();
        this.minLength = min;
        Predicate<String> predicate = (x -> x.length() >= minLength);
        this.addConditions("minLength", predicate);
    }

    public boolean isValid(String str) {
        return super.isValid(str);
    }

}
