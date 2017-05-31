package com.velo.cityon.api.vo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;


@Document(collection="reply")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReplyVO {
	@Id
	private String id;
	private String writer;
	private Date date;
	private String contents;
	private List<ReReplyVO> replies;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public List<ReReplyVO> getReplies() {
		return replies;
	}
	public void setReplies(List<ReReplyVO> replies) {
		this.replies = replies;
	}
	
}
