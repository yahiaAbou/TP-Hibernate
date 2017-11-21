package com.isamm.Classjava;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.isamm.hibernate.util.HibernateUtil;
import com.isamm.model.*;

import isamm.projet.service.*;
public class Test {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSession();

		
		EtudiantService etudiant = new EtudiantService();
		FiliereService filiere = new FiliereService();
		FormateurService formateur = new FormateurService();
		MatiereService matiere = new MatiereService();
		
		
		
		Filiere Fi = new Filiere("IAII","Ingénierie des automatismes et informatique industrielle");
		Filiere Fi1 = new Filiere("IRT","Ingénierie des réseaux et télécommunications");
		Filiere Fi2 = new Filiere("IIR","Ingénierie informatique et réseaux");
		filiere.create(Fi);
		filiere.create(Fi1);
		filiere.create(Fi2);
		
		
		Formateur fo1 = new Formateur("SELIMANI","Yahya","Vide","Vide","Homme","vide");
		Formateur fo2 = new Formateur("SAFI","Ilham","Vide","Vide","Homme","vide");
		formateur.create(fo1);
		formateur.create(fo2);
		
		Matiere Mat = new Matiere("TPC","Techniques de programmation structurée");
		Matiere Mat1 = new Matiere("JB","Java de Base");
		Matiere Mat2 = new Matiere("AU","Administration Unix");
		Matiere Mat3 = new Matiere("Hibernate","Framework de persistance");
		Matiere Mat4 = new Matiere("POO","Programmation orientée objet");
		
		Mat.setFormateur(fo1);
		Mat2.setFormateur(fo2);
		Mat4.setFormateur(fo2);
		
		matiere.create(Mat);
		matiere.create(Mat1);
		matiere.create(Mat2);
		matiere.create(Mat3);
		matiere.create(Mat4);
		
		Etudiant Et = new Etudiant("SAFI","Amal","vide","vide","Femme","22845676");
		Etudiant Et1 = new Etudiant("ALAMI","Samir","vide","vide","Homme","23845976");
		Etudiant Et2 = new Etudiant("ALAOUI","Safa","vide","vide","Femme","22345476");
		
		Et.setFiliere(Fi2);
		Et1.setFiliere(Fi2);
		Et2.setFiliere(Fi);
		
		etudiant.create(Et);
		etudiant.create(Et1);
		etudiant.create(Et2);
		
		
		//Afficher la liste des matieres
		List <Matiere> L =  matiere.getAll();
		Iterator i = L.iterator();
		while (i.hasNext()) {
		System.out.println(((Matiere) i.next()).getCode());
		}
		
		//Aficher la liste des matiere pour le formateur d' id=5
		int id = 5;
		List <Matiere> M =  matiere.listeMatiere(id);
		Iterator i1 = L.iterator();
		while (i.hasNext()) {
		System.out.println(((Matiere) i.next()).getCode());
		}
		
		
		
		
		
		
		
	}

}
