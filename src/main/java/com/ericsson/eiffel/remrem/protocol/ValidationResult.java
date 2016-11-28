package com.ericsson.eiffel.remrem.protocol;

public class ValidationResult {
	
	private boolean valid;
	private String validationMesage;
	
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getValidationMesage() {
		return validationMesage;
	}
	public void setValidationMesage(String validationMesage) {
		this.validationMesage = validationMesage;
	}

}
