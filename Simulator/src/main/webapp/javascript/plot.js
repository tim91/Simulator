var renderPlots = function () {
	
		var accelerationData = [];

		var accelerationPlot = new CanvasJS.Chart("accelerationPlot",{
			title :{
				text: "Wykres przyspieszenia"
			},	
			axisY: {				
				title: "Przyspieszenie [m/s]"
			},
			axisX: {				
				title: "Czas [s]"
			},
			data: [{
				type: "line",
				dataPoints: accelerationData 
			}]
		});

		var updateInterval = 200;
		//liczba widocznych punktów na wykresie
		var dataLength = 10;

		var updateAccelerationChart = function () {

			accelerationData.push({
					x: plane.flightTime,
					y: plane.accel.x
				});
				
			if (accelerationData.length > dataLength)
			{
				accelerationData.shift();				
			}
			
			accelerationPlot.render();		

		};

		var speedData = [];

		var speedPlot = new CanvasJS.Chart("speedPlot",{
			title :{
				text: "Wykres predkosci"
			},	
			axisY: {				
				title: "Predkosc [m/s]"
			},
			axisX: {				
				title: "Czas [s]"
			},
			data: [{
				type: "line",
				dataPoints: speedData 
			}]
		});

		
		var lastSpeed = 0;
		var updateSpeedChart = function () {
			
			var deltaTime;
			var acceleration;
			var speed;
			if(plane.crashed == false){
				deltaTime = 0.2;
				acceleration = plane.accel.x;
				speed = lastSpeed + acceleration * deltaTime;
			}else{
				speed = 0;
			}
			
			
			speedData.push({
					x: plane.flightTime,
					y: speed
				});
				
			if (speedData.length > dataLength)
			{
				speedData.shift();				
			}
			
			speedPlot.render();		
			lastSpeed = speed;
		};
		
		// update chart after specified time. 
		setInterval(function(){updateAccelerationChart()}, updateInterval);
		setInterval(function(){updateSpeedChart()}, updateInterval);
};

var plane = new Plane();
plane.crashed = true;
var renderer = null;

function insertTextNode(query) {
	var v = document.createTextNode("");
	document.getElementById(query).appendChild(v);
	return v;
}



