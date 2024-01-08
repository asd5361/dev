package com.kh.app.gallery.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.gallery.vo.GalleryVo;

@Repository
public class GalleryDao {

	//작성하기
	public int write(SqlSessionTemplate sst,GalleryVo vo) {
		return sst.insert("GalleryMapper.write",vo);
	}
	
	//목록조회
	public List<GalleryVo> list(SqlSessionTemplate sst){
		return sst.selectList("GalleryMapper.list");
	}
	
	//단일조회
	public GalleryVo detail(SqlSessionTemplate sst, String no) {
		return sst.selectOne("GalleryMapper.detail",no);
	}
	
	//조회수 증가
	public int increaseHit(SqlSessionTemplate sst, String no) {
		return sst.update("GalleryMapper.increaseHit",no);
	}
	
	//수정하기
	public int edit(SqlSessionTemplate sst, GalleryVo vo) {
		return sst.update("GalleryMapper.edit",vo);
	}
	//삭제하기
	public int delete(SqlSessionTemplate sst, String no) {
		return sst.update("GalleryMapper.delete",no);
	}
}
