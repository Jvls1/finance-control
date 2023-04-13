package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.model.to.WalletCreationTO;
import com.jojo.financialcontrol.service.generic.IGenericCrudService;
import org.springframework.web.client.HttpClientErrorException;

public interface IWalletService extends IGenericCrudService<Wallet> {

    void save(WalletCreationTO wallet) throws HttpClientErrorException.NotFound, InfoNotFoundException;

}
