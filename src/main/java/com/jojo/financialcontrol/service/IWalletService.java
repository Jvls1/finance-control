package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Expense;
import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.model.to.WalletCreationTO;
import com.jojo.financialcontrol.service.generic.IGenericCrudService;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IWalletService extends IGenericCrudService<Wallet> {

    void save(WalletCreationTO wallet) throws HttpClientErrorException.NotFound, InfoNotFoundException;

}
