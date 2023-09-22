package net.daum.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity //JPA를 다루는 엔티티빈 클래스
@SequenceGenerator(//시퀀스 생성기
		name = "bno_seq2_gename", //시퀀스 제네레이터 이름
		sequenceName = "bno_seq2", //시퀀스 이름
		initialValue = 1, //시작값
		allocationSize = 1  //증가값, 기본값은 50
		) 
@Table(name="tbl_useraddr2")
public class UserAddrVO {//tbl_useraddr2 테이블명 지정
	
	@Id //기본키(구분키) 지정
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "bno_seq2_gename" //시퀀스 제네레이터 이름
			)
	private int userno; //번호(기본키)
	private String username; //이름
	
	@Column(length=4000)//varchar2(사이즈지정; 컬럼크기를 4000으로 설정)
	private String useraddr; //주소
	
	@CreationTimestamp //등록날짜 지정(하이버네이트에서 제공)
	private Timestamp regdate;
	

}
