package com.aeromexico.am.ab.ancillary.offer.dto;

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

	public CustomerDTO(String channel, String flow, String xTransactionId, String store, String pnr) {
		super();
		this.channel = channel;
		this.flow = flow;
		this.xTransactionId = xTransactionId;
		this.store = store;
		this.pnr = pnr;
	}

	public String getChannel() {
		return StringUtils.isNotEmpty(channel) ? channel.toLowerCase() : "";
	}
}
