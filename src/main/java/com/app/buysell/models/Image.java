package com.app.buysell.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "originFileName")
    private String originalFileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "contentTyped")
    private String contentType;
    @Column(name = "isPreviewImage")
    private boolean isPreviewImage; // типа какая первая отображается у продукта изначально
    @Lob // в бд будет хранится в виде типа LONGBLOB
    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER) // cascade - действия отражаются на зависимых fetch -тип загрузки
    private Product product;

}
