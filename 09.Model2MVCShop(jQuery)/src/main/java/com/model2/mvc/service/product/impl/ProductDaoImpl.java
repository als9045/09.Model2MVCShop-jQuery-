package com.model2.mvc.service.product.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductDao;


//==> 雀盔包府 DAO CRUD 备泅
@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//Constructor
	public  ProductDaoImpl() {
		System.out.println(this.getClass()+"===积己磊==");
	}
	
	@Override
	public void addProduct(Product product) throws Exception {
		sqlSession.insert("ProductMapper.addProduct",product);
		
	}
	@Override
	public Product getProduct(int prodNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ProductMapper.getProduct",prodNo);
	}
	@Override
	public List<Product> getProductList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ProductMapper.getProductList", search);
	}
	@Override
	public void updateProduct(Product product) throws Exception {
		sqlSession.update("ProductMapper.updateProduct", product);
		
	}
	@Override
	public int getTotalCount(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ProductMapper.getTotalCount", search);
	}

}
	
	