package com.shefzee.currencyconversion.entity;


import lombok.Data;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Override
    public boolean equals(Object o) {
        if(o instanceof BaseEntity){
            BaseEntity e = (BaseEntity) o;
            return isNotBlank(e.getId()) && isNotBlank(this.getId())
                    && e.getId().equalsIgnoreCase(this.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
