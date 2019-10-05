function saveSupplieMasterData(){
    	alert("kuch to aaya");
    	var data = $("#myForm").serialize();
    	var resData = doAjaxCall('supplier?save', 'post', data, false, 'json');
    	alert(resData);
    	alert(resData.projectName);
    	var res = JSON.parse(resData);
    	alert("====="+res.length);
    }

function viewSupplierData(supplierNumber){

	var data = 'supplierNumber='+ supplierNumber+'&requestType=1';
	$("#formContent").empty();
	var resData = doAjaxCall('supplier?viewSupplierInfo', 'post', data, false, 'json');
	$("#formContent").html(resData); 
}

function editSupplierData(supplierNumber){

	var data = 'supplierNumber='+ supplierNumber+'&requestType=2';
	$("#formContent").empty();
	var resData = doAjaxCall('supplier?viewSupplierInfo', 'post', data, false, 'json');
	$("#formContent").html(resData); 
}

function deleteSupplierData(supplierNumber){

	var data = 'supplierNumber='+ supplierNumber+'&requestType=3';
	$("#formContent").empty();
	var resData = doAjaxCall('supplier?viewSupplierInfo', 'post', data, false, 'json');
	$("#formContent").html(resData); 
}

function repeatrow(id){
	
	pdcount++;
console.log("#"+id);
	element=""+
	'<tr>'+
	'<td><input type="text" name="" size="27"></td>'+
	'<td><input type="text" name="supplierDetailses['+pdcount+'].makeDescription" size="27"></td>'+
	
		'<td><img src="images/plus.png" height="35" width="35" ></img>'+
		'<img src="images/minus.png" height="35" width="35" onclick="this.parentElement.parentElement.remove();"></img></td>'+
	'</tr>';
	$("#"+id).append(element);
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
