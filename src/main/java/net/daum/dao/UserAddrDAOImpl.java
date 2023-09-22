package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.UserAddrVO;

@Repository
public class UserAddrDAOImpl implements UserAddrDAO{

	@Autowired
	private SqlSession sqlSession; //mybatis 쿼리문 수행할 sqlSession 의존성(DI) 설정
	
	@Autowired
	private UserAddrRepository UserAddrRepo; //JAP를 수행할 Repository 의존성 주입

	@Override
	public void insertUserAddr(UserAddrVO useraddr) {
		//this.sqlSession.insert("useraddr_in",useraddr);//insert()메서드가 mybatis에서는 레코드 저장
		
		System.out.println("\n =============================>JPA로 이름과 주소 저장");
		this.UserAddrRepo.save(useraddr); //this.생략가능
	}//이름과 주소 저장
}
