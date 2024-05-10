package com.vam.model;

import java.util.Date;

import lombok.Data;

public class CompanyVO {
    /* �۰� ���̵� */
    private int companyId;
    
    /* �۰� �̸� */
    private String companyName;
    
    /* ���� id */
    private String nationId;
    
    /* �۰� ���� */
    private String nationName;
    
    /* �۰� �Ұ� */
    private String companyIntro;
    
    /*��� ��¥*/
    private Date regDate;
    
    /* ���� ��¥ */
    private Date updateDate;

	@Override
	public String toString() {
		return "CompanyVO [companyId=" + companyId + ", companyName=" + companyName + ", nationId=" + nationId
				+ ", nationName=" + nationName + ", companyIntro=" + companyIntro + ", regDate=" + regDate
				+ ", updateDate=" + updateDate + "]";
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getNationId() {
		return nationId;
	}

	public void setNationId(String nationId) {
	    this.nationId = nationId;
	    if(nationId.equals("01")) {
	        this.nationName = "����";
	    } else {
	        this.nationName = "����";
	    }
	}


	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public String getCompanyIntro() {
		return companyIntro;
	}

	public void setCompanyIntro(String companyIntro) {
		this.companyIntro = companyIntro;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
    public CompanyVO() {
		// TODO Auto-generated constructor stub
	}

	public CompanyVO(int companyId, String companyName, String nationId, String nationName, String companyIntro,
			Date regDate, Date updateDate) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.nationId = nationId;
		this.nationName = nationName;
		this.companyIntro = companyIntro;
		this.regDate = regDate;
		this.updateDate = updateDate;
	}
    
}
