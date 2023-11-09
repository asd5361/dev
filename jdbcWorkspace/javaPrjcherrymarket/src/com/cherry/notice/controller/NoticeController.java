package com.cherry.notice.controller;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;

import com.cherry.main.Main;
import com.cherry.notice.service.NoticeService;
import com.cherry.notice.vo.NoticeVo;


public class NoticeController {
	// 필드
	private final NoticeService service;

	// 기본 생성자
	public NoticeController() {
		service = new NoticeService();
	}

	// 메뉴선택
	public void selectMenu() {
		

		while(true) {
			
			if(Main.loginManager!=null) { //관리자
			System.out.println();
			adminNoticeList();
			System.out.println();
			System.out.println("===NOTICE===");
			System.out.println("1. 공지글 작성");
			System.out.println("2. 공지글 비공개여부");
			System.out.println("3. 공지글 수정");
			System.out.println("4. 공지글 검색(제목)");
			System.out.println("5. 공지글 검색(내용)");
			System.out.println("6. 공지글 조회(최신순)");
			System.out.println("7. 공지글 조회(조회순)");
			System.out.println("8. 공지글 상세조회(번호)");
			System.out.println("9. 뒤로가기");
			System.out.println("=======================");
			System.out.print("원하시는 번호를 입력해주세요: ");
			String num = Main.SC.nextLine();
			switch (num) {
			case "1":write(); break;
			case "2": secret(); break;
			case "3": modify(); break;
			case "4":adminSearchNoticeByTitle(); break;//제목		
			case "5":adminSearchNoticeByContent(); break;//내용	
			case "6":adminNoticeList(); break;//최신
			case "7":adminNoticeList2(); break;//조회수
			case "8":adminNoticeDetailByNo(); break;
			case "9": return; 
			default: System.out.println("잘 못 입력하셨습니다.");
			}
		}else{ //유저
			System.out.println();
			noticeList();
			System.out.println();
			
			System.out.println("===NOTICE===");
			System.out.println("1. 공지글 조회(최신순)");
			System.out.println("2. 공지글 조회(조회순)");
			System.out.println("3. 공지글 검색(제목)");
			System.out.println("4. 공지글 검색(내용)");
			System.out.println("5. 공지글 상세조회(번호)");
			System.out.println("9. 뒤로가기");
			System.out.println("=======================");
			System.out.print("원하시는 번호를 입력해주세요: ");
			String num = Main.SC.nextLine();
			switch (num) {
			case "1":noticeList(); break;
			case "2":noticeList2(); break;
			case "3":searchNoticeByTitle(); break;		
			case "4":searchNoticeByContent(); break;		
			case "5":noticeDetailByNo(); break;
			case "9": return; 
			default: System.out.println("잘 못 입력하셨습니다.");
		}
			
		}
		}//while
	}

	// 공지글 작성(관리자만)
	public void write() {
		try {
//			if(Main.loginManager==null) {
//			throw new Exception("관리자 로그인 하고 진행하세요");
//			}
			System.out.println("===공지글 작성===");
			// 데이터
			System.out.print("제목: ");
			String title = Main.SC.nextLine();
			System.out.print("내용: ");
			String content = Main.SC.nextLine();
//			System.out.print("작성할 관리자번호: ");
//			String managerNo = Main.SC.nextLine();

			NoticeVo vo = new NoticeVo();
			vo.setTitle(title);
			vo.setContent(content);
//			vo.setManagerNo(managerNo);

			// 서비스
			int result = service.write(vo);

			// 결과
			if (result != 1) {
				throw new Exception("작성할 관리자번호를 잘 못 입력하셨습니다.");
			}
			System.out.println("공지글 작성에 성공하셨습니다.");
			
		} catch (Exception e) {
			System.out.println("공지글 작성에 실패하셨습니다.");
			e.printStackTrace();
		}
		

	}// write()end

	// 공지글 조회(최신순)//유저
	public void noticeList() {

		System.out.println("==공지글 목록 조회 (최신순)==");
		try {
			// 서비스
			ArrayList<NoticeVo> voList = service.noticeList();

			// 결과
			System.out.print("번호");
			System.out.print(" | ");
			System.out.print("제목");
			System.out.print(" | ");
			System.out.print("닉네임");
			System.out.print(" | ");
			System.out.print("조회수");
			System.out.print(" | ");
			System.out.println("작성일자");

			for (NoticeVo vo : voList) {
				System.out.print(vo.getNo());
				System.out.print(" | ");
				System.out.print(vo.getTitle());
				System.out.print(" | ");
				System.out.print(vo.getManagerName());
				System.out.print(" | ");
				System.out.print(vo.getHit());
				System.out.print(" | ");
				System.out.println(vo.getEnrolldate());
			}
			System.out.println("공지글 조회에 성공하였습니다.");
		} catch (Exception e) {
			System.out.println("공지글 조회를 실패하였습니다.");
			e.printStackTrace();
		}
		
		
	}// noticeList() end
	
