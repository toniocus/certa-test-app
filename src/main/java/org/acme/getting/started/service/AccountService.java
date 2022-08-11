package org.acme.getting.started.service;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

import org.acme.getting.started.db.model.SfAccount;
import org.acme.getting.started.db.model.dto.AccountMapper;
import org.acme.getting.started.db.model.dto.AccountUpdateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class AccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    @Inject
    AccountMapper mapper;

    @Transactional
    public SfAccount accountById(final int id) {
        return SfAccount.findById(id);
    }

    @Transactional
    public SfAccount updateAccountBasics(final AccountUpdateDTO dto) {

        SfAccount account = SfAccount.findById(dto.id);

        this.mapper.updateAlias(account, dto);
        account.persistAndFlush();

        return account;
    }
}
