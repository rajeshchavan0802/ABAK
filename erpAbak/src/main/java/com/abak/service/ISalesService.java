package com.abak.service;

import java.util.List;

import com.abak.entity.Project;
import com.abak.model.ProjectInformation;

public interface ISalesService {

	
	public void saveProject(Project project);
	public List<Project> getAllProject();
	public Project getProjectById(Integer projectId);
	public ProjectInformation getProjectInformation(Integer projectId);
	
}
