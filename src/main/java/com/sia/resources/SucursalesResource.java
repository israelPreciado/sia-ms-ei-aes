/**
 * 
 */
package com.sia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sia.SiaMsEiAesApplication;
import com.sia.pojos.TablePagination;
import com.sia.services.interfaces.SucursalesService;
import com.sia.vo.SucursalesVO;

/**
 * @author quattro1
 *
 */
@RestController
@RequestMapping("/v1/sucursales")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SucursalesResource {
	
	@Autowired
	SucursalesService sucursalesService;

	@GetMapping
	public ResponseEntity<List<SucursalesVO>> findByNombre(@RequestParam String nombre) {
		boolean isNumeric = false;
		int cr = 0;
		
		try {
			cr = Integer.valueOf(nombre);
			isNumeric = true;
		} catch(Exception e) {
			isNumeric = false;
		}
		
		if(isNumeric)
			return new ResponseEntity<>(sucursalesService.findAllByCr(SiaMsEiAesApplication.conn, cr), HttpStatus.OK);
		else
			return new ResponseEntity<>(sucursalesService.findAllByNombre(SiaMsEiAesApplication.conn, nombre), HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<TablePagination>> findAllByPage(@RequestParam int page) {
		int pagging = 10;
		return new ResponseEntity<>(sucursalesService.findAllByPage(SiaMsEiAesApplication.conn, page, pagging), HttpStatus.OK);
	}
}
