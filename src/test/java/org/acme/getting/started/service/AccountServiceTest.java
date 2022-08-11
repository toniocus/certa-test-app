package org.acme.getting.started.service;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class AccountServiceTest {

    @Inject
    AccountService service;

    @Test
    void test() {

        System.out.println(this.service.accountById(1));
    }

}
