package com.gesila.test.guard.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.HttpHostConnectException;

/**
 * 
 * @author robin
 *
 */
public class PostGuardHttpClientUtil {

	public static Object execute(IPostGuardHttpClient commonHttpClient)
			throws IOException, ClientProtocolException, HttpHostConnectException {
		IPostGuardHttpExecute httpExectue = createExectue(commonHttpClient);
		Object result = httpExectue.execute();
		return result;
	}

	private static IPostGuardHttpExecute createExectue(IPostGuardHttpClient commonHttpClient) {
		String requestType = commonHttpClient.getRequestMethod();
		IPostGuardHttpExecute httpExectue = null;
		if (requestType.equals(IPostGuardHttpClient.POST_METHOD)) {
			httpExectue = new PostGuardPostHttpExecute(commonHttpClient);
		} else if (requestType.equals(IPostGuardHttpClient.METHOD_PUT)) {
			httpExectue = new PostGuardPutHttpExecute(commonHttpClient);
		} else if (requestType.equals(IPostGuardHttpClient.METHOD_DELETE)) {
			httpExectue = new PostGuardDeleteHttpExecute(commonHttpClient);
		} else{
			httpExectue = new PostGuardGetHttpExecute(commonHttpClient);
		}
		return httpExectue;
	}

}
