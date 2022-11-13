package com.mococo.core.account.vo;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@Access(AccessType.FIELD)
public class Address {

     @Size(max = 50)
     @Column(name = "address")
     private String value;

     public static Address create(String value) {
          final Address address = new Address();
          address.value = value;
          return address;
     }

}
