package com.chanchal.futures.staticdata.repository;

import com.chanchal.futures.staticdata.bo.ClientBO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientStaticDataRepository extends CrudRepository<ClientBO,Long> {
    ClientBO getClientByCode(String code);
}
