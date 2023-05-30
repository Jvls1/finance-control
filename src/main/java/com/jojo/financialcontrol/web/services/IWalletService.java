package com.jojo.financialcontrol.web.services;

import com.jojo.financialcontrol.infra.exception.InfoNotFoundException;
import com.jojo.financialcontrol.domain.Wallet;
import com.jojo.financialcontrol.web.model.WalletCreationTO;
import com.jojo.financialcontrol.web.services.generic.IGenericCrudService;
import org.springframework.web.client.HttpClientErrorException;

public interface IWalletService extends IGenericCrudService<Wallet> {

    void save(WalletCreationTO wallet) throws HttpClientErrorException.NotFound, InfoNotFoundException;

}
