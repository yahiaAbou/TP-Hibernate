package isamm.projet.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.isamm.hibernate.util.HibernateUtil;
import com.isamm.model.Matiere;

import isamm.projet.inter.IDao;

public class MatiereService implements IDao <Matiere> {

	@Override
	public boolean create(Matiere obj) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		tx = session.getTransaction();
        tx.begin();
		session.save(obj);
		tx.commit();
		return true;
	}

	@Override
	public List<Matiere> getAll() {
		Session session = HibernateUtil.openSession();
		Query q = session.createQuery("from Matiere");
		List l = q.list();
		return l;
	}

	@Override
	public boolean delete(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("delete from Matiere where id_matiere='"+id+"'");
        query.executeUpdate();
		tx.commit();
		return true;
	}

	@Override
	public boolean update(int id, Matiere obj) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		tx = session.getTransaction();
        tx.begin();
		session.update(obj);
		tx.commit();
		return true;
	}

	@Override
	public boolean getById(int id) {
		Session session = HibernateUtil.openSession();
		 boolean result = false;
		 Transaction tx = null;
		 try{
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from Matiere where id_matiere='"+id+"'");
			 Matiere u = (Matiere)query.uniqueResult();
			 tx.commit();
			 if(u!=null) result = true;
		 }catch(Exception ex){
			 if(tx!=null){
				 tx.rollback();
			 }
		 }finally{
			 session.close();
		 }
		 return result;
	}
	
	public List<Matiere> listeMatiere(int id_formateur){
		
		Session session = HibernateUtil.openSession();
		Query q = session.createQuery("from Matiere where id_formateur='"+id_formateur+"' ");
		List l = q.list();
		return l;
	}

}
