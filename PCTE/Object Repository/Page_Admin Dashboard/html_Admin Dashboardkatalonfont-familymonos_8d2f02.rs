<?xml version="1.0" encoding="UTF-8"?>
<WebElementEntity>
   <description></description>
   <name>html_Admin Dashboardkatalonfont-familymonos_8d2f02</name>
   <tag></tag>
   <elementGuidId>68cef7a2-20c6-459d-ad4d-867883d17037</elementGuidId>
   <selectorCollection>
      <entry>
         <key>CSS</key>
         <value>html.no-js</value>
      </entry>
      <entry>
         <key>XPATH</key>
         <value>//*/text()[normalize-space(.)='']/parent::*</value>
      </entry>
   </selectorCollection>
   <selectorMethod>XPATH</selectorMethod>
   <useRalativeImagePath>true</useRalativeImagePath>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>tag</name>
      <type>Main</type>
      <value>html</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>lang</name>
      <type>Main</type>
      <value>en</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>no-js</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>
	
	
	
	
	
	
	
	Admin Dashboard

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
#katalon{font-family:monospace;font-size:13px;background-color:rgba(0,0,0,.7);position:fixed;top:0;left:0;right:0;display:block;z-index:999999999;line-height: normal} #katalon div{padding:0;margin:0;color:#fff;} #katalon kbd{display:inline-block;padding:3px 5px;font:13px Consolas,&quot;Liberation Mono&quot;,Menlo,Courier,monospace;line-height:10px;color:#555;vertical-align:middle;background-color:#fcfcfc;border:1px solid #ccc;border-bottom-color:#bbb;border-radius:3px;box-shadow:inset 0 -1px 0 #bbb;font-weight: bold} div#katalon-spy_elementInfoDiv {color: lightblue; padding: 0px 5px 5px} div#katalon-spy_instructionDiv {padding: 5px 5px 2.5px}



  PCTE
		
		
			
			
				 Account 
				
          Documentation
					Change Password
					Logout
				
			
		
	

	
	
			
			
				Main
				 Dashboard
			
			 Userlist
			
			  Profile
			
			  Deleted Users
			
      	  Notifications
				
			
			
		

				
			

				
					

						Dashboard
						
						
							
								
									
										
											
												
													3
													Total Users
												
											
											Full Detail 
										
									
									
										
											
												


																									0
													Deleted Users
												
											
											Full Detail   
										
									
							
								
							
						
					
				












			
		
	

	
	
	
	
	
	
	
	
	
	
	
	
		
	window.onload = function(){
    
		// Line chart from swirlData for dashReport
		var ctx = document.getElementById(&quot;dashReport&quot;).getContext(&quot;2d&quot;);
		window.myLine = new Chart(ctx).Line(swirlData, {
			responsive: true,
			scaleShowVerticalLines: false,
			scaleBeginAtZero : true,
			multiTooltipTemplate: &quot;&lt;%if (label){%>&lt;%=label%>: &lt;%}%>&lt;%= value %>&quot;,
		}); 
		
		// Pie Chart from doughutData
		var doctx = document.getElementById(&quot;chart-area3&quot;).getContext(&quot;2d&quot;);
		window.myDoughnut = new Chart(doctx).Pie(doughnutData, {responsive : true});

		// Dougnut Chart from doughnutData
		var doctx = document.getElementById(&quot;chart-area4&quot;).getContext(&quot;2d&quot;);
		window.myDoughnut = new Chart(doctx).Doughnut(doughnutData, {responsive : true});

	}
	


/html[@class=&quot;no-js&quot;]</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath</name>
      <type>Main</type>
      <value>/html[@class=&quot;no-js&quot;]</value>
   </webElementProperties>
   <webElementXpaths>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:neighbor</name>
      <type>Main</type>
      <value>//*/text()[normalize-space(.)='']/parent::*</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:position</name>
      <type>Main</type>
      <value>//html</value>
   </webElementXpaths>
</WebElementEntity>
