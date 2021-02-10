package mj.ita.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mj.ita.dao.ProjectRepository;
import mj.ita.dto.ChartData;
import mj.ita.dto.TimeChartData;
import mj.ita.entities.Project;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository proRepo;
	
	public Project save(Project project) {
		return proRepo.save(project);
	}
	
	public List<Project> getAll() {
		return proRepo.findAll();
	}
	
	public List<ChartData> getProjectStatus() {
		return proRepo.getProjectStatus();
	}
	
	public Project findByProjectId(long theId) {
		return proRepo.findByProjectId(theId);
	}

	public void delete(Project theProj) {
		proRepo.delete(theProj);
	}
	
	public List<TimeChartData> getTimeData() {
		return proRepo.getTimeData();
	}
	
}
