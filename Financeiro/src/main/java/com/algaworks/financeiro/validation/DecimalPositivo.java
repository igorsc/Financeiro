package com.algaworks.financeiro.validation;

import  java.lang.annotation.*;
import javax.validation.*;
import javax.validation.constraints.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@NotNull
@DecimalMin("0")
public @interface DecimalPositivo {
	
	@OverridesAttribute(constraint = DecimalMin.class, name = "message")
	String message() default "{com.algaworks.NumeroDecimal.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
