package za.co.hilltop.NorthRowTest.model;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class Food {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
	private String name;
	
	private String type;
	
	private Double quantity;

	@CreatedDate
	@Column(name = "createddate")
	Date createddate;
	  
	public String getId () {
		return id;
	}

	public String getName () {
		return name;
	}
	public void setName (String name) {
		this.name = name;
	}

	public String getType () {
		return type;
	}
	public void setType (String type) {
		this.type = type;
	}

	public Double getQuantity () {
		return quantity;
	}
	public void setQuantity (Double quantity) {
		this.quantity = quantity;
	}

	public Date getCreateddate () {
		return createddate;
	}
	public void setCreateddate (Date createddate) {
		this.createddate = createddate;
	}
}
