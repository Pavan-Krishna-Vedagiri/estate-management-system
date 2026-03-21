package com.pavan.github.estatemanagementsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pricing_method")
public class PricingMethod extends DateAttribute{

    @Id
    @Column(name = "pricing_method_id")
    private String pricingMethodId;

    @Column(name = "pricing_method_name")
    private String pricingMethodName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private String price;

    @Column(name = "charge_code")
    private String chargeCode;

}
