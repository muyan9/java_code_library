package zcy.json;

import java.util.HashSet;
import java.util.Set;

/**
 * Terminaltype entity. @author MyEclipse Persistence Tools
 */

public class Terminaltype extends POJO implements java.io.Serializable {

	// Fields

	private Integer tertypeId;
	private String tertypename;
	private String description;
	private Set terminals = new HashSet(0);

	// Constructors

	/** default constructor */
	public Terminaltype() {
	}

	/** minimal constructor */
	public Terminaltype(String tertypename) {
		this.tertypename = tertypename;
	}

	/** full constructor */
	public Terminaltype(String tertypename, String description, Set terminals) {
		this.tertypename = tertypename;
		this.description = description;
		this.terminals = terminals;
	}

	// Property accessors

	public Integer getTertypeId() {
		return this.tertypeId;
	}

	public void setTertypeId(Integer tertypeId) {
		this.tertypeId = tertypeId;
	}

	public String getTertypename() {
		return this.tertypename;
	}

	public void setTertypename(String tertypename) {
		this.tertypename = tertypename;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getTerminals() {
		return this.terminals;
	}

	public void setTerminals(Set terminals) {
		this.terminals = terminals;
	}

}