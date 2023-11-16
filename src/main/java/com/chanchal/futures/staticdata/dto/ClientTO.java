package com.chanchal.futures.staticdata.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientTO {
    private String name;
    private String code;
    private String clientType;
    private Boolean isActive;
    private Boolean isClient;
    private Boolean isBroker;
    private Boolean hasAccounts;
    private String country;
    private String updateComment;
}
