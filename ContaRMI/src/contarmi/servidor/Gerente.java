package contarmi.servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import contarmi.interfaces.MsgInterface;

public final class Gerente extends UnicastRemoteObject implements MsgInterface {

	private static final long serialVersionUID = 1L;
	private static MsgInterface instance = null;
	private List<Conta> contas;
	
	private Gerente() throws RemoteException {
		this.contas = new ArrayList<Conta>();
	}

	@Override
	public boolean criarConta(String nome, int conta) throws RemoteException {
		for (Conta c: contas){
			
			if (c.getConta() == conta){
				return false;
			}
			
		}
		
		Conta novaConta = new Conta(nome, conta);
		contas.add(novaConta);
		
		return true;
	}

	@Override
	public boolean removerConta(int conta) throws RemoteException {
		
		for (Conta c : contas){
			
			if (c.getConta() == conta){
				
				contas.remove(c);
				return true;
				
			}
			
		}
		
		return false;
	}

	@Override
	public boolean saque(int conta, double valor) throws RemoteException {
		
		for (Conta c : contas){
			
			if (c.getConta() == conta){
				return c.sacar(valor);
			}
			
		}
		
		return false;
	}

	@Override
	public boolean transferir(int conta1, int conta2, double valor) throws RemoteException {
		
		for (Conta c : contas){		
			if (c.getConta() == conta1){	
				for (Conta c2 : contas){		
					if (c2.getConta() == conta2){	
						return c.transferir(valor, c2);
						
					}
					
				}
				
			}
			
		}
		
		return false;
	}

	@Override
	public boolean depositar(int conta, double valor) throws RemoteException {
		
		for (Conta c : contas){
			
			if (c.getConta() == conta){		
				c.depositar(valor);		
				return true;
				
			}
			
		}
		return false;
	}
	
	@Override
	public String consultarSaldo(int conta) throws RuntimeException {
		
		for (Conta c : contas){
			
			if (c.getConta() == conta){
				
				return c.getSaldoString();
				
			}
			
		}
		
		return null;
		
	}
	
	
	public static MsgInterface getInstance() throws RemoteException {
		
		if (instance == null){	
			instance = new Gerente();
			
		}
		return instance;
		
	}

	
	

}
