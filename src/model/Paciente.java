package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="zb_paciente")
public class Paciente {
	@Id
	@SequenceGenerator(name="zb_paciente_seq", allocationSize=1, initialValue=4)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="zb_paciente_seq")
	private int paci_id;
	@JoinColumn(name="tpac_id")
	@ManyToOne
	private TipoPaciente tipoPaciente;
	private String paci_dni;
	private String paci_nomb;
	private String paci_apel,
	paci_dire,
	paci_telf,
	paci_emai;
	@Temporal(TemporalType.DATE)
	private Date paci_fnac;
	@Temporal(TemporalType.DATE)
	private Date paci_freg;
	private Character paci_esta;
	public int getPaci_id() {
		return paci_id;
	}
	public void setPaci_id(int paci_id) {
		this.paci_id = paci_id;
	}
	public TipoPaciente getTipoPaciente() {
		return tipoPaciente;
	}
	public void setTipoPaciente(TipoPaciente tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}
	public String getPaci_dni() {
		return paci_dni;
	}
	public void setPaci_dni(String paci_dni) {
		this.paci_dni = paci_dni;
	}
	public String getPaci_nomb() {
		return paci_nomb;
	}
	public void setPaci_nomb(String paci_nomb) {
		this.paci_nomb = paci_nomb;
	}
	public String getPaci_apel() {
		return paci_apel;
	}
	public void setPaci_apel(String paci_apel) {
		this.paci_apel = paci_apel;
	}
	public String getPaci_dire() {
		return paci_dire;
	}
	public void setPaci_dire(String paci_dire) {
		this.paci_dire = paci_dire;
	}
	public String getPaci_telf() {
		return paci_telf;
	}
	public void setPaci_telf(String paci_telf) {
		this.paci_telf = paci_telf;
	}
	public String getPaci_emai() {
		return paci_emai;
	}
	public void setPaci_emai(String paci_emai) {
		this.paci_emai = paci_emai;
	}
	public Date getPaci_fnac() {
		return paci_fnac;
	}
	public void setPaci_fnac(Date paci_fnac) {
		this.paci_fnac = paci_fnac;
	}
	public Character getPaci_esta() {
		return paci_esta;
	}
	public void setPaci_esta(Character paci_esta) {
		this.paci_esta = paci_esta;
	}
	public Date getPaci_freg() {
		return paci_freg;
	}
	public void setPaci_freg(Date paci_freg) {
		this.paci_freg = paci_freg;
	}
	
	
	
	
	
	

}