	// 공지글 조회(최신순)//관리자
		public void adminNoticeList() {

			System.out.println("==공지글 목록 조회 (최신순)==");
			try {
				// 서비스
				ArrayList<NoticeVo> voList = service.adminNoticeList();

				// 결과
				System.out.print("번호");
				System.out.print(" | ");
				System.out.print("제목");
				System.out.print(" | ");
				System.out.print("닉네임");
				System.out.print(" | ");
				System.out.print("조회수");
				System.out.print(" | ");
				System.out.print("작성일자");
				System.out.print(" | ");
				System.out.println("공지글 비공개여부");

				for (NoticeVo vo : voList) {
					System.out.print(vo.getNo());
					System.out.print(" | ");
					System.out.print(vo.getTitle());
					System.out.print(" | ");
					System.out.print(vo.getManagerName());
					System.out.print(" | ");
					System.out.print(vo.getHit());
					System.out.print(" | ");
					System.out.print(vo.getEnrolldate());
					System.out.print(" | ");
					if(vo.getSecretYn().equals("Y")) {
						System.out.println("비밀글");
					}else {
						System.out.println("전체공개");
					}
				}
				System.out.println("공지글 조회에 성공하였습니다.");
				
			} catch (Exception e) {
				System.out.println("공지글 조회를 실패하였습니다.");
				e.printStackTrace();
			}
			
		}// adminNoticeList() end
		
	// 공지글 상세 조회(no기본키로)//유저
	public void noticeDetailByNo() {
		try {
			System.out.println("==공지글 상세 조회==");
			// 데이터
			System.out.print("조회할 공지글 번호: ");
			String num = Main.SC.nextLine();

			// 서비스
			NoticeVo vo = service.noticeDetailByNo(num);

			// 결과
			if (vo == null) {
				throw new Exception("비공개 공지글 입니다.");
			}
			System.out.println("------------------------------");
			System.out.println("글번호: " + vo.getNo());
			System.out.println("제목: " + vo.getTitle());
			System.out.println("내용: " + vo.getContent());
			System.out.println("관리자 닉네임: " + vo.getManagerName());
			System.out.println("조회수: " + vo.getHit());
			System.out.println("작성일시: " + vo.getEnrolldate());
			if(vo.getEditDate()!=null) {
				System.out.println("수정일시: " + vo.getEditDate());
			}
			System.out.println("------------------------------");
			System.out.println("공지글 상세 조회에 성공하였습니다.");
			
		} catch (Exception e) {
			System.out.println("공지글 상세 조회 실패");
			e.printStackTrace();
			
		}
		
		

	}// noticeDetailByNo() end
	
	// 공지글 상세 조회(no기본키로)//관리자
		public void adminNoticeDetailByNo() {
			try {
				System.out.println("==공지글 상세 조회==");
				// 데이터
				System.out.print("조회할 공지글 번호: ");
				String num = Main.SC.nextLine();

				// 서비스
				NoticeVo vo = service.adminNoticeDetailByNo(num);

				// 결과
				if (vo == null) {
					throw new Exception();
				}
				System.out.println("------------------------------");
				System.out.println("글번호: " + vo.getNo());
				System.out.println("제목: " + vo.getTitle());
				System.out.println("내용: " + vo.getContent());
				System.out.println("관리자 닉네임: " + vo.getManagerName());
				System.out.println("조회수: " + vo.getHit());
				System.out.println("작성일시: " + vo.getEnrolldate());
				if(vo.getEditDate()!=null) {
					System.out.println("수정일시: " + vo.getEditDate());
				}
				if(vo.getSecretYn().equals("Y")) {
					System.out.println("비공개여부: 비밀글");
				}else {
					System.out.println("비공개여부: 전체공개");
				}
				System.out.println("------------------------------");
				System.out.println("공지글 상세 조회에 성공하였습니다.");
				
			} catch (Exception e) {
				System.out.println("공지글 상세 조회 실패");
				e.printStackTrace();
				
			}
			

		}// adminNoticeDetailByNo() end

