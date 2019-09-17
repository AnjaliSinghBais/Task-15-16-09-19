package com.ssi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Employee {
	@Id
	private int Empno;
	private String Empname;
	private int sal;
	@OneToOne//(fetch=FetchType.LAZY)
	private Laptop laptop;
	@OneToOne//(fetch=FetchType.LAZY)
	private Vehicle vehicle;


	public Employee(int empno, String empname, int sal, Laptop laptop, Vehicle vehicle) {
		super();
		Empno = empno;
		Empname = empname;
		this.sal = sal;
		this.laptop = laptop;
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Employee(int empno, String empname, int sal, Laptop laptop) {
		super();
		Empno = empno;
		Empname = empname;
		this.sal = sal;
		this.laptop = laptop;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public int getEmpno() {
		return Empno;
	}

	public void setEmpno(int empno) {
		Empno = empno;
	}

	public String getEmpname() {
		return Empname;
	}

	public void setEmpname(String empname) {
		Empname = empname;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [Empno=" + Empno + ", Empname=" + Empname + ", sal=" + sal + ", laptop=" + laptop
				+ ", vehicle=" + vehicle + "]";
	}

	public Employee(int empno, String empname, int sal) {
		super();
		Empno = empno;
		Empname = empname;
		this.sal = sal;
	}

	public Employee() {
		super();
	}

	public Employee(int empno) {
		super();
		Empno = empno;
	}

}
