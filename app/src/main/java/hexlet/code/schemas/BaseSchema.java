package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {

    private boolean canBeNullable;
    private Map<String, Predicate> conditions;

    public BaseSchema() {
        this.canBeNullable = true;
        this.conditions = new HashMap<>();
    }

    public BaseSchema required() {
        this.canBeNullable = false;
        return this;
    }

    public <T> boolean isValid(T obj) {

        if (obj == null || obj.equals("")) {
            return this.canBeNullable;
        }

        return this.conditions.values().stream()
                .allMatch(predicate -> predicate.test(obj));

    }

    public <T> void addCondition(String conditionName, Predicate<T> predicate) {
        this.conditions.put(conditionName, predicate);
    }
}
