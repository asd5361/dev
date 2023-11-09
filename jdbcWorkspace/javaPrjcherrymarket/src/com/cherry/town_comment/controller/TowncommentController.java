package com.cherry.town_comment.controller;

import java.util.HashMap;

import com.cherry.main.Main;
import com.cherry.town.controller.TownController;
import com.cherry.town.vo.TownVo;
import com.cherry.town_comment.service.TowncommentService;
import com.cherry.town_comment.vo.TowncommentVo;

public class TowncommentController {

	
	private TowncommentService service;
	
	//
	public TowncommentController() {
		service = new TowncommentService();
	}

//  ---------------------댓글작성---------------------------------------
	public void commentwrite(TownVo tvo) {
		while(true) {
			try {
				System.out.println("============================================= 댓글작성 =============================================");
				
				System.out.print("댓글 : ");
				String content = Main.SC.nextLine();
				
				TowncommentVo vo = new TowncommentVo();
				vo.setContent(content);
				int result = service.commentwrite(vo,tvo);
				
				
				if(result != 1) {
					throw new Exception("ㅋㅋ");
				}
				return;
			}catch(Exception e) {
				System.out.println("댓글작성실패");
				e.printStackTrace();
			}	
		}
		
		
	}
	
}
