package zinchenko.sb.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import zinchenko.sb.dao.ProductDao;
import zinchenko.sb.model.Product;

/**
 * Created by zinchenko on 30.08.14.
 */
@Repository
public class ProductDaoImpl implements ProductDao{

    private SessionFactory sessionFactory;

    @Override
    public void save(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
