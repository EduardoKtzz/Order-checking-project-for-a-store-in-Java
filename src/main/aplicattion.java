package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entitiesEnum.OrderStatus;

public class aplicattion {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println();

		//Dados do cliente
		//name
		System.out.println("Enter cliente data:");
		System.out.println("Name: ");
		String name = sc.nextLine();

		//email
		System.out.println("Email: ");
		String email = sc.nextLine();

		//data de nascimento
		System.out.println("Birth date (DD/MM/YYYY): ");
		String birthDateStr = sc.next();

		//Formatando data
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate birthDate = LocalDate.parse(birthDateStr, fmt);

		//Instanciando cliente
		Client client = new Client(name, email, birthDate);

		//Dados do pedido
		//Status
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		System.out.println();

		Order order = new Order(LocalDate.now(), status, client);

		System.out.print("How many items to this order? ");
		int N = sc.nextInt();
		for (int i=1; i<=N; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			
			OrderItem it = new OrderItem(quantity, productPrice, product);
			
			order.addItem(it);			
		}
		
		System.out.println();
		System.out.println(order);
		
		sc.close();
	}
}

