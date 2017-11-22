package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.model;

public class view extends JFrame implements Observer{
 
	JPanel background1;	
	JPanel background2;	
	JButton button1;
	JComboBox<String> temperature;
	JLabel temperatureInterieur, humidite, temperatureExterieur,temperatureModule;
	JLabel TemperatureVoulue;
	

	
	public JPanel getBackground1() {
		return background1;
	}
	public JLabel getTemperatureInterieur() {
		return temperatureInterieur;
	}
	public void setTemperatureInterieur(JLabel temperatureInterieur) {
		this.temperatureInterieur = temperatureInterieur;
	}
	public JLabel getHumidite() {
		return humidite;
	}
	public void setHumidite(JLabel humidite) {
		this.humidite = humidite;
	}
	public JLabel getTemperatureExterieur() {
		return temperatureExterieur;
	}
	public void setTemperatureExterieur(JLabel temperatureExterieur) {
		this.temperatureExterieur = temperatureExterieur;
	}
	public JLabel getTemperatureVoulue() {
		return TemperatureVoulue;
	}
	public void setTemperatureVoulue(JLabel temperatureVoulue) {
		TemperatureVoulue = temperatureVoulue;
	}
	public void setTemperature(JComboBox<String> temperature) {
		this.temperature = temperature;
	}
	public void setTemperatureModule(JLabel temperatureModule) {
		this.temperatureModule = temperatureModule;
	}
	public JPanel getBackground2() {
		return background2;
	}
	
	public JLabel getTemperatureModule() {
		return temperatureModule;
	}

	public JLabel gettemperatureInterieur() {
		return temperatureInterieur;
	}
	public JLabel gethumidite() {
		return humidite;
	}
	public JLabel gettemperatureExterieur() {
		return temperatureExterieur;
	}
	public JLabel gettemperatureModule() {
		return temperatureModule;
	}
	public JComboBox getTemperature() {
		return temperature;
	}
	
	public JButton getButton() {
		return button1;
	}
	
	
	public void init(){
		
		this.setTitle("PimpMyFridge");
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(1000,500);
		

		background1 = new JPanel ();
		background2 = new JPanel ();
		
		button1 = new JButton ("Envoyer");
		
	
		temperatureInterieur = new JLabel ("Temperature Interieur: ");		
		humidite = new JLabel ("Humidité: ");
		temperatureExterieur = new JLabel ("Temperature Exterieur: ");
		temperatureModule = new JLabel ("Temperature Module : ");
				
		
		
		background1.setVisible(true);
		background2.setVisible(true);
	
		background1.setBounds(0,0, 300, 260);	
		background1.setBackground(Color.RED);
		background2.setBackground(Color.BLUE);
		
		background1.add(temperatureInterieur);
		background1.add(temperatureExterieur);
		background1.add(humidite);
	
		this.add(background1);
		this.add(background2);
		
		background2.setBounds(0,200, 300, 250);
		
		
		this.TemperatureVoulue = new JLabel("Température voulue : ");
		
	    background2.add(TemperatureVoulue);
	    background2.add(button1);
	    
		//this.temperature = new JComboBox<String>();	   
	    	
	    //temperature.addItem("bonjour");
	    
	   // background2.add(temperature);	    	    
	  			
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {		
	model m = (model) arg1;	
	this.temperatureInterieur.setText("Température intérieur : " + m.getTempInt());
	this.humidite.setText("Humidité : " + m.getHum());
	this.temperatureExterieur.setText("Température extérieur : " +m.getTempExt());
	this.temperatureModule.setText("Température Module : " +m.getTempMod());
	
	}
	
	
}