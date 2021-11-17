package com.senla.haltvinizki.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateAutoShop {
    private static final SessionFactory sessionFactory = configureSessionFactory();
    private static HibernateAutoShop hibernateAutoShop;

    public static HibernateAutoShop getIstance() {
        if (hibernateAutoShop == null) {
            hibernateAutoShop = new HibernateAutoShop();
        }
        return hibernateAutoShop;
    }
    private static SessionFactory configureSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
