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
@Table(name = "PROJECT", schema = "PUBLIC", catalog = "BOOTDB")
public class Project implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5994309006658949113L;
	private Long id;
	private long version;
	private String path;
	private String preProcessor;
	private String supervisor;
	private Set<ProjectBatch> projectBatches = new HashSet<ProjectBatch>(0);

	public Project() {
	}

	public Project(String path, String preProcessor, String supervisor) {
		this.path = path;
		this.preProcessor = preProcessor;
		this.supervisor = supervisor;
	}

	public Project(String path, String preProcessor, String supervisor, Set<ProjectBatch> projectBatches) {
		this.path = path;
		this.preProcessor = preProcessor;
		this.supervisor = supervisor;
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

	@Column(name = "PRE_PROCESSOR", nullable = false)
	public String getPreProcessor() {
		return this.preProcessor;
	}

	public void setPreProcessor(String preProcessor) {
		this.preProcessor = preProcessor;
	}

	@Column(name = "SUPERVISOR", nullable = false)
	public String getSupervisor() {
		return this.supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<ProjectBatch> getProjectBatches() {
		return this.projectBatches;
	}

	public void setProjectBatches(Set<ProjectBatch> projectBatches) {
		this.projectBatches = projectBatches;
	}

}
