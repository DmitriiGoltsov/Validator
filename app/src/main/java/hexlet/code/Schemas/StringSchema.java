package hexlet.code.Schemas;

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

        int strLength = str.length();
        boolean currentRequire = super.isRequiredStatus();

        if (currentRequire && this.minimalLength != -1) {
            return (!str.isEmpty()) && str != null && strLength >= minimalLength;
        } else if (!currentRequire && this.minimalLength != -1) {
            return strLength >= this.minimalLength;
        } else if (currentRequire && minimalLength == -1) {
            return !str.isEmpty() && str != null;
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
