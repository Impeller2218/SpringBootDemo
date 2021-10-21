package org.impelsys.SpringBootDemo.model;

import java.util.List;

import javax.persistence.*;


@Entity
public class Likes {
	@Id
	@Column(name="like_id")
	private int likeId;
	
	@ManyToMany(mappedBy="likedBy")
	private List<Message> messageList;

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}
	
}
