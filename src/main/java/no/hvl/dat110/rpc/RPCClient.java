package no.hvl.dat110.rpc;

import java.io.IOException;
import java.net.UnknownHostException;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	// underlying messaging client used for RPC communication
	private MessagingClient msgclient;

	// underlying messaging connection used for RPC communication
	private MessageConnection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() throws UnknownHostException, IOException {
		
		// TODO - START
		// connect using the RPC client
		
		connection = msgclient.connect();
		
//		if (true)
//			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
	}
	
	public void disconnect() {
		
		
		// TODO - START
		// disconnect by closing the underlying messaging connection
		
		connection.close();
		
//		if (true)
//			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
	}

	/*
	 Make a remote call om the method on the RPC server by sending an RPC request message and receive an RPC reply message

	 rpcid is the identifier on the server side of the method to be called
	 param is the marshalled parameter of the method to be called
	 */

	public byte[] call(byte rpcid, byte[] param) {
		
		byte[] returnval = null;
		
		// TODO - START

		byte[] req = RPCUtils.encapsulate(rpcid, param);
		
		/*

		The rpcid and param must be encapsulated according to the RPC message format

		The return value from the RPC call must be decapsulated according to the RPC message format

		*/
		
		connection.send(new Message(req));
		Message rep = connection.receive();
		returnval = RPCUtils.decapsulate(rep.getData());
		
				
//		if (true)
//			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
		return returnval;
		
	}

}
