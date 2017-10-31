//client.java  

import java.net.*;  
import java.io.*;  

public class client  
{
	public static void main(String args[] )  
	{  
		String sumString = "";  
		try  
		{	 if( args.length != 2 ){  
				System.out.println("Passagem de argumentos para o servidor java <IP_host> <quantidade>");  
				return;  }  
		
			System.out.println("Abrindo o socket e criando o stream.");  
			String host = "127.0.0.1";  
			@SuppressWarnings("resource")
			Socket socket = new Socket (host, 250);  
	
			DataOutputStream ostream = new DataOutputStream(socket.getOutputStream());  
			DataInputStream istream = new DataInputStream(socket.getInputStream());  
	
			System.out.println("inicializando sum 0.");  
			ostream.writeUTF("set_sum");  
			ostream.flush();  
			sumString = istream.readUTF();  
			
			System.out.println("Incrementando.");  
			int count = new Integer(args[1]).intValue();  
			long startTime = System.currentTimeMillis();  
			
			for (int i = 0; i < count; i++)  
			{  
			ostream.writeUTF("incrementando");  
			ostream.flush();  
			sumString = istream.readUTF();  
			}  
			
			long stopTime = System.currentTimeMillis();  
			System.out.println ("AVG ping = " + ((stopTime - startTime) /   
			(float)count) + "msecs") ;  
			System.out.println("Contador = " + sumString);  
			} catch(Exception e)  
				{ System.err.println(e);  
				}  
		}  
		}