package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {

    private boolean canBeNullable;
    private Map<String, Predicate> conditions;
    private Map<String, BaseSchema> shapes;

    public BaseSchema() {
        this.canBeNullable = true;
        this.conditions = new HashMap<>();
        this.shapes = new HashMap<>();
    }

    public BaseSchema required() {
        this.canBeNullable = false;
        return this;
    }

    public <T> boolean isValid(T obj) {

        if (!this.shapes.isEmpty() && obj instanceof Map<?, ?>) {
            for (Map.Entry<String, BaseSchema> entry : shapes.entrySet()) {
                if (((Map<?, ?>) obj).containsKey(entry.getKey())) {
                    var result = entry.getValue().isValid(((Map<?, ?>) obj).get(entry.getKey()));
                    if (!result) {
                        return false;
                    }
                }
            }

            return true;
        }

        if (obj == null || obj.equals("")) {
            return this.canBeNullable;
        }

        return this.conditions.values().stream()
                .allMatch(predicate -> predicate.test(obj));

    }

    public <T> void addConditions(String conditionName, Predicate<T> predicate) {
        this.conditions.put(conditionName, predicate);
    }

    public void addShape(Map<String, BaseSchema> schema) {
        shapes.putAll(schema);
    }

}
