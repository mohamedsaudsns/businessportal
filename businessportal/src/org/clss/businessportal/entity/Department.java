package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the department database table.
 * 
 */
@Entity
@Table(name="department")
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DEPARTMENT_ID", unique=true, nullable=false)
	private int departmentId;

	@Column(length=1)
	private String block;

	@Column(name="DEPARTMENT_NAME", length=45)
	private String departmentName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="department")
	private List<Product> products;

	//bi-directional many-to-one association to Scheme
	@OneToMany(mappedBy="department")
	private List<Scheme> schemes;

	public Department() {
	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getBlock() {
		return this.block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setDepartment(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setDepartment(null);

		return product;
	}

	public List<Scheme> getSchemes() {
		return this.schemes;
	}

	public void setSchemes(List<Scheme> schemes) {
		this.schemes = schemes;
	}

	public Scheme addScheme(Scheme scheme) {
		getSchemes().add(scheme);
		scheme.setDepartment(this);

		return scheme;
	}

	public Scheme removeScheme(Scheme scheme) {
		getSchemes().remove(scheme);
		scheme.setDepartment(null);

		return scheme;
	}

}