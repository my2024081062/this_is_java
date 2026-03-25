package com.mjc813.chapter21.gamecrud;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CommonResponse {
    private int code;
    private String str;
}
