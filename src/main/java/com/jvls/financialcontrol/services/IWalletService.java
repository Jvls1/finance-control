package com.jvls.financialcontrol.services;

import org.springframework.web.client.HttpClientErrorException;

import com.jvls.financialcontrol.dtos.WalletCreationDTO;
import com.jvls.financialcontrol.entities.Wallet;
import com.jvls.financialcontrol.exceptions.InfoNotFoundException;
import com.jvls.financialcontrol.services.generic.IGenericCrudService;

public interface IWalletService extends IGenericCrudService<Wallet> {

    Wallet save(WalletCreationDTO wallet) throws HttpClientErrorException.NotFound, InfoNotFoundException;

}
