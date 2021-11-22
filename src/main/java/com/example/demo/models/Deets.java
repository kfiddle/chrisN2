package com.example.demo.models;

import javax.persistence.Embeddable;

@Embeddable
public class Deets {

    private String email;
    private String homePhone;
    private String cellPhone;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;

}
