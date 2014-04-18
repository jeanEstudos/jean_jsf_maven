package br.com.jsf1.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

public class HibernateDAO<T> implements InterfaceDAO<T>, Serializable {

    private static final long serialVersionUID = 1L;
    private Class<T> classe;
    private Session session;

    //toda vez que instanciar essa classe do tipo <t>(generico)
    //vai passar uma entidade e uma sessao hibernate
    public HibernateDAO(Class<T> classe, Session session) {
        super();
        this.classe = classe;
        this.session = session;
    }

    @Override
    public void save(T entity) {
        session.save(entity);
    }

    @Override
    public void update(T entity) {
        session.update(entity);
    }

    @Override
    public void remove(T entity) {
        session.delete(entity);
    }

    @Override
    public void merge(T entity) {
        session.merge(entity);
    }

    @Override
    public T getEntity(Serializable id) {
        T entity = (T) session.get(classe, id);
        return entity;
    }

    @Override
    public T getEntityDetachedCriteria(DetachedCriteria criteria) {
        T entity = (T) criteria.getExecutableCriteria(session).uniqueResult();
        return entity;
    }

    @Override
    public List<T> getListByDetachedCriteria(DetachedCriteria criteria) {
        return criteria.getExecutableCriteria(session).list();
    }

    @Override
    //retorna lista de entidades
    public List<T> getEntities() {
        List<T> entities = (List<T>) session.createCriteria(classe).list();
        return entities;
    }
}
