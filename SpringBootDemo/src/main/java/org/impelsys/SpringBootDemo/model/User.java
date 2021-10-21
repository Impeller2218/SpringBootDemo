package org.impelsys.SpringBootDemo.model;

import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //(name="User")
@Entity
//@Table(name="user")
public class User {
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + "]";
	}

	@Id
	@Column(name="user_id")
	@XmlAttribute(name="userId")
	private int id;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="userEmail")
	private String userEmail;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="User_Message",joinColumns= {
			@JoinColumn(name="user_id",referencedColumnName ="user_id")},
			inverseJoinColumns ={@JoinColumn(name="msg_id",referencedColumnName ="msg_Id")}
	 )
	private List<Message> messageList;
	
	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
