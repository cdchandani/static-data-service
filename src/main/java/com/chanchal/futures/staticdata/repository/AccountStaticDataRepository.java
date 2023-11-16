package com.chanchal.futures.staticdata.repository;

import com.chanchal.futures.staticdata.bo.AccountBO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountStaticDataRepository extends CrudRepository<AccountBO,Long> {
    AccountBO getAccountByCode(String code);
}
