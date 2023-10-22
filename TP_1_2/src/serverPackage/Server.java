package serverPackage;

import java.io.IOException;

import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		try {
			//création de ServerSocket
			ServerSocket ss =new ServerSocket(1236);	
			System.out.println("je suis un serveur en attente de la connexion");
			//création de nouveau socket et accepter une connexion pour communiquer avec le client
			Socket s=ss.accept();
			System.out.println("un client est connecté");
			//création de InputStream pour lire les données depuis ss
			InputStream is=s.getInputStream();
			//création de OutputStream pour ecrire les données vers ss
			OutputStream os =s.getOutputStream();
			System.out.println("un client est connecte");
			System.out.println("j'attend un nombre");
			int nb=is.read();
			System.out.println("choisir un operateur parmis * - / + :");
			
			InputStreamReader isr= new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
		    String op= br.readLine();
			float res=0;
			switch(op)
			{ case "+":
				res= nb + 5;
				break;
			case "*":
				res=nb * 5;
				break;
			case "-":
				res =nb - 5;
				break;
			case "/":
				if(nb!=0) {
				res=nb / 5;}
				break;
			
			}
			System.out.println("la reponse=" + res);
			
			//fermeture de ServerSocket			
			ss.close();
	}catch(IOException e)
		{e.printStackTrace();}
	}
}
