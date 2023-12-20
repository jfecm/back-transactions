package com.jfecm.springtransactions.repository;

import com.jfecm.springtransactions.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends BaseRepository<Address, Long> {
}
