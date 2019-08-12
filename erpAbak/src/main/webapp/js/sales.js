
var projectIdforEstimation;

function veiwProjectInfo(projectId){

		projectIdforEstimation = projectId;
    	var data = 'projectId='+ projectId;
    	var resData = doAjaxCall('sales?viewSalesOrderInfo', 'post', data, false, 'json');
    	var res = JSON.parse(resData);

    	$('#projectInfo').show();

    	$('#projectName').val(res.projectName);
    	$('#enquiryNumber').val(res.enquiryNumber);
    	$('#revision').val(res.revision);
        $('#enquiryRecDate').val(res.enquiryRecDate);
        $('#quetationSendDate').val(res.quetationSendDate);
        $('#typesofPanne').val(res.typesofPanne);
        $('#jobNumber').val(res.jobNumber);
        $('#drawingAprvDate').val(res.drawingAprvDate);
        $('#quntity').val(res.quntity);
        $('#enquiryType').val(res.enquiryType);
        $('#estimator').val(res.estimator);
        $('#draftman').val(res.draftman);
        $('#schemaDesigner').val(res.schemaDesigner);
    	
    	/* $('html, body').animate({
            scrollTop: $("#projectInfo").offset().top
        }, 2000); */
    	
    }
   
   
    function  closeProjectInfo(){
    	/* $('#projectInfo').hide(); */

    	$('#projectName').val('');
    	$('#enquiryNumber').val('');
    	$('#revision').val('');
        $('#enquiryRecDate').val('');
        $('#quetationSendDate').val('');
        $('#typesofPanne').val('');
        $('#jobNumber').val('');
        $('#drawingAprvDate').val('');
        $('#quntity').val('');
        $('#enquiryType').val('');
        $('#estimator').val('');
        $('#draftman').val('');
        $('#schemaDesigner').val('');

    	
    	/* $('html, body').animate({
            scrollTop: $("#rc").offset().top
        }, 2000); */
    }

    function doAjaxCall(url, reqType, data, async, dataType){
     
    	var result='';
    	result =$.ajax({
    			url : url,
    			data : data,
    			type : reqType,
    			async : async,
    			dataType : dataType,
    			success : function(response) {
    				
    				//result = response;
    			},
    			 error : function(xhr, ajaxOptions, thrownError) {

    			} 
    		}).responseText;
    	
    	 return result;
    	
    }
    
    
    function addSalesDetails(){
	   	var data = $("#projectDetailsSave").serialize();
	   	var resData = doAjaxCall('sales?add', 'post', data, false, 'json');
	   	var res = JSON.parse(resData);
	   	$("#mainSalesMsg tbody").append("<div class='alert alert-success'>"+res.msg+"</div>" );
	}
    
    
    function getEstimationfromSalesOrder(){
    	
    	var data= {
				 	projectId: projectIdforEstimation,
				 	viewType : 'r'
			};
 
		$("#formContent").empty();
		var resData = doAjaxCall('sales/viewEstimation', 'post', data, false, 'json');
		$("#formContent").html(resData); 
    	
    	
    }
    
    
    
    
    
    
    
    
    
    

