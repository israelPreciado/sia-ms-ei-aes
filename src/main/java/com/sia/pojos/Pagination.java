/**
 * 
 */
package com.sia.pojos;

/**
 * @author quattro1
 *
 */
public class Pagination {
	private int startItem;
	private int endItem;
	private int totalItem;
	
	public int getStartItem() {
		return startItem;
	}
	public void setStartItem(int startItem) {
		this.startItem = startItem;
	}
	public int getEndItem() {
		return endItem;
	}
	public void setEndItem(int endItem) {
		this.endItem = endItem;
	}
	public int getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}
}
