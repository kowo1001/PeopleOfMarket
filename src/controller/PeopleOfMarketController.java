package controller;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import lombok.extern.slf4j.Slf4j;
import model.dao.MartDAO;
import model.dao.OrdersDAO;
import model.dao.PeopleOfMartService;
import model.dao.ProductDAO;
import model.domain.Mart;
import model.domain.Orders;
import model.domain.Product;
import model.util.PublicCommon;
import view.RunningEndView;

@Slf4j
public class PeopleOfMarketController {

	private static PeopleOfMarketController instance = new PeopleOfMarketController();

	public static PeopleOfMarketController getInstance() {
		return instance;
	}

	static PeopleOfMartService service = PeopleOfMartService.getInstance();
	
	public void addMart(String martName, String location) {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("마트 추가");
		try {
			Mart m = service.addMart(martName, location,em);
			RunningEndView.allView(m);
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void findAllMart() {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("모든 마트 검색");
		try {
			service.findAll(em).forEach(m -> RunningEndView.allView(m));
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void findMart(String martName) {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("마트 검색 : " + martName);
		try {
			service.findMart(martName, em).forEach(m -> RunningEndView.allView(m));
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void updateMart(int martNumber, String martName, String location) {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("마트 수정 : " + martNumber + " -> " + martName + location);
		try {
			if (service.updateMart(martNumber, martName, location, em)) {
				RunningEndView.showMessage("수정 성공");
			} else {
				RunningEndView.showError("수정 실패");
			}
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void deleteMart(int martNumber) {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("마트 삭제 : " + martNumber);
		try {
			if (service.deleteMart(martNumber, em)) {
				RunningEndView.showMessage("삭제성공");
			} else {
				RunningEndView.showError("삭제실패");
			}
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void addProduct(String productName, int price) {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("상품 추가 : " + productName + " " + price + "원");
		try {
			Product p = service.createProduct(productName, price, em);
			RunningEndView.allView(p);
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void findAllProduct() {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("모든 상품 조회");
		try {
			service.findAllProduct(em).forEach(v -> RunningEndView.allView(v));
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void findProduct(String productName) {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("상품 검색 : " + productName);
		try {
			service.findProduct(productName, em).forEach(v -> RunningEndView.allView(v));
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void updateProduct(int productNo, String productName, int price) {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("상품 수정 : " + productNo + " -> " + productName + " " + price + "원");
		try {
			if (service.updateProduct(productName, price, productNo, em)) {
				RunningEndView.showMessage("수정 성공");
			} else {
				RunningEndView.showError("수정 실패");
			}
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void deleteProduct(int productNo) {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("상품 삭제 : " + productNo);
		try {
			if (service.deleteProduct(productNo, em)) {
				RunningEndView.showMessage("삭제 성공");
			} else {
				RunningEndView.showError("삭제 실패");
			}
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void addOrders(int orderNumber, int martNumber, int productNumber, int amount, String pickupDate,
			String pickupTime, char ispickup) {

		EntityManager em = PublicCommon.getEntityManager();
		try {
			Orders o = service.createOrder(orderNumber, martNumber, productNumber, amount,
					pickupDate, pickupTime, ispickup, em);
			log.info("주문 : " + o);
			RunningEndView.allView(o);
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		}
	}

	public void findAllOrders() {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("모든 주문 조회");
		try {
			service.findAll(em).forEach(v -> RunningEndView.allView(v));
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void getMartOrders(int martNumber) {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("마트별 주문 검색 : " + martNumber);
		try {
			service.getMartOrders(martNumber, em).forEach(m -> RunningEndView.allView(m));
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		}
	}
	
	public void getProductOrders(int productNumber) {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("상품별 주문조회 : " + productNumber);
		try {
			service.getProductOrders(productNumber, em).forEach(m -> RunningEndView.allView(m));
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		}
	}
	
	public void findOrdersByOrderNumber(int orderNumber) {
		
		EntityManager em = PublicCommon.getEntityManager();
		try {
			int tot = service.getTotalPriceForOrderNumber(orderNumber, em);
			service.findOrdersByOrderNumber(orderNumber, em).forEach(v -> RunningEndView.allView(v));
			RunningEndView.showMessage("주문번호 " + orderNumber + "의 전체 가격은 " + tot + "원 입니다.");
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void updateOrders(int orderId, String pickupDate, String pickupTime) {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("주문 수정 : " + orderId + " -> " + pickupDate + " " + pickupTime);
		try {
			if (service.updateOrders(orderId, pickupDate, pickupTime, em)) {
				RunningEndView.showMessage("수정 성공");
			} else {
				RunningEndView.showError("수정 실패");
			}
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void deleteOrder(int orderId) {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("상품 주문 취소 : " + orderId);
		try {
			if (service.deleteOrder(orderId, em)) {
				RunningEndView.showMessage("삭제 성공");
			} else {
				RunningEndView.showError("삭제 실패");
			}
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void deleteOrderByOno(int orderNumber) {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("주문 전체 취소 : " + orderNumber);
		try {
			if (service.deleteOrderByOno(orderNumber, em)) {
				RunningEndView.showMessage("삭제 성공");
			} else {
				RunningEndView.showError("삭제 실패");
			}
		} catch (Exception e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void endOrder(int orderNumber) {

		EntityManager em = PublicCommon.getEntityManager();
		log.info("수령 완료 : " + orderNumber);
		try {
			if (service.endOrder(orderNumber, em)) {
				RunningEndView.showMessage("주문번호 " + orderNumber + " 수령 완료");
			} else {
				RunningEndView.showError("수령 실패");
			}
		} catch (SQLException e) {
			RunningEndView.showError("오류");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}