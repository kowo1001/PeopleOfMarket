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
		PeopleOfMarketController.updateMart(1, "레몬마트", "마포구");
		PeopleOfMarketController.findAllMart();
		
		System.out.println("---------------------------");
		System.out.println("마트 삭제");
		PeopleOfMarketController.deleteMart(1);
		PeopleOfMarketController.findMart("레몬마트");
		
		
		
		
		
		
		
	}
}
