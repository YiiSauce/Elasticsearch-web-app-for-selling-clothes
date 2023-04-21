package com.example.demo.Person;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Data
@Document(indexName = "person")
@Setting(settingPath = "static/settings.json")
public class Person {
    @Id
    @Field(type = FieldType.Keyword)
    private Long id;
    @Field(type = FieldType.Text)
    private String username;
    @Field(type = FieldType.Text)
    private String email;
}
