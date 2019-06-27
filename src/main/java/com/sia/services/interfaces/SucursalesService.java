/**
 * 
 */
package com.sia.services.interfaces;

import java.sql.Connection;
import java.util.List;

import com.sia.model.Sucursales;
import com.sia.pojos.TablePagination;
import com.sia.vo.SucursalesVO;

/**
 * @author quattro1
 *
 */
public interface SucursalesService  extends CommonService<SucursalesVO> {
	public List<SucursalesVO> findAllByCr(Connection conn, int cr);
	public List<SucursalesVO> findAllByNombre(Connection conn, String nombre);
	public List<TablePagination> findAllByPage(Connection conn, int page, int pagging);
}
