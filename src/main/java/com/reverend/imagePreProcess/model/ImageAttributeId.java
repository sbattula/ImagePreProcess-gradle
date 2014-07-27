package com.reverend.imagePreProcess.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author vgajula
 *
 */
@Embeddable
public class ImageAttributeId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1776095798912301139L;
	private Long imageAttributesId;
	private Long attributeId;

	public ImageAttributeId() {
	}

	public ImageAttributeId(Long imageAttributesId, Long attributeId) {
		this.imageAttributesId = imageAttributesId;
		this.attributeId = attributeId;
	}

	@Column(name = "IMAGE_ATTRIBUTES_ID")
	public Long getImageAttributesId() {
		return this.imageAttributesId;
	}

	public void setImageAttributesId(Long imageAttributesId) {
		this.imageAttributesId = imageAttributesId;
	}

	@Column(name = "ATTRIBUTE_ID")
	public Long getAttributeId() {
		return this.attributeId;
	}

	public void setAttributeId(Long attributeId) {
		this.attributeId = attributeId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ImageAttributeId))
			return false;
		ImageAttributeId castOther = (ImageAttributeId) other;

		return ((this.getImageAttributesId() == castOther.getImageAttributesId()) || (this.getImageAttributesId() != null && castOther.getImageAttributesId() != null && this.getImageAttributesId()
				.equals(castOther.getImageAttributesId())))
				&& ((this.getAttributeId() == castOther.getAttributeId()) || (this.getAttributeId() != null && castOther.getAttributeId() != null && this.getAttributeId().equals(
						castOther.getAttributeId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getImageAttributesId() == null ? 0 : this.getImageAttributesId().hashCode());
		result = 37 * result + (getAttributeId() == null ? 0 : this.getAttributeId().hashCode());
		return result;
	}

}
