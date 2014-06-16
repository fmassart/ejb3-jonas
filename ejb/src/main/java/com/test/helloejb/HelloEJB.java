package com.test.helloejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.test.ejb3.IHelloEJB;

@Remote(IHelloEJB.class)
@Stateless(mappedName = IHelloEJB.JNDI_NAME)
public class HelloEJB implements IHelloEJB {


	@Override
	public String sayHello() {
		return "hello";
	}

	@Override
	public String sayHelloTo(String name) {
		return "hello " + name;
	}
}
