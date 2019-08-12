function doAjaxCall(url, reqType, data, async, dataType){
	
	var result='';
	 $.ajax({
			url : url,
			data : data,
			type : reqType,
			async : async,
			dataType : dataType,
			success : function(response) {
				result = response;
			},
			error : function(xhr, ajaxOptions, thrownError) {
				/*var errorList = [];
				errorList.push(getLocalMessage("admin.login.internal.server.error"));
				showError(errorList);*/
			}
		});

		return result;
	
}