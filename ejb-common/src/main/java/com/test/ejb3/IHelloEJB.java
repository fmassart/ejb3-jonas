package com.test.ejb3;

public interface IHelloEJB {

	public static final String JNDI_NAME = "SAMPLE_EJB";

	public String sayHello();

	public String sayHelloTo(String name);

}
