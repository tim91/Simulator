package org.tstraszewski.model.validator;

import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FlyHistoryParametersValidator implements ConstraintValidator<FlyHistoryParamterRange, Float> {

	private float min;
	private float max;
	public void initialize(FlyHistoryParamterRange arg0) {
		min = arg0.min();
		max = arg0.max();
		
	}


	public boolean isValid(Float val, ConstraintValidatorContext arg1) {
		
		if(val >= min && val <= max ){
			return true;
		}
		throw new ConstraintDeclarationException("Invalid value: " + val);
	}

}
