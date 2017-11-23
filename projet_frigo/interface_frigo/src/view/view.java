package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.model;

public class view extends JFrame implements Observer{
	
	JPanel background12;	
	JPanel background1;	
	JPanel background2;
	graphTemp background3;	
	graphHum background4;
	JButton button1;
	JComboBox<String> temperature;
	JLabel temperatureInterieur, humidite, temperatureExterieur,temperatureModule, ptRose;
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
		this.setSize(1120,650);

		
		
		background1 = new JPanel ();
		background12 = 	new JPanel();
		background12.setLayout(new GridLayout(2, 1));
		background1.setLayout(new GridLayout(4, 1));
		background2 = new JPanel ();
		background3 = new graphTemp();
		background4 = new graphHum();
		
		button1 = new JButton ("Envoyer");
		
	
		temperatureInterieur = new JLabel ("Temperature Interieur: ");		
		humidite = new JLabel ("Humidité: ");
		temperatureExterieur = new JLabel ("Temperature Exterieur: ");
		temperatureModule = new JLabel ("Temperature Module : ");
				

		

		background1.setBorder(BorderFactory.createTitledBorder("Valeurs en temps réel"));
		background2.setBorder(BorderFactory.createTitledBorder("Modification de valeurs"));
		background12.setBounds(0,0, 300, 650);	
		background3.setBounds(300,0, 800, 300);	
		background4.setBounds(300,302, 800, 301);
		background1.setBackground(Color.WHITE);
		background2.setBackground(Color.WHITE);
		
		background1.add(temperatureInterieur);
		background1.add(temperatureExterieur);
		background1.add(temperatureModule);
		background1.add(humidite);
		background12.add(background1);
		background12.add(background2);
		this.add(background12);
		//this.add(background2);
		this.add(background3);
		this.add(background4);
		
		//background2.setBounds(0,200, 300, 250);
		
		
		this.TemperatureVoulue = new JLabel("Température voulue : ");
		
	    background2.add(TemperatureVoulue);
	    background2.add(button1);
	    
	    
		background1.setVisible(true);
		background2.setVisible(true);
		background3.setVisible(true);
		background4.setVisible(true);
		this.setVisible(true);
		//this.temperature = new JComboBox<String>();	   
	    	
	    //temperature.addItem("bonjour");
	    
	   // background2.add(temperature);	    	    
			
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {		
	model m = (model) arg1;	
	this.temperatureInterieur.setText("Température intérieur : " + m.getTempInt());
	this.humidite.setText("Humidité : " + m.getHum());
	this.temperatureExterieur.setText("Température extérieur : " + m.getTempExt());
	this.temperatureModule.setText("Température Module : " + m.getTempMod());
	this.background3.updateGraph(m);
	this.background4.updateGraph(m);
	
	checkCond(Double.parseDouble( m.getHum()));
	checkTemp(Double.parseDouble( m.getTempInt()));
	}
	
	private void checkCond(double d)
	{
		if(d > 80)
		{
			 JOptionPane jop1;
			    jop1 = new JOptionPane();
			    ImageIcon img = new ImageIcon("view/alerte.png");
			    jop1.showMessageDialog(null, "Détection de condensation.", "Attention", JOptionPane.WARNING_MESSAGE, img);
		}
	}
	
	private void checkTemp(double d)
	{
		if(d > 26)
		{
			 JOptionPane jop1;
			    jop1 = new JOptionPane();
			    ImageIcon img = new ImageIcon("view/alerte.png");
			    jop1.showMessageDialog(null, "Attention la porte est potentiellement ouverte.", "Attention", JOptionPane.WARNING_MESSAGE, img);
		}
	}
	
	
}