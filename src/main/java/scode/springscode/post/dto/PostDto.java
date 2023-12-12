package scode.springscode.post.dto;

import java.time.LocalDate;

public record PostDto (Long id,

                        String author,

                       LocalDate createDate,

                       String title,

                       String body
){

}
