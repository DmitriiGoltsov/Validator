package hexlet.code.Schemas;

public class Schema {

    private boolean requiredStatus;

    public Schema() {
        this.requiredStatus = false;
    }

    public Schema(boolean requiredStatus) {
        this.requiredStatus = requiredStatus;
    }

    public void required() {
        if (this.requiredStatus) {
            this.requiredStatus = false;
        }

        this.requiredStatus = true;
    }

    public boolean isRequiredStatus() {
        return requiredStatus;
    }



}
