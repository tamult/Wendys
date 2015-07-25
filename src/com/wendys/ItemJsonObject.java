package com.wendys;

import java.util.List;
import com.wendys.Item;

public class ItemJsonObject {
		int iTotalRecords;
	    int iTotalDisplayRecords;
	    String sEcho;
	    String sColumns;
	    List<Item> aaData;
	    public int getiTotalRecords() {
	    return iTotalRecords;
	    }
	    public void setiTotalRecords(int iTotalRecords) {
	    this.iTotalRecords = iTotalRecords;
	    }
	    public int getiTotalDisplayRecords() {
	    return iTotalDisplayRecords;
	    }
	    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
	    this.iTotalDisplayRecords = iTotalDisplayRecords;
	    }
	    public String getsEcho() {
	    return sEcho;
	    }
	    public void setsEcho(String sEcho) {
	    this.sEcho = sEcho;
	    }
	    public String getsColumns() {
	    return sColumns;
	    }
	    public void setsColumns(String sColumns) {
	    this.sColumns = sColumns;
	    }
	    public List<Item> getAaData() {
	        return aaData;
	    }
	    public void setAaData(List<Item> aaData) {
	        this.aaData = aaData;
	    }
	}
