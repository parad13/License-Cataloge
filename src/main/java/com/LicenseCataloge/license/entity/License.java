package com.LicenseCataloge.license.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long licenseId;
    private String name;
    private String description;
    private String productCode;
}
