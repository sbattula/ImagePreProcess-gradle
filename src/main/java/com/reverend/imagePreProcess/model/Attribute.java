package com.reverend.imagePreProcess.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * 
 * @author vgajula
 *
 */
@Entity
@Table(name = "ATTRIBUTE", schema = "PUBLIC", catalog = "BOOTDB")
public class Attribute implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1185414209994005840L;
	
	private Long id;
	private long version;
	private AttributeType attributeType;
	private String value;
	private Set<ImageAttribute> imageAttributes = new HashSet<ImageAttribute>(0);

	public Attribute() {
	}

	public Attribute(AttributeType attributeType, String value) {
		this.attributeType = attributeType;
		this.value = value;
	}

	public Attribute(AttributeType attributeType, String value, Set<ImageAttribute> imageAttributes) {
		this.attributeType = attributeType;
		this.value = value;
		this.imageAttributes = imageAttributes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	@Column(name = "VERSION", nullable = false)
	public long getVersion() {
		return this.version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ATTRIBUTE_TYPE_ID", nullable = false)
	public AttributeType getAttributeType() {
		return this.attributeType;
	}

	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}

	@Column(name = "VALUE", nullable = false)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "attribute")
	public Set<ImageAttribute> getImageAttributes() {
		return this.imageAttributes;
	}

	public void setImageAttributes(Set<ImageAttribute> imageAttributes) {
		this.imageAttributes = imageAttributes;
	}

}
