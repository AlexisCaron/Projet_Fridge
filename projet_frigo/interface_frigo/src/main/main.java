package main;
import view.view;

import model.*;
import java.util.Observer;
import org.jfree.ui.RefineryUtilities;
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
		
		/*
        final graphTemp demo = new graphTemp("Line Chart Demo 6",m);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        */
		//model.addObserver(view.getLabel2());
		//model.addObserver(view.getLabel3());

		//view v = new view();
		
		
		

	}

}
