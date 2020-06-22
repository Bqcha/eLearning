package eLearning.presentation;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import eLearning.dao.ClasseDAO;
import eLearning.dao.ClasseDaoImp;
import eLearning.dao.Cours;
import eLearning.dao.CoursDAO;
import eLearning.dao.CoursDaoImp;
import eLearning.dao.EtudiantDAO;
import eLearning.dao.EtudiantDaoImp;
import eLearning.services.ClasseService;
import eLearning.services.ClasseServiceImpl;
import eLearning.services.CoursService;
import eLearning.services.CoursServiceImpl;

import java.util.List;

import javax.annotation.*;

@SuppressWarnings("deprecation")
@ManagedBean(name="CoursBean1")
@ApplicationScoped
public class CoursBean {
	
	private CoursService coursservice = new CoursServiceImpl();
	//private ClasseService classeservice = new ClasseServiceImpl();
	private ClasseDAO classeDAO = new ClasseDaoImp();
	private CoursDAO coursDAO = new CoursDaoImp();
	
	private String nomcours;
	private String contenu;
	private String cat�gorie;
	private String succ�s;
	private static Cours leCours;
	public Cours getLeCours() {
		return leCours;
	}





	public void setLeCours(Cours leCours) {
		CoursBean.leCours = leCours;
	}

	private List<String> cat�gories;
	
	public List<String> getCat�gories() {
		return cat�gories;
		
	}
	
	private List<Cours> listcours;
	 
	
	
	
	
	
	
	public CoursBean() {
        /*cat�gories = new ArrayList<String>();
		
		cat�gories.add("Informatique");
		cat�gories.add("M�decine");
		cat�gories.add("Litt�rature"); */
	}
	
	@PostConstruct
	public void initBean() {
		try {
			listcours = coursservice.findAll();
			cat�gories = classeDAO.findAll();
			}catch(Exception e) {
				System.out.println(e);
			}		
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



	public List<Cours> getListcours() {
		return listcours;
	}



	public void setListcours(List<Cours> listcours) {
		this.listcours = listcours;
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
		coursDAO.add(c);
		
		nomcours="";
		contenu="";
		cat�gorie="";
		
		succ�s = "le cours est bien ajout�";
		

		
	}
	
	public String fonction() {
		
		System.out.println("here");
		int id;		
		id = Integer.parseInt(FacesContext.getCurrentInstance()
						.getExternalContext().getRequestParameterMap()
						.get("id_cours"));
		leCours = coursservice.findById((long) id);
		return ("ContenuCours.xhtml");
		
	}
	
	
	
	
	

}
