package model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import model.domain.Mart;
import model.domain.Orders;
import model.domain.Product;
import model.util.PublicCommon;

public class PeopleOfMartService {

	private static PeopleOfMartService instance = new PeopleOfMartService();
	
	public static PeopleOfMartService getInstance() {
		return instance;
	}
	
	private static MartDAO martDAO = MartDAO.getInstance();
	private static ProductDAO productDAO = ProductDAO.getInstance();
	private static OrdersDAO ordersDAO = OrdersDAO.getInstance();
	
	public Mart addMart(String martName, String location, EntityManager em) throws SQLException {
			return martDAO.addMart(martName, location, em);
	}
	
	public List<Mart> findAll(EntityManager em) throws SQLException, NoResultException {
		return martDAO.findAll(em);
	}
	
	public Mart findMart(int martNumber, EntityManager em) throws SQLException, NoResultException {
		return martDAO.findMart(martNumber, em);
	}
	
	public List<Mart> findMart(String martName, EntityManager em) throws SQLException, NoResultException {
		return martDAO.findMart(martName, em);
	}

	public boolean updateMart(int martNumber, String martName, String location, EntityManager em) throws SQLException, NoResultException {
		return martDAO.updateMart(martNumber, martName, location, em);
	}

	public boolean deleteMart(int martNumber, EntityManager em) throws SQLException, NoResultException {
		return martDAO.deleteMart(martNumber, em);
	}
	
	public Product createProduct(String productName, int price, EntityManager em) throws SQLException {
		return productDAO.createProduct(productName, price, em);
	}
	
	public List<Product> findAllProduct(EntityManager em) throws SQLException, NoResultException {
		return productDAO.findAllProduct(em);
	}
	
	public Product findProduct(int productNumber, EntityManager em) throws SQLException,NoResultException {
		return productDAO.findProduct(productNumber, em);
	}
	
	public List<Product> findProduct(String productName, EntityManager em)  throws SQLException, NoResultException {
		return productDAO.findProduct(productName, em);
	}
	
	public boolean updateProduct(String productName, int price, int productNo, EntityManager em) throws SQLException, NoResultException {
		return productDAO.updateProduct(productName, price, productNo, em);
	}
	
	public boolean deleteProduct(int productNo, EntityManager em) throws SQLException, NoResultException {
		return productDAO.deleteProduct(productNo, em);
	}
	
	public Orders createOrder(int orderNumber, int martNumber, int productNumber, int amount, String pickupDate,
			String pickupTime, char ispickup, EntityManager em) throws SQLException {
		Product p = productDAO.findProduct(productNumber, em);
		Mart m = martDAO.findMart(martNumber, em);
		return OrdersDAO.createOrder(orderNumber, m, p, amount,
				p.getPrice() * amount, pickupDate, pickupTime, ispickup, em);
	}
	
	public List<Orders> findAllOrders(EntityManager em)  throws SQLException, NoResultException {
		return ordersDAO.findAll(em);
	}
	
	public List<Orders> getMartOrders(int martNumber, EntityManager em) throws SQLException, NoResultException {
		return martDAO.getOrders(martNumber, em);
	}
	
	public List<Orders> getProductOrders(int productNumber, EntityManager em) throws SQLException, NoResultException {
		return productDAO.getOrders(productNumber, em);
	}
	
	public boolean updateOrders(int orderId, String pickupDate, String pickupTime, EntityManager em) throws SQLException, NoResultException {
		return ordersDAO.updateOrders(orderId, pickupDate, pickupTime, em);
	}
	
	public boolean deleteOrder(int orderId, EntityManager em)  throws SQLException, NoResultException {
		return ordersDAO.deleteOrder(orderId, em);
	}
	
	public boolean deleteOrderByOno(int orderNumber, EntityManager em) throws SQLException, NoResultException {
		return ordersDAO.deleteOrderByOno(orderNumber, em);
	}
	
	public boolean endOrder(int orderNumber, EntityManager em) throws SQLException, NoResultException {
		return ordersDAO.endOrder(orderNumber, em);
	}
}
