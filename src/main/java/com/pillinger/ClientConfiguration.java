package com.pillinger;

public class ClientConfiguration {
	
	private String host;
	private int port;
	private int messageInterval;
	private String message;
	
	public ClientConfiguration() {
		super();		
	}
	
	public ClientConfiguration(String host, int port, int messageInterval,
			String message) {
		super();
		this.host = host;
		this.port = port;
		this.messageInterval = messageInterval;
		this.message = message;
	}
	
	public String getHost() {
		return host;
	}
	
	public int getPort() {
		return port;
	}
	
	public int getMessageInterval() {
		return messageInterval;
	}
	
	public String getMessage() {
		return message;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setMessageInterval(int messageInterval) {
		this.messageInterval = messageInterval;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ClientConfiguration [host=" + host + ", port=" + port
				+ ", messageInterval=" + messageInterval + ", message="
				+ message + "]";
	}
			
}
