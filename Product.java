package com.example.amazon.Modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@AllArgsConstructor @Data
public class Product {
    @NotNull(message = "id cant be null")
    @Size(min = 3 , message = "id length must be more than 2")
    private String id;


    @NotNull (message = "id cant be null")
    @Size(min = 3 , message = "name length must be more than 2")
    private String name;


    @NotNull (message = "input cant be null")
    @Pattern(regexp = "^\\d{0,8}(\\.\\d{1,4})?$",message="price must be a positive number")
    @Range(min = 1,max = 9 , message = "input length must be more than 25 and less than 9")
    private int price;

    @NotNull (message = "id cant be null")
    @Size(min = 3 , message = "id length must be more than 2")
    private String categoryId;

}