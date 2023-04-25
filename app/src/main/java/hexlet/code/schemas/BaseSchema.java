package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    private boolean canBeNullable;
    private List<Predicate> conditions;

    public BaseSchema() {
        this.canBeNullable = true;
        this.conditions = new ArrayList<>();
    }

    public BaseSchema required() {
        this.canBeNullable = false;
        return this;
    }

    public <T> boolean isValid(T obj) {

        if (obj == null || obj.equals("")) {
            return this.canBeNullable;
        }

        return this.conditions.stream()
                .allMatch(predicate -> predicate.test(obj));

    }

    public <T> void addConditions(Predicate<T> predicate) {
        if (!this.conditions.contains(predicate)) {
            this.conditions.add(predicate);
        }
    }

}
