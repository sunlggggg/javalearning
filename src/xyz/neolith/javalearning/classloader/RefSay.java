package xyz.neolith.javalearning.classloader;

import xyz.neolith.javalearning.classloader.Say;

public class RefSay implements Say {
	@Override
	public void say() {
		System.out.println("I am Jack Sun");
	}

}
