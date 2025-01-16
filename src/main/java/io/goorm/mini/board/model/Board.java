package io.goorm.mini.board.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Board {

    private Long seq;

    private String title;

    private String contents;

//     @JsonProperty("reg_user")
    private String regUser;

//     @JsonProperty("reg_date")
    private LocalDateTime regDate;
}
