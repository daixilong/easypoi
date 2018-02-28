package com.xiaodai.tool_easypoi.model;

import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

@ExcelTarget(value="Person")
public class Person {
	
	 @Excel(name="姓名",width=100,isImportField="true",orderNum="2")
   private String name;
   
	 @Excel(name="年龄",width=100,isImportField="true",orderNum="1")
   private Integer age;
   
	 @Excel(name="出生",databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd", isImportField = "true_st", width = 20)
   private Date birth;
   
	 @Excel(name = "学生性别", replace = { "男_1", "女_2" }, suffix = "生", isImportField = "true_st")
   private Integer sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Person(String name, Integer age, Date birth, Integer sex) {
		super();
		this.name = name;
		this.age = age;
		this.birth = birth;
		this.sex = sex;
	}
   
   
  public Person(){} 
}
