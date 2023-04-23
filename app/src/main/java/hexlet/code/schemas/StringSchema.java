package hexlet.code.schemas;

public class StringSchema extends Schema {

    private int minimalLength;
    private String stringContent;

    public StringSchema() {
        super(true);
        this.minimalLength = -1;
        this.stringContent = "";
    }

    private void setMinimalLength(int minLength) {
        this.minimalLength = minLength;
    }

    private void setStringContent(String stringContent) {
        this.stringContent = stringContent;
    }

    public int getMinimalLength() {
        return this.minimalLength;
    }

    public String getStringContent() {
        return this.stringContent;
    }

    @Override
    public void required() {
        super.required();
        this.minLength(1);
    }

    public void contains(String str) {
        setStringContent(str);
        super.required();
        minLength(str.length());
    }

    public void minLength(int min) {
        setMinimalLength(min);
        super.required();
    }

    public <T> boolean isValid(String str) {

        if (!super.isValid(str)) {
            return false;
        } else if (!this.stringContent.equals("") && !str.contains(this.stringContent)) {
            return false;
        } else {
            return (this.minimalLength == -1 || str.length() >= this.minimalLength);
        }
    }

}