	// 공지글 검색(제목)//유저
	public void searchNoticeByTitle() {
		try {
			System.out.println("==제목으로 공지글 검색==");
			// 데이터
			System.out.print("제목 검색: ");
			String search = Main.SC.nextLine();

			// 서비스
			ArrayList<NoticeVo> voList = service.searchNoticeByTitle(search);

			// 결과
			if (voList.size() == 0) {
				System.out.println("검색 결과가 없습니다.");
			}

			for (NoticeVo vo : voList) {
				System.out.println("------------------------------");
				System.out.println("글번호: " + vo.getNo());
				System.out.println("제목: " + vo.getTitle());
				System.out.println("닉네임: " + vo.getManagerName());
				System.out.println("조회수: " + vo.getHit());
				System.out.println("작성일시: " + vo.getEnrolldate());
				System.out.println("------------------------------");
			}
			System.out.println("공지글 검색에 성공하였습니다.");
			
		} catch (Exception e) {
			System.out.println("검색에 실패 하셨습니다.");
			e.printStackTrace();
			
		}
		

	}// searchNoticeByTitle() end

	// 공지글 검색(제목)//관리자
	public void adminSearchNoticeByTitle() {
		try {
			System.out.println("==제목으로 공지글 검색==");
			// 데이터
			System.out.print("제목 검색: ");
			String search = Main.SC.nextLine();

			// 서비스
			ArrayList<NoticeVo> voList = service.adminSearchNoticeByTitle(search);

			// 결과
			if (voList.size() == 0) {
				System.out.println("검색 결과가 없습니다.");
			}

			for (NoticeVo vo : voList) {
				System.out.println("------------------------------");
				System.out.println("글번호: " + vo.getNo());
				System.out.println("제목: " + vo.getTitle());
				System.out.println("닉네임: " + vo.getManagerName());
				System.out.println("조회수: " + vo.getHit());
				System.out.println("작성일시: " + vo.getEnrolldate());
				System.out.println("------------------------------");
			}
			System.out.println("공지글 검색에 성공하였습니다.");
			
		} catch (Exception e) {
			System.out.println("검색에 실패 하셨습니다.");
			e.printStackTrace();
			}
		

	}// adminSearchNoticeByTitle() end
	
	// 공지글 수정(관리자만,비공개 된 계시판만)
	public void modify() {

		try {
//			if(Main.loginManager==null) {
//				throw new Exception("관리자 로그인 하고 진행하세요");
			System.out.println("==공지글 수정==");
			// 데이터
			System.out.print("수정할 공지글 번호: ");
			String num = Main.SC.nextLine();
			System.out.print("수정할 공지글 제목: ");
			String title = Main.SC.nextLine();
			System.out.print("수정할 공지글 내용: ");
			String content = Main.SC.nextLine();

			NoticeVo vo = new NoticeVo();
			vo.setNo(num);
			vo.setTitle(title);
			vo.setContent(content);

			// 서비스
			int result = service.modify(vo);
			// 결과
			if (result != 1) {
				throw new Exception("수정할 공지글 번호를 잘 못 입력하셨습니다.");
			}
			System.out.println("공지글 수정을 성공하셨습니다.");
			
		} catch (Exception e) {
			System.out.println("공지글 수정을 실패하셨습니다.");
			e.printStackTrace();
		}
		
	}// modify() end

	// 공지글 공개 여부(관리자만)
	public void secret() {

		try {
//			if(Main.loginManager==null) {
//				throw new Exception("관리자 로그인 하고 진행하세요");
//			}
			System.out.println("==공지글 비공개 여부==");
			// 데이터
			System.out.print("공지글 번호: ");
			String num = Main.SC.nextLine();
			System.out.print("공지글 비공개 여부: ");
			String choice = Main.SC.nextLine();

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("noticeNum", num);
			map.put("secretChoice", choice);

			// 서비스
			int result = service.secret(map);

			// 결과
			if (result != 1) {
				throw new Exception("공지글번호 또는 비공개여부 체크를 잘 못 입력하셨습니다");
			}
			System.out.println("공지글 비공개 여부를 완료하셨습니다.");
			
			
		} catch (Exception e) {
			System.out.println("공지글 비공개 여부를 실패하셨습니다.");
			e.printStackTrace();
		}
		
	}// secret() end

