package com.chanchal.futures.staticdata.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountTO {

    private Long id;
    private String name;
    private String code;
    private String type;
    private boolean isActive;
    private String country;
}
