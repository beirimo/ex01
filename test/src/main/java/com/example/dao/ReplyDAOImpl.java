package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.QueryVO;
import com.example.domain.ReplyVO;


@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.ReplyMapper";
	

	


	@Override
	public void insert(ReplyVO vo) {
		session.insert(namespace +".Rinsert", vo);
		
	}





	@Override
	public void delete(int rid) {
		session.delete(namespace + ".Rdelete",rid);
		
	}





	@Override
	public void update(ReplyVO vo) {
		session.update(namespace + ".Rupdate", vo);
		
	}





	@Override
	public ReplyVO read(int rid) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public List<HashMap<String, Object>> list(int bid, QueryVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
