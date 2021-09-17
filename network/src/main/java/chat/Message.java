package chat;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;

public class Message {
	private String type;
	private String content;
	private String contentEncoded;
	private String sender;
	private String senderEncoded;
	private String receiver;
	private String receiverEncoded;
	private Encoder encoder;
	
	private final static List<String> methodList = Arrays.asList(new String[] { "join", "quit", "msg" });

	public Message(String type, String content, String sender, String receiver) throws IllegalTypeException {
		encoder = Base64.getEncoder();
		
		if (!methodList.contains(type))
			throw new IllegalTypeException("유효하지 않은 메시지 유형입니다.");
		
		this.type = type;
		if(content != null) setContent(content);
		if(sender != null) setSender(sender);
		
		if (receiver == null)
			setReceiver("all");
		else
			setReceiver(receiver);
	}

	public Message(String type) throws IllegalTypeException {
		this(type, null, "system", null);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSender() {
		return sender;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		try {
			this.contentEncoded = new String(encoder.encode(content.getBytes("utf-8")), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String Type() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
		try {
			this.senderEncoded = new String(encoder.encode(sender.getBytes("utf-8")), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
		try {
			this.receiverEncoded = new String(encoder.encode(receiver.getBytes("utf-8")), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setContentEncoded(String contentEncoded) {
		this.contentEncoded = contentEncoded;
	}
	
	public String getContentEncoded() {
		return this.contentEncoded;
	}
	
	public String getSenderEncoded() {
		return senderEncoded;
	}

	public void setSenderEncoded(String senderEncoded) {
		this.senderEncoded = senderEncoded;
	}

	public String getReceiverEncoded() {
		return receiverEncoded;
	}

	public void setReceiverEncoded(String receiverEncoded) {
		this.receiverEncoded = receiverEncoded;
	}

	@Override
	public String toString() {
		return type + " " + contentEncoded + " " + senderEncoded + " " + receiverEncoded;
	}
}
