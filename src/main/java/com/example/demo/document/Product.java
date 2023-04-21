package com.example.demo.document;

import com.example.demo.helper.Indices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;


@Data
@Document(indexName = Indices.PRODUCT_INDEX)
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
