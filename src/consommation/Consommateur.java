package consommation;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class Consommateur {

	/**
	 * @param args
	 */

	protected static final String SERVICE_URI = "http://192.168.1.125:8080/";
	protected static Consommateur singleton = null;
	protected  Client client;
	public  WebTarget target; // permet de r�cup�rer l'URL du WS

	protected Consommateur() {
		
		client = ClientBuilder.newClient(); 
         target = client.target(SERVICE_URI);
	}

	public static Consommateur get() {
		if (singleton == null)
			singleton = new Consommateur();
		return singleton;
	}

	public WebTarget target() {
		return client.target(SERVICE_URI);
	}

	

}


