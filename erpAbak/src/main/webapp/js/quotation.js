var projectIdQu ='';

function getQuotationPopUp(projectId){
	projectIdQu = projectId;
	alert("getQuotationPopUp");
	
	$("#tempQuotationPopUp").empty();
	$("#tempQuotationPopUp").html('');
	var data = '';//'panelKey='+ panelKey;
	var resData = doAjaxCall('quotation?newQuotationPopUp', 'post', data, false, 'json');
	$("#tempQuotationPopUp").append(resData);	
	window.location = "#popup2";
	
}


function closeQuotationPopUp(){
	
	alert("closeQuotationPopUp");
	projectIdQu ='';
	$("#tempQuotationPopUp").empty();
	$("#tempQuotationPopUp").html('');
}

function generateQuotation(){
	
	var data = 'projectId='+ projectIdQu;
	var resData = doAjaxCall('quotation?generateQuotation', 'post', data, false, 'json');
	$("#tempQuotationPopUp").empty();
	$("#tempQuotationPopUp").html('');
	
	
	$("#formContent").empty();
	resData = doAjaxCall('quotation?index', 'post', '', false, 'json');
	$("#formContent").html(resData);
	
}

