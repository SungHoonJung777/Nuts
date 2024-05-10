package com.vam.mapper;

import java.util.List;

import com.vam.model.CompanyVO;
import com.vam.model.Criteria;

public interface CompanyMapper {
	public void companyEnroll(CompanyVO company);
	public List<CompanyVO> companyGetList(Criteria cri);
	public int companyGetTotal(Criteria cri);
	public CompanyVO companyGetDetail(int companyId);
	public int companyModify(CompanyVO company);
	
	/* �۰� ���� ���� */
	public int companyDelete(int companyId);
}
