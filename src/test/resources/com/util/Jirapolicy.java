package com.util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Jirapolicy(logTicketReady=true)
	@Retention (RetentionPolicy.RUNTIME)
	public @interface Jirapolicy {
		
		boolean logTicketReady();
		
		

	}



