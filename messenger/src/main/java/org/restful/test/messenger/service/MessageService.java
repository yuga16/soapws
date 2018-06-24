package org.restful.test.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.restful.test.messenger.database.DatabaseClass;
import org.restful.test.messenger.model.Message;

public class MessageService {
private Map<Long,Message> messages =DatabaseClass.getMessages();
	public MessageService(){
		messages.put(1L,new Message(1L, "Hello World ", "Yuga"));
		messages.put(2L, new Message(2L, "Hello Java ", "Yuga"));
	}

	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message setMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
}
