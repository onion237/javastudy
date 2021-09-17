package http;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private static final String DOCUMENT_ROOT = "./webapp";
	private Socket socket;

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());

			String requestURL = br.readLine();
//			while(true) {
//				String line = br.readLine();
//				
//				// 브라우저가 연결을 끊었을 때 == 입력스트림의 끝
//				if(line == null) {
//					break;
//				}
//				// body 시작 (GET요청만 처리, BODY는 무시)
//				if("".equals(line)) {
//					break;
//				}
//				// HEADER 출력
//				consoleLog(line);
//			}
			consoleLog(requestURL);
			String[] tokens = requestURL.split(" ");
			if (!"GET".equals(tokens[0])) {
				response400Error(outputStream, tokens[1], tokens[2]);
				return;
			}

			responseStaticResource(outputStream, tokens[1], tokens[2]);

			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
//			outputStream.write("HTTP/1.1 200 OK\r\n".getBytes("UTF-8"));
//			outputStream.write("Content-Type:text/html; charset=utf-8\r\n".getBytes("UTF-8"));
//			outputStream.write("\r\n".getBytes());
//			outputStream.write("<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes("UTF-8"));

		} catch (Exception ex) {
			consoleLog("error:" + ex);
		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}

			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}

	private void responseStaticResource(OutputStream outputStream, String url, String protocol) throws IOException {
		// welcome file
		if ("/".equals(url))
			url = DOCUMENT_ROOT + "/index.html";

		File resource = new File(url);

		if (!resource.exists()) {
			response404Error(outputStream, url, protocol);
			return;
		}
		
		// GET / HTTP/1.1
		
		String status = "200 OK";
		response(outputStream, url, protocol, status, resource);
	}

	private void response(OutputStream outputStream, String url, String protocol, String status, File resource) throws IOException {
		byte[] body = Files.readAllBytes(resource.toPath());
		
		String contentType = Files.probeContentType(resource.toPath());
		
		// HTTP/1.1 400 Bad Request
		// ContentType: asdfasdfasdfasdfsadf
		// 
	
		outputStream.write((protocol + " " + status +"\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\n").getBytes("UTF-8"));
		outputStream.write("\n".getBytes());
		
		//html파일이 디스크에 utf-8과 호환되지 않는 인코딩으로 저장되어있다면 응답이 깨질 수 있음(클라이언트에는 body를 utf-8으로 해석하려하지만 실제 body는 다른 인코딩 방식으로 표현되어 있는 경우)
		outputStream.write(body);
	}

	private void response404Error(OutputStream outputStream, String url, String protocol) throws UnsupportedEncodingException, IOException {
		File resource = new File(DOCUMENT_ROOT + "/error/404.html");
		response(outputStream, url, protocol, "404 Not Found", resource);		
	}

	private void response400Error(OutputStream outputStream, String url, String protocol) throws UnsupportedEncodingException, IOException {
		File resource = new File(DOCUMENT_ROOT + "/error/400.html");		
		response(outputStream, url, protocol, "400 Bad Request", resource);
	}

	public void consoleLog(String message) {
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}
}
