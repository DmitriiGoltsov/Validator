package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema {
    private String stringContent;
    private int minLength;

    public StringSchema() {
        super();
        Predicate<String> predicate = (x -> x instanceof String);
        this.addConditions(predicate);
    }

    @Override
    public BaseSchema required() {
        super.required();
        return this;
    }

    public void contains(String str) {
        this.stringContent = str;
        Predicate<String> predicate = (x -> x.contains(stringContent));
        this.addConditions(predicate);
        this.required();
        minLength(str.length());
    }

    public void minLength(int min) {
        this.minLength = min;
        Predicate<String> predicate = (x -> x.length() >= min);
        this.addConditions(predicate);
        this.required();
    }

    public boolean isValid(String str) {
        return super.isValid(str);
    }

}
