package com.vam.service;

import java.util.List;

import com.vam.model.CompanyVO;
import com.vam.model.Criteria;

public interface CompanyService {
	public void companyEnroll(CompanyVO company);
	public List<CompanyVO> companyGetList(Criteria cri) throws Exception;
	public int companyGetTotal(Criteria cri) throws Exception;  
	public CompanyVO companyGetDetail(int companyId) throws Exception;
	public int companyModify(CompanyVO company) throws Exception;
	/* �۰� ���� ���� */
	public int companyDelete(int companyId);
	
}
