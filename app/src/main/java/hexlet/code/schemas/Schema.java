package hexlet.code.schemas;

public class Schema {

    private boolean canBeNullable;

    public Schema() {
        this.canBeNullable = true;
    }

    public boolean getCanBeNullable() {
        return this.canBeNullable;
    }

    public void required() {
        if (!this.canBeNullable) {
            this.canBeNullable = true;
        }

        this.canBeNullable = false;
    }

    public <T> boolean isValid(T obj) {

        if (!(this instanceof StringSchema) && obj instanceof String) {
            return false;
        } else if (!(this instanceof NumberSchema) && obj instanceof Integer) {
            return false;
        }

        return this.canBeNullable || obj != null;
    }

}
