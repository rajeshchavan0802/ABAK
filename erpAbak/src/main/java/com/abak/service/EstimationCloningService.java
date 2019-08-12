package com.abak.service;

import com.abak.dao.EstSheetDao;
import com.abak.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class EstimationCloningService implements IEstimationCloningService {

    @Autowired
    private ISalesService iSalesService;

    @Autowired
    private EstSheetDao iEstSheetDao;

    @Override
    @Transactional
    public boolean doCloning(int sourceProjectId, int destinationProjectId) {

        boolean result = false;
        Project sourceProject = iSalesService.getProjectById(sourceProjectId);
        Project destinationProject = iSalesService.getProjectById(destinationProjectId);
        List<Panel> panelList = new ArrayList<>(sourceProject.getPanels());
        List<Panel> SourcePanelList ;
        try{
             SourcePanelList = this.setPanelForCloning(panelList,destinationProject.getProjectId(),destinationProject);
        }catch (CloneNotSupportedException c){
            System.out.println("Exception cloning");
            return result;
        }

        destinationProject.setIsEstimationCreated(true);
        destinationProject.setPanels(SourcePanelList);
        iEstSheetDao.saveEstimation(destinationProject);
        result = true;
        return result;
    }

    public List<Panel> setPanelForCloning(List<Panel> panelList,int projectId,Project project) throws CloneNotSupportedException{

        List<Panel> returnPanles = new ArrayList<>();

        for(Panel panelTemp:panelList){
           Panel panel = (Panel)panelTemp.clone();
           iEstSheetDao.disconectPanel(panelTemp);
            panel.setPanelId(null);
            panel.setProject(project);

            List<PanelAdditionalComponent> panelAdditionalComponents=new ArrayList<>();
            PanelAdditionalComponent additionalComponent;
            for(PanelAdditionalComponent additionalComponentTemp : panel.getPanelAdditionalComponents()) {
                additionalComponent = (PanelAdditionalComponent)additionalComponentTemp.clone();
                additionalComponent.setProjectId(projectId);
                additionalComponent.setPanel(panel);
                additionalComponent.setPanelAdditionalComponentId(null);
                panelAdditionalComponents.add(additionalComponent);
            }
            panel.setPanelAdditionalComponents(panelAdditionalComponents);

            List<PanelDetails> panelDetails = new ArrayList<>();
            PanelDetails details;
            for(PanelDetails detailsTemp: panel.getPanelDetailses()) {
                details= (PanelDetails)detailsTemp.clone();
                details.setProjectId(projectId);
                details.setPanel(panel);
                details.setPanelDetailsId(null);
                panelDetails.add(details);
            }
            panel.setPanelDetailses(panelDetails);


            List<PanelSpecification> panelSpecifications = new ArrayList<>();
            PanelSpecification specification;
            for(PanelSpecification specificationTemp : panel.getPanelSpecifications()) {
                specification= (PanelSpecification)specificationTemp.clone();
                specification.setProjectId(projectId);
                specification.setPanel(panel);
                specification.setPanelSpecificationId(null);
                panelSpecifications.add(specification);
            }
            panel.setPanelSpecifications(panelSpecifications);


            returnPanles.add(panel);

        }

        return returnPanles;

    }


}
