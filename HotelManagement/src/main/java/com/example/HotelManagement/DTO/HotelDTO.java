package com.example.HotelManagement.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data // Lombok annotation to automatically generate getters, setters, toString(), etc.
public class HotelDTO {

    private String name; // changed from Name to name
    private String address; // changed from Address to address
    private String city;
    private float rating;
    private int postalCode; // changed from PostalCode to postalCode

    @Column(name = "available")
    private boolean isAvailable; // keeps isAvailable

    // Lombok will automatically generate the getters and setters for these fields,
    // so no need to define them manually unless you want to customize them.
}
