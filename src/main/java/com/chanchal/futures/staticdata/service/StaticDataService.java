package com.chanchal.futures.staticdata.service;

import com.chanchal.futures.staticdata.bo.AccountBO;
import com.chanchal.futures.staticdata.bo.ClientBO;
import com.chanchal.futures.staticdata.dto.ClientTO;
import com.chanchal.futures.staticdata.mappers.SimpleMapper;
import com.chanchal.futures.staticdata.repository.AccountStaticDataRepository;
import com.chanchal.futures.staticdata.repository.ClientStaticDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class StaticDataService {
    private final Logger logger = LoggerFactory.getLogger(StaticDataService.class);
    @Autowired
    private ClientStaticDataRepository clientRepo;
    @Autowired
    private AccountStaticDataRepository accountRepo;

    @CacheEvict(value = "client", key = "#request.code")
    public ClientBO persistClientData(@RequestBody ClientTO request) {
        logger.info("persisting account in db");
        SimpleMapper instance = SimpleMapper.INSTANCE;
        ClientBO clientBO = instance.clientTOToClientBO(request);
        ClientBO savedCLient = clientRepo.save(clientBO);
        return savedCLient;
    }

    @CacheEvict(value = "account", key = "#request.code")
    public AccountBO persistAccountData(@RequestBody AccountBO request) {
        logger.info("persisting account in db");
        AccountBO savedAccount = accountRepo.save(request);
        return savedAccount;
    }

    @Cacheable(value = "client", key = "#clientCode")
    public ClientBO getClient(@RequestParam String clientCode) {
        logger.info("getting client from db");
        ClientBO client = clientRepo.getClientByCode(clientCode);
        return client;
    }

    @Cacheable(value = "account", key = "#accountCode")
    public AccountBO getAccount(@RequestParam String accountCode) {
        logger.info("getting account from db");
        AccountBO account = accountRepo.getAccountByCode(accountCode);
        return account;
    }
}
