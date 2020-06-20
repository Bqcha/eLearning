package eLearning.presentation;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import eLearning.dao.Cours;
import eLearning.services.CoursService;
import eLearning.services.CoursServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.*;

@ManagedBean(name="CoursBean1")
@RequestScoped
public class CoursBean {
	
	private CoursService service = new CoursServiceImpl();
	
	
	private String nomcours;
	private String contenu;
	private String cat�gorie;
	private String succ�s;
	private List<String> cat�gories;
	public List<String> getCat�gories() {
		return cat�gories;
		
	}


	
	@PostConstruct
	public void initBean() {
		
	}
	
	
	
	public CoursBean() {
        cat�gories = new ArrayList<String>();
		
		cat�gories.add("Informatique");
		cat�gories.add("M�decine");
		cat�gories.add("Litt�rature"); 
	}




	public void setCat�gories(List<String> cat�gories) {
		this.cat�gories = cat�gories;
	}
	
	public String getCat�gorie() {
		return cat�gorie;
	}

	public void setCat�gorie(String cat�gorie) {
		this.cat�gorie = cat�gorie;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	

	public String getNomcours() {
		return nomcours;
	}

	public void setNomcours(String nomcours) {
		this.nomcours = nomcours;
	}
	
	
	
	
	public String getSucc�s() {
		return succ�s;
	}



	public void setSucc�s(String succ�s) {
		this.succ�s = succ�s;
	}



	public void addCours(ActionEvent e) {
		
		succ�s="";
		System.out.println(nomcours);
		System.out.println(contenu);
		System.out.println(cat�gorie);
		
		Cours c = new Cours();
		c.setNom_cours(nomcours);
		c.setContenu(contenu);
		c.setCat�gorie(cat�gorie);
		service.add(c);
		
		nomcours="";
		contenu="";
		cat�gorie="";
		
		succ�s = "le cours est bien ajout�";
		

		
	}
	
	
	
	

}
