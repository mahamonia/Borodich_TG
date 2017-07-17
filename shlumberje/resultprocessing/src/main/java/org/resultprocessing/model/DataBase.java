package org.resultprocessing.model;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

	private List<Detail> details = new ArrayList<Detail>();

	public DataBase() {
		details.add(new Detail("First detail"));
		details.add(new Detail("Second detail"));
		details.add(new Detail("Third detail"));
		details.add(new Detail("New detail"));
		details.add(new Detail("Detail #1"));
		details.add(new Detail("Detail #2"));
		details.add(new Detail("Detail #3"));

	}

	public List<Detail> getListDetails(){
		return this.details;

	}



}
