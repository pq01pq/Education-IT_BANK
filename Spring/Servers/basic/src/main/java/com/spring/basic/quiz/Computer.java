package com.spring.basic.quiz;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer {
	
	private Monitor monitor;
	private Mouse mouse;
	private Keyboard keyboard;
		
	@Autowired
	public Computer(Monitor monitor, Mouse mouse, Keyboard keyboard) {
		super();
		this.monitor = monitor;
		this.mouse = mouse;
		this.keyboard = keyboard;
	}



	public void computerInfo() {
		System.out.println("*** 컴퓨터의 정보 ***");
		monitor.info();
		keyboard.info();
		mouse.info();
	}

}
