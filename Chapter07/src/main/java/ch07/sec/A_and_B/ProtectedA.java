package ch07.sec.A_and_B;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProtectedA {
    protected String field;

    protected void method(){}

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
