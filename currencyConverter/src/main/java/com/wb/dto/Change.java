package com.wb.dto;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Change {
	private Integer idChange;
	private String base;
	private Double rateValue;
	private String rateName;
	private String createDate;
	

	public Integer getIdChange() {
		return idChange;
	}
	public void setIdChange(Integer idChange) {
		this.idChange = idChange;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public Double getRateValue() {
		return rateValue;
	}
	public void setRateValue(Double rateValue) {
		this.rateValue = rateValue;
	}
	public String getRateName() {
		return rateName;
	}
	public void setRateName(String rateName) {
		this.rateName = rateName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	
}
