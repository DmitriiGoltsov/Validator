package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        super();
    }

    @Override
    public BaseSchema required() {
        super.required();
        super.addCondition("classCondition", Map.class::isInstance);
        return this;
    }

    public void sizeOf(Integer size) {
        this.required();
        Predicate<Map<Object, Object>> predicate = (x -> x.size() == size);
        this.addCondition("size", predicate);
    }

    public <K, V> boolean isValid(Map<K, V> map) {
        return super.isValid(map);
    }

    public BaseSchema shape(Map<String, BaseSchema> schemas) {
        addCondition(
                "shape",
                value -> {
                    return schemas.entrySet().stream().allMatch(e -> {
                        Object v = ((Map<?, ?>) value).get(e.getKey());
                        return e.getValue().isValid(v);
                    });
                });
        return this;
    }

}
