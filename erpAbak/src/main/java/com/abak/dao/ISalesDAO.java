package com.abak.dao;

import java.util.List;

import com.abak.entity.Project;

public interface ISalesDAO {
	
	public void saveProject(Project project);
	public List<Project> getAllProject();
	public Project getProjectById(Integer projectId);
	

}
