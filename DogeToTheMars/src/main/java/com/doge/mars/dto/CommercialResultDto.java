package com.doge.mars.dto;

import java.util.List;

public class CommercialResultDto {
	private List<CommercialDto> cafeList;
	private List<CommercialDto> convenienceList;
	private List<CommercialDto> pharmacyList;
	private List<CommercialDto> martList;
	private List<CommercialDto> gasStationList;
	
	public List<CommercialDto> getCafeList() {
		return cafeList;
	}
	public void setCafeList(List<CommercialDto> cafeList) {
		this.cafeList = cafeList;
	}
	public List<CommercialDto> getConvenienceList() {
		return convenienceList;
	}
	public void setConvenienceList(List<CommercialDto> convenienceList) {
		this.convenienceList = convenienceList;
	}
	public List<CommercialDto> getPharmacyList() {
		return pharmacyList;
	}
	public void setPharmacyList(List<CommercialDto> pharmacyList) {
		this.pharmacyList = pharmacyList;
	}
	public List<CommercialDto> getMartList() {
		return martList;
	}
	public void setMartList(List<CommercialDto> martList) {
		this.martList = martList;
	}
	public List<CommercialDto> getGasStationList() {
		return gasStationList;
	}
	public void setGasStationList(List<CommercialDto> gasStationList) {
		this.gasStationList = gasStationList;
	}

}
