package com.reverend.imagePreProcess.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * 
 * @author vgajula
 *
 */
@Entity
@Table(name = "IMAGE", schema = "PUBLIC", catalog = "BOOTDB")
public class Image implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6409926803138123587L;
	private Long id;
	private long version;
	private String name;
	private Set<ImageAttribute> imageAttributes = new HashSet<ImageAttribute>(0);
	private Set<BatchImage> batchImages = new HashSet<BatchImage>(0);

	public Image() {
	}

	public Image(String name) {
		this.name = name;
	}

	public Image(String name, Set<ImageAttribute> imageAttributes, Set<BatchImage> batchImages) {
		this.name = name;
		this.imageAttributes = imageAttributes;
		this.batchImages = batchImages;
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

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "image")
	public Set<ImageAttribute> getImageAttributes() {
		return this.imageAttributes;
	}

	public void setImageAttributes(Set<ImageAttribute> imageAttributes) {
		this.imageAttributes = imageAttributes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "image")
	public Set<BatchImage> getBatchImages() {
		return this.batchImages;
	}

	public void setBatchImages(Set<BatchImage> batchImages) {
		this.batchImages = batchImages;
	}

}
