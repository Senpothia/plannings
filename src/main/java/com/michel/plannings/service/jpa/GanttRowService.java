package com.michel.plannings.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.plannings.models.Dependance;
import com.michel.plannings.models.GanttRow;
import com.michel.plannings.models.Phase;
import com.michel.plannings.models.Projet;
import com.michel.plannings.service.GanttRowAbstractServive;

@Service
public class GanttRowService implements GanttRowAbstractServive {

	@Autowired
	DependanceService dependanceService;

	public String getGraphDependencies(GanttRow row) {

		String dependencies = new String();
		Integer idPhase = Integer.parseInt(row.getTaskId());
		List<Dependance> dependances = dependanceService.listeDependances(idPhase);
		for (Dependance d : dependances) {

			dependencies = dependencies + String.valueOf(d.getAntecedente()) + ",";

		}
		
		return dependencies;
	}

}
