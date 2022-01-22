package com.spring.db.jdbc.score.model;

/**
-- 점수 테이블 생성
-- NUMBER(5,2) : 정수부, 실수부를 합쳐서 총 5자리, 소숫점 둘째자리까지 표기
CREATE TABLE scores(
    stu_id NUMBER PRIMARY KEY,
    stu_name VARCHAR2(30) not null,
    kor NUMBER DEFAULT 0,
    eng NUMBER DEFAULT 0,
    math NUMBER DEFAULT 0,
    total NUMBER DEFAULT 0,
    average NUMBER(5,2)
);

-- 시퀀스 생성 (순차적으로 증가하는 순번을 반환하는 데이터베이스의 객체
CREATE SEQUENCE id_seq
    START with 1 INCREMENT by 1 MAXVALUE 1000
    NOCYCLE NOCACHE;
*/
public class ScoreVO {
	private int stuId;
	private String stuName;
	private int kor;
	private int math;
	private int eng;
	
	private int total;
	private double average;
	
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
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
	
	// 총점, 평균을 구하는 메서드
	public void calcData() {
		this.total = this.kor + this.math + this.eng;
		this.average = this.total / 3.0;
	}
	
	@Override
	public String toString() {
		return "ScoreVO [stuId=" + stuId + ", stuName=" + stuName
				+ ", kor=" + kor + ", math=" + math + ", eng=" + eng
				+ ", total=" + total + ", average=" + average + "]";
	}
}
