package com.snipe.let.admin.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductDomain implements Serializable {

    private static final long serialVersionUID = -8101027725855260642L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "sub_categories_id")
    private SubCategoriesDomain subCategoriesId;

    @Column(name = "quality")
    private String productQuality;

    @Column(name = "image_name")
    private String productImageName;

    @Column(name = "image_url")
    private String productImageUrl;

    @Column(name = "detail_description")
    private String productDetailedDescription;

    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime productCreationDate;

    @Column(name = "modified_date")
    @UpdateTimestamp
    private LocalDateTime productModifiedDate;

	public String getProductName() {
		// TODO Auto-generated method stub
		return productName;
	}

	public void setProductImageName(String productImageName2) {
		// TODO Auto-generated method stub
		
	}

	public void setProductImageUrl(String imageUrl) {
		// TODO Auto-generated method stub
		
	}

	public SubCategoriesDomain getSubCategoriesId() {
		// TODO Auto-generated method stub
		return null;
	}
}
