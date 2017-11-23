package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;
import java.util.Observable;

public class SerialTest extends Observable implements SerialPortEventListener {

SerialPort serialPort;
/** The port we’re normally going to use. */
private String PORT_NAMES[] = {"COM7"};

private BufferedReader input;
private OutputStream output;
private static final int TIME_OUT = 2000;
private static final int DATA_RATE = 9600;


public String temperature = "vide";
public String exterieur = "vide" ;

private model model;


	public SerialTest(model m)
	{
		model = m;
	}

	public void findPort()
	{
		System.out.println("Program Started!!!");
	
		CommPortIdentifier serialPortId;
	
		Enumeration enumComm;
	
		enumComm = CommPortIdentifier.getPortIdentifiers();
	
		while(enumComm.hasMoreElements())
		{
			serialPortId = (CommPortIdentifier)enumComm.nextElement();
			
			if(serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL)
			{
				System.out.println(serialPortId.getName());
				
			}
		}
	
		System.out.println("Program Finished Sucessfully");
	}





	public void initialize() {
		
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
	
		//First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements())
		{
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			
			for (String portName : PORT_NAMES) 
			{
					if (currPortId.getName().equals(portName)) 
					{
							portId = currPortId;
							break;
					}
			}
		}
		
		if (portId == null) 
		{
			System.out.println("Could not find COM port.");
			return;
		}
	
		try 
		{
			serialPort = (SerialPort) portId.open(this.getClass().getName(),TIME_OUT);
			serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
	
			// open the streams
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			output = serialPort.getOutputStream();
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
			
		} 
		catch (Exception e) 
		{
			System.err.println(e.toString());
		}
	}
	
	
	public synchronized void close() 
	{
		if (serialPort != null) 
		{
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	
	public synchronized void serialEvent(SerialPortEvent oEvent) 
	{
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) 
		{
			try 
			{
				String inputLine = null;
				if (input.ready()) 
				{
					inputLine = input.readLine();
					//System.out.println("inputline : " + inputLine);
					String[] tp = inputLine.split(":");
					//System.out.println("tp0 : " + tp[0]);
						model.setTempExt( tp[0]);
						//System.out.println(model.listetempExt.get(model.listetempExt.size()-1));
						model.setTempInt(tp[1]);
						model.setTempMod(tp[2]);
						model.setTempRos(tp[3]);
						model.setHum(tp[4]);
						
						
						/*
						if(model.listetempExt.size() == 31)
						{
							model.listetempExt.remove(30);
							model.listetempInt.remove(30);
							model.listetempMod.remove(30);
							model.listetempRos.remove(30);
							model.listehum.remove(30);
						}
					
					*/
					//System.out.println("temperature : " + this.temperature);
					//System.out.println("exterieur : " + this.exterieur);
					//String [] chunks = inputLine.split(",");
					//System.out.println(inputLine);
					//System.out.println(chunks[0] + "\t" + chunks[1] + "\t" + chunks[2] + "\t");	
				setChanged();
				notifyObservers(this.model);	
				}

			} 
			catch (Exception e) 
			{
				System.err.println(e.toString());
			}
		}
// Ignore all the other eventTypes, but you should consider the other ones.
	}
		
}
