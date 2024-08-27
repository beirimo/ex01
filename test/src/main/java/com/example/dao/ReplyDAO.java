package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.QueryVO;
import com.example.domain.ReplyVO;

public interface ReplyDAO {
	public void insert(ReplyVO vo);
	public void delete(int rid);
	public void update(ReplyVO vo);
	public ReplyVO read(int rid);
	public List<HashMap<String,Object>> list(int bid, QueryVO vo);

}