var startFlying = function(vals){
	// XZ - horizontal plane, Y - height
	plane = new Plane();
	console.log(vals.posX);
	
	plane.setVel(vals.posX,vals.posY,vals.posZ);
	plane.setPos(vals.velX,vals.velY,vals.velZ);
	
	var land = new Land(2245, 10000, 10000, 5);
	var autopilot = new Autopilot();
	autopilot.setup(plane, land, new THREE.Vector3(100000, 0.0, -50000));

	var height = land.getValue(plane.pos.x, plane.pos.z);
	plane.pos.y = height + 1000.0;

	var camera, scene, objects = {};

	scene = new THREE.Scene();
	camera = new THREE.PerspectiveCamera(45, 800 / 400, 1, 10000);

	var ambientLight = new THREE.AmbientLight(0x555555);
	scene.add(ambientLight);

	var directionalLight = new THREE.DirectionalLight(0xffffff);
	directionalLight.position.set(1, 1, 1).normalize();
	scene.add(directionalLight);

	var manager = new THREE.LoadingManager();
	var loader = new THREE.JSONLoader(manager);
	loader.load('javascript/plane.js', function(geometry) {
		var mesh = new THREE.Mesh(geometry, new THREE.MeshPhongMaterial());
		mesh.position.x = 0;
		mesh.position.y = 0;
		mesh.position.z = 0;
		mesh.scale.set(20, 20, 20); // huge model to make it visible
		scene.add(mesh);
		objects[1] = mesh;
	});

	landGridParent = new THREE.Object3D();
	scene.add(landGridParent);

	var landW = 5000;
	var landH = 5000;
	var landWS = 8;
	var landHS = 8;
	var xstep = landW / (landWS + 1);
	var zstep = landH / (landHS + 1);
	var gridGeometry = new THREE.PlaneGeometry(landW, landH, landWS, landHS);
	gridGeometry.dynamic = true;
	var grid = new THREE.Mesh(gridGeometry, new THREE.MeshBasicMaterial({
		wireframe : true
	}));
	grid.rotation.x = -Math.PI / 2;
	grid.frustumCulled = false;
	landGridParent.add(grid);

	var sphereGeom = new THREE.SphereGeometry(1000.0, 64, 32);
	var sphereMat = new THREE.MeshBasicMaterial( { color: 0xffaa00, transparent: true, blending: THREE.AdditiveBlending } );
	var targetMark = new THREE.Mesh(sphereGeom, sphereMat);
	scene.add(targetMark);
	
	

	

	function round(value, number) {
		var factor = Math.pow(10, number);
		return "" + Math.floor(value * factor) / factor;
	}

	
	document.getElementById("cra1").setAttribute("crashed", "false");

	document.getElementById("rollA").addEventListener("click", function(e) {
		plane.setRoll(plane.rollSettings + 0.05);
	}, false);

	document.getElementById("rollB").addEventListener("click", function(e) {
		plane.setRoll(plane.rollSettings - 0.05);
	}, false);

	document.getElementById("pitchA").addEventListener("click", function(e) {
		plane.setPitch(plane.pitchSettings + 0.05);
	}, false);

	document.getElementById("pitchB").addEventListener("click", function(e) {
		plane.setPitch(plane.pitchSettings - 0.05);
	}, false);

	document.getElementById("yawA").addEventListener("click", function(e) {
		plane.setYaw(plane.yawSettings + 0.05);
	}, false);

	document.getElementById("yawB").addEventListener("click", function(e) {
		plane.setYaw(plane.yawSettings - 0.05);
	}, false);

	document.getElementById("engineA").addEventListener("click", function(e) {
		plane.setEnginePower(plane.enginesPowerSetting + 0.05);
	}, false);

	document.getElementById("engineB").addEventListener("click", function(e) {
		plane.setEnginePower(plane.enginesPowerSetting - 0.05);
	}, false);
	
	document.getElementById("ap").addEventListener("click", function(e) {
		autopilot.navigationEnabled = !autopilot.navigationEnabled;
		var title = "Enabled";
		if (autopilot.navigationEnabled == false) {
			title = "Disabled";
		}
		var ctrl = document.getElementById("ap");
		ctrl.firstChild.data = title;
	}, false);

	function animate() {
		requestAnimationFrame(animate);
		if (plane.crashed == false) {
			var mesh = objects[1];
			if (mesh) {
				// update plane if loaded
				mesh.setRotationFromMatrix(plane.rotationMatrix);
				//meshes[1].matrixAutoUpdate = false;
				//meshes[1].updateMatrix();
//				point = getPositionForCamera(x,y,z);
				camera.position.set(plane.pos.x - 4000.0, plane.pos.y - 200.0, plane.pos.z);
				camera.lookAt(plane.pos);
				mesh.position.set(plane.pos.x, plane.pos.y, plane.pos.z);
				grid.position.set(plane.pos.x, 0.0, plane.pos.z);
				targetMark.position.set(autopilot.target.x, 500.0, autopilot.target.z);
			}

			// update land
			var xoffset = plane.pos.x - landW * 0.5;
			var zoffset = plane.pos.z - landH * 0.5;
			var vertexIdx = 0;
			for (var z = 0; z <= landHS; z++) {
				for (var x = 0; x <= landWS; x++) {
					var xp = xoffset + x * xstep;
					var zp = zoffset + z * zstep;
					var height = land.getValue(xp, zp);
					//height = vertexIdx * 10 + 50;//rotation!
					//if ((z == 0) && (x == 0)) {
					//	height = 0.0;
					//}
					grid.geometry.vertices[vertexIdx++].z = height;
				}
			}
			//grid.geometry.computeFaceNormals();
			//grid.geometry.normalsNeedUpdate = true;
			grid.geometry.verticesNeedUpdate = true;
		}
		renderer.render(scene, camera);
	}
	animate();

	var deltaTime = 0.1; // secs.
	animationIntervalHandler = setInterval(function() {
		if (plane.crashed == true) {
			return;
		}

		plane.calculateForces(deltaTime);
		plane.fly(deltaTime);
		autopilot.navigate(deltaTime);
		//plane.pos.y = 500;

		v1.data = "" + plane.vel.x;
		v2.data = "" + plane.vel.y;
		v3.data = "" + plane.vel.z;

		d1.data = "" + plane.direction.x;
		d2.data = "" + plane.direction.y;
		d3.data = "" + plane.direction.z;

		f1.data = "" + plane.force.x;
		f2.data = "" + plane.force.y;
		f3.data = "" + plane.force.z;

		l1.data = "" + plane.pos.x;
		l2.data = "" + plane.pos.y;
		l3.data = "" + plane.pos.z;

		r1.data = "" + round(plane.rollSettings, 3);
		r2.data = "" + round(plane.pitchSettings, 3);
		r3.data = "" + round(plane.yawSettings, 3);
		r4.data = "" + round(plane.enginesPowerSetting, 3);

		var height = land.getValue(plane.pos.x, plane.pos.z);
		he.data = "" + round(height, 2);

		if (plane.pos.y < height) {
			plane.crashed = true;
			plane.pos.y = height;
			document.getElementById("cra1").setAttribute("crashed", "true");

			var vertexIdx = 0;
			for (var z = 0; z <= landHS; z++) {
				for (var x = 0; x <= landWS; x++) {
					console.log(vertexIdx + ' ' + grid.geometry.vertices[vertexIdx++].z);//rotation!
				}
			}
		}

		if(plane.crashed == true){
			cr.data = "crashed " + round(plane.flightTime, 1) + " sec.";
		}else{
			cr.data = "flying " + round(plane.flightTime, 1) + " sec.";
		}
		
		
	}, 10);
};

