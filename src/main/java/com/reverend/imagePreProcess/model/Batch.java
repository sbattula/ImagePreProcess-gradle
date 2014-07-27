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
@Table(name = "BATCH", schema = "PUBLIC", catalog = "BOOTDB")
public class Batch implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1277623208497958508L;
	private Long id;
	private long version;
	private String path;
	private Set<BatchImage> batchImages = new HashSet<BatchImage>(0);
	private Set<ProjectBatch> projectBatches = new HashSet<ProjectBatch>(0);

	public Batch() {
	}

	public Batch(String path) {
		this.path = path;
	}

	public Batch(String path, Set<BatchImage> batchImages, Set<ProjectBatch> projectBatches) {
		this.path = path;
		this.batchImages = batchImages;
		this.projectBatches = projectBatches;
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

	@Column(name = "PATH", nullable = false)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "batch")
	public Set<BatchImage> getBatchImages() {
		return this.batchImages;
	}

	public void setBatchImages(Set<BatchImage> batchImages) {
		this.batchImages = batchImages;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "batch")
	public Set<ProjectBatch> getProjectBatches() {
		return this.projectBatches;
	}

	public void setProjectBatches(Set<ProjectBatch> projectBatches) {
		this.projectBatches = projectBatches;
	}

}
