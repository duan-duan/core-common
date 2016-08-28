package com.common.exception;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author wanghaixia-ds
 *
 */
public class MessageException extends BaseException{

	private static final long serialVersionUID = 1L;
	private List<String> messages = new ArrayList<String>();

	public MessageException() {
		super();
	}

	public MessageException(String s) {
		super(s);
		messages.add(s);
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	
}
