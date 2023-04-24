package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends Schema {

    private int requiredSize;
    private boolean hasRequiredSize;

    public MapSchema() {
        super();
        this.hasRequiredSize = false;
    }

    private void setRequiredSize(int requiredSize) {
        this.requiredSize = requiredSize;
    }

    @Override
    public void required() {
        super.required();
    }

    public void sizeOf(Integer size) {
        setRequiredSize(size);
        this.hasRequiredSize = true;
    }

    public <K, V> boolean isValid(Map<K, V> map) {

        if (!super.isValid(map)) {
            return false;
        } else {
            return !this.hasRequiredSize || (this.requiredSize == map.size());
        }
    }

}
