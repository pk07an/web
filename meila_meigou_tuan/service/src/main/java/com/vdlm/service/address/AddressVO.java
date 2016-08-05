package com.vdlm.service.address;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.vdlm.dal.model.Address;
import com.vdlm.dal.model.Zone;

public class AddressVO extends Address {
    
    private static final long serialVersionUID = -7472612896539013215L;
    
    private String details;
    
    private List<Zone> zones;
    
    public AddressVO() {}
    
    public AddressVO(Address address, String details) {
        BeanUtils.copyProperties(address, this);
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }
}
