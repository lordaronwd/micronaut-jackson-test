package test.jackson;

import java.math.BigDecimal;

public class TestPojo {

    private BigDecimal decimal;

    public TestPojo() {
    }

    public TestPojo(BigDecimal decimal) {
        this.decimal = decimal;
    }

    public BigDecimal getDecimal() {
        return decimal;
    }

    public void setDecimal(BigDecimal decimal) {
        this.decimal = decimal;
    }
}
