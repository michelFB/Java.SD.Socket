// server.java  
import java.net.*;  
import java.io.*;  
  
public class server {  
  public static void main ( String[] args )  
    {  
    Socket socket = null;  
    int sum = 0;  
    String sumString = "" ;  
  
    while (true)  
    { 
    try {  
      @SuppressWarnings("resource")
	ServerSocket serverSocket = new ServerSocket(250);  
  
      System.out.println("Aguardando um conexão cliente");  
      socket = serverSocket.accept();  
      DataOutputStream ostream = new DataOutputStream(socket.getOutputStream());  
      DataInputStream istream = new  DataInputStream(socket.getInputStream());  
  
      while(true)  
      { 
    	  String myOperation = istream.readUTF();  
    	  if (myOperation.equals("Incrementando"))  
    		  sumString = String.valueOf (++sum);  
    	  else  
    		  if (myOperation.equals("set_sum"))  
		      {  
		      sum = 0;  
		      sumString = String.valueOf(sum);  
		      System.out.println("Contador = " + sumString );  
		      }  
	      ostream.writeUTF(sumString);  
	      ostream.flush();  
	      }
      } catch (Exception e)  {
    	  System.err.println("Fechando conexão") ;  
        if  (socket != null)  
	        try  
	        { socket.close();  
	        } catch (IOException ex) {
	        	
	        }  
      }  
    }  
  }  
}  
