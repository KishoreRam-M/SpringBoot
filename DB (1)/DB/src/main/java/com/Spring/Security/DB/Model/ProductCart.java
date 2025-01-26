package com.Spring.Security.DB.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cart") // Map to the 'products' table in the DB
public class ProductCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @JsonProperty("id") // Map to JSON key
    private int id;

    @Column(nullable = false)
    @JsonProperty("name") // Map to JSON key
    private String name;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("description") // Map to JSON key
    private String description;

    @Column(nullable = false)
    @JsonProperty("price") // Map to JSON key
    private double price;

    @Column(nullable = false)
    @JsonProperty("discount") // Map to JSON key
    private double discount;

    @Column(name = "final_price", insertable = false, updatable = false) // Derived column
    @JsonProperty("finalPrice") // Map to JSON key
    private double finalPrice;

    @JsonProperty("category") // Map to JSON key
    private String category;

    @Column(name = "sub_category")
    @JsonProperty("subCategory") // Map to JSON key
    private String subCategory;

    @JsonProperty("brand") // Map to JSON key
    private String brand;

    @Column(name = "stock_quantity")
    @JsonProperty("stockQuantity") // Map to JSON key
    private int stockQuantity;

    @Column(nullable = false)
    @JsonProperty("availability") // Map to JSON key
    private boolean availability;

    @Column(name = "image_url")
    @JsonProperty("imageUrl") // Map to JSON key
    private String imageUrl;

    @ElementCollection
    @JsonProperty("additionalImages") // Map to JSON key
    private List<String> additionalImages;

    @JsonProperty("rating") // Map to JSON key
    private double rating;

    @Column(name = "review_count")
    @JsonProperty("reviewCount") // Map to JSON key
    private int reviewCount;

    @ElementCollection
    @JsonProperty("tags") // Map to JSON key
    private List<String> tags;

    @Column(name = "created_at", updatable = false)
    @JsonProperty("createdAt") // Map to JSON key
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @JsonProperty("updatedAt") // Map to JSON key
    private LocalDateTime updatedAt;

    @JsonProperty("seller") // Map to JSON key
    private String seller;
}