	// 공지글 조회(조회수순)//유저
	public void noticeList2() {
		// 데이터

		try {
			System.out.println("==공지글 목록 조회 (조회수)==");
			// 서비스
			ArrayList<NoticeVo> voList = service.noticeList2();

			// 결과
			System.out.print("번호");
			System.out.print(" | ");
			System.out.print("제목");
			System.out.print(" | ");
			System.out.print("닉네임");
			System.out.print(" | ");
			System.out.print("조회수");
			System.out.print(" | ");
			System.out.println("작성일자");

			for (NoticeVo vo : voList) {
				System.out.print(vo.getNo());
				System.out.print(" | ");
				System.out.print(vo.getTitle());
				System.out.print(" | ");
				System.out.print(vo.getManagerName());
				System.out.print(" | ");
				System.out.print(vo.getHit());
				System.out.print(" | ");
				System.out.println(vo.getEnrolldate());
			}
			System.out.println("공지글 조회에 성공하였습니다.");

		} catch (Exception e) {
			System.out.println("공지글 조회를 실패하였습니다.");
			e.printStackTrace();
		}
		
	}// noticeList2 end
	
	// 공지글 조회(조회수순)//관리자
		public void adminNoticeList2() {
			// 데이터

			try {
				System.out.println("==공지글 목록 조회 (조회수)==");
				// 서비스
				ArrayList<NoticeVo> voList = service.adminNoticeList2();

				// 결과
				System.out.print("번호");
				System.out.print(" | ");
				System.out.print("제목");
				System.out.print(" | ");
				System.out.print("닉네임");
				System.out.print(" | ");
				System.out.print("조회수");
				System.out.print(" |");
				System.out.println("작성일자   ");

				for (NoticeVo vo : voList) {
					System.out.print(vo.getNo());
					System.out.print(" | ");
					System.out.print(vo.getTitle());
					System.out.print(" | ");
					System.out.print(vo.getManagerName());
					System.out.print(" | ");
					System.out.print(vo.getHit());
					System.out.print(" | ");
					System.out.println(vo.getEnrolldate());
				}
				System.out.println("공지글 조회에 성공하였습니다.");
			} catch (Exception e) {
				System.out.println("공지글 조회를 실패하였습니다.");
				e.printStackTrace();
			}
			
		}// adminNoticeList2 end
	
	//게시글 검색(내용)//유저
	public void searchNoticeByContent() {

		try {
			System.out.println("==내용으로 공지글 검색==");
			// 데이터
			System.out.print("내용 검색: ");
			String content = Main.SC.nextLine();

			// 서비스
			ArrayList<NoticeVo> voList = service.searchNoticeByContent(content);

			System.out.println();

			// 결과
			if (voList.size() == 0) {
				System.out.println("검색 결과가 없습니다.");
			}
			for (NoticeVo vo : voList) {
				System.out.println("------------------------------");
				System.out.println("글번호: " + vo.getNo());
				System.out.println("제목: " + vo.getTitle());
				System.out.println("닉네임: " + vo.getManagerName());
				System.out.println("조회수: " + vo.getHit());
				System.out.println("작성일시: " + vo.getEnrolldate());
				System.out.println("------------------------------");
			}
			System.out.println("공지글 검색에 성공하였습니다.");
		} catch (Exception e) {
			System.out.println("검색에 실패 하셨습니다.");
			e.printStackTrace();
		}
		

	}
	
	//게시글 검색(내용)//관리자
		public void adminSearchNoticeByContent() {

			try {
				System.out.println("==내용으로 공지글 검색==");
				// 데이터
				System.out.print("내용 검색: ");
				String content = Main.SC.nextLine();

				// 서비스
				ArrayList<NoticeVo> voList = service.adminSearchNoticeByContent(content);

				System.out.println();

				// 결과
				if (voList.size() == 0) {
					System.out.println("검색 결과가 없습니다.");
				}
				for (NoticeVo vo : voList) {
					System.out.println("------------------------------");
					System.out.println("글번호: " + vo.getNo());
					System.out.println("제목: " + vo.getTitle());
					System.out.println("닉네임: " + vo.getManagerName());
					System.out.println("조회수: " + vo.getHit());
					System.out.println("작성일시: " + vo.getEnrolldate());
					System.out.println("------------------------------");
				}
				System.out.println("공지글 조회에 성공하였습니다.");
				
			} catch (Exception e) {
				System.out.println("검색에 실패 하셨습니다.");
				e.printStackTrace();
			}
			
		}

}// class
