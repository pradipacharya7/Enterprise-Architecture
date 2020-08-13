package edu.mum.domain;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.Range;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 5784L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(length = 32)
 	private String name;
     private String manufacturer;
	   @Range(min = 2 , max = 100 ,  message= "{NumberRange}")
    private BigDecimal weight;
   
    @Column(length = 2000)
     private String description;

    @Column(length = 255)
     private String shortDescription;
    
    private String productNumber;

 //   @Valid
 //   @NotEmpty(message= "{NotEmpty}", groups={ProductDefinition.class})
    @ManyToMany(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="products")
    private List<Category> categories = new ArrayList<Category>();

     private BigDecimal price;
    
     private Integer quantity;

	private ProductionStatus status = ProductionStatus.INVALID;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
 
	public void addCategory(Category category) {
		this.categories.add(category);
		category.getProducts().add(this);
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public ProductionStatus getStatus() {
		return status;
	}
	public void setStatus(ProductionStatus status) {
		this.status = status;
	}
	
 }