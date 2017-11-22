package main;
import view.view;


import model.*;

import java.util.Observer;

import controller.controller;

public class main {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		model m = new model();
		view view = new view();
		view.init();
		
		controller c = new controller(m);//, view.getField() , view.getLabel()
		
		view.getButton().addActionListener(c);
		
		m.serial.addObserver(view);
		//model.addObserver(view.getLabel2());
		//model.addObserver(view.getLabel3());

		//view v = new view();
		
		
		

	}

}
