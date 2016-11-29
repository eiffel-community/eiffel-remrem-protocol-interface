package com.ericsson.eiffel.remrem.protocol;

public class ValidationResult {

    private boolean valid = true;
    private String validationMesage;

    public ValidationResult() {
        super();
    }
    public ValidationResult(boolean valid, String validationMesage) {
        this.valid = valid;
        this.validationMesage = validationMesage;
    }
}
