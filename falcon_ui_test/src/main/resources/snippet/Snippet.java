package snippet;

public class Snippet {
	<?xml version="1.0" encoding="UTF-8"?>
	<extentreports>
	    <configuration>
	        <!-- report theme -->
	        <!-- standard, dark -->
	        <theme>standard</theme>
	        
	        <!-- document encoding -->
	        <!-- defaults to UTF-8 -->
	        <encoding>UTF-8</encoding>
	        
	        <!-- enable or disable timeline on dashboard -->
	        <enableTimeline>true</enableTimeline>
	        
	        <!-- protocol for script and stylesheets -->
	        <!-- defaults to https -->
	        <protocol>https</protocol>
	        
	        <!-- title of the document -->
	        <documentTitle>FalconDashboard</documentTitle>
	        
	        <!-- report name - displayed at top-nav -->
	        <reportName>FalconDashboard Automation Report</reportName>
	
			<!-- create a report with all artifacts stored locally -->
			<enableOfflineMode>true</enableOfflineMode>
	        
	        <!-- custom javascript -->
	        <scripts>
	            <![CDATA[
	                $(document).ready(function() {
	                    
	                });
	            ]]>
	             <!-- custom styles -->
	    <styles>
	      <![CDATA[
	        
	      ]]>
	    </styles>
	        </scripts>
	    </configuration>
	</extentreports>
}

