$(window).load(function() {
    $(".loader").fadeOut("slow");
});

$(document).ready(function(e){
	var theme = 'ui-start';
	$('#InchargeWelcome').addClass("active");
	//$("#breadcrumb-ol").append("<li class='breadcrumb-item'><a href='#'>Home</a></li>");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> Dashboard</a></li>");
	
	var d = new Date();
	var curYear = d.getFullYear();
	var curMonth = d.getMonth();
	
	var yearData = [];
	var lpdData = [];
	var noOfFarmerData = [];
	var fatData = [];
	var snfData = [];
	
	
	var yearFeedData = [];
	var yearFeedQtyData = [];
	
	$.ajax({
		type : "POST",
		url : "getMilkLiability",
		
		success : function(response) {
										//	alert("resp.."+response);

			var json_obj = $.parseJSON(response);

			

			
			$.each(json_obj, function(index, items) {
				//alert("i.."+index);
				//	alert("items.."+items)
				$.each(items, function(index, item) {
					
					//console.log("item.inputDate.."+item.inputDate);
					
		
					yearData.push(''+item.inputDate+'');
					lpdData.push(''+item.lpd+'');
					noOfFarmerData.push(''+item.nop+'');
					fatData.push(item.fatPer);
					snfData.push(''+item.snfPer+'');


				


					
				})
			})
		//	console.log("yearData...before."+yearData+".lpdData."+lpdData+"..noOfFarmerData.."+noOfFarmerData+"..fatData.."+fatData+".snfData."+snfData);
			// Bar chart
			new Chart(document.getElementById("avg-lpd-bar-chart"), {
			    type: 'bar',
			    data: {
			     // labels: ["Jan-2017", "Feb-2017", "Mar-2017", "Apr-2017", "May-2017", "Jun-2017", "Jul-2017", "Aug-2017", "Sep-2017", "Oct-2017", "Nov-2017", "Dec-2017"],
			    	labels:yearData,
			    	datasets: [
			        {
			          label: "",
			          backgroundColor: ["#9c0bb5", "#9c0bb5","#9c0bb5","#9c0bb5","#9c0bb5","#9c0bb5","#9c0bb5","#9c0bb5","#9c0bb5","#9c0bb5","#9c0bb5","#9c0bb5"],
			        //  data: [222,190,162,145,157,181,238,341,364,404]
			          
			          data:  lpdData
			        }
			      ]
			    },
			    options: {
		    		"hover": {
		        	"animationDuration": 0
		        },
		        "animation": {
		        	"duration": 2000,
								"onComplete": function () {
									var chartInstance = this.chart,
										ctx = chartInstance.ctx;
									
									ctx.font = Chart.helpers.fontString(Chart.defaults.global.defaultFontSize, Chart.defaults.global.defaultFontStyle, Chart.defaults.global.defaultFontFamily);
									ctx.textAlign = 'center';
									ctx.textBaseline = 'bottom';

									this.data.datasets.forEach(function (dataset, i) {
										var meta = chartInstance.controller.getDatasetMeta(i);
										meta.data.forEach(function (bar, index) {
											var data = dataset.data[index];                            
											ctx.fillText(data, bar._model.x, bar._model.y - 5);
										});
									});
								}
		        },
		    		legend: {
		        	"display": false
		        },
		        tooltips: {
		        	"enabled": false
		         },
		        scales: {
		            yAxes: [{
		            		display: true,
		            		gridLines: {
		                	display : true
		                },
		                ticks: {
		                		display: true,
		                    beginAtZero:true
		                }
		            }],
		            xAxes: [{
		            		gridLines: {
		                	display : false
		                },
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
			});
			
			
			new Chart(document.getElementById("no-of-farmers-bar-chart"), {
			    type: 'bar',
			    data: {
			     // labels: ["Jan-2017", "Feb-2017", "Mar-2017", "Apr-2017", "May-2017", "Jun-2017", "Jul-2017", "Aug-2017", "Sep-2017", "Oct-2017", "Nov-2017", "Dec-2017"],
			    	labels:yearData,
			    	datasets: [
			        {
			          label: "",
			          backgroundColor: ["#00897b", "#00897b","#00897b","#00897b","#00897b","#00897b","#00897b","#00897b","#00897b","#00897b","#00897b","#00897b"],
			        //  data: [83,75,68,59,59,58,65,73,73,70]
			          data:  noOfFarmerData
			        }
			      ]
			    },
			    options: {
		    		"hover": {
		        	"animationDuration": 0
		        },
		        "animation": {
		        	"duration": 2000,
								"onComplete": function () {
									var chartInstance = this.chart,
										ctx = chartInstance.ctx;
									
									ctx.font = Chart.helpers.fontString(Chart.defaults.global.defaultFontSize, Chart.defaults.global.defaultFontStyle, Chart.defaults.global.defaultFontFamily);
									ctx.textAlign = 'center';
									ctx.textBaseline = 'bottom';

									this.data.datasets.forEach(function (dataset, i) {
										var meta = chartInstance.controller.getDatasetMeta(i);
										meta.data.forEach(function (bar, index) {
											var data = dataset.data[index];                            
											ctx.fillText(data, bar._model.x, bar._model.y - 5);
										});
									});
								}
		        },
		    		legend: {
		        	"display": false
		        },
		        tooltips: {
		        	"enabled": false
		         },
		        scales: {
		            yAxes: [{
		            		display: true,
		            		gridLines: {
		                	display : true
		                },
		                ticks: {
		                		display: true,
		                    beginAtZero:true
		                }
		            }],
		            xAxes: [{
		            		gridLines: {
		                	display : false
		                },
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
			});
			
			
			
			var ctx = document.getElementById("fat-snf-bar-chart").getContext("2d");

			var data = {
					// labels: ["Jan-17", "Feb-17", "Mar-17", "Apr-17", "May-17", "Jun-17", "Jul-17", "Aug-17", "Sep-17", "Oct-17", "Nov-17", "Dec-17"],
					labels:yearData,
					datasets: [{
			    label: "Fat %",
			    backgroundColor: "#1f5ae4",
			   // data: [5.06, 4.98, 4.74,4.60,4.32,4.06,4.23,4.35,4.44,4.60]
					 data:fatData
					
			  }, {
			    label: "SNF %",
			    backgroundColor: "#C62828",
			    data: snfData
			 //   data: [8.27,8.28,8.21,8.22,8.26,8.31,8.35,8.41,8.35,8.30]
			  }, ]
			};

			var myBarChart = new Chart(ctx, {
			  type: 'bar',
			  data: data,
			    options: {
		    		"hover": {
		        	"animationDuration": 0
		        },
		        "animation": {
		        	"duration": 2000,
								"onComplete": function () {
									var chartInstance = this.chart,
										ctx = chartInstance.ctx;
									
									ctx.font = Chart.helpers.fontString(Chart.defaults.global.defaultFontSize, Chart.defaults.global.defaultFontStyle, Chart.defaults.global.defaultFontFamily);
									ctx.textAlign = 'center';
									ctx.textBaseline = 'bottom';

									this.data.datasets.forEach(function (dataset, i) {
										var meta = chartInstance.controller.getDatasetMeta(i);
										meta.data.forEach(function (bar, index) {
											var data = dataset.data[index];                            
											ctx.fillText(data, bar._model.x, bar._model.y - 5);
										});
									});
								}
		        },
		    		legend: {
		        	"display": true
		        },
		        tooltips: {
		        	"enabled": false
		         },
		        scales: {
		            yAxes: [{
		            		display: true,
		            		gridLines: {
		                	display : true
		                },
		                ticks: {
		                		display: true,
		                    beginAtZero:true
		                }
		            }],
		            xAxes: [{
		            		gridLines: {
		                	display : false
		                },
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
//			  options: {
//			    barValueSpacing: 20,
//			    scales: {
//			      yAxes: [{
//			        ticks: {
//			          min: 0,
//			        }
//			      }]
//			    }
//			  }
			});
			
			
			
			
			
			
			$.ajax({
				type : "POST",
				url : "getFeedQty",
				
				success : function(response) {
												//	alert("resp.."+response);

					var json_obj = $.parseJSON(response);

					

					
					$.each(json_obj, function(index, items) {

						$.each(items, function(index, item) {

							yearFeedData.push(''+item.inputDate+'');
							yearFeedQtyData.push(''+item.sumOfFeed+'');
							


						


							
						})
					})
			
					// Bar chart
					new Chart(document.getElementById("feed-kgs-bar-chart"), {
					    type: 'bar',
					    data: {
					     // labels: ["Jan-2017", "Feb-2017", "Mar-2017", "Apr-2017", "May-2017", "Jun-2017", "Jul-2017", "Aug-2017", "Sep-2017", "Oct-2017", "Nov-2017", "Dec-2017"],
					    	labels:yearFeedData,
					    	datasets: [
					        {
					          label: "",
					          backgroundColor: ["#E65100", "#E65100","#E65100","#E65100","#E65100","#E65100","#E65100","#E65100","#E65100","#E65100","#E65100","#E65100"],
					        //  data: [222,190,162,145,157,181,238,341,364,404]
					          
					          data:  yearFeedQtyData
					        }
					      ]
					    },
					    options: {
				    		"hover": {
				        	"animationDuration": 0
				        },
				        "animation": {
				        	"duration": 2000,
										"onComplete": function () {
											var chartInstance = this.chart,
												ctx = chartInstance.ctx;
											
											ctx.font = Chart.helpers.fontString(Chart.defaults.global.defaultFontSize, Chart.defaults.global.defaultFontStyle, Chart.defaults.global.defaultFontFamily);
											ctx.textAlign = 'center';
											ctx.textBaseline = 'bottom';

											this.data.datasets.forEach(function (dataset, i) {
												var meta = chartInstance.controller.getDatasetMeta(i);
												meta.data.forEach(function (bar, index) {
													var data = dataset.data[index];                            
													ctx.fillText(data, bar._model.x, bar._model.y - 5);
												});
											});
										}
				        },
				    		legend: {
				        	"display": false
				        },
				        tooltips: {
				        	"enabled": false
				         },
				        scales: {
				            yAxes: [{
				            		display: true,
				            		gridLines: {
				                	display : true
				                },
				                ticks: {
				                		display: true,
				                    beginAtZero:true
				                }
				            }],
				            xAxes: [{
				            		gridLines: {
				                	display : false
				                },
				                ticks: {
				                    beginAtZero:true
				                }
				            }]
				        }
				    }
					});
					
							
					
					
			

			

				},
				dataType : "html"
			});
			
			
			

		},
		dataType : "html"
	});
	
	

	
	
	
	
	
	
	
	

});