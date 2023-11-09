package com.cherry.faq.controller;

import java.util.List;

import com.cherry.faq.service.FaqService;
import com.cherry.faq.vo.FaqVo;
import com.cherry.main.Main;

public class FaqController {

	//필드
	private final FaqService fs;

	//기본생성자
	public FaqController() {
		fs = new FaqService();
	}

	//메뉴 선택
	public void selectMenu() {
		
		while(true) {
			if(Main.loginManager != null) { //관리자일 때
				boardList();
				System.out.println("==================================================메뉴 선택===================================================");
				System.out.println("1.게시판 등록");
				System.out.println("2.게시판 수정");
				System.out.println("3.게시판 삭제");
				System.out.println("4.게시판 검색(번호)");
				System.out.println("5.게시판 검색(제목)");
				System.out.println("6.게시판 검색(작성자)");
				System.out.println("7.게시판 전체 조회");
				System.out.println("8.게시판 상세 조회(번호)");
				System.out.println("9.뒤로가기");
				System.out.println("==============================================================================================================");
				System.out.print("번호를 입력해주세요 : ");
				String num = Main.SC.nextLine();
				
				switch(num) {
				case "1" : write(); break;
				case "2" : edit(); break;
				case "3" : delete(); break;
				case "4" : boardPrintByNo(); break;
				case "5" : boardPrintByTitle(); break;
				case "6" : boardPrintByMno(); break;
				case "7" : boardList(); break;
				case "8" : boardDetailByNo(); break;
				case "9" : return; 
				default : System.out.println("올바른 번호를 입력하세요");
				}
			
			}else {  //회원일 때
				boardList();
				System.out.println("==================================================메뉴 선택====================================================");
				System.out.println("1.게시판 검색(번호)");
				System.out.println("2.게시판 검색(제목)");
				System.out.println("3.게시판 검색(작성자)");
				System.out.println("4.게시판 전체 조회");
				System.out.println("5.게시판 상세 조회(번호)");
				System.out.println("9.뒤로가기");
				System.out.println("===============================================================================================================");
				System.out.print("번호를 입력해주세요 : ");
				String num = Main.SC.nextLine();
				
				switch(num) {
				case "1" : boardPrintByNo(); break;
				case "2" : boardPrintByTitle(); break;
				case "3" : boardPrintByMno(); break;
				case "4" : boardList(); break;
				case "5" : boardDetailByNo(); break;
				case "9" : return; 
				default : System.out.println("올바른 번호를 입력하세요");
				}//switch
			}//else
		}//while
	}//selectMenu
	
	//게시판 등록
	public void write() {
		try {
			System.out.println("=================================================게시판 등록=================================================");
			//데이터
			System.out.print("게시판 제목: ");
			String title = Main.SC.nextLine();
			System.out.print("게시판 내용: ");
			String content = Main.SC.nextLine();
			
			FaqVo vo = new FaqVo();
			vo.setTitle(title);
			vo.setContent(content);
			
			//서비스
			int result = fs.write(vo);
			
			//결과 처리
			if(result!= 1) {
				throw new Exception();
			}
			System.out.println("게시판 등록 성공!");
			
		}catch(Exception e) {
			System.out.println("게시판 등록 실패..");
			e.printStackTrace();
		}
	}
	
	//게시판 수정(번호)
	public void edit() {
		
		try {
			System.out.println("=========================================게시판 수정(제목, 내용)============================================");
			//데이터
			System.out.print("게시판 번호: ");
			String no = Main.SC.nextLine();
			System.out.println("수정할 게시판 제목: ");
			String title = Main.SC.nextLine();
			System.out.print("수정할 게시판 내용: ");
			String content = Main.SC.nextLine();
			
			FaqVo vo = new FaqVo();
			vo.setFaqNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			
			//서비스
			int result = fs.edit(vo);
			
			//결과 처리
			if(result != 1) {
				throw new Exception();
			}
			
			System.out.println("게시판 수정 완료!");
			
		}catch(Exception e) {
			System.out.println("게시판 수정 실패");
			e.printStackTrace();
		}
	}
	
	
	//게시판 삭제
	public void delete() {
		
		try {
			System.out.println("=============================================게시판 삭제(번호)=============================================");
			//데이터
			System.out.println("삭제할 게시판 번호: ");
			String no = Main.SC.nextLine();
			
			//서비스
			int result = fs.delete(no);
			
			
			//결과 처리
			if(result != 1) {
				throw new Exception();
			}
		
			System.out.println("게시판 삭제 성공!");
			
		}catch(Exception e) {
			System.out.println("게시판 삭제 실패...");
			e.printStackTrace();
		}
	}
	
	//게시판 검색(게시판 번호)
	public void boardPrintByNo() {
		try {
			//데이터
			System.out.println("=================================================게시판 검색=================================================");
			System.out.print("게시판 번호: ");
			String num = Main.SC.nextLine();
			
			
			//서비스
			FaqVo vo = FaqService.boardPrintByNo(num);
			
			//결과
			if(vo == null) {
				throw new Exception();
			}
			
			System.out.println("게시판 검색 성공!");
			if(Main.loginManager != null) {
				System.out.println("게시판 번호 : " + vo.getFaqNo() + " | 게시판 제목 : " + vo.getTitle() 
				+ "| 글쓴이 : " + vo.getManagerName() + "| 작성일자 : " + vo.getEnrollDate() + "| 조회 수 : " + vo.getHit()
				+ "| 비공개: " + vo.getSecretYn());
			}else {
				System.out.println("게시판 번호 : " + vo.getFaqNo() + " | 게시판 제목 : " + vo.getTitle() 
				+ "| 글쓴이 : " + vo.getManagerName() + "| 작성일자 : " + vo.getEnrollDate() + "| 조회 수 : " + vo.getHit());
			}
			
		}catch(Exception e) {
			System.out.println("게시판 검색 실패..");
			e.printStackTrace();
		}
	}
	
