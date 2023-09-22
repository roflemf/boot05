package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.UserAddrService;
import net.daum.vo.UserAddrVO;

@Controller
public class UserAddrController {
	
	@Autowired
	private UserAddrService UserAddrService;

	@RequestMapping(value = "/mybatis_jpa", method=RequestMethod.GET) 
	//get으로 접근하는 매핑주소 처리, mybatis_jpa 매핑주소 등록
	public void mybatis_jpa(Model m) {
		//반환(return)타입이 없는 void형이면 매핑주소가 뷰페이지 파일명이 됌.
		//뷰페이지 경로; /WEB-INF/viwes/mybatis_jpa.jsp
		
		m.addAttribute("content_title", "mybatis_jpq매핑주소 실행과 이름 , 주소 폼 연동 연습");
	}//mybatis_jpa
	
	//스프링 부트로 저장연습
	@PostMapping("/mybatis_jpa")//포스트로 접근하는 매핑주소
	public ModelAndView mybatis_jpa(UserAddrVO useraddr) {//전달인자 타입 다르게한 메서드 오버로딩
		/* UserAddrVO useraddr ; 뷰페이지 네임 파라미터 이름과 엔티티빈 클래스명 변수명이 같으면 
		 * user addr에 이름과 주소가 저장되어있다.
 		 * 
		 */
		
		this.UserAddrService.insertUserAddr(useraddr); //이름과 주소 저장
		/* 문제) useraddr.xml mybatis 매퍼태그에 유일 아이디명 useraddr_in으로 해서 
		 * bno_seq2를 사용하고, 날짜함수 sysdate를 사용해 이름과 주소를 저장하는 코드를 완성시켜 보자.
		 * 스프링 MVC 흐름도 ; UserAddrController.java -> UserAddrService.java -> UserAddrServiceImpl.java->
		 * 					UserAddrDAO.java -> UserAddrDAOImpl.java -> useraddr.xml
		 */
		
		ModelAndView okM=new ModelAndView("resultSuccess"); 
		//생성자 인자값으로 뷰페이지 파일명 설정 
		//=>뷰페이지경로; /WEB-INF/views/resultSuccess.jsp
		okM.addObject("result", "이름과 주소 저장 성공!");//result키이름에 값을 저장
		return okM;
		
	}
}
