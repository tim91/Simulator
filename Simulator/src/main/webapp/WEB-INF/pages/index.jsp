<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html> -->
<html>
<head>
<!-- <meta charset="UTF-8"> -->
<meta name="Author" content="RadosÅaw ZiembiÅski" />
<meta name="Copyright" content="PoznaÅ Universtiy of Technolgy, 2014" />
<meta name="Description"
	content="Laboratories: Technologie programistyczne systemy internetowe - teaching materials" />

<title>Symulator lotu</title>
<link href="css/mainpage.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap-responsive.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/bootstrapValidator.min.css" rel="stylesheet"
	type="text/css" />


<script type="text/javascript" src="javascript/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="javascript/bootstrap.min.js"></script>
<script type="text/javascript"
	src="javascript/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="javascript/canvasjs.min.js"></script>
<script type="text/javascript" src="javascript/three/three.js"></script>
<script type="text/javascript" src="javascript/utils.js"></script>
<script type="text/javascript" src="javascript/globals.js"></script>
<script type="text/javascript" src="javascript/simulator.js"></script>
<script type="text/javascript" src="javascript/plot.js"></script>
<script type="text/javascript" src="javascript/serwerAJAX.js"></script>
<script type="text/javascript" src="javascript/services.js"></script>
<script type="text/javascript" src="javascript/formValidator.js"></script>
<script type="text/javascript" src="javascript/moment.min.js"></script>

</head>
<body>
	<div>

		<div class="nav-bar-div">
			<ul class="nav nav-pills nav-bar">
				<li><a id="logoutEl" href="/Simulator/logout">Logout</a></li>
			</ul>
		</div>

		<div id="view3d"></div>

		<table class="results">
			<thead>
				<tr>
					<td>Dimension</td>
					<td>Velocity [m/s]</td>
					<td>Direction</td>
					<td>Forces [N]</td>
					<td>Position [m]</td>
					<td>Height [m]</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>X</td>
					<td><div id="vel1"></div></td>
					<td><div id="dir1"></div></td>
					<td><div id="for1"></div></td>
					<td><div id="pos1"></div></td>
					<td><div id="hoh1"></div></td>
				</tr>
				<tr>
					<td>Y(height)</td>
					<td><div id="vel2"></div></td>
					<td><div id="dir2"></div></td>
					<td><div id="for2"></div></td>
					<td><div id="pos2"></div></td>
					<td><div id="cra1"></div></td>
				</tr>
				<tr>
					<td>Z</td>
					<td><div id="vel3"></div></td>
					<td><div id="dir3"></div></td>
					<td><div id="for3"></div></td>
					<td><div id="pos3"></div></td>
				</tr>
			</tbody>
		</table>

		<table class="controls">
			<thead>
				<tr>
					<td>Roll</td>
					<td>Pitch</td>
					<td>Yaw</td>
					<td>Engine</td>
					<td>Autopilot</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><button id="rollA">+</button></td>
					<td><button id="pitchA">+</button></td>
					<td><button id="yawA">+</button></td>
					<td><button id="engineA">+</button></td>
					<td><button id="ap">Disabled</button></td>
				</tr>
				<tr>
					<td><button id="rollB">-</button></td>
					<td><button id="pitchB">-</button></td>
					<td><button id="yawB">-</button></td>
					<td><button id="engineB">-</button></td>
					<td></td>
				</tr>
				<tr>
					<td><div id="rollV"></div></td>
					<td><div id="pitchV"></div></td>
					<td><div id="yawV"></div></td>
					<td><div id="engineV"></div></td>
					<td></td>
				</tr>
			</tbody>
		</table>

		<div>
			<div id="formHistoryDiv">
				<div>
					<form id="startDataForm" method="post">
						<div id="startDataFormSet">
							<div class="startDataFormFields poss form-group">
								<div class="col-md-4">
									<label class="control-label" for="posX">Pozycja X:</label> <input
										id="posX" name="posX" class="form-control" type="text">
								</div>
								<div class="col-md-4">
									<label class="control-label" for="posY">Pozycja Y:</label> <input
										id="posY" name="posY" class="form-control" type="text">
								</div>
								<div class="col-md-4">
									<label class="control-label" for="posZ">Pozycja Z:</label> <input
										id="posZ" name="posZ" class="form-control" type="text">
								</div>
							</div>

							<div class="startDataFormFields vels form-group">
								<div class="col-md-4">
									<label class="control-label" for="velX">Prędkosć X:</label> <input
										id="velX" name="velX" class="form-control" type="text">
								</div>
								<div class="col-md-4">
									<label class="control-label" for="velY">Prędkosć Y:</label> <input
										id="velY" name="velY" class="form-control" type="text">
								</div>
								<div class="col-md-4">
									<label class="control-label" for="velZ">Prędkosć Z:</label> <input
										id="velZ" name="velZ" class="form-control" type="text"
										required="required">
								</div>
							</div>
						</div>
						<button type="submit" class="btn btn-success">Start</button>
						<button class="btn btn-danger" onclick="stop()">Stop</button>
					</form>
					<button type="submit" class="btn btn-info" onclick="setCameraType('satelite')">Satelita</button>
					<button type="submit" class="btn btn-info" onclick="setCameraType('normal')">Tryb normalny</button>
				</div>
				<div class="table-responsive">

					<div class="row">
						<div id="history-header" class="col-md-4">Historia lotów</div>
						<div class="col-md-4">Data przelotu</div>
					</div>



					<div class="historyDiv">
						<table id="historyTable" class="table">
							<tbody>
								<tr></tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>


			<!-- <div id="plots">-->
				<div id="accelerationPlot"></div>
				<div id="speedPlot"></div>
			<!--  </div>-->
		</div>
	</div>
</body>
</html>