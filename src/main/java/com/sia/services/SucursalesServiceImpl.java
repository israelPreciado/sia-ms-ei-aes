/**
 * 
 */
package com.sia.services;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.sia.pojos.Pagination;
import com.sia.pojos.TablePagination;
import com.sia.services.interfaces.SucursalesService;
import com.sia.utilities.ProcessData;
import com.sia.vo.SucursalesVO;

/**
 * @author quattro1
 *
 */
@Service
public class SucursalesServiceImpl implements SucursalesService {
	
	private static final Logger log = Logger.getLogger(SucursalesServiceImpl.class.getName());

	@Override
	public SucursalesVO findById(Connection conn, BigInteger id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SucursalesVO create(Connection conn, SucursalesVO object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SucursalesVO update(Connection conn, SucursalesVO object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SucursalesVO delete(Connection conn, SucursalesVO object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SucursalesVO> findAllByCr(Connection conn, int cr) {
		List<SucursalesVO> sucursales = new ArrayList<>();
		
		try {
			StringBuilder sql = new StringBuilder();			
			sql.append("select s.sucursal_id, s.empresa_id, d.division_id, d.nombre nombre_division, s.zona_id, s.cr, s.nombre, s.clasificacion, s.tipo_sucursal");
			sql.append(", s.domicilio, s.entre_calles, s.colonia, s.cp, s.fecha_creacion, s.fecha");
			sql.append(" from sucursales s ");
			sql.append(" join divisiones d on d.division_id=s.division_id ");
			sql.append(" where s.cr like concat(?, '%') ");
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, cr);
			
			JSONArray result = new ProcessData().toJSONArray(ps);
			
			for(int i = 0; i < result.length(); i++) {
				JSONObject obj = result.getJSONObject(i);
				SucursalesVO sucursal = new SucursalesVO();
				sucursal.setSucursalId(BigInteger.valueOf(obj.getInt("sucursal_id")));
				sucursal.setEmpresaId(BigInteger.valueOf(obj.getInt("empresa_id")));
				sucursal.setDivisionId(BigInteger.valueOf(obj.getInt("division_id")));
				sucursal.setNombreDivision(obj.getString("nombre_division"));
				sucursal.setZonaId(BigInteger.valueOf(obj.getInt("zona_id")));
				sucursal.setCr(obj.getInt("cr"));
				sucursal.setNombre(obj.getString("nombre"));
				sucursal.setClasificacion(obj.getString("clasificacion"));
				sucursal.setTipoSucursal(obj.getString("tipo_sucursal"));
				sucursal.setDomicilio(obj.getString("domicilio"));
				sucursal.setEntreCalles(obj.getString("entre_calles"));
				sucursal.setColonia(obj.getString("colonia"));
				sucursal.setCp(obj.getString("cp"));				
				log.info("fecha_creacion="+ obj.get("fecha_creacion"));
				log.info("fecha="+ obj.get("fecha"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");				
				
				sucursales.add(sucursal);
			}
		} catch(Exception e) {
			log.warning(e.getMessage());
		}
		
		return sucursales;
	}

	@Override
	public List<SucursalesVO> findAllByNombre(Connection conn, String nombre) {
		List<SucursalesVO> sucursales = new ArrayList<>();
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select s.sucursal_id, s.empresa_id, d.division_id, d.nombre nombre_division, s.zona_id, s.cr, s.nombre, s.clasificacion, s.tipo_sucursal");
			sql.append(", s.domicilio, s.entre_calles, s.colonia, s.cp, s.fecha_creacion, s.fecha");
			sql.append(" from sucursales s ");
			sql.append(" join divisiones d on d.division_id=s.division_id ");
			sql.append(" where s.nombre like concat('%', ?, '%') ");
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, nombre);
			
			JSONArray result = new ProcessData().toJSONArray(ps);
			
			for(int i = 0; i < result.length(); i++) {
				JSONObject obj = result.getJSONObject(i);
				SucursalesVO sucursal = new SucursalesVO();
				sucursal.setSucursalId(BigInteger.valueOf(obj.getInt("sucursal_id")));
				sucursal.setEmpresaId(BigInteger.valueOf(obj.getInt("empresa_id")));
				sucursal.setDivisionId(BigInteger.valueOf(obj.getInt("division_id")));
				sucursal.setNombreDivision(obj.getString("nombre_division"));
				sucursal.setZonaId(BigInteger.valueOf(obj.getInt("zona_id")));
				sucursal.setCr(obj.getInt("cr"));
				sucursal.setNombre(obj.getString("nombre"));
				sucursal.setClasificacion(obj.getString("clasificacion"));
				sucursal.setTipoSucursal(obj.getString("tipo_sucursal"));
				sucursal.setDomicilio(obj.getString("domicilio"));
				sucursal.setEntreCalles(obj.getString("entre_calles"));
				sucursal.setColonia(obj.getString("colonia"));
				sucursal.setCp(obj.getString("cp"));				
				log.info("fecha_creacion="+ obj.get("fecha_creacion"));
				log.info("fecha="+ obj.get("fecha"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//sucursal.setFechaCreacion(sdf.parse(obj.getString("fecha_creacion")));
				//sucursal.setFecha(sdf.parse(obj.getString("fecha")));
				
				sucursales.add(sucursal);
			}
		} catch(Exception e) {
			log.warning(e.getMessage());
		}
		
		return sucursales;
	}

	@Override
	public List<TablePagination> findAllByPage(Connection conn, int page, int pagging) {
		List<TablePagination> responseTablePagination = new ArrayList<>();
		TablePagination tablePagination = new TablePagination();
		List<Object> sucursales = new ArrayList<>();
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select s.sucursal_id, s.empresa_id, d.division_id, d.nombre nombre_division, s.zona_id, s.cr, s.nombre, s.clasificacion, s.tipo_sucursal");
			sql.append(", s.domicilio, s.entre_calles, s.colonia, s.cp, s.fecha_creacion, s.fecha");
			sql.append(" from sucursales s ");
			sql.append(" join divisiones d on d.division_id=s.division_id ");
			sql.append(" where s.status=1 ");
			sql.append(" order by s.nombre ");
			sql.append(" limit ?, ? ");
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, page);
			ps.setInt(2, pagging);
			
			ProcessData processData = new ProcessData();
			
			JSONArray result = processData.toJSONArray(ps);
			
			for(int i = 0; i < result.length(); i++) {
				JSONObject obj = result.getJSONObject(i);
				SucursalesVO sucursal = new SucursalesVO();
				sucursal.setSucursalId(BigInteger.valueOf(obj.getInt("sucursal_id")));
				sucursal.setEmpresaId(BigInteger.valueOf(obj.getInt("empresa_id")));
				sucursal.setDivisionId(BigInteger.valueOf(obj.getInt("division_id")));
				sucursal.setNombreDivision(obj.getString("nombre_division"));
				sucursal.setZonaId(BigInteger.valueOf(obj.getInt("zona_id")));
				sucursal.setCr(obj.getInt("cr"));
				sucursal.setNombre(obj.getString("nombre"));
				sucursal.setClasificacion(obj.getString("clasificacion"));
				sucursal.setTipoSucursal(obj.getString("tipo_sucursal"));
				sucursal.setDomicilio(obj.getString("domicilio"));
				sucursal.setEntreCalles(obj.getString("entre_calles"));
				sucursal.setColonia(obj.getString("colonia"));
				sucursal.setCp(obj.getString("cp"));				
				log.info("fecha_creacion="+ obj.get("fecha_creacion"));
				log.info("fecha="+ obj.get("fecha"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//sucursal.setFechaCreacion(sdf.parse(obj.getString("fecha_creacion")));
				//sucursal.setFecha(sdf.parse(obj.getString("fecha")));
				
				sucursales.add(sucursal);
			}
			
			sql = new StringBuilder();
			sql.append("select count(s.sucursal_id) as sucursales from sucursales s where s.status=1");
			
			ps = conn.prepareStatement(sql.toString());
			
			JSONArray rsPagination = processData.toJSONArray(ps);
			Pagination pagination = new Pagination();
			
			for(int i = 0; i < rsPagination.length(); i++) {
				JSONObject obj = rsPagination.getJSONObject(i);
				pagination.setStartItem(page + 1);
				pagination.setEndItem(obj.getInt("sucursales") > (page + pagging) ? page + pagging : obj.getInt("sucursales"));
				pagination.setTotalItem(obj.getInt("sucursales"));
			}
			
			tablePagination.setBody(sucursales);
			tablePagination.setPagination(pagination);
			
			responseTablePagination.add(tablePagination);
			
		} catch(Exception e) {
			SucursalesVO sucursal = new SucursalesVO();
			sucursal.setNombre(e.getMessage());
			sucursales.add(sucursal);
			tablePagination.setBody(sucursales);
			
			log.warning(e.getMessage());
		}
		
		return responseTablePagination;
	}	

}
