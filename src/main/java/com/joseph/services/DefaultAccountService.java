package com.joseph.services;

import com.joseph.models.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by joseph on 4/3/17.
 * Email: developergitch@outlook.com
 */
@DefaultService
public class DefaultAccountService implements AccountService {
    private SessionFactory sessionFactory;
    @Autowired
    private void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    @Transactional(readOnly = false)
    @Override
    public void createAccount(Account account) {
        sessionFactory.getCurrentSession().save(account);
    }

    @Override
    public void removeAccount(Account account) {
        sessionFactory.getCurrentSession().remove(account);

    }

    @Override
    public Account getAccount(String email) {
        return (Account) sessionFactory.getCurrentSession().getSession()
                .createQuery("FROM Account a WHERE a.email=:email")
                .setParameter("email",email)
                .uniqueResult();
    }

    @Override
    public List<Account> getUserAccounts() {

        return sessionFactory.getCurrentSession().getSession()
                .createQuery("FROM Account  a order by a.createdOn asc ").getResultList();
    }

    @Override
    public List<Account> getUserAccounts(String email) {
        return sessionFactory.getCurrentSession().getSession()
                .createQuery("FROM Account a WHERE a.email=:email").setParameter("email",email)
                .getResultList();
    }
}
