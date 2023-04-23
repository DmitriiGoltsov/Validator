package hexlet.code.schemas;

public class NumberSchema extends Schema {
    private boolean hasToBePositive;
    boolean hasRange;
    private final Integer[] range = new Integer[2];

    public NumberSchema() {
        super(true);
        this.hasToBePositive = false;
        this.hasRange = false;
    }

    @Override
    public void required() {
        super.required();
    }

    public void range(int min, int max) throws Exception {

        if (max < min) {
            throw new Exception("Incorrect range. The second value should be "
                    + "greater or equal to the first one!");
        }

        super.required();
        this.hasRange = true;
        range[0] = min;
        range[1] = max;
    }

    public void positive() {
        this.hasToBePositive = true;
    }

    public boolean isValid(int number) {

        if (!super.isValid(number)) {
            return false;
        } else if (this.hasToBePositive && number <= 0) {
            return false;
        } else {
            return !this.hasRange || (number >= this.range[0] && number <= this.range[1]);
        }

    }

}
