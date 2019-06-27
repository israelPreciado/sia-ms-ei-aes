/**
 * 
 */
package com.sia.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.SiaMsEiAesApplication;
import com.sia.model.ReporteFotografico;
import com.sia.services.interfaces.ReporteFotograficoService;
import com.sia.vo.ReporteFotograficoVO;

/**
 * @author randd1
 * Clase que representa el servicio web de Reporte Fotografico
 */
@RestController
@RequestMapping("/v1/reporte-fotografico")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReporteFotograficoResource {	
	
	@Autowired
	ReporteFotograficoService reporteFotofragicoService;

	@PostMapping
	public ResponseEntity<ReporteFotograficoVO> createReporteFotografico(@RequestBody ReporteFotograficoVO reporteFotograficoVO) {				
		if(reporteFotograficoVO == null) {
			return new ResponseEntity<>(reporteFotograficoVO, HttpStatus.CONFLICT);
		}
		if(reporteFotograficoVO.getS1Titulo() == null) {
			return new ResponseEntity<>(reporteFotograficoVO, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		ReporteFotografico reporteFotografico = new ReporteFotografico();
		// seccion 1
		reporteFotografico.setS1Titulo(reporteFotograficoVO.getS1Titulo());
		reporteFotografico.setS1DivisionRegion(reporteFotograficoVO.getS1DivisionRegion() == null ? "" : reporteFotograficoVO.getS1DivisionRegion());
		reporteFotografico.setS1Objetivo(reporteFotograficoVO.getS1Objetivo() == null ? "" : reporteFotograficoVO.getS1Objetivo());
		reporteFotografico.setS1Supervisor(reporteFotograficoVO.getS1Supervisor() == null ? "" : reporteFotograficoVO.getS1Supervisor());
		reporteFotografico.setS1Oficina(reporteFotograficoVO.getS1Oficina() == null ? "" : reporteFotograficoVO.getS1Oficina());
		// seccion 2
		reporteFotografico.setS2PlantaEmergencia(reporteFotograficoVO.getS2PlantaEmergencia() == null ? "" : reporteFotograficoVO.getS2PlantaEmergencia());
		reporteFotografico.setS2AzoteaPropCompartida(reporteFotograficoVO.getS2AzoteaPropCompartida() == null ? "" : reporteFotograficoVO.getS2AzoteaPropCompartida());
		reporteFotografico.setS2LocalPropRentado(reporteFotograficoVO.getS2LocalPropRentado() == null ? "" : reporteFotograficoVO.getS2LocalPropRentado());
		reporteFotografico.setS2CuentaEstacionamiento(reporteFotograficoVO.getS2CuentaEstacionamiento() == null ? "" : reporteFotograficoVO.getS2CuentaEstacionamiento());
		reporteFotografico.setS2NumCajasVentanilla(reporteFotograficoVO.getS2NumCajasVentanilla() == null ? "" : reporteFotograficoVO.getS2NumCajasVentanilla());
		reporteFotografico.setS2NumBancas3Plazas(reporteFotograficoVO.getS2NumBancas3Plazas() == null ? "" : reporteFotograficoVO.getS2NumBancas3Plazas());
		reporteFotografico.setS2NumBancas2Plazas(reporteFotograficoVO.getS2NumBancas2Plazas() == null ? "" : reporteFotograficoVO.getS2NumBancas2Plazas());
		reporteFotografico.setS2NumEjecutivos(reporteFotograficoVO.getS2NumEjecutivos() == null ? "" : reporteFotograficoVO.getS2NumEjecutivos());
		reporteFotografico.setS2LugaresEjecDisponibles(reporteFotograficoVO.getS2LugaresEjecDisponibles() == null ? "" : reporteFotograficoVO.getS2LugaresEjecDisponibles());
		reporteFotografico.setS2CuentaBancaPersonal(reporteFotograficoVO.getS2CuentaBancaPersonal() == null ? "" : reporteFotograficoVO.getS2CuentaBancaPersonal());
		// seccion 3
		reporteFotografico.setS3CuentaSenalizacionProtCivCompleta(reporteFotograficoVO.getS3CuentaSenalizacionProtCivCompleta() == null ? "" : reporteFotograficoVO.getS3CuentaSenalizacionProtCivCompleta());
		reporteFotografico.setS3NumExtintores(reporteFotograficoVO.getS3NumExtintores() == null ? "" : reporteFotograficoVO.getS3NumExtintores());
		reporteFotografico.setS3CuentaLlaveSwitch(reporteFotograficoVO.getS3CuentaLlaveSwitch() == null ? "" : reporteFotograficoVO.getS3CuentaLlaveSwitch());
		reporteFotografico.setS3CuentaContactoresAlumbradoAA(reporteFotograficoVO.getS3CuentaContactoresAlumbradoAA() == null ? "" : reporteFotograficoVO.getS3CuentaContactoresAlumbradoAA());
		reporteFotografico.setS3NumAtms(reporteFotograficoVO.getS3NumAtms() == null ? "" : reporteFotograficoVO.getS3NumAtms());
		reporteFotografico.setS3NumPc(reporteFotograficoVO.getS3NumPc() == null ? "" : reporteFotograficoVO.getS3NumPc());
		reporteFotografico.setS3CuentaPisoAlfombra(reporteFotograficoVO.getS3CuentaPisoAlfombra() == null ? "" : reporteFotograficoVO.getS3CuentaPisoAlfombra());
		// seccion 4
		reporteFotografico.setS4CapacidadUpsMarca(reporteFotograficoVO.getS4CapacidadUpsMarca() == null ? "" : reporteFotograficoVO.getS4CapacidadUpsMarca());
		reporteFotografico.setS4CuentaCalefaccion(reporteFotograficoVO.getS4CuentaCalefaccion() == null ? "" : reporteFotograficoVO.getS4CuentaCalefaccion());
		reporteFotografico.setS4GarantiaImpermeabilizacion(reporteFotograficoVO.getS4GarantiaImpermeabilizacion() == null ? "" : reporteFotograficoVO.getS4GarantiaImpermeabilizacion());
		reporteFotografico.setS4FacilidadAccesoAzotea(reporteFotograficoVO.getS4FacilidadAccesoAzotea() == null ? "" : reporteFotograficoVO.getS4FacilidadAccesoAzotea());
		reporteFotografico.setS4CuentaConPodio(reporteFotograficoVO.getS4CuentaConPodio() == null ? "" : reporteFotograficoVO.getS4CuentaConPodio());
		reporteFotografico.setS4NumPantallas(reporteFotograficoVO.getS4NumPantallas() == null ? "" : reporteFotograficoVO.getS4NumPantallas());
				
		reporteFotofragicoService.create(SiaMsEiAesApplication.conn, reporteFotografico);
		reporteFotograficoVO.setReporteFotograficoId(reporteFotografico.getReporteFotograficoId());
						
		return new ResponseEntity<>(reporteFotograficoVO, HttpStatus.CREATED);
	}
}
