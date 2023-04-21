package com.example.demo.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Data
@Document(indexName = "product")
public class Product {
    @Id
    @Field(type = FieldType.Keyword)
    private Long id;
    @Field(type = FieldType.Binary)
    private String mainImg;
    @Field(type = FieldType.Text)
    private String productName;
    @Field(type = FieldType.Binary)
    private String descImg;
    @Field(type = FieldType.Double)
    private Double price;
    @Field(type = FieldType.Integer)
    private Integer rate; // 0<rate<5
    @Field(type = FieldType.Integer)
    private Integer likes;
    @Field(type = FieldType.Integer)
    private Integer reviews;
    @Field(type = FieldType.Integer)
    private Integer quantity;
    @Field(type = FieldType.Boolean)
    private Boolean cart;
    @Field(type = FieldType.Boolean)
    private Boolean wishlist;
    @Field(type = FieldType.Boolean)
    private Boolean bestProduct;
    @Field(type = FieldType.Boolean)
    private Boolean newProduct;
    @Field(type = FieldType.Boolean)
    private Boolean recoProduct;
    @Field(type = FieldType.Boolean)
    private Boolean saleProduct;
    @Field(type = FieldType.Integer)
    private Integer stock;
}
