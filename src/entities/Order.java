package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import entitiesEnum.OrderStatus;

public class Order {

	//ATRIBUTOS
	private LocalDate moment;
	private OrderStatus status;

	//ASSOCIAÇÔES
	private Client client;
	private List<OrderItem> orderitem = new ArrayList<>();

	//CONSTRUTORES
	public Order() {

	}

	public Order (OrderStatus status) {
		this.status = status;
	}

	public Order(LocalDate moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	//GETTERS E SETTERS
	public LocalDate getMoment() {
		return moment;
	}

	public void setMoment(LocalDate moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	};

	//METADOS
	//Adcionar itens a uma lista
	public void addItem(OrderItem orderItem) {
		orderitem.add(orderItem);
	}

	//Remover itens de uma lista
	public void removeItem(OrderItem orderItem) {
		orderitem.remove(orderItem);
	}

	public double total() {
		double sum = 0.0;
		for (OrderItem it : orderitem) {
			sum += it.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		StringBuilder OrderClient = new StringBuilder();
		OrderClient.append("Order moment: " + moment.format(fmt) + "\n"); // <-- Aqui é o ajuste
		OrderClient.append("Order status: " + status + "\n");
		OrderClient.append("Client: ");
		OrderClient.append(client + "\n");
		OrderClient.append("Order items:\n");
		for (OrderItem item : orderitem){
			OrderClient.append(item + "\n");
		}
		OrderClient.append("Total price: $");
		OrderClient.append(String.format("%.2f", total()));
		return OrderClient.toString();
	}


}
