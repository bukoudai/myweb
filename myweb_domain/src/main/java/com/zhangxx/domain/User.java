package com.zhangxx.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;




/**
 * 管理员用户PO类
 * @author 布口袋
 *
 */
@Entity
@Table (name="admin_user",catalog="myweb",uniqueConstraints = {@UniqueConstraint(columnNames="username")})
public class User {
	/**
	 * 主键为UUID
	 */
	@Id
	@GenericGenerator(name ="myuuid",strategy ="uuid")
	@GeneratedValue(generator="myuuid")
	private String uid;
	
	private String username;
	private String password;
	private String name;
	private String email;
	private String telephone;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	private String sex;
	private Integer state;
	private String code;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password="
				+ password + ", name=" + name + ", email=" + email
				+ ", telephone=" + telephone + ", birthday=" + birthday
				+ ", sex=" + sex + ", state=" + state + ", code=" + code + "]";
	}
	
}
