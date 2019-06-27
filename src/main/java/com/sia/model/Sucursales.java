/**
 * 
 */
package com.sia.model;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author quattro1
 * Estaclase es la entidad que representa a un registro de la tabla sucursales
 */
public class Sucursales {
	private BigInteger sucursalId;
	private BigInteger empresaId;
	private BigInteger divisionId;
	private BigInteger zonaId;
	private int cr;
	private String nombre;
	private String clasificacion;
	private String tipoSucursal;
	private String domicilio;
	private String entreCalles;
	private String colonia;
	private String cp;
	private Date fecha;
	private short status;
	
	public BigInteger getSucursalId() {
		return sucursalId;
	}
	public void setSucursalId(BigInteger sucursalId) {
		this.sucursalId = sucursalId;
	}
	public BigInteger getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(BigInteger empresaId) {
		this.empresaId = empresaId;
	}
	public BigInteger getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(BigInteger divisionId) {
		this.divisionId = divisionId;
	}
	public BigInteger getZonaId() {
		return zonaId;
	}
	public void setZonaId(BigInteger zonaId) {
		this.zonaId = zonaId;
	}
	public int getCr() {
		return cr;
	}
	public void setCr(int cr) {
		this.cr = cr;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getTipoSucursal() {
		return tipoSucursal;
	}
	public void setTipoSucursal(String tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getEntreCalles() {
		return entreCalles;
	}
	public void setEntreCalles(String entreCalles) {
		this.entreCalles = entreCalles;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}		
}
