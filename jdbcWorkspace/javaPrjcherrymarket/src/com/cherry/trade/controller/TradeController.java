package com.cherry.trade.controller;

import java.util.List;
import java.util.Scanner;


import com.cherry.main.Main;
import com.cherry.trade.service.TradeService;
import com.cherry.trade.vo.TradeVo;
import com.cherry.util.Color;
import com.cherry.util.Util;

public class TradeController {

	private final Scanner sc;
	private final TradeService ts;
	
	public TradeController() {
		sc = new Scanner(System.in);
		ts = new TradeService();
	}
	
	// 게시글 조회 - 메뉴
	public boolean postMenu(String boardNo) {
		try {
			TradeVo vo = ts.searchPostInfo(boardNo);
			
			if(Main.loginMember != null) {
				
				// 본인 게시글
				if(Main.loginMember.getMemberNo().equals(vo.getMemberNo())) {            
					
					System.out.println("<메뉴> "+ Color.YELLOW +"➊" + Color.EXIT + "게시글 수정 "
												+ Color.YELLOW +"➋" + Color.EXIT + "게시글 삭제 "
												+ Color.RED +"➒" + Color.EXIT + "뒤로가기");

					System.out.print("선택할 메뉴 : " + Color.CYAN);
					String select = sc.nextLine();
					System.out.print(Color.EXIT);
					
					switch(select) {
					
						case "1" : editPost(boardNo); break;
						case "2" : delPost(boardNo); break;
						case "9" : return true;
						default : System.out.println("잘못 입력하셨습니다");
						
					} 					
				
				// 타인 게시글
				} else if(!Main.loginMember.getMemberNo().equals(vo.getMemberNo())) {
					
					System.out.println("<메뉴> "+ Color.YELLOW +"➊"+ Color.EXIT + "구매 신청 "
												+ Color.RED + "➒" + Color.EXIT + "뒤로가기");

					System.out.print("선택할 메뉴 : " + Color.CYAN);
					String select = sc.nextLine();
					System.out.print(Color.EXIT);
					
					switch(select) {
					
						case "1" : purchaseRequest(vo); break;
						case "9" : return true;
						default : System.out.println("잘못 입력하셨습니다.");
						
					}
				} 
			}
			// 관리자일때
			if(Main.loginMember == null || Main.loginManager != null) { 
				
				System.out.println("<관리자 메뉴> "+ Color.YELLOW +"➊" + Color.EXIT + "게시글 수정 "
													+ Color.YELLOW +"➋" + Color.EXIT + "게시글 삭제 "
													+ Color.RED +"➒" + Color.EXIT + "뒤로가기");

				System.out.print("선택할 메뉴 : " + Color.CYAN);
				String select = sc.nextLine();
				System.out.print(Color.EXIT);
				
				switch(select) {				
					case "1" : editPost(boardNo); break;
					case "2" : delPost(boardNo); break;
					case "9" : return true;
					default : System.out.println("잘못 입력하셨습니다");
				} 					
			
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 구매 신청 
	private void purchaseRequest(TradeVo vo) {
		try {
			
			System.out.println(Color.CYAN + vo.getProduct() + Color.EXIT + " 거래를 완료하셨나요?");
			System.out.print("거래완료 (y/n) : " + Color.CYAN);
			String x = sc.nextLine();
			System.out.print(Color.EXIT);
			switch(x) {
				case "y" : 
					int purchaseNo = ts.confirmPurchase(vo);  
					if(purchaseNo == 1) {
						System.out.println("구매가 확정되었습니다.");
					}
					break; 
				case "n" : return;
				default : System.out.println("잘못 입력했습니다"); break;
			}
		} catch(Exception e) {
			System.out.println("구매 확정 실패");
			e.printStackTrace();
		}
	}
		
	

//	// 구매후기 작성 -- 미완성
//	private void writeReview(TradeVo vo) {
//		try {
//
//	        String manner;
//	        
//	        System.out.print("구매후기 : " + Color.CYAN);
//	        String content = sc.nextLine();
//	        System.out.print(Color.EXIT);
//
//	        do {
//
//	            System.out.println("거래는 어땠나요?");
//	            System.out.println("1.최고에요 2.무난해요 3.별로에요" + Color.CYAN);
//	            manner = sc.nextLine();
//	            System.out.print(Color.EXIT);
//	
//	            if (!(manner.equals("1") || manner.equals("2") || manner.equals("3"))) {
//	                System.out.println("잘못입력하셨습니다");
//	            }
//	           ㅤ
//	        } while (!(manner.equals("1") || manner.equals("2") || manner.equals("3")));
//
//	        int result = ts.writeReview(purchaseNo, manner, content); 
//
//			if(result != 1) {
//				throw new Exception();
//			} 
//			
//			System.out.println("구매후기 작성 완료");
//			
//		} catch(Exception e) {
//			System.out.println("구매후기 작성 실패");
//			e.printStackTrace();
//		}
//	}

	
	// 게시글 수정
	public void editPost(String boardNo) {
		try {
			System.out.println(Color.RED + "               게시글 수정 | 수정할 내용을 입력해주세요");
			System.out.println(Color.GREEN + "▃▃▃​​​​▃​​​​▃▃​​​​​​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
			System.out.printf("제목 : ");
			String title = sc.nextLine();
			System.out.println(Color.GREEN + "▃▃▃​​​​​▃▃▃​​​​▃​​​​​▃​​​​​▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
			System.out.print("물품명 : " );
			String product = sc.nextLine();
			System.out.print("가격 : ");
			String price = sc.nextLine();
			System.out.print("거래 장소 : ");
			String tradeArea = sc.nextLine();
			if(Main.loginMember != null) {
				System.out.println("접속 지역 : " + Main.loginMember.getAreasName());
			}
			System.out.println(Color.GREEN + "▃▃▃​​​​​▃▃▃​​​​​​​​​▃▃▃​​​​▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
			System.out.print("내용 : ");
			String content = sc.nextLine();
			System.out.println(Color.GREEN + "▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​▃​​​​​▃​​​​​▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
			System.out.println();
			
			TradeVo vo = new TradeVo();
			vo.setTitle(title);
			vo.setProduct(product);
			vo.setPrice(price);
			vo.setTradeAreas(tradeArea);
			vo.setContent(content);
			vo.setBoardNo(boardNo);
			
			int result = ts.editPost(vo);
			
			if(result != 1) {
				throw new Exception("게시글 수정 실패");
			}
			
			System.out.println("게시글 수정 완료");
			
		}  catch(Exception e) {
//			System.out.println("게시글 수정 실패");
			e.printStackTrace();
		}
		
	}

	// 게시글 삭제
	public void delPost(String boardNo) {
		try {
			
			int result = 0;
			
			if(Main.loginMember == null || Main.loginManager != null) {
				
				result = ts.delPost(boardNo);
				
			} else if(Main.loginMember != null || Main.loginManager == null) {	
				
				System.out.println("비밀번호를 입력해주세요");
				System.out.print("비밀번호 : " + Color.CYAN);
				String pwd = sc.nextLine();
				System.out.print(Color.EXIT);
				
				if(pwd.equals(Main.loginMember.getPwd())) {
					result = ts.delPost(boardNo);
				} else {
					System.out.println("비밀번호가 올바르지 않습니다.");
				}
			}
			
			if(result != 1) {
				throw new Exception();
			}
			
			System.out.println("게시글을 삭제했습니다.");
			
		} catch(Exception e) {
			System.out.println(Color.RED + "게시글 삭제 실패" + Color.EXIT);
			e.printStackTrace();
		}
		
	}
	
	
	// 게시글 목록 (중고거래 메인)
	public void tradeMain() {
		try {
			boolean x = false;
			
			while(!x) {
				Util.clearConsole();
				
				if(Main.loginMember == null || Main.loginManager != null) {
					System.out.println("접속중인 관리자 : " + Color.RED + Main.loginManager.getName() + Color.EXIT);
				} else if(Main.loginMember != null || Main.loginManager == null){
					System.out.println("접속중인 회원 : " + Color.YELLOW + Main.loginMember.getNick() + Color.EXIT);
					System.out.println("접속 지역 : " + Color.YELLOW + Main.loginMember.getAreasName() + Color.EXIT);
				}
				
				System.out.println(Color.CYAN + "▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃​​​​​▃▃▃▃▃​​​​​" + Color.EXIT);
				System.out.println("번호        제목                         물품명         가격           판매자           작성일         조회수   ");
				System.out.println(Color.CYAN + "▃▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​▃▃​​​​​▃▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
				
				
				List<TradeVo> voList = ts.printPost();
				
				for(TradeVo vo : voList) {
	
					String color = "";
					String resetColor = Color.EXIT;
	
					if(Main.loginMember != null) {
						if(vo.getMemberNo().equals(Main.loginMember.getMemberNo())) {
							color = Color.YELLOW;
						} 
					}
					
					String boardNo = vo.getBoardNo();
					String title = vo.getTitle();
					String product = vo.getProduct();
					String price = vo.getPrice();
					String memberNick = vo.getMemberNick();
					String enrollDate = vo.getEnrollDate();
					String hit = vo.getHit();
					

					System.out.println(color + boardNo + resetColor + title + product + price + memberNick + enrollDate + hit);
					
						
				}
				
				System.out.println(Color.CYAN + "▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃▃▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
				x = mainMenu();
			}
		} catch (Exception e) {
			System.out.println("목록 조회 실패");
			e.printStackTrace();
	
		}
	}
	
	// 게시글 목록 - 메뉴선택
	public boolean mainMenu() {
		if(Main.loginMember == null || Main.loginManager != null) {
			
			System.out.println("<관리자 메뉴> "+ Color.YELLOW +"➊" + Color.EXIT + "게시글 조회 "
												+ Color.YELLOW +"➋" + Color.EXIT + "게시글 검색 "
												+ Color.RED +"➒" + Color.EXIT + "뒤로가기");
			System.out.print("선택할 메뉴 : " + Color.CYAN);
			String select = sc.nextLine();
			System.out.print(Color.EXIT);
			
			switch(select) {
			
				case "1" : showContent(); break;
				case "2" : searchPost(); break;
				case "9" : return true;
				default : System.out.println("잘못 입력하셨습니다.");
				
			}
			
		} else if(Main.loginMember != null || Main.loginManager == null) {
		
			System.out.println("<메뉴> "+ Color.YELLOW +"➊" + Color.EXIT + "게시글 작성 "
										+ Color.YELLOW +"➋" + Color.EXIT + "게시글 조회 "
										+ Color.YELLOW +"➌" + Color.EXIT + "관심목록에 추가 "
										+ Color.YELLOW +"➍" + Color.EXIT + "게시글 검색 "
										+ Color.RED +"➒" + Color.EXIT + "뒤로가기");
			System.out.print("선택할 메뉴 : " + Color.CYAN);
			String select = sc.nextLine();
			System.out.print(Color.EXIT);
			
			switch(select) {
				case "1" : writePost(); break;
				case "2" : showContent(); break;
				case "3" : addWishList(); break;
				case "4" : searchPost(); break;
				case "9" : return true;

				default : System.out.println("잘못 입력하셨습니다.");
			}
		}
		return false;
	}
	
	// 게시글 목록(메인) -> 1.게시글 작성
		public void writePost() {
			try {
				Util.clearConsole();
				
				if(Main.loginMember == null || Main.loginManager != null) {
					System.out.println("접속중인 관리자 : " + Color.RED + Main.loginManager.getName() + Color.EXIT);
				} else if(Main.loginMember != null || Main.loginManager == null){
					System.out.println("접속중인 회원 : " + Color.YELLOW + Main.loginMember.getNick() + Color.EXIT);
					System.out.println("접속 지역 : " + Color.YELLOW + Main.loginMember.getAreasName() + Color.EXIT);
				};
				
				System.out.println(Color.CYAN + "▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
				System.out.print("제목 : " + Color.CYAN);
				String title = sc.nextLine();
				System.out.print(Color.EXIT);
				System.out.println(Color.CYAN + "▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
				System.out.println("작성자 : " + Main.loginMember.getNick());
				System.out.print("물품명 : " + Color.CYAN );
				String product = sc.nextLine();
				System.out.print(Color.EXIT);
				System.out.print("가격 : " + Color.CYAN);
				String price = sc.nextLine();
				System.out.print(Color.EXIT);
				System.out.print("거래 장소 : " + Color.CYAN);
				String tradeArea = sc.nextLine();
				System.out.print(Color.EXIT);
				System.out.println("접속 지역 : " + Main.loginMember.getAreasName());
				System.out.println(Color.CYAN + "▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃" + Color.EXIT);
				System.out.print("내용 : " + Color.CYAN);
				String content = sc.nextLine();
				System.out.print(Color.EXIT);
				
				TradeVo vo = new TradeVo();
				vo.setTitle(title);
				vo.setProduct(product);
				vo.setPrice(price);
				vo.setTradeAreas(tradeArea);
				vo.setContent(content);
				
				int result = ts.writePost(vo);
				
				if(result != 1) {
					throw new Exception();
				}
				
				System.out.println("게시글을 작성했습니다.");
				
			} catch(Exception e) {
				
				System.out.println(Color.RED + "게시글 작성 실패" + Color.EXIT);
				String ex = e.getMessage();
				
				if(ex.contains("TITLE")) {System.out.println("제목을 입력해주세요");} 
				else if(ex.contains("CONTENT")){System.out.println("내용을 입력해주세요");}
				else if(ex.contains("PRODUCT")){System.out.println("물품명을 입력해주세요");}
				else if(ex.contains("PRICE")){System.out.println("가격을 입력해주세요");}
				else if(ex.contains("TRADE_AREAS")){System.out.println("거래장소를 입력해주세요");}
				else if(ex.contains("ORA-01722")) {System.out.println("가격은 숫자로 입력해주세요");}			
				
			}
		}
	
	
	// 게시글 목록(메인) -> 2.게시글 조회
	public void showContent() {
		try {
			System.out.print("조회할 게시글 번호 : " + Color.CYAN);
			String select = sc.nextLine();
			System.out.print(Color.EXIT);
			
			TradeVo vo = ts.showContent(select);
			
			if(vo == null) {
				throw new Exception("존재하지 않는 게시글");
			}
			
			Util.clearConsole();
			
			if(Main.loginMember == null || Main.loginManager != null) {
				System.out.println("접속중인 관리자 : " + Color.RED + Main.loginManager.getName() + Color.EXIT);
			} else if(Main.loginMember != null || Main.loginManager == null){
				System.out.println("접속중인 회원 : " + Color.YELLOW + Main.loginMember.getNick() + Color.EXIT);
				System.out.println("접속 지역 : " + Color.YELLOW + Main.loginMember.getAreasName() + Color.EXIT);
			}
			
			System.out.println(Color.CYAN + "▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
			System.out.println(vo.getTitle());
			System.out.println(Color.CYAN + "▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
			System.out.println("판매자 : " + vo.getMemberNick());
			System.out.println("물품명 : " + vo.getProduct());
			System.out.println("가격 : " + vo.getPrice());
			System.out.println("거래 장소 : " + vo.getTradeAreas());
			System.out.println("접속 지역 : " + vo.getAreasName());
			System.out.println(Color.CYAN + "▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
			String content = vo.getContent();
			
	        String[] contents = content.split("#");
	       
	        for (String con : contents) {
	            System.out.println(con);
	        }
	        
			System.out.println(Color.YELLOW +"작성일자 : " +  vo.getEnrollDate() + Color.EXIT);
			
			if(vo.getEditDate() != null) {
				System.out.println(Color.YELLOW +"수정일자 : " + vo.getEditDate() + Color.EXIT);
			}
			System.out.println(Color.YELLOW + "조회수 : " + vo.getHit() + Color.EXIT);
			System.out.println(Color.CYAN + "▃▃▃​​​​​​​▃▃​​▃​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
			
			Boolean x = postMenu(vo.getBoardNo());
			
		} catch(Exception e) {
			
			System.out.println(Color.RED + "게시글 조회 실패" + Color.EXIT);
			String ex = e.getMessage();
//			e.printStackTrace();
			if(ex.contains("존재하지")) {System.out.println("존재하지 않는 게시글입니다.");}
			if(ex.contains("ORA-01722")) {System.out.println("숫자만 입력해주세요."); }
			
		}
	}
	
	// 게시글 목록(메인) -> 3.관심목록 추가
	public void addWishList() {
		try {
			System.out.print("관심목록에 추가할 게시글 번호 : " + Color.CYAN);
			String boardNo = sc.nextLine();
			System.out.print(Color.EXIT);
			int result = ts.addWishList(boardNo);
		
			if(result != 1) {
				throw new Exception("본인 게시글은 관심목록에 추가 할 수 없습니다.");
			} 
			
			System.out.println(Color.YELLOW+ boardNo + "번 게시글을 관심목록에 추가했습니다." + Color.EXIT);
			
		} catch(Exception e) {
			System.out.println(Color.RED + "관심목록 추가 실패" + Color.EXIT);
			String x = e.getMessage();
			
			if(x.contains("UNIQUE_WISHLIST")) {
				System.out.println("이미 관심목록에 존재합니다.");
				
			}else if(x.contains("null")) {
				System.out.println("존재하지 않는 번호입니다.");
				
			} else if(x.contains("본인 게시글")) {
				System.out.println(x);
			} 
		}
	}
	
	
	// 게시글 목록(메인) -> 4. 게시글 검색
	public void searchPost() {
		System.out.println(Color.YELLOW +"➊" + Color.EXIT + "제목으로 검색  " 
							+ Color.YELLOW +"➋" + Color.EXIT + "제품명으로 검색");

		System.out.print("선택 : " + Color.CYAN);
		String x = Main.SC.nextLine();
		System.out.print(Color.EXIT);
		
		switch(x) {
		case "1" : 
			searchPostByTitle();
			break;
		case "2" :
			searchPostByProduct();
			break;
		default : System.out.println("잘못입력하셨습니다.");
		}
	}
		
	// 4. 게시글 검색 -> 제목으로 검색
	private void searchPostByTitle() {
		try {
		System.out.println("검색 할 제목을 입력해주세요.");
		System.out.print("제목 : " + Color.CYAN);
		String searchTitle = Main.SC.nextLine();
		System.out.print(Color.EXIT);
		
		Util.clearConsole();
		
		if(Main.loginMember == null || Main.loginManager != null) {
			System.out.println("접속중인 관리자 : " + Color.RED + Main.loginManager.getName() + Color.EXIT);
		} else if(Main.loginMember != null || Main.loginManager == null){
			System.out.println("접속중인 회원 : " + Color.YELLOW + Main.loginMember.getNick() + Color.EXIT);
			System.out.println("접속 지역 : " + Color.YELLOW + Main.loginMember.getAreasName() + Color.EXIT);
		}
		
		System.out.println(Color.CYAN + "▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃​​​​​▃▃▃▃▃​​​​​" + Color.EXIT);
		System.out.println("번호        제목                         물품명         가격           판매자           작성일         조회수   ");
		System.out.println(Color.CYAN + "▃▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​▃▃​​​​​▃▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);

		List<TradeVo> voList = ts.searchPostByTitle(searchTitle);

		if(voList.size() == 0) {
			System.out.println(Color.CYAN + searchTitle + Color.EXIT + Color.YELLOW + "으로 검색 된 게시글이 없습니다." +Color.EXIT);
		}
		
		for(TradeVo vo : voList) {

			String color = "";
			String resetColor = Color.EXIT;
			
			
			if(Main.loginMember != null) {
				if(vo.getMemberNo().equals(Main.loginMember.getMemberNo())) {
					color = Color.YELLOW;
				}
			}

			String boardNo = vo.getBoardNo();
			String title = vo.getTitle();
			String product = vo.getProduct();
			String price = vo.getPrice();
			String memberNick = vo.getMemberNick();
			String enrollDate = vo.getEnrollDate();
			String hit = vo.getHit();
			
			System.out.println(color + boardNo + resetColor + title + product + price + memberNick + enrollDate + hit);
		}
		
		System.out.println(Color.CYAN + "▃▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​▃▃​​​​​▃▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
	
		mainMenu();
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	// 4. 게시글 검색 -> 제품명으로 검색
	private void searchPostByProduct() {
		try {
			System.out.println("검색 할 제품 이름을 입력해주세요.");
			System.out.print("제품명 : " + Color.CYAN);
			String searchProduct = Main.SC.nextLine();
			System.out.print(Color.EXIT);
			
			Util.clearConsole();
			
			List<TradeVo> voList = ts.searchPostByProduct(searchProduct);
			
			if(Main.loginMember == null || Main.loginManager != null) {
				System.out.println("접속중인 관리자 : " + Color.RED + Main.loginManager.getName() + Color.EXIT);
			} else if(Main.loginMember != null || Main.loginManager == null){
				System.out.println("접속중인 회원 : " + Color.YELLOW + Main.loginMember.getNick() + Color.EXIT);
				System.out.println("접속 지역 : " + Color.YELLOW + Main.loginMember.getAreasName() + Color.EXIT);
			}
			
			System.out.println(Color.CYAN + "▃▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​▃▃​​​​​▃▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
			System.out.println("번호        제목                         물품명         가격           판매자           작성일         조회수   ");
			System.out.println(Color.CYAN + "▃▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​▃▃​​​​​▃▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);

			if(voList.size() == 0) {
				System.out.println(Color.CYAN + searchProduct + Color.EXIT + Color.YELLOW + "으로 검색 된 게시글이 없습니다." +Color.EXIT);
			}
			
			for(TradeVo vo : voList) {

				String color = "";
				String resetColor = Color.EXIT;

				if(Main.loginMember != null) {
					if(vo.getMemberNo().equals(Main.loginMember.getMemberNo())) {
						color = Color.YELLOW;
					}
				}

				String boardNo = vo.getBoardNo();
				String title = vo.getTitle();
				String product = vo.getProduct();
				String price = vo.getPrice();
				String memberNick = vo.getMemberNick();
				String enrollDate = vo.getEnrollDate();
				String hit = vo.getHit();
				
				System.out.println(color + boardNo + resetColor + title + product + price + memberNick + enrollDate + hit);

			}
			
			System.out.println(Color.CYAN + "▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
			
			mainMenu();
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		
	}
	
}
