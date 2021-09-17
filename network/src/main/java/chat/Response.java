package chat;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Encoder;

public class Response {
	private String type;
	private String status;
	private String desc;
	private Encoder encoder;
	
	public Response() {
		this(null, null);
	}
	public Response(String status) {
		this(status, null);
	}
	public Response(String status, String desc) {
		super();
		this.type = "response";
		this.status = status;
		this.desc = desc;
		this.encoder = Base64.getEncoder();
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Encoder getEncoder() {
		return encoder;
	}
	public void setEncoder(Encoder encoder) {
		this.encoder = encoder;
	}
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		try {
			return type + " " + status + " " + new String(encoder.encode(desc.getBytes("utf-8")),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
}
