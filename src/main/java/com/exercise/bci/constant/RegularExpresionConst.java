package com.exercise.bci.constant;

public class RegularExpresionConst {

	public static final String REGULAR_EXPRESION_DATE = "";
	public static final String REGULAR_EXPRESION_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String REGULAR_EXPRESION_PASSWORD = 
			"^(?=.?[A-Z]){1,1}(?=.?[a-z])(?=.*?[0-9]){2,2}.{8,12}$";
}
