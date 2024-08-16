package com.korea.test.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;

import org.apache.ibatis.annotations.Mapper;

import com.korea.test.vo.BoardVO;

@Mapper
public interface BoardMapper {
public List<BoardVO> selectList(HashMap<String, Integer> map);
	
	//전체게시물조회
	public int getRowTotal();
	
	public BoardVO selectOne(int idx);
	
	public int update_readhit(int idx);
	
	public int insert(BoardVO vo);
	
	public int del_update(BoardVO vo);
	
	public List<Subject> selectSub(HashMap<String, Integer> map);


	
	
}
