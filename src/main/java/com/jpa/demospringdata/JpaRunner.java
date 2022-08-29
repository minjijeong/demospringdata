package com.jpa.demospringdata;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager entityManager;

    public void run(ApplicationArguments args) throws Exception{
        Account account = new Account();
        account.setUserName("keesun");
        account.setPassword("pass");

        Study study = new Study();
        study.setName("Spring JPA");
//        study.setOwner(account);

        account.getStudies().add(study);

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
//        entityManager.persist(account);
    }
}
