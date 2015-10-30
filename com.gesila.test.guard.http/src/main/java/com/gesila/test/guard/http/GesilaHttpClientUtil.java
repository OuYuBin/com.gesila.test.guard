package com.gesila.test.guard.http;

import com.gesila.test.guard.model.testGuard.RequestMethod;

/**
 * 
 * @author robin
 *
 */
public class GesilaHttpClientUtil {

	public static Object execute(IGesilaHttpClient gesilaHttpClient) {
		IGesilaHttpExecute httpExectue = createExectue(gesilaHttpClient);
		return httpExectue.execute();
	}

	private static IGesilaHttpExecute createExectue(IGesilaHttpClient gesilaHttpClient) {
		RequestMethod requestType = gesilaHttpClient.getRequestMethod();
		IGesilaHttpExecute httpExectue = null;
		switch (requestType) {
		case POST:
			httpExectue = new GesilaPostHttpExecute(gesilaHttpClient);
			break;
		case PUT:
			httpExectue=new GesilaGetHttpExecute(gesilaHttpClient);
			break;
		}
		return httpExectue;
	}

}
