package com.reverend.imagePreProcess.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author vgajula
 *
 */
@Embeddable
public class BatchImageId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4947020744189796384L;
	private Long batchImagesId;
	private Long imageId;

	public BatchImageId() {
	}

	public BatchImageId(Long batchImagesId, Long imageId) {
		this.batchImagesId = batchImagesId;
		this.imageId = imageId;
	}

	@Column(name = "BATCH_IMAGES_ID")
	public Long getBatchImagesId() {
		return this.batchImagesId;
	}

	public void setBatchImagesId(Long batchImagesId) {
		this.batchImagesId = batchImagesId;
	}

	@Column(name = "IMAGE_ID")
	public Long getImageId() {
		return this.imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BatchImageId))
			return false;
		BatchImageId castOther = (BatchImageId) other;

		return ((this.getBatchImagesId() == castOther.getBatchImagesId()) || (this.getBatchImagesId() != null && castOther.getBatchImagesId() != null && this.getBatchImagesId().equals(
				castOther.getBatchImagesId())))
				&& ((this.getImageId() == castOther.getImageId()) || (this.getImageId() != null && castOther.getImageId() != null && this.getImageId().equals(castOther.getImageId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBatchImagesId() == null ? 0 : this.getBatchImagesId().hashCode());
		result = 37 * result + (getImageId() == null ? 0 : this.getImageId().hashCode());
		return result;
	}

}
