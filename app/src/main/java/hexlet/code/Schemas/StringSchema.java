package hexlet.code.Schemas;

import java.util.Optional;

public class StringSchema extends Schema {
    private int minimalLength;

    private String stringContent;

    public StringSchema() {
        super(false);
        this.minimalLength = -1;
        this.stringContent = "";
    }

    @Override
    public void required() {
        super.required();
    }

    private void setMinimalLength(int minimalLength) {
        this.minimalLength = minimalLength;
    }

    private void setStringContent(String stringContent) {
        this.stringContent = stringContent;
    }

    @Override
    public boolean isRequiredStatus() {
        return super.isRequiredStatus();
    }

    public int getMinimalLength() {
        return minimalLength;
    }

    public String getStringContent() {
        return stringContent;
    }

    public boolean isValid(String str) {

        boolean currentRequire = this.isRequiredStatus();
        int currentMinLength = this.minimalLength;

        if (currentRequire && (str == null || str.isEmpty())) {
            return false;
        } else if (currentMinLength != -1 && str == null) {
            return false;
        } else if (currentMinLength != -1 && !currentRequire) {
            return str.length() >= minimalLength;
        }

        return true;
    }

    public void contains(String str) {
        setStringContent(str);
    }


    public void minLength(int min) {
        setMinimalLength(min);
    }
}
