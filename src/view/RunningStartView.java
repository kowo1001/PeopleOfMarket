package view;

import controller.PeopleOfMarketController;;

public class RunningStartView {
	public static void main(String[] args) {
		PeopleOfMarketController instance = PeopleOfMarketController.getInstance();
		
//		System.out.println("---------------------------");
//		System.out.println("마트 추가");
//		instance.addMart("GS마트", "마포구");
//		instance.addMart("eMart", "용산구");
//		instance.addMart("롯데마트", "서초구");
//		instance.addMart("하나로마트", "성동구");
//		instance.addMart("홈플러스", "강서구");
//
//		System.out.println("---------------------------");
//		System.out.println("마트 검색");
//		System.out.println("마트 전체 검색");
//		instance.findAllMart();
//		System.out.println();
//		System.out.println("GS마트 검색");
//		instance.findMart("GS마트");
//		
//		System.out.println("---------------------------");
//		System.out.println("마트 수정");
//		instance.updateMart(2, "레몬마트", "마포구");
//		instance.findAllMart();
//
////		System.out.println("---------------------------");
////		System.out.println("마트 삭제");
////		instance.deleteMart(1);
////		instance.findMart("레몬마트");
//
//		System.out.println("---------------------------");
//		System.out.println("상품 추가");
//		instance.addProduct("백산수1L", 1200);
//		instance.addProduct("에비앙1L", 10000);
//		instance.addProduct("삼다수1L", 1400);
//		instance.addProduct("몽쉘통통12개입", 3000);
//		instance.addProduct("초코파이12개입", 3000);
//		instance.addProduct("콘푸라이트", 4000);
//		instance.addProduct("오곡코코볼", 4000);
//		instance.addProduct("바나나", 3000);
//		instance.addProduct("벗겨먹는고오스", 800);
//
//		System.out.println("---------------------------");
//		System.out.println("상품 검색");
//		System.out.println("상품 전체 검색");
//		instance.findAllProduct();
//		System.out.println();
//		System.out.println("벗겨먹는고오스 검색");
//		instance.findProduct("벗겨먹는고오스");
//
//		System.out.println("---------------------------");
//		System.out.println("상품 수정");
//		instance.updateProduct(8, "사과", 1500);
//		instance.findAllProduct();
//
////		System.out.println("---------------------------");
////		System.out.println("상품 삭제");
////		instance.deleteProduct(8);
////		instance.findAllProduct();
////		
//		System.out.println("---------------------------");
//
//		System.out.println("주문 추가");
//		instance.addOrders(1, 2, 9, 10, "20/12/05", "08:30", '1');
//		instance.addOrders(1, 2, 8, 10, "20/12/05", "08:30", '1');
//		instance.addOrders(2, 3, 6, 1, "20/12/05", "08:30", '1');
//		System.out.println("---------------------------");
//		
//		System.out.println("주문 전체 검색");
//		instance.findAllOrders();
//		System.out.println();
//		System.out.println("마트번호로  주문 검색");
//		instance.getMartOrders(2);
//		
//		System.out.println("---------------------------");
//		System.out.println("주문 수정");
//		instance.updateOrders(104,"20/12/06","09:30");
//		instance.findAllOrders();

//		System.out.println("---------------------------");
//		System.out.println("주문 삭제");
//		instance.deleteOrder(2);
//		instance.findAllOrders();
//
//		System.out.println("---------------------------");
//		System.out.println("주문 삭제");
//		instance.deleteOrderByOno(1);
//		instance.findAllOrders();
		
//		System.out.println("---------------------------");
//		System.out.println("수령");
//		instance.endOrder(2);
//		instance.findAllOrders();
		
		instance.findOrdersByOrderNumber(1);
		
	}
}
