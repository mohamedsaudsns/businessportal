$(document).ready(function(e){	
	var theme = 'ui-start';
	var buttontheme='orange';
	$('#userID').jqxInput({width:'100%',theme:theme,height:25});
	$('#userName').jqxInput({width: 250,theme:theme,height:25});
	$('#address').jqxInput({width:250,theme:theme,height:25});
	$('#mobileNo').jqxInput({width:'100%',theme:theme,height:25});
	$('#emailID').jqxInput({width:250,theme:theme,height:25});
	var statusType = [{"statusID": "A", "statusName": "Active"}, {"statusID": "X", "statusName": "Inactive"}];
	$('#userStatus').jqxDropDownList({source: statusType,width:'100%',theme:theme,selectedIndex:-1,height:25});
	//$('#userHead').jqxDropDownList({width: 250,theme:theme,selectedIndex:-1,height:25});
	
	var userTypeSource = {
			datatype : "json",
			datafields : [ 
			    {name : 'userTypeID',type : 'int'},
			    {name : 'userTypeName',type : 'string'}
			    ],
			url : "getUserTypes"
		};
	var userTypeAdapter = new $.jqx.dataAdapter(userTypeSource);
	$('#userType').jqxDropDownList({source: userTypeAdapter,width:'100%',theme:theme,selectedIndex:-1,height:25, displayMember: 'userTypeName',valueMember: 'userTypeID'});
	
	var userMasterSource = {
			datatype : "json",
			datafields : [ 
			    {name : 'userId',type : 'int'},
			    {name : 'userName',type : 'string'},
			    {name : 'companyName',type : 'string'},
			    {name : 'emailId',type : 'string'},
			    {name : 'mobileNo',type : 'string'},
			    {name : 'userTypeId',type : 'int'},
			    {name : 'userTypeName',type : 'string'},
			    {name : 'address',type : 'string'},
			    {name : 'status',type : 'string'}
			    ],
			url : "getUserMasterDetails"
		};
	var userMasterAdapter = new $.jqx.dataAdapter(userMasterSource);
	var imagerenderer = function (row, datafield, value) {
		if(value=="A"){
			return '<center><div style="margin-top: 3px;" class="btn btn-success btn-xs"><i class="fa fa-unlock fa-1x"></i></div></center>';
		}else{
			return '<center><div style="margin-top: 3px;" class="btn btn-danger btn-xs"><i class="fa fa-lock fa-1x"></i></div><center>';
		}
     }
	$('#userType').jqxDropDownList({source: userTypeAdapter,width:'100%',theme:theme,selectedIndex:-1,height:25, displayMember: 'userTypeName',valueMember: 'userTypeID'});
	
	$('#userMasterGrid').jqxGrid({
		width:'100%',
		height:'380',
		theme:theme,
		source: userMasterAdapter,
		filterable: true,
	    autoshowfiltericon: true,
	    sortable: true,
	    altrows: true,
	    columnsresize: true,
	    enabletooltips: true,
	    enablebrowserselection: true,
        showtoolbar: true,
	    toolbarheight: 30,
		columns:[
		         {text:'User ID',datafield:'userId',width:'10%'},
		         {text:'User Name',datafield:'userName',width:'20%'},
		         {text:'Company',datafield:'companyName',width:'10%'},
		         {text:'User Type',datafield:'userTypeName', width:'10%'},
		         {text:'Email',datafield:'emailId',width:'15%'},
		         {text:'Mobile',datafield:'mobileNo',width:'10%'},
		         {text:'Address',datafield:'address',width:'15%'},
		         {text:'Status',datafield:'status',cellsrenderer: imagerenderer,cellsalign: 'center',width:'10%'}
		],
		rendertoolbar: function(toolbar) {
            var container = $("<div style='margin: 2px;'></div>");
            var editButton = $("<button id='editBtn' style='width: 60px;height:25px;' class='btn btn-warning btn-sm'><i class='fa fa-pencil'  aria-hidden='true'></i>&nbsp;Edit</button>");
            toolbar.append(container);
            container.append(editButton);
            editButton.click(function(){
            	/*var selectedrowindex = $("#userMasterGrid").jqxGrid('getselectedrowindex');
            	if(selectedrowindex=="-1"){
            		alert("Please select a row");
            		return false;
            	}
        		$('#userViewDiv').css('display','none');
        		$('#userCreateDiv').css('display','block');
            	var rowData= $("#userMasterGrid").jqxGrid('getrowdata',selectedrowindex);
            	$("#userID").val(rowData.userId);
            	$("#userName").val(rowData.userName);
            	$("#userType").val(rowData.userTypeId);
            	$("#address").val(rowData.address);
            	$("#emailID").val(rowData.emailId);
            	$("#mobileNo").val(rowData.mobileNo);*/
            	//$("#userStatus").val(rowData.status);
            })
		}
	});
	
	
	$('#saveBtn').on("click",function(e){
		var userID=$("#userID").val();
		var userName=$("#userName").val();
		var userType=$("#userType").val();
		var address=$("#address").val();
		var mobileNo=$("#mobileNo").val();
		var emailID=$("#emailID").val();
		var userStatus=$("#userStatus").val();
		var address=$("#address").val();
		if(userName.length===0){
			$("#messageSuccess").html("Please enter user name");
			return false;
		}
		$.ajax({
			type: "GET",
			url: "updateUserMaster",
			data: "userId="+userID+"&userName="+userName+"&emailId="+emailId+"&mobileNo="+mobileNo+"&address="+address+"&status="+status,
			success: function(response){
				if(response=="S"){
					alert("User details updated successfully");
					$('#userMasterGrid').jqxGrid('updatebounddata');
					clearAllValues();
					$('#userViewDiv').css('display','block');
					$('#userCreateDiv').css('display','none');
				}
			}
		})
	});
	
	$('#clearBtn').on("click",function(e){
		clearAllValues();
	});
	
});

function clearAllValues(){
	$('#userID').val("");
	$('#userName').val("");
	$('#userType').jqxDropDownListval({selectedIndex: -1});
	$('#mobileNo').val("");
	$('#address').val("");
}