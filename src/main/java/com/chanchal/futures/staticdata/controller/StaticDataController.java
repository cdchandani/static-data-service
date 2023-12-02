package com.chanchal.futures.staticdata.controller;

import com.chanchal.futures.staticdata.service.StaticDataService;
import com.chanchal.futures.staticdata.bo.AccountBO;
import com.chanchal.futures.staticdata.bo.ClientBO;
import com.chanchal.futures.staticdata.dto.ClientTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StaticDataController {

    private final Logger logger = LoggerFactory.getLogger(StaticDataController.class);
    @Autowired
    private StaticDataService staticDataService;

    @PostMapping(value = "/client", consumes = "application/json")
    public ClientBO persistClientData(@RequestBody ClientTO request) {

        return staticDataService.persistClientData(request);
    }

    @PostMapping("/account")
    public AccountBO persistAccountData(@RequestBody AccountBO request) {

        return staticDataService.persistAccountData(request);
    }

    @GetMapping("/client")
    public ClientBO getClient(@RequestParam("code") String clientCode) {
        long startTime = System.currentTimeMillis();
        ClientBO client = staticDataService.getClient(clientCode);
        long endTime = System.currentTimeMillis();
        logger.info("retrieved client in {} milliseconds", endTime-startTime);
        return client;
    }

    @GetMapping("/account")
    public AccountBO getAccount(@RequestParam String accountCode) {

        return staticDataService.getAccount(accountCode);
    }
}
