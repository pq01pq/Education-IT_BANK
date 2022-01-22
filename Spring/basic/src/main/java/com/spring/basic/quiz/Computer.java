package com.spring.basic.quiz;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer {
	
//	@Autowired
	private Monitor monitor;
//	@Autowired
	private Mouse mouse;
//	@Autowired
	private Keyboard keyboard;
	
	
	@Autowired
	public Computer(Monitor monitor, Mouse mouse, Keyboard keyboard) {
		super();
		this.monitor = monitor;
		this.mouse = mouse;
		this.keyboard = keyboard;
	}

	public void computerInfo() {
		System.out.println("*** 컴퓨터 정보 ***");
		monitor.info();
		keyboard.info();
		mouse.info();
	}
}
