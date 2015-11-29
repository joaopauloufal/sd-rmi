package contarmi.cliente;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import contarmi.interfaces.MsgInterface;

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
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
		
		Registry registro = LocateRegistry.getRegistry("192.168.2.100", 8000);
		MsgInterface gerente = (MsgInterface) registro.lookup("gerente");
		
		Scanner sc = new Scanner(System.in);
		String nome;
		
		int conta, conta1, conta2;
		double valor;
		
		String opcao = "1";
		
		while (!opcao.equals("0")){
			
			exibirMenu();
			opcao = sc.next();
			
			switch(opcao){
				
			case "1":
				
				System.out.println("Criar conta");
				System.out.print("Informe o nome: ");
				nome = sc.next();
				
				System.out.print("Informe o número da conta: ");
				conta1 = sc.nextInt();
				
				if (gerente.criarConta(nome, conta1)){
					
					System.out.println("Conta criada com sucesso!");
					
				} else {
					System.out.println("Já existre uma conta com esse núemro!");
				}
				
				break;
				
			case "2":
				
				System.out.println("Remover conta");
				System.out.print("Informe a conta: ");
				conta = sc.nextInt();
				
				if (gerente.removerConta(conta)){
					System.out.println("Conta removida com sucesso!");
				} else {
					System.out.println("Conta inexistente!");
				}
				
				break;
				
			case "3":
				
				System.out.println("Realizar depósito");
				System.out.print("Informe a conta: ");
				conta = sc.nextInt();
				System.out.print("Valor a ser depositado: ");
				valor = sc.nextDouble();
				
				if (gerente.depositar(conta, valor)){
					System.out.println("Depósito realizado com sucesso!");
				} else {
					System.out.println("Conta inexistente!");
				}
				
				break;
				
			case "4":
				
				System.out.println("Realizar saque");
				System.out.print("Informe a conta: ");
				conta = sc.nextInt();
				System.out.print("Valor a ser sacado: ");
				valor = sc.nextDouble();
				
				if (gerente.saque(conta, valor)){
					
					System.out.println("Saque realizado com sucesso!");
					
				} else {
					
					System.out.println("Saldo insuficiente! Tente outro valor.");
					
				}
				
				break;
				
			case "5":
				
				System.out.println("Realizar transferência");
				System.out.print("Informe a sua conta: ");
				conta1 = sc.nextInt();
				System.out.println("informe a conta para a trasferência: ");
				conta2 = sc.nextInt();
				System.out.print("Valor a ser transferido: ");
				valor = sc.nextDouble();
				
				if (gerente.transferir(conta1, conta2, valor)){
					
					System.out.println("Trasferência realizada com sucesso!");
					
				} else {
					
					System.out.println("Saldo insuficiente! Tente outro valor.");
					
				}
				
				break;
				
			case "6":
				 System.out.println("Consultar saldo");
				 System.out.print("Informe a conta: ");
				 conta = sc.nextInt();
				 String saldo = gerente.consultarSaldo(conta);
				 System.out.println(saldo);
				 
				 
				 break;
			
			}
			
		}
		
		System.out.println("Operação finalizada.");
		sc.close();
		
	}

}
