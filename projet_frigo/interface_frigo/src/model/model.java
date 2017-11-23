package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class model extends Observable{

	public SerialTest serial;	
	
	private String tempExt;
	private String tempInt;
	private String tempMod;
	private String tempRos;
	private String hum;
	
	public List<String> listetempExt; //= new ArrayList<String>();
	public List<String> listetempInt;
	public List<String> listetempMod;
	public List<String> listetempRos;
	public List<String> listehum;



public model()
{
	
	this.serial = startcom2();
	this.listetempExt = new ArrayList<String>();
	this.listetempInt = new ArrayList<String>();
	this.listetempMod = new ArrayList<String>();
	this.listetempRos = new ArrayList<String>();
	this.listehum = new ArrayList<String>();
	//testEnvoie(this.main);
}
    	   	 

	public List<String> getListetempExt() {
	return listetempExt;
}


public List<String> getListetempInt() {
	return listetempInt;
}


public List<String> getListetempMod() {
	return listetempMod;
}


public List<String> getListetempRos() {
	return listetempRos;
}


public List<String> getListehum() {
	return listehum;
}


	private SerialTest startcom2()
	{
		SerialTest main = new SerialTest(this);
		main.initialize();
		Thread t=new Thread() { public void run() {try {Thread.sleep(1000000);} catch (InterruptedException ie) {}}};
//the following line will keep this app alive for 1000 seconds,
//waiting for events to occur and responding to them (printing incoming messages to console).
		t.start();
		System.out.println("Started");
		return main;
	}
	
	
	
	
		
   
	//acesseur
	
	public String getTempExt() {
		return tempExt;
	}
	
	


	public void setTempExt(String tempExt) {
		this.tempExt = tempExt;
		System.out.println(tempExt);
	}


	public String getTempInt() {
		return tempInt;
	}


	public void setTempInt(String tempInt) {
		this.tempInt = tempInt;
		System.out.println(tempInt);

	}


	public String getTempMod() {
		return tempMod;
	}


	public void setTempMod(String tempMod) {
		this.tempMod = tempMod;
		System.out.println(tempMod);

	}


	public String getTempRos() {
		return tempRos;
	}


	public void setTempRos(String tempRos) {
		this.tempRos = tempRos;
		System.out.println(tempRos);

	}


	public String getHum() {
		return hum;
	}


	public void setHum(String hum) {
		this.hum = hum;
		System.out.println(hum);

	}
	
	
}
