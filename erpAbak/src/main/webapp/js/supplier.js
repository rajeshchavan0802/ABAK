function saveSupplieMasterData(){
    	alert("kuch to aaya");
    	var data = $("#myForm").serialize();
    	var resData = doAjaxCall('supplier?save', 'post', data, false, 'json');
    	alert(resData);
    	alert(resData.projectName);
    	var res = JSON.parse(resData);
    	alert("====="+res.length);
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