var clearAnimation = function(){
	plane.crashed = true;
	clearInterval(animationIntervalHandler);
	$('#view3d').empty();
}

var stop = function(){
//	clearAnimation();
//	if(plane.crashed == true){
////		removeChild("view3d");
//		removeChild("speedPlot");
//		removeChild("accelerationPlot");
//	}
//	renderer = null;
	location.reload();
}


$(document).ready(function(){
//	formFields.push('#posX');
//	formFields.push('#posY');
//	formFields.push('#posZ');
//	formFields.push('#velX');
//	formFields.push('#velY');
//	formFields.push('#velZ');
	
	v1 = insertTextNode("vel1");
	v2 = insertTextNode("vel2");
	v3 = insertTextNode("vel3");

	d1 = insertTextNode("dir1");
	d2 = insertTextNode("dir2");
	d3 = insertTextNode("dir3");

	f1 = insertTextNode("for1");
	f2 = insertTextNode("for2");
	f3 = insertTextNode("for3");

	l1 = insertTextNode("pos1");
	l2 = insertTextNode("pos2");
	l3 = insertTextNode("pos3");

	r1 = insertTextNode("rollV");
	r2 = insertTextNode("pitchV");
	r3 = insertTextNode("yawV");
	r4 = insertTextNode("engineV");

	he = insertTextNode("hoh1");

	cr = insertTextNode("cra1");
	
	var params = checkStartParams();
	
	if(params){
		init(params,false);
	}else{
		//nie podano startowych paramterów
		/*
		 * For test
		 */
		setVal('#posX',3);
		setVal('#posY',3);
		setVal('#posZ',3);
		setVal('#velX',3);
		setVal('#velY',3);
		setVal('#velZ',3);
	}
	
	var u = getCurrentUser();
	
	var el =$('#logoutEl'); 
	val = el.text();
	val = val + ' '+ u.nickName;
	el.text(val);
	
	initHistoryPage();
	
	});


var setVal = function(id,val){
	$(id).val(val);
};

var checkStartParams = function(){
	console.log("Sprawdzam startowe paramtery");
	
	params = getAllQueryStringParams();
	
	if(params && params.length == 6 && validate(params)){
		return params;
	}else{
		return null;
	}
	
}

var validate = function(vals){
	var len = vals.length;
	for(var i = 0; i< len; i++){
		val = parseInt(vals[i]);
		if(!(val && (typeof val === 'number') && val >=0)){
			console.log('Niepoprawne dane....');
			return false;
		}
	}
	return true;
}

var init = function(vals,saveHistory_){
	console.log('sdfsdfsdf');
	if(plane.crashed == true){
//		var vals = readDataFromForm();
//		
//		if(vals == null)
//			return;
		
		if(renderer == null){
			renderer = new THREE.WebGLRenderer();
			renderer.setSize(800, 400);
			document.getElementById("view3d").appendChild(renderer.domElement);
		}
		
		startFlying(vals);
		renderPlots();
		if(saveHistory_ && saveHistory_ == true){
			saveStartData(vals);
		}
	}
	
};
//
//var readDataFromForm = function(){
//	
//	var len = formFields.length;
//	var valid = true;
//	var vals = {};
//	for(var i=0;i<len;i++){
//		el = formFields[i];
//		val = getValueAndValidate(el);
//		if(isNaN(val) || val < 0){
//			valid = false;
//			console.log("Invalid: " + el);
//			addClass($(el).parent(),'has-error');
//		}else{
//			vals[el.substr(1)] = val;
//			console.log("Valid: " + el);
//		}
//	}
//	
//	return valid == true ? vals : null;
//};

var getValueAndValidate = function(id){
	posX = $(id).val();
	px = parseInt(posX);
	return px;
};

var convertTimeFromServer = function(time){
	
	d = new Date().setTime(time);
	return d;
};

var saveStartData = function(vals){
	
	console.log("Wysylam dane na serwer....");
	vals = JSON.stringify(vals);
	saveHistory(vals);
};

var addClass = function (id,className){
	$(id).addClass(className);
};

var removeChild = function(elementId){
	var childs=document.getElementById(elementId);
	if(childs.childNodes.length > 0)
		childs.removeChild(childs.childNodes[0]);
};

var readStartData = function(){
	
};

var getPositionForCamera = function(x,y,z){
	
	/*
	 * W zaleznosci od flagi
	 */
	return [x,y,z];
};