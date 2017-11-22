package model;

import java.util.Observable;

public class model extends Observable{

		
public model()
{

	startCom();
}

    	   	    
    private void startCom()
    {
    	try
        {
            (new TwoWaySerialComm()).connect("COM7");
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
