package com.vam.model;

import lombok.Data;

@Data
public class MemberVO {
	//ȸ�� id
		private String memberId;
		
		//ȸ�� ��й�ȣ
		private String memberPw;
		
		//ȸ�� �̸�
		private String memberName;
		
		//ȸ�� �̸���
		private String memberMail;
		
		//ȸ�� �����ȣ
		private String memberAddr1;
		
		//ȸ�� �ּ�
		private String memberAddr2;
		
		//ȸ�� ���ּ�
		private String memberAddr3;
		
		// ������ ����(0:�Ϲݻ����, 1:������)
		private int adminCk;
		
		//�������
		private int regDate;
		
		//ȸ�� ��
		private int money;
		
		//ȸ�� ����Ʈ
		private int point;
}
