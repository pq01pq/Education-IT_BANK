package com.spring.web.model;

public class ScoreVO {
	private String stuName;
	private int kor;
	private int math;
	private int eng;
	private int total;
	private double average;
	
	// 총점, 평균을 구하는 메서드
	public void calcData() {
		this.total = this.kor + this.math + this.eng;
		this.average = Math.round((this.total / 3.0) * 100) / 100.0;
		// Math.round : 소숫점 첫째자리에서 반올림
	}
	
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	
	@Override
	public String toString() {
		return "ScoreVO [stuName=" + stuName + ", kor=" + kor + ", math=" + math + ", eng=" + eng + ", total=" + total
				+ ", average=" + average + "]";
	}
	
	
}
