package com.fztrck.apiLibrary.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDto {
    private String title;
    private String author;
    private String categoryName;
    private Date returndate;
}
