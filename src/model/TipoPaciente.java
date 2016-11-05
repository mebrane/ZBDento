package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="zb_tipopaciente")
public class TipoPaciente {
	@Id
	@SequenceGenerator(name="hm_tipopaciente_seq", allocationSize=1, initialValue=4)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hm_tipopaciente_seq")  
	private int tpac_id;
	private String tpac_nomb;
	public int getTpac_id() {
		return tpac_id;
	}
	public void setTpac_id(int tpac_id) {
		this.tpac_id = tpac_id;
	}
	public String getTpac_nomb() {
		return tpac_nomb;
	}
	public void setTpac_nomb(String tpac_nomb) {
		this.tpac_nomb = tpac_nomb;
	}
	
	
	

}
