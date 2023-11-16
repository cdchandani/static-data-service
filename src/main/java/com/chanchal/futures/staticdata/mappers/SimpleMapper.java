package com.chanchal.futures.staticdata.mappers;

import com.chanchal.futures.staticdata.bo.AccountBO;
import com.chanchal.futures.staticdata.bo.ClientBO;
import com.chanchal.futures.staticdata.dto.AccountTO;
import com.chanchal.futures.staticdata.dto.ClientTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SimpleMapper {

    SimpleMapper INSTANCE = Mappers.getMapper(SimpleMapper.class);

    ClientBO clientTOToClientBO(ClientTO source);

    AccountBO accountTOToAccountBO(AccountTO source);

}
