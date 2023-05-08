package hexlet.code.schemas;

import java.util.Objects;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        super();
    }

    @Override
    public StringSchema required() {
        super.required();
        super.addCondition("required", String.class::isInstance);
        return this;
    }

    public BaseSchema contains(String sequence) {
        this.addCondition("contains", obj -> ((String) obj).contains(sequence));
        return this;
    }

    public StringSchema minLength(int min) {
        this.addCondition("minLength", (obj -> ((String) obj).length() >= min));
        return this;
    }
}
