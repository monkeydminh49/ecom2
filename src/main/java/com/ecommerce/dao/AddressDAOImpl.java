package com.ecommerce.dao;

import com.ecommerce.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAOImpl implements AddressDAO {
    public void createAddress(Address address) {}
    public void updateAddress(Address address) {}
    public void deleteAddress(int id) {}
    public Address getAddressById(int id) { return null; }
}