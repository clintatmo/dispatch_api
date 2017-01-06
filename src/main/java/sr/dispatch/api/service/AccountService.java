package sr.dispatch.api.service;


import sr.dispatch.api.model.Account;

import java.util.Collection;

/* * * @author Clint Atmosoerodjo #commander *  */
public interface AccountService {

    Collection<Account> findAll();

    Account findByUsername(String userename);

    Account createNewAccount(Account account);


}
