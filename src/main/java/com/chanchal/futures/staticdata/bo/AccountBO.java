package com.chanchal.futures.staticdata.bo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "tbl_account", schema = "static")
@Getter
@Setter
public class AccountBO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Column(unique = true)
    private String code;
    private String type;
    private boolean isActive;
    private String country;
    @CreationTimestamp
    private Timestamp dtCreated;
    @CreationTimestamp
    private Timestamp dtUpdated;
    private String updateComment;
}
