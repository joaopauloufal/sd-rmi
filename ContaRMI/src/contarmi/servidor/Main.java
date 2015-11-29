package contarmi.servidor;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
	

	
	
	public static void exibirMenu(){
		
		System.out.println("1 - Criar conta");
		System.out.println("2 - Remover conta");
		System.out.println("3 - Realizar depósito");
		System.out.println("4 - Realizar saque");
		System.out.println("5 - Realizar transferência");
		System.out.println("6 - Consultar saldo");
		System.out.println("0 - Sair");
		System.out.println("Opção: ");
		
	}
	
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		
		Registry registro = LocateRegistry.createRegistry(8000);
		registro.bind("gerente", Gerente.getInstance());
		System.out.println("Servidor do banco iniciado!");
		
		
		
	}

}
