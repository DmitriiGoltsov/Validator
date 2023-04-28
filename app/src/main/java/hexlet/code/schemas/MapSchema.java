package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        super();
    }

    @Override
    public BaseSchema required() {
        super.required();
        super.addConditions("classCondition", Map.class::isInstance);
        return this;
    }

    public void sizeOf(Integer size) {
        this.required();
        Predicate<Map<Object, Object>> predicate = (x -> x.size() == size);
        this.addConditions("size", predicate);
    }

    public <K, V> boolean isValid(Map<K, V> map) {
        return super.isValid(map);
    }

    public void shape(Map<String, BaseSchema> schemas) {
        super.addShape(schemas);


    }

}
