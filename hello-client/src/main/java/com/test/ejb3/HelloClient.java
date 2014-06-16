package com.test.ejb3;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HelloClient {

	public static void main(String[] args) {
		HelloClient client = new HelloClient();
		client.callEJB();
	}

	public void callEJB() {
		try {
			IHelloEJB helloEJB = (IHelloEJB) getCtx().lookup(IHelloEJB.JNDI_NAME);
			String response = helloEJB.sayHelloTo("fred");
			System.out.println("Response from EJB " + response);
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	private Context getCtx() throws NamingException {
		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put(Context.URL_PKG_PREFIXES, "org.objectweb.jonas.naming");
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.objectweb.carol.jndi.spi.MultiOrbInitialContextFactory");
		props.put(Context.PROVIDER_URL, "rmi://localhost:1099");
		return new InitialContext(props);
	}
}
