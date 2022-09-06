package com.mintic.teamCualquiera.modelo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "enterprise")
public class Enterprise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "document", unique = true)
	private String document;

	@Column(name = "phone")
	private String phone;

	@Column(name = "address")
	private String address;

	@Column(name = "createdAt")
	private Date createdAt;

	@Column(name = "updatedAt", nullable = true)
	private Date updatedAt;

	// ........ Constructor ........ //

	public Enterprise(){
	}
	public Enterprise(Long id, String name, String document, String phone, String address, Date createdAt,
			Date updatedAt) {
		this.id = id;
		this.name = name;
		this.document = document;
		this.phone = phone;
		this.address = address;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	// ........ Getter and Setter ........ //




	public Long getId() { return id;	}

	public void setId(Long id) { this.id = id;	}

	public String getName() { return name;	}

	public void setName(String name) { this.name = name;	}

	public String getDocument() { return document;	}

	public void setDocument(String document) { this.document = document;	}

	public String getPhone() { return phone;	}

	public void setPhone(String phone) { this.phone = phone;	}

	public String getAddress() { return address;	}

	public void setAddress(String address) { this.address = address;	}

	public Date getCreatedAt() { return createdAt;	}

	public void setCreatedAt(Date createdAt) { this.createdAt = createdAt;	}

	public Date getUpdatedAt() { return updatedAt;	}

	public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt;	}

}
