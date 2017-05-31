package com.velo.cityon.api.vo;

import java.util.List;

public class PostDetailVO extends PostVO {
	private String contents;
	private List<ReplyVO> replies;

	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public List<ReplyVO> getReplies() {
		return replies;
	}
	public void setReplies(List<ReplyVO> replies) {
		this.replies = replies;
	}
}
