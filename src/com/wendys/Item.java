package com.wendys;

import java.io.Serializable;

public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	private String type;
    private String season;
    private String style;
    private String color;
    private String length;
    private String size;
    private String designer;
    private String locale;
    private int inventoryid;
    
	public Item() {		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public int getInventoryid() {
		return inventoryid;
	}

	public void setInventoryid(int inventoryid) {
		this.inventoryid = inventoryid;
	}
	
}
