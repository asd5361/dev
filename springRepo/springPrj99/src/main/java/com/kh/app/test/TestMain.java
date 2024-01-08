package com.kh.app.test;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.app.gallery.dao.GalleryDao;
import com.kh.app.gallery.service.GalleryService;
import com.kh.app.gallery.vo.GalleryVo;

public class TestMain {

	public static void main(String[] args) {
		GalleryDao dao = new GalleryDao();
		SqlSessionTemplate sst = new SqlSessionTemplate(null);
		GalleryService service = new GalleryService(dao,sst);
		
		test01(service);
		test02(service);
	}
	

	//작성하기 TEST
	public static void test01(GalleryService service) {
		
		GalleryVo gvo = new GalleryVo();
		gvo.setTitle("제목01");
		gvo.setFullPath("D:/dev/zzz.png");
		gvo.setWriterNo("1");
		int result = service.write(gvo);
		
		if(result == 1) {
			System.out.println("[작성하기] 테스트 성공");			
		}else {
			System.out.println("[작성하기] 테스트 실패");			
		}
	}

	// 목록조회 TEST
	private static void test02(GalleryService service) {
		List<GalleryVo> gvoList = service.list();
		
		if(gvoList.size() == 1) {
			System.out.println("[목록조회] 테스트 성공");			
		}else {
			System.out.println("[목록조회 ] 테스트 실패");			
		}
			
	}
	
}
