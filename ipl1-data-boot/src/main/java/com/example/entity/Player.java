package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Player {
	@Id
	private int jno;
	@Column
	private String name;
	@Column
	private String genre;
	@Column
	private double bidAmt;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="tId")
	private Team t;
	public int getJno() {
		return jno;
	}
	public void setJno(int jno) {
		this.jno = jno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getBidAmt() {
		return bidAmt;
	}
	public void setBidAmt(double bidAmt) {
		this.bidAmt = bidAmt;
	}
	public Team getT() {
		return t;
	}
	public void setT(Team t) {
		this.t = t;
	}
	
	
}

