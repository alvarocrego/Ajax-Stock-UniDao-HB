/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rafaelaznar.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import net.rafaelaznar.bean.Usuario;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author rafa
 */
public class UsuarioDao extends GenericDaoImplementation<Usuario> {

    public Usuario getFromLogin(String login,String pass) { //public TIPO_ENTIDAD read(TIPO_ENTIDAD entity) {
        Usuario oUsuario;

        Session sesion = null;
        //Class<Usuario> tipo = (Class<Usuario>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = sesion.createCriteria(Usuario.class);

            criteria.add(Restrictions.eq("login", login));
            criteria.add(Restrictions.eq("password", pass));

            criteria.setMaxResults(1);
            List<Usuario> results = criteria.list();
            if (results.size() > 0) {
                return results.get(0);
            } else {
                return new Usuario();
            }
        } catch (HibernateException he) {
            throw new HibernateException("Error en read DAO", he);
        } finally {
            sesion.close();
        }

    }

}
