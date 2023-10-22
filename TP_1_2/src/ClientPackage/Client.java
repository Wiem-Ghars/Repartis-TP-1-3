package ClientPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				try {
				//création de socket
				Socket o =new Socket("localhost",1236);
				System.out.println("je suis un client pas encore connecte");
				//création de InputStream pour lire les données depuis o
				InputStream in=o.getInputStream();
				//création de OutputStream pour ecrire les données vers o
				OutputStream out =o.getOutputStream();
				System.out.println("je suis un client connecte");
				Scanner scanner=new Scanner(System.in);
				System.out.println("donner un nombre");
				int nb=scanner.nextInt();
				out.write(nb);
				System.out.println("donner un operateur");
				String op=scanner.next();
				PrintWriter pw = new PrintWriter(out, true);
				pw.print(op);
				int rep=in.read();
				System.out.println("Reponse="+rep);
				//fermeture de socket
				o.close();
				}catch(IOException e)
				{e.printStackTrace();}

			}

		}

	
