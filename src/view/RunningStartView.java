package view;

import controller.PeopleOfMarketController;

public class RunningStartView {
	public static void main(String[] args) {
		System.out.println("---------------------------");
		System.out.println("마트 추가");
		PeopleOfMarketController.addMart("GS마트", "마포구");
		PeopleOfMarketController.addMart("eMart", "용산구");
		PeopleOfMarketController.addMart("롯데마트", "서초구");
		PeopleOfMarketController.addMart("하나로마트", "성동구");
		PeopleOfMarketController.addMart("홈플러스", "강서구");

		System.out.println("---------------------------");
		System.out.println("마트 검색");
		System.out.println("마트 전체 검색");
		PeopleOfMarketController.findAllMart();
		System.out.println();
		System.out.println("GS마트 검색");
		PeopleOfMarketController.findMart("GS마트");

		System.out.println("---------------------------");
		System.out.println("마트 수정");
		PeopleOfMarketController.updateMart(2, "레몬마트", "마포구");
		PeopleOfMarketController.findAllMart();

//		System.out.println("---------------------------");
//		System.out.println("마트 삭제");
//		PeopleOfMarketController.deleteMart(1);
//		PeopleOfMarketController.findMart("레몬마트");

		System.out.println("---------------------------");
		System.out.println("상품 추가");
		PeopleOfMarketController.addProduct("백산수1L", 1200);
		PeopleOfMarketController.addProduct("에비앙1L", 10000);
		PeopleOfMarketController.addProduct("삼다수1L", 1400);
		PeopleOfMarketController.addProduct("몽쉘통통12개입", 3000);
		PeopleOfMarketController.addProduct("초코파이12개입", 3000);
		PeopleOfMarketController.addProduct("콘푸라이트", 4000);
		PeopleOfMarketController.addProduct("오곡코코볼", 4000);
		PeopleOfMarketController.addProduct("바나나", 3000);
		PeopleOfMarketController.addProduct("벗겨먹는고오스", 800);

		System.out.println("---------------------------");
		System.out.println("상품 검색");
		System.out.println("상품 전체 검색");
		PeopleOfMarketController.findAllProduct();
		System.out.println();
		System.out.println("벗겨먹는고오스 검색");
		PeopleOfMarketController.findProduct("벗겨먹는고오스");

		System.out.println("---------------------------");
		System.out.println("상품 수정");
		PeopleOfMarketController.updateProduct(8, "사과", 1500);
		PeopleOfMarketController.findAllProduct();

//		System.out.println("---------------------------");
//		System.out.println("상품 삭제");
//		PeopleOfMarketController.deleteProduct(8);
//		PeopleOfMarketController.findAllProduct();
//		
		System.out.println("---------------------------");

		System.out.println("주문 추가");
		PeopleOfMarketController.addOrders(2, 9, 10, "20/12/05", "08:30", '1');
		PeopleOfMarketController.addOrders(2, 8, 10, "20/12/05", "08:30", '1');
		System.out.println("---------------------------");
		
		System.out.println("주문 전체 검색");
		PeopleOfMarketController.findAllOrders();
		System.out.println();
		System.out.println("마트번호로  주문 검색");
		PeopleOfMarketController.getMartOrders(2);
		
		System.out.println("---------------------------");
		System.out.println("주문 수정");
		PeopleOfMarketController.updateOrders(2,"20/12/06","09:30");
		PeopleOfMarketController.findAllOrders();

		System.out.println("---------------------------");
		System.out.println("주문 삭제");
		PeopleOfMarketController.deleteOrder(2);
		PeopleOfMarketController.findAllOrders();

		System.out.println("---------------------------");
		

	}
}
