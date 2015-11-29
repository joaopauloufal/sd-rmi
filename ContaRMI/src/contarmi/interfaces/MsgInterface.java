package contarmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MsgInterface extends Remote {
	
	boolean criarConta(String nome, int conta) throws RemoteException;
	
	boolean removerConta(int conta) throws RemoteException;
	
	boolean saque(int conta, double valor) throws RemoteException;
	
	boolean transferir(int conta1, int conta2, double valor) throws RemoteException;
	
	boolean depositar(int conta, double valor) throws RemoteException;
	
	String consultarSaldo(int conta) throws RemoteException;

}
