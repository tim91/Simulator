<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="Author" content="Tomasz Straszewski"/>

		<title>Historia</title>

		<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
		<link href="css/bootstrapValidator.min.css" rel="stylesheet" type="text/css" />
		<link href="css/mainpage.css" rel="stylesheet" type="text/css" />
		<link href="css/flyHistory.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="javascript/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="javascript/bootstrap.min.js"></script>
		<script type="text/javascript" src="javascript/utils.js"></script>
		<script type="text/javascript" src="javascript/serwerAJAX.js"></script>
		<script type="text/javascript" src="javascript/services.js"></script>
		<script type="text/javascript" src="javascript/moment.min.js"></script>
		<script type="text/javascript" src="javascript/historyPage.js"></script>

	</head>

	<body onload="initHistoryPage()">
		
		<div class="nav-bar-div">
			<ul class="nav nav-pills nav-bar">
			  <li><a href="/Simulator/index.htm">Home</a></li>
			</ul>
		</div>
		
		<div class="table-responsive">
			<table id="historyTable" class="table">
				<caption>
					Historia lotów
				</caption>
				<thead>
					<tr>
						<th>Data przelotu</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</body>
</html>