	//게시판 검색(제목)
	public void boardPrintByTitle() {
		try {

			System.out.println("=============================================게시판 검색(제목)===============================================");
			
			//데이터
			System.out.print("게시판 제목 : ");
			String boardTitle = Main.SC.nextLine();
			
			//서비스
			FaqVo vo = fs.boardPrintByTitle(boardTitle);
			
			//결과
			if(vo == null) {
				throw new Exception();
			}
			
			System.out.println("게시판 검색 성공!");
			if(Main.loginManager != null) {
				System.out.println("게시판 번호 : " + vo.getFaqNo() + " | 게시판 제목 : " + vo.getTitle() 
				+ "| 글쓴이 : " + vo.getManagerName() + "| 작성일자 : " + vo.getEnrollDate() + "| 조회 수 : " + vo.getHit()
				+ "| 비공개: " + vo.getSecretYn());
			}else {
				System.out.println("게시판 번호 : " + vo.getFaqNo() + " | 게시판 제목 : " + vo.getTitle() 
				+ "| 글쓴이 : " + vo.getManagerName() + "| 작성일자 : " + vo.getEnrollDate() + "| 조회 수 : " + vo.getHit());
			}
			
		}catch(Exception e) {
			System.out.println("게시판 검색 실패..");
			e.printStackTrace();
		}
	}
	
	
	//게시판 검색(관리자 이름)
	public void boardPrintByMno() {
		
		try {
			System.out.println("================================================게시판 검색==================================================");
			
			//데이터
			System.out.print("작성자 이름: ");
			String mName = Main.SC.nextLine();
			
			//서비스
			List<FaqVo> voList = fs.boardPrintByMno(mName);
			
			//결과 처리
			if(voList.size() == 0) {
				throw new Exception();
			}
			
			System.out.println("게시판 검색 성공!");
			
			if(Main.loginManager != null) {
				for(FaqVo vo : voList) {
					System.out.println("게시판 번호 : " + vo.getFaqNo() + " | 게시판 제목 : " + vo.getTitle() 
					+ "| 글쓴이 : " + vo.getManagerName() + "| 작성일자 : " + vo.getEnrollDate() + "| 조회 수 : " + vo.getHit()
					+ "| 비공개: " + vo.getSecretYn());
				}
			}else {
				for(FaqVo vo : voList) {
					System.out.println("게시판 번호 : " + vo.getFaqNo() + " | 게시판 제목 : " + vo.getTitle() 
					+ "| 글쓴이 : " + vo.getManagerName() + "| 작성일자 : " + vo.getEnrollDate() + "| 조회 수 : " + vo.getHit());
				}
			}
			
		}catch(Exception e) {
			System.out.println("게시판 검색 실패..");
			e.printStackTrace();
		}
	}
	
	//게시판 전체 조회
	public void boardList() {
		try {

			System.out.println("==============================================전체 게시판 조회===============================================");
			//서비스
			List<FaqVo> voList = fs.boardList();
			
			//결과
			
			if(voList.size() == 0) {
				throw new Exception();
			}
			if(Main.loginManager != null) {
				for(FaqVo vo : voList) {
					System.out.println("게시판 번호 : " + vo.getFaqNo() + " | 게시판 제목 : " + vo.getTitle() 
					+ "| 글쓴이 : " + vo.getManagerName() + "| 작성일자 : " + vo.getEnrollDate() + "| 조회 수 : " + vo.getHit()
					+ "| 비공개: " + vo.getSecretYn());
				}
			}else {
				for(FaqVo vo : voList) {
					System.out.println("게시판 번호 : " + vo.getFaqNo() + " | 게시판 제목 : " + vo.getTitle() 
					+ "| 글쓴이 : " + vo.getManagerName() + "| 작성일자 : " + vo.getEnrollDate() + "| 조회 수 : " + vo.getHit());
				}
			}
		}catch(Exception e) {
			System.out.println("전체 게시판 조회 실패...");
			e.printStackTrace();
		}
	}
	
	//게시판 상세 조회(게시판 번호)
	public void boardDetailByNo() {
		try {
			System.out.println("==============================================게시판 상세 조회===============================================");
			//데이터
			System.out.print("게시판 번호: ");
			String no = Main.SC.nextLine();
			
			//서비스
			FaqVo vo = fs.boardDetailByNo(no);
			
			//결과
			if(vo == null) {
				throw new Exception("해당 번호의 게시판은 존재하지 않습니다.");
			}
			
			System.out.println("=============================================================================================================");
			System.out.println("글 번호 : " + vo.getFaqNo());
			System.out.println("관리자 번호 : " + vo.getManagerNo());
			System.out.println("글 제목 : " + vo.getTitle());
			System.out.println("글 내용 : " + vo.getContent());
			System.out.println("등록 일자 : " + vo.getEnrollDate());
			if(Main.loginManager != null) {
				System.out.println("비공개 여부 : " + vo.getSecretYn());
			}
			if(vo.getEditDate() != null) {
				System.out.println("수정 일자 : " + vo.getEditDate());
			}
			System.out.println("조회수 : " + vo.getHit());
			System.out.println("============================================================================================================");
			
		}catch(Exception e) {
			System.out.println("게시판 상세 조회 실패..");
			e.printStackTrace();
		}
	}
	
}//class
