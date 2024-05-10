package com.vam.model;

import java.util.Date;

import lombok.Data;

public class CompanyVO {
    /* 작가 아이디 */
    private int companyId;
    
    /* 작가 이름 */
    private String companyName;
    
    /* 국가 id */
    private String nationId;
    
    /* 작가 국가 */
    private String nationName;
    
    /* 작가 소개 */
    private String companyIntro;
    
    /*등록 날짜*/
    private Date regDate;
    
    /* 수정 날짜 */
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
	        this.nationName = "국내";
	    } else {
	        this.nationName = "국외";
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
