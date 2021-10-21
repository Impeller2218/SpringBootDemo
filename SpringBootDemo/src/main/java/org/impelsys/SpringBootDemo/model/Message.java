package org.impelsys.SpringBootDemo.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Message {
		
		@Id
		@Column(name="msg_id")
		private int messageId;
		
		@Column
		private int messageContent;
		
		public int getMessageId() {
			return messageId;
		}

		public void setMessageId(int messageId) {
			this.messageId = messageId;
		}

		public int getMessageContent() {
			return messageContent;
		}

		public void setMessageContent(int messageContent) {
			this.messageContent = messageContent;
		}

	

		public List<Likes> getLikedBy() {
			return likedBy;
		}

		public void setLikedBy(List<Likes> likedBy) {
			this.likedBy = likedBy;
		}

		public List<User> getUserList() {
			return userList;
		}

		public void setUserList(List<User> userList) {
			this.userList = userList;
		}

		@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
		@JoinTable(name="message_like",joinColumns={
		@JoinColumn(name="msg_id",referencedColumnName ="msg_id" )},
		inverseJoinColumns= {@JoinColumn(name="likedBy",referencedColumnName ="like_id" )
		
		})
		private List<Likes> likedBy;
		
		@ManyToMany(mappedBy="messageList")
		private List<User> userList;
}
