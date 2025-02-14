package com.demor.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import static com.demo.constant.Constants.UNDEFINED;

@Getter
@Setter
public class DataForLogs {

    private String xTransactionId = UNDEFINED;
    private String pnr = UNDEFINED;
    private String channel = UNDEFINED;
    private String urlRequest = UNDEFINED;
    private String bodyRequest = UNDEFINED;
    private String store = UNDEFINED;
    private Map<String, String> mapHeader;
	public String getxTransactionId() {
		return xTransactionId;
	}
	public void setxTransactionId(String xTransactionId) {
		this.xTransactionId = xTransactionId;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getUrlRequest() {
		return urlRequest;
	}
	public void setUrlRequest(String urlRequest) {
		this.urlRequest = urlRequest;
	}
	public String getBodyRequest() {
		return bodyRequest;
	}
	public void setBodyRequest(String bodyRequest) {
		this.bodyRequest = bodyRequest;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public Map<String, String> getMapHeader() {
		return mapHeader;
	}
	public void setMapHeader(Map<String, String> mapHeader) {
		this.mapHeader = mapHeader;
	}
}