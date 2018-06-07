package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the company_master database table.
 * 
 */
@Entity
@Table(name="company_master")
@NamedQuery(name="CompanyMaster.findAll", query="SELECT c FROM CompanyMaster c")
public class CompanyMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="`DESC`", nullable=false, length=45)
	private String desc;

	//bi-directional many-to-one association to CustomerAccountGroup
	@OneToMany(mappedBy="companyMaster")
	private List<CustomerAccountGroup> customerAccountGroups;

	//bi-directional many-to-one association to CustomerGroup
	@OneToMany(mappedBy="companyMaster")
	private List<CustomerGroup> customerGroups;

	//bi-directional many-to-one association to CustomerMaster
	@OneToMany(mappedBy="companyMaster")
	private List<CustomerMaster> customerMasters;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="companyMaster")
	private List<Product> products;

	//bi-directional many-to-one association to Scheme
	@OneToMany(mappedBy="companyMaster")
	private List<Scheme> schemes;

	//bi-directional many-to-one association to UserMaster
	@OneToMany(mappedBy="companyMaster")
	private List<UserMaster> userMasters;

	//bi-directional many-to-one association to VendorAccountGroup
	@OneToMany(mappedBy="companyMaster")
	private List<VendorAccountGroup> vendorAccountGroups;

	//bi-directional many-to-one association to VendorMaster
	@OneToMany(mappedBy="companyMaster")
	private List<VendorMaster> vendorMasters;

	public CompanyMaster() {
	}

	public String getCompCode() {
		return this.compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<CustomerAccountGroup> getCustomerAccountGroups() {
		return this.customerAccountGroups;
	}

	public void setCustomerAccountGroups(List<CustomerAccountGroup> customerAccountGroups) {
		this.customerAccountGroups = customerAccountGroups;
	}

	public CustomerAccountGroup addCustomerAccountGroup(CustomerAccountGroup customerAccountGroup) {
		getCustomerAccountGroups().add(customerAccountGroup);
		customerAccountGroup.setCompanyMaster(this);

		return customerAccountGroup;
	}

	public CustomerAccountGroup removeCustomerAccountGroup(CustomerAccountGroup customerAccountGroup) {
		getCustomerAccountGroups().remove(customerAccountGroup);
		customerAccountGroup.setCompanyMaster(null);

		return customerAccountGroup;
	}

	public List<CustomerGroup> getCustomerGroups() {
		return this.customerGroups;
	}

	public void setCustomerGroups(List<CustomerGroup> customerGroups) {
		this.customerGroups = customerGroups;
	}

	public CustomerGroup addCustomerGroup(CustomerGroup customerGroup) {
		getCustomerGroups().add(customerGroup);
		customerGroup.setCompanyMaster(this);

		return customerGroup;
	}

	public CustomerGroup removeCustomerGroup(CustomerGroup customerGroup) {
		getCustomerGroups().remove(customerGroup);
		customerGroup.setCompanyMaster(null);

		return customerGroup;
	}

	public List<CustomerMaster> getCustomerMasters() {
		return this.customerMasters;
	}

	public void setCustomerMasters(List<CustomerMaster> customerMasters) {
		this.customerMasters = customerMasters;
	}

	public CustomerMaster addCustomerMaster(CustomerMaster customerMaster) {
		getCustomerMasters().add(customerMaster);
		customerMaster.setCompanyMaster(this);

		return customerMaster;
	}

	public CustomerMaster removeCustomerMaster(CustomerMaster customerMaster) {
		getCustomerMasters().remove(customerMaster);
		customerMaster.setCompanyMaster(null);

		return customerMaster;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCompanyMaster(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCompanyMaster(null);

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
		scheme.setCompanyMaster(this);

		return scheme;
	}

	public Scheme removeScheme(Scheme scheme) {
		getSchemes().remove(scheme);
		scheme.setCompanyMaster(null);

		return scheme;
	}

	public List<UserMaster> getUserMasters() {
		return this.userMasters;
	}

	public void setUserMasters(List<UserMaster> userMasters) {
		this.userMasters = userMasters;
	}

	public UserMaster addUserMaster(UserMaster userMaster) {
		getUserMasters().add(userMaster);
		userMaster.setCompanyMaster(this);

		return userMaster;
	}

	public UserMaster removeUserMaster(UserMaster userMaster) {
		getUserMasters().remove(userMaster);
		userMaster.setCompanyMaster(null);

		return userMaster;
	}

	public List<VendorAccountGroup> getVendorAccountGroups() {
		return this.vendorAccountGroups;
	}

	public void setVendorAccountGroups(List<VendorAccountGroup> vendorAccountGroups) {
		this.vendorAccountGroups = vendorAccountGroups;
	}

	public VendorAccountGroup addVendorAccountGroup(VendorAccountGroup vendorAccountGroup) {
		getVendorAccountGroups().add(vendorAccountGroup);
		vendorAccountGroup.setCompanyMaster(this);

		return vendorAccountGroup;
	}

	public VendorAccountGroup removeVendorAccountGroup(VendorAccountGroup vendorAccountGroup) {
		getVendorAccountGroups().remove(vendorAccountGroup);
		vendorAccountGroup.setCompanyMaster(null);

		return vendorAccountGroup;
	}

	public List<VendorMaster> getVendorMasters() {
		return this.vendorMasters;
	}

	public void setVendorMasters(List<VendorMaster> vendorMasters) {
		this.vendorMasters = vendorMasters;
	}

	public VendorMaster addVendorMaster(VendorMaster vendorMaster) {
		getVendorMasters().add(vendorMaster);
		vendorMaster.setCompanyMaster(this);

		return vendorMaster;
	}

	public VendorMaster removeVendorMaster(VendorMaster vendorMaster) {
		getVendorMasters().remove(vendorMaster);
		vendorMaster.setCompanyMaster(null);

		return vendorMaster;
	}

}