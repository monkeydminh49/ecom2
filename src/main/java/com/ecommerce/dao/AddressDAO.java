package com.ecommerce.dao;

import com.ecommerce.model.Address;

public interface AddressDAO {
    void createAddress(Address address);
    void updateAddress(Address address);
    void deleteAddress(int id);
    Address getAddressById(int id);
}