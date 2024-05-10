package com.vam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.CompanyMapper;
import com.vam.model.CompanyVO;
import com.vam.model.Criteria;
@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	CompanyMapper companymapper;
	
	public void companyEnroll(CompanyVO company) {
		companymapper.companyEnroll(company);
		
	}
	@Override
    public List<CompanyVO> companyGetList(Criteria cri) throws Exception {
        
        return companymapper.companyGetList(cri);
    }
	@Override
	public int companyGetTotal(Criteria cri) throws Exception {
		 return companymapper.companyGetTotal(cri);
	}
	
	@Override
	public CompanyVO companyGetDetail(int companyId) throws Exception {
		
		return companymapper.companyGetDetail(companyId);
	}
	@Override
	public int companyModify(CompanyVO company) throws Exception {
		return companymapper.companyModify(company);
	}
	@Override
	public int companyDelete(int companyId) {
		// TODO Auto-generated method stub
		return companymapper.companyDelete(companyId);
	}
	
}



