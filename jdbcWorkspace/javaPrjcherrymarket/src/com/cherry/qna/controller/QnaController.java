package com.cherry.qna.controller;

import java.util.List;

import com.cherry.jdbc.JDBCTemplate;
import com.cherry.main.Main;
import com.cherry.qna.service.QnaService;
import com.cherry.qna.vo.QnaVo;
import com.cherry.util.Color;

public class QnaController {

	private final QnaService service;

	// 기본 생성자
	public QnaController() {
		service = new QnaService();
	}

	// 메뉴선택
	public void selectMenu() {
		while(true) {
			if(Main.loginManager == null) {
				
				System.out.println();
				System.out.println();
				qnaList();
				System.out.println();
				System.out.println();
				                              
				System.out.println(Color.RED + "========================================== QnA Menu =========================================" +  Color.EXIT);
				
				System.out.println(Color.YELLOW + "➊" + Color.EXIT + " 문의글 목록 (최신순)");
				System.out.println(Color.YELLOW + "➋" + Color.EXIT +" 문의글 작성");
				System.out.println(Color.YELLOW + "❸" + Color.EXIT + " 문의글 상세조회 (번호)");
				System.out.println(Color.YELLOW + "❹" + Color.EXIT +" 문의글 제목 검색");
				System.out.println(Color.YELLOW + "❺" + Color.EXIT + " 내가 작성한 문의글");
				System.out.println(Color.YELLOW + "❻" + Color.EXIT + " 내가 작성한 문의글 상세보기"); 
				System.out.println(Color.RED +"➒" + Color.EXIT + " 뒤로가기");  
				System.out.println(Color.RED + "=============================================================================================" + Color.EXIT);
				
				System.out.print("선택할 메뉴 : " + Color.CYAN);
				String num = Main.SC.nextLine();
				System.out.print(Color.EXIT);
				
				switch(num) {
				case "1": qnaList();break;
				case "2": write();break;
				case "3":qnaDetailByNo();break;
				case "4":searchQnaByTitle();break;
				case "5":qnaMyList();break;
				case "6":qnaMyDetail();break;
				case "9":return;
				default : System.out.println("잘못입력하셨습니다.");
				}  // 유저용
				
			}else if(Main.loginManager != null){
				
				System.out.println();
				System.out.println();
				qnaListManager();
				System.out.println();
				
				System.out.println(Color.RED + "==================================== QnA Menu (관리자용) ====================================" +  Color.EXIT);
				
				System.out.println(Color.YELLOW + "➊" + Color.EXIT +" 문의글 목록");
				System.out.println(Color.YELLOW + "➋" + Color.EXIT +" 문의글 상세조회 (번호)"); 
				System.out.println(Color.YELLOW + "❸" + Color.EXIT + " 관리자 답변작성");
				System.out.println(Color.YELLOW + "❹" + Color.EXIT +" 관리자 답변수정");
				System.out.println(Color.RED +"➒" + Color.EXIT + " 뒤로가기");
				System.out.println(Color.RED + "=============================================================================================" +  Color.EXIT);
				
				System.out.print("선택할 메뉴 : " + Color.CYAN);
				String num = Main.SC.nextLine();
				System.out.print(Color.EXIT);
				
				switch(num) {
				case "1": qnaListManager();break;
				case "2": qnaDetailByNoManager();break;
				case "3": answer();break;
				case "4": answerEdit();break;
				case "9": return;
				} // 관리자용
				
			}
			
		}
		
	}//selectMenu end	
	
/////////////////////////////////////// 유저용  /////////////////////////////////////////// 
	
	
	// 1.문의글 목록 (최신순)
	public void qnaList() {
		
		try {
			System.out.println();
			System.out.println();
			System.out.println("< 문의글 목록 >");
			System.out.println();
			
			// 데이터
			System.out.println(Color.CYAN + "▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
			System.out.printf("%-15s%-30s%-10s%-15s%-15s\n", "번호", "제목", "닉네임", "조회수", "작성일");
			System.out.println(Color.CYAN + "▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
			// 서비스
			List<QnaVo> voList = service.qnaList();
			
			// 결과
			if(voList.size() == 0) {
				System.out.println("게시글이 없습니다.");
			}
			
			for (QnaVo vo : voList) {
				
				String color = "";
				String resetColor = Color.EXIT;

				if(Main.loginMember != null) {
				}
				
				String qnaNo = vo.getQnaNo();
				String title = vo.getTitle();
				String writerNick = vo.getWriterNick();
				String hit = vo.getHit();
				String memberEnrollDate = vo.getMemberEnrollDate();
				
				System.out.println(
					    color + qnaNo+ resetColor+ title+ writerNick+ hit+ memberEnrollDate);
			}
			
			System.out.println(Color.CYAN + "▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​" + Color.EXIT);
			
		} catch (Exception e) {
			System.out.println("문의글 목록 조회 실패 ...");
			e.printStackTrace();
		}
		
	}// qnaList end
	
	// 2.문의글 작성
	public void write() {

		try {
			System.out.println();
			System.out.println();
			System.out.println("< 문의글 작성 >");
			System.out.println();

			// 로그인 여부
			if (Main.loginMember == null) {
				throw new Exception("회원만 문의글 작성이 가능합니다.");
			}
			
			// 데이터
			System.out.print("제목: " + Color.CYAN);
			String title = Main.SC.nextLine();
			System.out.print(Color.EXIT);
			System.out.print("내용: "+ Color.CYAN);
			String content = Main.SC.nextLine();
			System.out.print(Color.EXIT);
			System.out.print("비밀글로 올리시겠습니까? (Y / N)"+ Color.CYAN);
			String secretYn = Main.SC.nextLine();
			System.out.print(Color.EXIT);

			QnaVo vo = new QnaVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSecretYn(secretYn);

			// 서비스
			int result = service.write(vo);

			// 결과
			if (result != 1) {
				throw new Exception();
			}
			System.out.println("문의글 작성 완료 !!!");
			
			
		} catch (Exception e) {
			System.out.println("문의글 작성 실패 ...");
			e.printStackTrace();
		}

	}// write end


	// 3.문의글 상세조회 (번호)
	public void qnaDetailByNo() {

		try {
			System.out.println();
			System.out.println();
			System.out.println("< 문의글 상세 조회 (번호) >");
			System.out.println();

			// 데이터
			System.out.print("조회할 문의글 번호: "+ Color.CYAN);
			String num = Main.SC.nextLine();
			System.out.print(Color.EXIT);

			// 서비스
			QnaVo vo = service.qnaDetailByNo(num);

			// 결과
			if (vo == null) {
				System.out.println("해당글이 존재하지 않습니다.");
			}
			System.out.println("---------------------------------------");
			System.out.println("글번호: " + vo.getQnaNo());
			System.out.println("제목: " + vo.getTitle());
			System.out.println("작성자: " + vo.getWriterNick());
			System.out.println("조회수: " + vo.getHit());
			System.out.println("작성일자: " + vo.getMemberEnrollDate());
			System.out.println("내용: " + vo.getContent());
			System.out.println();
			
			if(vo.getAnswer() != null) {
				System.out.println("[관리자 답변] " + vo.getAnswer());
				if(vo.getManagerEditDate() == null) {
					System.out.println("[답변 작성일자]: " + vo.getManagerEnrollDate());
				}else {
					System.out.println("[답변 수정일자]: " + vo.getManagerEditDate());
				}
			}
			
			System.out.println("---------------------------------------");

			
		} catch (Exception e) {
			System.out.println("문의글 상세 조회 실패 ...");
			e.printStackTrace();
		}

	}// qnaDetailByNo end

	// 4. 문의글 검색 (제목)
	public void searchQnaByTitle() {

		try {
			System.out.println();
			System.out.println();
			System.out.println("< 문의글 제목 검색 >");
			System.out.println();
			
			// 데이터
			System.out.print("검색할 제목: " + Color.CYAN);
			String searchValue = Main.SC.nextLine();
			System.out.print(Color.EXIT);

			// 서비스
			List<QnaVo> voList = service.searchQnaByTitle(searchValue);

			// 결과
			if (voList.size() == 0) {
				System.out.println("해당글이 존재하지 않습니다.");
			}
			for (QnaVo vo : voList) {
				System.out.println();
				System.out.print("글번호: " + vo.getQnaNo());
				System.out.print(" | ");
				System.out.print("제목: " + vo.getTitle());
				System.out.print(" | ");
				System.out.print("작성자: " + vo.getWriterNick());
				System.out.print(" | ");
				System.out.print("조회수: " + vo.getHit());
				System.out.print(" | ");
				System.out.print("작성일자: " + vo.getMemberEnrollDate());
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("게시글 검색 실패 ...");
			e.printStackTrace();
		}

	}// searchQnaByTitle end

	// 5. 내가 작성한 문의글
	public void qnaMyList() {

		try {
			System.out.println();
			System.out.println();
			System.out.println("< 내가 작성한 문의글 조회 >");
			System.out.println();
			
			// 로그인 체크
			if(Main.loginMember == null) {
				throw new Exception("로그인한 회원만 내 문의글 조회가 가능합니다.");
			}
			
			//데이터
			String loginMember = Main.loginMember.getMemberNo();
			
			//서비스
			List<QnaVo> voList = service.qnaMyList(loginMember);
			
			//결과
			if(voList.size() == 0) {
				System.out.println("내가 작성한 글이 없습니다.");
			}
			for(QnaVo vo : voList) {
				System.out.println(); 
				System.out.print("글번호: " + vo.getQnaNo());
				System.out.print(" | ");
				System.out.print("제목: " + vo.getTitle());
				System.out.print(" | ");
				System.out.print("작성자: " + vo.getWriterNick());
				System.out.print(" | ");
				System.out.print("조회수: " + vo.getHit());
				System.out.print(" | ");
				System.out.print("작성일자: " + vo.getMemberEnrollDate());
				System.out.print(" | ");
				if(vo.getSecretYn().equals("Y")) {
					System.out.print("비밀글");
				}else {
					System.out.print("전체공개");
				}
				System.out.println();
			}
			
		}catch(Exception e) {
			System.out.println("게시글 목록 조회 실패 ...");
			e.printStackTrace();
		}

	} // qnaMyList

	// 6. 내가 작성한 문의글 상세보기
	public void qnaMyDetail() {
		try {
			System.out.println();
			System.out.println();
			System.out.println("< 나의 문의글 상세 조회 >");
			System.out.println();

			// 데이터
			String loginMember = Main.loginMember.getMemberNo();
			
			// 서비스
			List<QnaVo> voList = service.qnaMyDetail(loginMember);

			// 결과
			if (voList.size() == 0) {
				System.out.println("해당글이 존재하지 않습니다.");
			}
			for(QnaVo vo : voList) {
				System.out.println("---------------------------------------");
				System.out.println("글번호: " + vo.getQnaNo());
				System.out.println("제목: " + vo.getTitle());
				System.out.println("작성자: " + vo.getWriterNick());
				System.out.println("조회수: " + vo.getHit());
				System.out.println("작성일자: " + vo.getMemberEnrollDate());
				System.out.println("내용: " + vo.getContent());
				System.out.println();
				if(vo.getSecretYn().equals("Y")) {
					System.out.print("비밀글");
				}else {
					System.out.println("전체공개");
				}
				System.out.println();
				
				if(vo.getAnswer() != null) {
					System.out.println("[관리자 답변] " + vo.getAnswer());
					if(vo.getManagerEditDate() == null) {
						System.out.println("답변 작성일자: " + vo.getManagerEnrollDate());
					}else {
						System.out.println("답변 수정일자: " + vo.getManagerEditDate());
					}
				}
				System.out.println();
				System.out.println("---------------------------------------");
			}
		} catch (Exception e) {
			System.out.println("나의 문의글 상세 조회 실패 ...");
			e.printStackTrace();
		}
		
	}// qnaMyDetail end
	
	
	
	/////////////////////////////////////// 관리자용  /////////////////////////////////////////// 
	
	
	
	// 1. 문의글 목록 (관리자용)
	public void qnaListManager() {
		try {
			System.out.println();
			System.out.println();
			System.out.println("< 문의글 목록 (관리자용) >");
			System.out.println();
			
			// 데이터 %-10s
			System.out.println(Color.CYAN + "▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃▃▃▃▃▃▃▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃▃▃​​​​​" + Color.EXIT);
			System.out.printf("%-15s%-30s%-10s%-15s%-15s%-5s\n", "번호", "제목", "닉네임", "조회수", "작성일" , "비밀글 여부");
			System.out.println(Color.CYAN + "▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃▃▃▃▃▃▃▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃▃▃​​​​​" + Color.EXIT);
			
			// 서비스  %-10s
			List<QnaVo> voList = service.qnaListManager();
			
			// 결과
			if(voList.size() == 0) {
				System.out.println("게시글이 존재하지 않습니다.");
			}
			
			for(QnaVo vo : voList) {
				String color = "";
				String resetColor = Color.EXIT;
				
				String qnaNo = vo.getQnaNo();
				String title = vo.getTitle();
				String writerNick = vo.getWriterNick();
				String hit = vo.getHit();
				String memberEnrollDate = vo.getMemberEnrollDate();
				String secretYn = vo.getSecretYn();
				
				if (secretYn.substring(0,1).equals("Y")) {
					secretYn = "비밀글";
				} else {
					secretYn = "전체공개";
				}
				System.out.println(color + qnaNo + resetColor + title + writerNick + hit + memberEnrollDate + secretYn);
			}
			
			System.out.println(Color.CYAN + "▃▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​▃▃▃​​​​​▃▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃▃​​​​​▃▃▃▃▃▃▃▃▃▃▃▃​​​​​▃▃▃▃▃​​​​​▃▃▃▃▃​​​​​" + Color.EXIT);
			
		}catch(Exception e) {
			System.out.println("게시글 목록 조회 실패 ...");
			e.printStackTrace();
		}
		
	}//qnaListManger end
	
	
	// 2. 문의글 상세조회 (번호)   
	public void qnaDetailByNoManager() {
		
		try {
			System.out.println();
			System.out.println();
			System.out.println("< 문의글 상세 조회 (번호) >");
			System.out.println();

			// 데이터
			System.out.print("조회할 문의글 번호: " + Color.CYAN);
			String num = Main.SC.nextLine();
			System.out.print(Color.EXIT);

			// 서비스
			QnaVo vo = service.qnaDetailByNoManager(num);

			// 결과
			if (vo == null) {
				System.out.println("해당글이 존재하지 않습니다.");
			}
			System.out.println("---------------------------------------");
			System.out.println("글번호: " + vo.getQnaNo());
			System.out.println("제목: " + vo.getTitle());
			System.out.println("작성자: " + vo.getWriterNick());
			System.out.println("조회수: " + vo.getHit());
			System.out.println("작성일자: " + vo.getMemberEnrollDate());
			System.out.println("내용: " + vo.getContent());
			System.out.println();
			if(vo.getSecretYn().equals("Y")) {
				System.out.print("비밀글");
			}else {
				System.out.println("전체공개");
			}
			System.out.println();
			if(vo.getAnswer() != null) {
				System.out.println("[관리자 답변] " + vo.getAnswer());
				if(vo.getManagerEditDate() == null) {
					System.out.println("답변 작성일자: " + vo.getManagerEnrollDate());
				}else {
					System.out.println("답변 수정일자: " + vo.getManagerEditDate());
				}
			}
			System.out.println("---------------------------------------");

		} catch (Exception e) {
			System.out.println("문의글 상세 조회 실패 ...");
			e.printStackTrace();
		}
		
	}//qnaDetailByNoManager end
	
	
	// 3. 관리자 답변작성
	public void answer() {
		try {
			System.out.println();
			System.out.println();
			System.out.println("< 관리자 답변작성 >");
			System.out.println();
			
			// 데이터
			System.out.print("답글을 작성할 글 번호: " + Color.CYAN);
			String no = Main.SC.nextLine();
			System.out.print(Color.EXIT);
			System.out.print("내용: " + Color.CYAN);
			String answer = Main.SC.nextLine();
			System.out.print(Color.EXIT);
			
			QnaVo vo = new QnaVo();
			vo.setQnaNo(no);
			vo.setAnswer(answer);
			
			// 서비스
			int result = service.answer(vo);
			QnaVo Mo = service.answerPrint(no);
			
			// 결과
			if(result != 1) {
				throw new Exception("이미 답변을 작성했습니다. 수정을 원하시면 '관리자 답변수정' 메뉴로 들어가주세요!");
			}
			System.out.println("답변 작성 성공 !!!");
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.println("글번호: " + Mo.getQnaNo());
			System.out.println("제목: " + Mo.getTitle());
			System.out.println("내용: " + Mo.getContent());
			System.out.println("작성자: " + Mo.getWriterNick());
			System.out.println("작성일자: " + Mo.getMemberEnrollDate());
			System.out.println();
			if(Mo.getAnswer() != null) {
				System.out.println("[관리자 답변] " + Mo.getAnswer());
				System.out.println("답변 작성일자: " + Mo.getManagerEnrollDate());
			}
			System.out.println("---------------------------------------");
			
		}catch(Exception e) {
			System.out.println("답변 작성 실패 ...");
			e.printStackTrace();
		}
		
	}//answer end
	
	
	// 4. 관리자 답변수정
	public void answerEdit() {

		try {
			System.out.println();
			System.out.println();
			System.out.println("< 관리자 답변 수정 >");
			System.out.println();

			// 데이터
			System.out.print("수정할 글 번호: " + Color.CYAN);
			String no = Main.SC.nextLine();
			System.out.print(Color.EXIT);
			System.out.print("수정할 내용: " + Color.CYAN);
			String answer = Main.SC.nextLine();
			System.out.print(Color.EXIT);
			
			QnaVo vo = new QnaVo();
			vo.setQnaNo(no);
			vo.setAnswer(answer);
			
			// 서비스
			int result = service.answerEdit(vo);
			QnaVo Vo = service.answerPrint(no);
			
			// 결과 
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("답변 수정 성공 !!!");
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.println("글번호: " + Vo.getQnaNo());
			System.out.println("제목: " + Vo.getTitle());
			System.out.println("내용: " + Vo.getContent());
			System.out.println("작성자: " + Vo.getWriterNick());
			System.out.println("작성일자: " + Vo.getMemberEnrollDate());
			System.out.println();
			if(Vo.getAnswer() != null) {
				System.out.println("[관리자 답변] " + Vo.getAnswer());
				System.out.println("답변 수정일자: " + Vo.getManagerEditDate());
			}
			System.out.println("---------------------------------------");
		}catch(Exception e) {
			System.out.println("답변 수정 실패 ...");
			e.printStackTrace();
		}
		
	}//answerEdit end
	
	
}
