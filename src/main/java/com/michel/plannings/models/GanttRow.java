package com.michel.plannings.models;

import com.michel.plannings.models.auxiliary.AuxiliaryUtils;

public class GanttRow implements Comparable<GanttRow> {

	private String taskId;
	private String taskName;
	private String ressource;
	private String startDate;
	private String endDate;
	private int duration;
	private int percent;
	private String dependencies;

	public GanttRow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GanttRow(Phase phase) {

		this.taskId = String.valueOf(phase.getId());
		this.taskName = phase.getNom();
		this.ressource = phase.getRessource().getNom();
		this.startDate = AuxiliaryUtils.convertDateToString(phase.getDebut());
		this.endDate = AuxiliaryUtils.convertDateToString(phase.getFin());
		this.duration = 0;
		this.percent = phase.getAvancement();
		this.dependencies = makeDependancies(phase);

	}

	private String makeDependancies(Phase phase) {

		/*
		String dependencies = new String();
		Object[] dependances  = phase.getDependances().toArray();
		if (dependances.length !=0) {
			
			dependencies = String.valueOf(dependances[0]);
			for (int i=1; i<dependances.length;i++) {

				dependencies = dependencies + "," + dependances[i];
			}
			return dependencies;
			
		} else {
			return null;
		}
		*/
		return null;
	
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public String getDependencies() {
		return dependencies;
	}

	public void setDependencies(String dependencies) {
		this.dependencies = dependencies;
	}

	public String getRessource() {
		return ressource;
	}

	public void setRessource(String ressource) {
		this.ressource = ressource;
	}

	@Override
	public int compareTo(GanttRow ganttRow) {
		int id = Integer.parseInt(this.taskId);
		int idRow = Integer.parseInt(ganttRow.taskId);
		return (id - idRow);
	}

}
