var pdcount=0;
var groupCount = 1;
var panalDetailsDelIDs    = '';
var panalDetailsDelGroups = '';
var panalDelIDs    = '';

 function getPanelDetails(panelKey,viewType){

	 var data= {
			 	panelKey: panelKey,
			 	viewType : viewType
			};
	 
	 
	 $("#tempEstimationPopUp").empty();
	 $("#tempEstimationPopUp").html('');
	 	
	 
	 var resData = doAjaxCall('estimation?estimationDetailsPopUp', 'post', data, false, 'json');
	 $("#tempEstimationPopUp").append(resData);	
	 window.location = "#popup2";
	 
	 alert($('#panelDetailsRowCount').val()+"      "+$('#groupCount').val());
	 pdcount	= $('#panelDetailsRowCount').val()-1;
	 groupCount = $('#groupCount').val();
	 
 }

  
 function getPanelDetailsPopUpEmpty(){
	 
	 pdcount=0;
	 groupCount = 1;
	 $("#tempEstimationPopUp").empty();
	 $("#tempEstimationPopUp").html('');
	 var resData = doAjaxCall('estimation?openEstimationDetailsPopUp', 'post', '', false, 'json');
	 $("#tempEstimationPopUp").append(resData);	
	 window.location = "#popup2";
 }

 function closeUpadatePopUp(){
	 	$("#tempEstimationPopUp").empty();
	 	$("#tempEstimationPopUp").html('');
	   	$( "#estDetailsUpdate" ).remove();
 }
 
 function closeNewEstPopUp(){
	 $("#tempEstimationPopUp").empty();
	 $("#tempEstimationPopUp").html('');
	 $( "#estDetails" ).remove();
 }

 function updateEstimationDetails(){
	   	  
	 	$("#panalDetailsDelIDs").val(panalDetailsDelIDs);
	 	$("#panalDetailsDelGroups").val(panalDetailsDelGroups);
	 
	   	var panelId = $("#panelId").val();
	   	var data = $("#estDetailsUpdate").serialize();
	   	var resData = doAjaxCall('estimation?savePanalEntryInSession', 'post', data, false, 'json');
	   	var res = JSON.parse(resData);
	   	$("#tempEstimationPopUp").empty();
	   	$("#tempEstimationPopUp").html('');
	   	$( "#estDetailsUpdate" ).remove();
	   	
	    $("#description"+panelId+"").html(res.description);
	    $("#qty"+panelId+"").html(res.qty);
	    $("#unitRate"+panelId+"").html(res.unitRate);
	    $("#total"+panelId+"").html(res.total);
	   /*  $("#hight"+panelId+"").val(res.hight);
	    $("#width"+panelId+"").val(res.width);
	    $("#defth"+panelId+"").val(res.defth); */
		//document.getElementById('estDetailsUpdate').reset();
	   	
	   }
 
 	
 	
   function addEstimationDetails(){
   	
	pdcount=0;
	groupCount = 1;
   	var data = $("#estDetails").serialize();
   	var resData = doAjaxCall('estimation?savePanalEntryInSession', 'post', data, false, 'json');
   	var res = JSON.parse(resData);
   	var w = "w"
   	var panelKey = res.panelKey;
   	$("#tempEstimationPopUp").empty();
   	$("#tempEstimationPopUp").html('');
   	$( "#estDetails" ).remove();
   	
   	
   	$('#mainEstTbl').dataTable().fnAddData( [
   		'<td id="panelKey'+panelKey+'">'+res.panelKey+'</td>',
   		'<td id="description'+panelKey+'">'+res.description+'</td>',
   		'<td id="qty'+panelKey+'">'+res.qty+'</td>',
		'<td id="unitRate'+panelKey+'">'+res.unitRate+'</td>',
		'<td id="total'+panelKey+'">'+res.total+'</td>',
		'<td id="hight'+panelKey+'">'+res.hight+'</td>',
		'<td id="width'+panelKey+'">'+res.width+'</td>',
		'<td id="defth'+panelKey+'">'+res.defth+'</td>',
	    "<td><img src='images/tick.png' height='35' width='30'onclick='getPanelDetails("+res.panelKey+','+'"'+'w'+'"'+")'></td>",
	    "<td><img src='images/tick.png' height='35' width='30' onclick='getPanelSpecDetails("+res.panelKey+")'></td>" ,
	    "<td><i class='fa fa-trash fa-4' ></i></td>"
	    ] );
	
   	/*
   	
   	$("#mainEstTbl tbody").append(
   		  '<tr role="row">' +
   	   		'<td id="panelKey'+panelKey+'">'+res.panelKey+'</td>' +
   			'<td id="description'+panelKey+'">'+res.description+'</td>' +
   			'<td id="qty'+panelKey+'">'+res.qty+'</td>' +
   			'<td id="unitRate'+panelKey+'">'+res.unitRate+'</td>' +
   			'<td id="total'+panelKey+'">'+res.total+'</td>' +
   			'<td id="hight'+panelKey+'">'+res.hight+'</td>' +
   			'<td id="width'+panelKey+'">'+res.width+'</td>' +
   			'<td id="defth'+panelKey+'">'+res.defth+'</td>' +
   	        "<td><img src='images/tick.png' height='35' width='30'onclick='getPanelDetails("+res.panelKey+','+'"'+'w'+'"'+")'></td>" +
   	        "<td><img src='images/tick.png' height='35' width='30' onclick='getPanelSpecDetails("+res.panelKey+")'></td>" +
   	      "</tr>"
   	  );*/
   	
   	document.getElementById('estDetails').reset();

   	
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
   
 
	function repeatitem(id){
		var idsplit = id.split("_");
		itemcount = idsplit[1];
		console.log(itemcount);
		elemnt='<tr id="itemlist_'+(parseInt(itemcount)+1)+'">'+
			'<td>ADDITIONAL ITEM '+(parseInt(itemcount)+1)+'<img src="images/plus.png"  onclick="repeatitem(\'itemlist_'+(parseInt(itemcount)+1)+'\')" height="35" width="35"></img>'+
			'<img src="images/minus.png" onclick="this.parentElement.parentElement.remove();" height="35" width="35"></img></td>'+
			'<td></td>'+
			'<td><input type="text" name="panelAdditionalComponents['+(parseInt(itemcount)+7)+'].rate"  id="additionalItem'+(parseInt(itemcount)+1)+'Rate" onchange="additionalOnchange(this,'+(parseInt(itemcount)+1)+')" /></td>'+
			'<td><input type="text" name="panelAdditionalComponents['+(parseInt(itemcount)+7)+'].cost" id="additionalItem'+(parseInt(itemcount)+1)+'Cost" class="calTotCompCost"/></td>'+
		'</tr>';
		$("#"+id).after(elemnt);
	}
	
	
	function repeatEstimation(){
		pdcount++;
		groupCount++;
		var randomnumber= Math.floor((Math.random() * 10000) + 1);

		var grpID ="groupName"+groupCount;

			element='<div class="table_box"><table width="200" id="table_'+randomnumber+'" border="1">'+
			'<tr>'+
				'<th colspan="3">'+
				'<select name="panelDetailses['+pdcount+'].typeOfFeeder"><option >Select IO/OG</option><option value="incomer">incomer</option>'+
				'<option value="Out going">Out going</option></select>'+
				'</th>'+
				'<th colspan="10">'+
				'<input type="text" name="panelDetailses['+pdcount+'].feederSubtype" style="color: #000000;" />'+
				'<img src="images/plus.png" height="35" width="35" onclick="repeatEstimation()"></img>'+
				'<img src="images/minus.png" height="35" width="35" onclick="this.parentElement.parentElement.parentElement.parentElement.remove()"></img></th>'+
			'</tr>'+
			'<tr>'+
				'<th scope="col">Description</th>'+
				'<th scope="col">QTY</th>'+
				'<th scope="col">Type</th>'+
				'<th scope="col">Make</th>'+
				'<th scope="col">List Price</th>'+
				'<th scope="col">Dis Price</th>'+
				'<th scope="col">Unit Rate</th>'+
				'<th scope="col">Total</th>'+
				'<th scope="col">Labor</th>'+
				'<th scope="col"></th>'+
			'</tr>'+
			'<tr>'+ 
				'<td>'+
				'<input type="hidden" value="'+grpID+'" name="panelDetailses['+pdcount+'].groupName">'+
				'<input type="text" name="panelDetailses['+pdcount+'].description" id="panelDetailes'+pdcount+'description" size="7"></td>'+
				'<td><input type="text" name="panelDetailses['+pdcount+'].quntity" id="panelDetailes'+pdcount+'quntity" onchange="panelDetailesTotal('+pdcount+')" size="7"></td>'+
				'<td><input type="text" name="panelDetailses['+pdcount+'].type" size="7"></td>'+
				'<td><input type="text" name="panelDetailses['+pdcount+'].make" size="7"></td>'+
				'<td><input type="text" name="panelDetailses['+pdcount+'].listPrice" id="panelDetailes'+pdcount+'listPrice" onchange="panelDetailesTotal('+pdcount+')" size="7"></td>'+
				'<td><input type="text" name="panelDetailses['+pdcount+'].discount" id="panelDetailes'+pdcount+'discount" onchange="panelDetailesTotal('+pdcount+')" size="7"></td>'+
				'<td><input type="text" name="panelDetailses['+pdcount+'].discountPrice" id="panelDetailes'+pdcount+'discountPrice" size="7"></td>'+
				'<td><input type="text" name="panelDetailses['+pdcount+'].unitRate" id="panelDetailes'+pdcount+'unitRate" size="7"></td>'+
				'<td><input type="text" name="panelDetailses['+pdcount+'].total" id="panelDetailes'+pdcount+'total" class="caltotalEbon" size="7"></td>'+
				'<td><img src="images/plus.png" height="35" width="35" onclick="repeatrow(\'table_'+randomnumber+'\',\''+grpID+'\')"></img>'+
				'<img src="images/minus.png" height="35" width="35" onclick="this.parentElement.parentElement.remove();"></img></td>'+
			'</tr>'+
		'</table></div>';
		$("#append_table").append(element);
	}
	
	 

	function repeatrow(id,grpID){
		alert(id);
		pdcount++;
		console.log("#"+id);
		element=""+
		'<tr>'+
		'<td>'+
		'<input type="hidden" value="'+grpID+'" name="panelDetailses['+pdcount+'].groupName">'+
		'<input type="text" name="panelDetailses['+pdcount+'].description" id="panelDetailes'+pdcount+'description" size="7"></td>'+
		'<td><input type="text" name="panelDetailses['+pdcount+'].quntity" id="panelDetailes'+pdcount+'quntity" onchange="panelDetailesTotal('+pdcount+')" size="7"></td>'+
		'<td><input type="text" name="panelDetailses['+pdcount+'].type" id="panelDetailes'+pdcount+'type" size="7"></td>'+
		'<td><input type="text" name="panelDetailses['+pdcount+'].make" id="panelDetailes'+pdcount+'make" size="7"></td>'+
		'<td><input type="text" name="panelDetailses['+pdcount+'].listPrice" id="panelDetailes'+pdcount+'listPrice" onchange="panelDetailesTotal('+pdcount+')" size="7"></td>'+
		'<td><input type="text" name="panelDetailses['+pdcount+'].discount" id="panelDetailes'+pdcount+'discount" onchange="panelDetailesTotal('+pdcount+')" size="7"></td>'+
		'<td><input type="text" name="panelDetailses['+pdcount+'].discountPrice" id="panelDetailes'+pdcount+'discountPrice" size="7"></td>'+
		'<td><input type="text" name="panelDetailses['+pdcount+'].unitRate" id="panelDetailes'+pdcount+'unitRate" size="7"></td>'+
		'<td><input type="text" name="panelDetailses['+pdcount+'].total" id="panelDetailes'+pdcount+'total" class="caltotalEbon" size="7"></td>'+
			'<td><img src="images/plus.png" height="35" width="35" ></img>'+
			'<img src="images/minus.png" height="35" width="35" onclick="this.parentElement.parentElement.remove();"></img></td>'+
		'</tr>';
		$("#"+id).append(element);
	}
	
	
	function removeMainTemplate(x,groupName){
		groupCount--;
		x.parentElement.parentElement.parentElement.parentElement.remove();
		panalDetailsDelGroups += groupName +',';
		alert('removing Main Template');
		
		 calEbonPrize();
		 calTotCompCost();
		 callaborCost();
		 caloverHeadCost();
		 calculateRemainingAmt();
		
	}	
	
	 function getEstimation(){
		$("#popup2").show();
	 }
     
    
   
 function panelDetailesTotal(y){
	 
	 var quntity = ($('#panelDetailes'+y+'quntity').val()!='' ? parseFloat($('#panelDetailes'+y+'quntity').val()) : 0);
	 var listPrice =  ($('#panelDetailes'+y+'listPrice').val()!='' ? parseFloat($('#panelDetailes'+y+'listPrice').val()) : 0);
	 var discount = ($('#panelDetailes'+y+'discount').val()!='' ? parseFloat($('#panelDetailes'+y+'discount').val()) : 0);
	 
	 var discountPrice = (listPrice*discount)/100;
	 discountPrice = parseFloat(discountPrice).toFixed(2);
	 $('#panelDetailes'+y+'discountPrice').val(discountPrice);
	 
	 var unitRate = listPrice - discountPrice;
	 unitRate = parseFloat(unitRate).toFixed(2);
	 $('#panelDetailes'+y+'unitRate').val(unitRate);
	 
	 var total = unitRate * quntity;
	 if(total==0){
		 $('#panelDetailes'+y+'total').val(0);
	 }else{
		 total = parseFloat(total).toFixed(2);
	 $('#panelDetailes'+y+'total').val(total);
	 }
	 
	 calEbonPrize();
	 calTotCompCost()

	 callaborCost();
	 caloverHeadCost();
	 calculateRemainingAmt();
	 
 }
   
   
 	function calculateRemainingAmt(){

		var factoryCost = ($("#factoryCost").val() != '' ? $("#factoryCost").val() : 0 );
		
		var miscellaneousCostPercentage = ($("#miscellaneousCostPercentage").val() != '' ? $("#miscellaneousCostPercentage").val() : 0 );
		var miscellaneousCost = parseFloat((factoryCost * miscellaneousCostPercentage )/100).toFixed(2);
		
		var marginPersentage = ($("#marginPersentage").val() != '' ? $("#marginPersentage").val() : 0 );
		var marginCost = parseFloat((factoryCost * marginPersentage )/100).toFixed(2);
	 
		var transportCost = parseFloat(($("#transportCost").val() != '' ? $("#transportCost").val() : 0 )).toFixed(2);
		var woodenCratePakagingCost = parseFloat(($("#woodenCratePakagingCost").val() != '' ? $("#woodenCratePakagingCost").val() : 0 )).toFixed(2);
		
		var netTotal =  Number(factoryCost) + Number(miscellaneousCost) + Number(marginCost) + Number(transportCost) + Number(woodenCratePakagingCost);
		var grandRounedTotal = Math.round(netTotal);
		var negotiatedPrice = grandRounedTotal;


		$("#miscellaneousCost").val(miscellaneousCost);
		$("#marginCost").val(marginCost);
		$("#transportCost").val(transportCost);
		$("#woodenCratePakagingCost").val(woodenCratePakagingCost);
		$("#netTotal").val(netTotal);
		$("#grandRounedTotal").val(grandRounedTotal);
		$("#negotiatedPrice").val(negotiatedPrice);
		 
		 }
 																				
   
	 function createNewExtimation(projectId){
	
			var data = 'projectId='+ projectId;
			$("#formContent").empty();
			var resData = doAjaxCall('estimation?createEstimationTemplate', 'post', data, false, 'json');
			$("#formContent").html(resData); 
			
			}
	 
	 function openReadOrWriteView(projectId, viewType){
		 
		   panalDetailsDelIDs    = '';
		   panalDetailsDelGroups = '';
			
 		 var data= {
	 				 	projectId: projectId,
	 				 	viewType : viewType
					};
		 
			$("#formContent").empty();
			var resData = doAjaxCall('estimation?viewEstimation', 'post', data, false, 'json');
			$("#formContent").html(resData); 
		 
	 }
 
	 
	 //estimation final save 
		 function saveFinalEstimation(){
			 
			 alert("saveFinalEstimation..........");
			 var data = $("#newEstimation").serialize();
			 var resData = doAjaxCall('estimation?save', 'post', data, false, 'json');
			 	 
			 alert(resData);
		 }
	 
	 
	 
	    function searchEstimationForClone(){


	    	var enquiryNumber = $("#enquiryNumber").val();
	    	var projectName = $("#projectName").val();
	    	
	    	var data= {	enquiryNumber: enquiryNumber,
	    				projectName : projectName
						};
	    	
	    	
			var resData = doAjaxCall('estimation?getDataForEstClone', 'post', data, false, 'json');
            var res = JSON.parse(resData);
            //list => projectId projectName isEstimationCreated uniqueIdentity enquiryNumber

            $("#sourceProjectName").html('');
            $("#destinationProjectName").html('');

			var sourceDropdown='<option value="0">Check available Projects </option>';
            var targetDropdown='<option value="0">Check target Projects</option>';

					for (i = 0; i < res.length; i++) {

						if(res[i][2]){
                            sourceDropdown += '<option value='+res[i][0]+'> '+res[i][1]+'</option>';
						}else{
                            targetDropdown += '<option value='+res[i][0]+'> '+res[i][1]+'</option>';
						}

					}

            		$("#sourceProjectName").append(sourceDropdown);
            		$("#destinationProjectName").append(targetDropdown);


	        }


			function doEstimationCloning() {

	    		var sID=$("#sourceProjectName").val();
	    		var dID=$("#destinationProjectName").val();
				var data= {sourceID: sID,
						destinationId : dID
				};

				var resData = doAjaxCall('estimation?doEstimationCloning', 'post', data, false, 'json');
				clearEnquiry();
			}
	 
			
			
			function getPanelSpecDetails(panelKey){
				$("#tempEstimationSpecPopUp").empty();
				$("#tempEstimationSpecPopUp").html('');

				var data = 'panelKey='+ panelKey;
				var resData = doAjaxCall('estimation?estimationDetailsSpecPopup', 'post', data, false, 'json');
				$("#tempEstimationSpecPopUp").append(resData);
				window.location = "#popup1";
				 }
				 
				function updateEstimationSpecDetails(){
				var panelId = $("#panelId").val();
				    var data = $("#estDetailsSpecUpdate").serialize();
				    var resData = doAjaxCall('estimation?estSpecIncoming', 'post', data, false, 'json');
				    var res = JSON.parse(resData);
				    $("#tempEstimationSpecPopUp").empty();
				    $("#tempEstimationSpecPopUp").html('');
				    $( "#estDetailsSpecUpdate" ).remove();
				}

				 function closeUpadateSpecPopUp(){
				$("#tempEstimationSpecPopUp").empty();
				$("#tempEstimationSpecPopUp").html('');
				  $( "#estDetailsSpecUpdate" ).remove();
				}
			
			
				 
				 function removePanalDetails(x,panalId){
					 
					 x.parentElement.parentElement.remove();
					 panalDetailsDelIDs += panalId+',';
					 calEbonPrize();
					 calTotCompCost();
					 callaborCost();
					 caloverHeadCost();
					 calculateRemainingAmt();
					 
				 }
			
			
				 function getPanelDelete(x,panalId){
					 	panalDelIDs    += panalId+'';
						 $(x).closest('tr').remove(); 
					}
				 
				 
				 
				 
				 
				 
