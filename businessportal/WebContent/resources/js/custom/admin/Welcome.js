$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var financialYear=$("#financialYear_hidden").val();
//	$('#targetChartOption').jqxDropDownList({width:'100px',height:'20',theme:theme});
	var userNameSource = {
			datatype : "json",
			datafields : [ 
			    {name : 'financialYear',type : 'string'}
			    ],
			url : "getFinancialYears",
			async:false
		};
	var userNameAdapter = new $.jqx.dataAdapter(userNameSource);
	$("#targetChartOption").jqxDropDownList({source: userNameAdapter, displayMember: 'financialYear',valueMember: 'financialYear', width: '100%', height: 20, theme: theme});
	$("#targetChartOption").val(financialYear);
	
	var targetChartSource = {
			datatype : "json",
			datafields : [ 
			    {name : 'targetMonth',type : 'string'},
			    {name : 'targetAchieved',type : 'int'}
			    ],
			url : "getTargetAchievedReport?financialYear="+financialYear,
			async:false
		};
    	var targetChartAdapter = new $.jqx.dataAdapter(targetChartSource);
    	$('#targetAchievedChart').jqxChart({source: targetChartAdapter});
    	
	// prepare jqxChart settings
    var settings = {
        title: "Target Achieved Chart",
        description: "",
        source: targetChartAdapter,
        showLegend: true,
        enableAnimations: true,
        padding: { left: 20, top: 5, right: 20, bottom: 5 },
        titlePadding: { left: 90, top: 0, right: 0, bottom: 10 },
        categoryAxis:
            {
                dataField: 'targetMonth',
                //showGridLines: true,
                flip: false
            },
        colorScheme: 'scheme02',
        seriesGroups:
            [
                {
                    type: 'column',
                    orientation: 'vertical',
                    columnsGapPercent: 100,
                    //toolTipFormatSettings: { thousandsSeparator: ',' },
                    valueAxis:
                    {
                        flip: false,
                        minValue: 0,
                        //unitInterval: 100000,
                        //maxValue: 1000000,
                        displayValueAxis: true,
                        description: '',
                        /*formatFunction: function (value) {
                            return parseInt(value / 1000000);
                        }*/
                    },
                    series: [
                            { dataField: 'targetAchieved', displayText: 'Target Achieved', labels: true }
                        ]
                }
            ]
    };
    // setup the chart
    $('#targetAchievedChart').jqxChart(settings);
    
    
    $("#targetChartOption").on('change',function(event){
    	 var args=event.args;
		 var index=args.index;
		 var item = args.item;
		 var financialYear=item.value;
		 var targetChartSource = {
					datatype : "json",
					datafields : [ 
					    {name : 'targetMonth',type : 'string'},
					    {name : 'targetAchieved',type : 'int'}
					    ],
					url : "getTargetAchievedReport?financialYear="+financialYear,
					async:false
				};
		    	var targetChartAdapter = new $.jqx.dataAdapter(targetChartSource);
		    	$('#targetAchievedChart').jqxChart({source: targetChartAdapter});
    })
});