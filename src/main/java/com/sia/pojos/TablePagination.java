/**
 * 
 */
package com.sia.pojos;

import java.util.List;

/**
 * @author quattro1
 *
 */
public class TablePagination {
	private List<Object> body;	
	private Pagination pagination;
	
	public List<Object> getBody() {
		return body;
	}
	public void setBody(List<Object> body) {
		this.body = body;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}		
}
