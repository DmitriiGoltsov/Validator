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
        return this;
    }

    public void sizeOf(Integer size) {
        Predicate<Map<Object, Object>> predicate = (x -> x.size() == size);
        this.addConditions(predicate);
        this.required();
    }

    public <K, V> boolean isValid(Map<K, V> map) {
        return super.isValid(map);
    }

    public void shape(Map<String, BaseSchema> schemas) {


    }

}
