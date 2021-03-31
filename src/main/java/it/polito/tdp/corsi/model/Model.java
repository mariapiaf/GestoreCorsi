package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	
	public Model() {
		corsoDao = new CorsoDAO();
	}

	public List<Corso> getCorsiByPeriodo(Integer pd) {
		return corsoDao.getCorsiByPeriodo(pd);
	}
	
	public Map<Corso, Integer> getIscrittiByPeriodo(Integer pd){
		return corsoDao.getIscrittiByPeriodo(pd);
	}
	
	public List<Studente> getStudentiByCorso(String codice) {
		return corsoDao.getStudentiByCorso(new Corso(codice, null, null, null));
	}

	public Map<String, Integer> getDivisioneCDS(String codice) {
		// dato il corso con codice ABC
		// ci aspettiamo 
		// GEST -> 50
		// INF -> 40
		// MEC -> 30
		// string cds, integer = numero di studenti per quel corso di studi,
		// oppure una lista di una classe nuova detta DivisioneCDS che contiene il nome del cds e il numero di studenti per quel corso.
		// Noi usiamo una mappa, ma è uguale
		
		// SOLUZIONE 1
//		Map<String, Integer> divisione = new HashMap<String, Integer>();
//		List<Studente> studenti = this.getStudentiByCorso(codice);
//		for(Studente s: studenti) {
//			if(s.getCds()!=null && !s.getCds().equals("")) {
//				if(divisione.get(s.getCds()) == null) { // è il primo studente che incontro di quel cds
//					divisione.put(s.getCds(), 1);
//				}
//				else {
//					divisione.put(s.getCds(),  divisione.get(s.getCds())+1);
//				}
//			}
//		}
//		return divisione;
		
		// SOLUZIONE 2: passa direttamente dal database
		return corsoDao.getDivisioneStudenti(new Corso(codice, null, null, null));
	}
	public boolean esisteCorso(String codice) {
		return corsoDao.esisteCorso(new Corso(codice, null, null, null));
	}
}
