package com.kh.app.gallery.vo;

public class AttachmentVo {
	private String attachmentNo;
	private String refNo;
	private String originName;
	private String changeName;
	private String filePath;
	private String thumbnailYn;
	
	public AttachmentVo(String attachmentNo, String refNo, String originName, String changeName, String filePath,
			String thumbnailYn) {
		super();
		this.attachmentNo = attachmentNo;
		this.refNo = refNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.thumbnailYn = thumbnailYn;
	}
	public AttachmentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public final String getAttachmentNo() {
		return attachmentNo;
	}
	public final void setAttachmentNo(String attachmentNo) {
		this.attachmentNo = attachmentNo;
	}
	public final String getRefNo() {
		return refNo;
	}
	public final void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public final String getOriginName() {
		return originName;
	}
	public final void setOriginName(String originName) {
		this.originName = originName;
	}
	public final String getChangeName() {
		return changeName;
	}
	public final void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public final String getFilePath() {
		return filePath;
	}
	public final void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public final String getThumbnailYn() {
		return thumbnailYn;
	}
	public final void setThumbnailYn(String thumbnailYn) {
		this.thumbnailYn = thumbnailYn;
	}
	@Override
	public String toString() {
		return "AttachmentVo [attachmentNo=" + attachmentNo + ", refNo=" + refNo + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", thumbnailYn=" + thumbnailYn + "]";
	}
}
