package com.epam.dsb.denmarkRailway.bo;

public class Trip {
	
	private String date;
    private String email;
    private String cardNumber;
    private String NameOfPassenger;
	
    public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNameOfPassenger() {
		return NameOfPassenger;
	}
	public void setNameOfPassenger(String nameOfPassenger) {
		NameOfPassenger = nameOfPassenger;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
