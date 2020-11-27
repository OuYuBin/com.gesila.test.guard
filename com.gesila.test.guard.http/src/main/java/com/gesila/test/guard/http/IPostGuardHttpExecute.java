package com.gesila.test.guard.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.HttpHostConnectException;

/**
 * 
 * @author robin
 *
 */
public interface IPostGuardHttpExecute {

	public Object execute() throws HttpHostConnectException,IOException, ClientProtocolException;
}
