package hexlet.code.schemas;

public class Schema {

    private boolean canBeNullable;

    public Schema() {
        this.canBeNullable = true;
    }

    public Schema(boolean canBeNullable) {
        this.canBeNullable = canBeNullable;
    }

    public boolean canBeNullable() {
        return this.canBeNullable;
    }

    public void required() {
        if (!this.canBeNullable) {
            this.canBeNullable = true;
        }

        this.canBeNullable = false;
    }

    public boolean isCannotBeNullable() {
        return canBeNullable;
    }

    public <T> boolean isValid(T obj) {

        if (!(this instanceof StringSchema) && obj instanceof String) {
            return false;
        }

        return this.canBeNullable || obj != null;
    }

}
