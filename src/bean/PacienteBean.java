package bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import model.Paciente;
import model.TipoPaciente;
import serv.PacienteServ;
import serv.TipoPacienteServ;

@ManagedBean
@SessionScoped
public class PacienteBean {
private int paci_id;
private String 
	paci_dni,
	paci_nomb,
	paci_apel,
	paci_emai,
	paci_telf,
	paci_dire;
private Character 
	paci_esta;
private Date paci_fnac, paci_freg;
private TipoPaciente tipoPaciente;


private TipoPacienteServ oTipoPacienteServ = new TipoPacienteServ();
private PacienteServ oPacienteServ = new PacienteServ();


private List<TipoPaciente> listaTipoPaciente;
private List<Paciente> listaPaciente;

private int listaPacienteTamano;

private boolean sw_edit;

private int fila_seleccionada;


public void llenarCombos() throws Exception{
	listaTipoPaciente=oTipoPacienteServ.listar();
}


public boolean accion_insertar() throws Exception{
	sw_edit=false;
	llenarCombos();
	return sw_edit;
}

public boolean accion_editar() throws Exception{
	sw_edit=true;
	llenarCombos();
	return sw_edit;
}

public void insertar() throws Exception{
	Paciente oPaciente=new Paciente();
	oPaciente.setTipoPaciente(tipoPaciente);
	oPaciente.setPaci_dni(paci_dni);
	oPaciente.setPaci_nomb(paci_nomb);
	oPaciente.setPaci_apel(paci_apel);
	oPaciente.setPaci_dire(paci_dire);;
	oPaciente.setPaci_fnac(paci_fnac);
	oPaciente.setPaci_telf(paci_telf);
	oPaciente.setPaci_emai(paci_emai);
	oPaciente.setPaci_freg(new Date());
	oPaciente.setPaci_esta('A');
	Thread.sleep(4500);
	oPacienteServ.insertar(oPaciente);
	limpiar();
}

public void limpiar(){
	Paciente oPaciente=new Paciente();
	oPaciente.setTipoPaciente(new TipoPaciente());
	oPaciente.setPaci_dni(null);
	oPaciente.setPaci_nomb(null);
	oPaciente.setPaci_apel(null);
	oPaciente.setPaci_dire(null);;
	oPaciente.setPaci_fnac(null);
	oPaciente.setPaci_telf(null);
	oPaciente.setPaci_emai(null);
	oPaciente.setPaci_freg(null);
	oPaciente.setPaci_esta(null);
}
public void seleccionar(ActionEvent e) throws Exception
{
	String fila=e.getComponent().getAttributes().get("atributo_id").toString();
	System.out.println(fila);
	fila_seleccionada=Integer.parseInt(fila);
}

public void obtener_datos(ActionEvent e) throws Exception{
	seleccionar(e);
	accion_editar();
	Paciente em = new Paciente();
	em.setPaci_id(fila_seleccionada);
	Paciente oPaciente= oPacienteServ.obtener(em);
	setPaci_id(oPaciente.getPaci_id());
	setTipoPaciente(oPaciente.getTipoPaciente());
	setPaci_dni(oPaciente.getPaci_dni());
	setPaci_nomb(oPaciente.getPaci_nomb());
	setPaci_apel(oPaciente.getPaci_apel());
	setPaci_dire(oPaciente.getPaci_dire());
	setPaci_fnac(oPaciente.getPaci_fnac());
	setPaci_emai(oPaciente.getPaci_emai());
	setPaci_telf(oPaciente.getPaci_telf());
	setPaci_freg(oPaciente.getPaci_freg());
	setPaci_esta(oPaciente.getPaci_esta());
	
	
}

public void modificar() throws Exception{
	Paciente oPaciente = new Paciente();
	oPaciente.setPaci_id(paci_id);
	oPaciente.setPaci_dni(paci_dni);
	oPaciente.setPaci_nomb(paci_nomb);
	oPaciente.setPaci_apel(paci_apel);
	oPaciente.setPaci_dire(paci_dire);
	oPaciente.setPaci_freg(paci_freg);
	oPaciente.setPaci_emai(paci_emai);
	oPaciente.setPaci_fnac(paci_fnac);
	oPaciente.setPaci_telf(paci_telf);
	oPaciente.setPaci_dire(paci_dire);
	oPaciente.setTipoPaciente(tipoPaciente);
	oPaciente.setPaci_esta('A');
	Thread.sleep(4500);
	oPacienteServ.actualizar(oPaciente);
}

public void busqueda() throws Exception{
	Paciente oPaciente = new Paciente();
	oPaciente.setPaci_nomb(paci_nomb);
	listaPaciente=oPacienteServ.buscar(oPaciente);
	listaPacienteTamano=listaPaciente.size();
}

public void borrar() throws Exception{
	Paciente oPaciente = new Paciente();
	oPaciente.setPaci_id(fila_seleccionada);
	oPacienteServ.eliminar(oPaciente);
	busqueda();
	limpiar();
}


public int getPaci_id() {
	return paci_id;
}


public void setPaci_id(int paci_id) {
	this.paci_id = paci_id;
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


public String getPaci_emai() {
	return paci_emai;
}


public void setPaci_emai(String paci_emai) {
	this.paci_emai = paci_emai;
}


public String getPaci_telf() {
	return paci_telf;
}


public void setPaci_telf(String paci_telf) {
	this.paci_telf = paci_telf;
}


public String getPaci_dire() {
	return paci_dire;
}


public void setPaci_dire(String paci_dire) {
	this.paci_dire = paci_dire;
}




public Character getPaci_esta() {
	return paci_esta;
}


public void setPaci_esta(Character paci_esta) {
	this.paci_esta = paci_esta;
}


public Date getPaci_fnac() {
	return paci_fnac;
}


public void setPaci_fnac(Date paci_fnac) {
	this.paci_fnac = paci_fnac;
}


public Date getPaci_freg() {
	return paci_freg;
}


public void setPaci_freg(Date paci_freg) {
	this.paci_freg = paci_freg;
}


public TipoPaciente getTipoPaciente() {
	return tipoPaciente;
}


public void setTipoPaciente(TipoPaciente tipoPaciente) {
	this.tipoPaciente = tipoPaciente;
}


public TipoPacienteServ getoTipoPacienteServ() {
	return oTipoPacienteServ;
}


public void setoTipoPacienteServ(TipoPacienteServ oTipoPacienteServ) {
	this.oTipoPacienteServ = oTipoPacienteServ;
}


public PacienteServ getoPacienteServ() {
	return oPacienteServ;
}


public void setoPacienteServ(PacienteServ oPacienteServ) {
	this.oPacienteServ = oPacienteServ;
}


public List<TipoPaciente> getListaTipoPaciente() {
	return listaTipoPaciente;
}


public void setListaTipoPaciente(List<TipoPaciente> listaTipoPaciente) {
	this.listaTipoPaciente = listaTipoPaciente;
}


public List<Paciente> getListaPaciente() {
	return listaPaciente;
}


public void setListaPaciente(List<Paciente> listaPaciente) {
	this.listaPaciente = listaPaciente;
}


public int getListaPacienteTamano() {
	return listaPacienteTamano;
}


public void setListaPacienteTamano(int listaPacienteTamano) {
	this.listaPacienteTamano = listaPacienteTamano;
}


public boolean isSw_edit() {
	return sw_edit;
}


public void setSw_edit(boolean sw_edit) {
	this.sw_edit = sw_edit;
}


public int getFila_seleccionada() {
	return fila_seleccionada;
}


public void setFila_seleccionada(int fila_seleccionada) {
	this.fila_seleccionada = fila_seleccionada;
}

@PostConstruct
public void init() {
	tipoPaciente = new TipoPaciente();
}


}
