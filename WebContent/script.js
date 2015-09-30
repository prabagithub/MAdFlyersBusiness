// Code goes here

var MainController = function($scope){
  $scope.message = "MAdFlyers";
  $scope.overtopmsg = "Go green !!! No more pamplets !!! Now you can post your Ad at any time, any where !!!";
  $scope.color="darkgreen"
}
var SuccessController = function($scope){	
	
	$scope.message = "MAdFlyers";
	$scope.overtopmsg = "";
	$scope.color="green"
}

var ErrorController = function($scope){	
	
	$scope.message = "MAdFlyers";
	$scope.overtopmsg = "Error in posting Ad, Please try again";
	$scope.color="red"
}

var Step2Contoller = function($scope){
	$scope.message = "MAdFlyers";
	$scope.overtopmsg = "It is now easy to attach your files";
	$scope.color="black"
}

var FooterController = function($scope){
	$scope.copy="Copyright@2015";
			
}
var LoginController = function($scope){
	  $scope.message = "MAdFlyers";
	  $scope.overtopmsg = "Now you can post your Ad at any time, any where !!!";
	  $scope.color="black";
	  $scope.header="Existing User";
	  $scope.errmsg="Please provide valid login details";
	  $scope.username="User name";
	  $scope.pwd="Password";
	  $scope.btnvalue="Login";
	  $scope.regmsg="";
	  $scope.filename="register.jsp";
	  $scope.welcomeclass="hide";
	  $scope.forgot="Reset Password"
		  $scope.hdrbg="hdgreen";
	  
	}

var RegisterController = function($scope){
	  $scope.message = "MAdFlyers";
	  $scope.overtopmsg = "Now you can post your Ad at any time, any where !!!";
	  $scope.color="black";
	  $scope.header="New User";
	  $scope.errmsg="Sorry! Username already exists, Please try with new one";
	  $scope.username="User name";
	  $scope.pwd="Password";
	  $scope.confirm="Confirm Password";
	  $scope.btnvalue="Register";
	  $scope.regmsg="Don't have an account?,  create one, it is simple";
	  $scope.filename="login.jsp"
	  $scope.welcomeclass="hide";
	  $scope.hdrbg="hdrred";
	}

function check(){
	
	var orgName = document.getElementById("orgName").value;
	var addr1 = document.getElementById("addr1").value;
	var city = document.getElementById("city").value;
	var state = document.getElementById("state").value;
	var country = document.getElementById("country").value;
	var pincode = document.getElementById("zip").value;
	var desc = document.getElementById("desc").value;
	
	if(isEmpty(orgName) && isEmpty(addr1) && isEmpty(city) && isEmpty(state)
			&& isEmpty(country) && isEmpty(pincode) && isEmpty(desc)){
		return true;
	}	
	alert("Please provide all the mandatory information")
	return false;
}

function isEmpty(arg1){
	if(null == arg1)
		return false;
	if(arg1.trim() == '')
		return false;
	return true;
}


function checkLogin(){
	
	var username = document.getElementById("username").value;
	var pwd = document.getElementById("pwd").value;
	
	if(!isEmpty(username)){
		alert("Please provide Username");
		return false;
		}
	if(!isEmpty(pwd)){
		alert("Please provide password");
		return false;
	}
	return true;
	}
	
	