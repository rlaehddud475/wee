package com.korea.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;

import com.korea.test.vo.BoardVO;

public interface BoardService {
	
	public List<BoardVO> selectList(HashMap<String, Integer> map);
	
	public int getRowTotal();
	
	public BoardVO selectOne(int idx);
	
	public int update_readhit(int idx);
	
	public int insert(BoardVO vo);
	
	public int del_update(BoardVO vo);
	

	public List<Subject> selectSub(HashMap<String, Integer> map);


}
