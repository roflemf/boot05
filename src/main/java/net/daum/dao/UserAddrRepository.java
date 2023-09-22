package net.daum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.daum.vo.UserAddrVO;

public interface UserAddrRepository extends JpaRepository<UserAddrVO, Integer> {

	
}
