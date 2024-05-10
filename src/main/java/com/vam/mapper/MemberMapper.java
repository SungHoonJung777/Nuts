package com.vam.mapper;

import com.vam.model.MemberVO;

public interface MemberMapper {
	public void memberJoin(MemberVO member);
	
	public int idCheck(String memberId);
	
	public MemberVO memberLogin(MemberVO member);
	/* 주문자 정보 */
	public MemberVO getMemberInfo(String memberId);	
	
}
