package com.demor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String channel;
	private String flow;
	private String xTransactionId;
	private String store;
	private String pnr;
	private String contentType;

	

}
