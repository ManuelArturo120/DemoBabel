package com.demo.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class ErrorMessage {


	@JsonProperty("reason")
	@Schema(example = "Reason - Internal Server Error", name = "reason", type = "string")
	private String reason;

	@JsonProperty("httpCode")
	@Schema(example = "HTTP Code - 400", name = "httpCode", type = "integer")
	private Integer httpCode;

	public ErrorMessage( String reason, Integer httpCode) {
		super();
		this.reason = reason;
		this.httpCode = httpCode;
	}
	
	
}
