package com.app.buysell.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "price")
    private int price;
    @Column(name = "city")
    private String city;
    @Column(name = "author")
    private String author;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product") // lazy оптимизирует тут
    // mappedBy - вроде для связи таблиц
    private List<Image> images =new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dataOfCtreated;
    @PrePersist // указывает, что перед сохранением в бд записи нужно выполнить этот метод
    private void init() {
        dataOfCtreated = LocalDateTime.now();
    }
    public void addImageToProduct(Image image){
        image.setProduct(this);
        images.add(image);

    }

}
