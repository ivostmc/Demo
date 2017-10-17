var app = angular.module("myApp", ["ngRoute"]);
app.controller("MyCtrl", Ctrl);

function Ctrl($scope, $http, $location){
	
	$scope.users = [];

	  $scope.getUsers = function(){
	    var promise1 = $http.get("http://localhost:8080/users");
	    var promise2 = promise1.then(function(response){
	      return response.data;
	    });
	    return promise2;
	  }

	  $scope.getUsers()
	  .then(function (data){
	    $scope.users = data;
	  })

	  $scope.saveUser = function(){
	    var config = {
					headers : {
						'Content-Type': 'application/json;charset=utf-8;'
					}
			}
			var user = {
					firstName: $scope.firstName,
					lastName: $scope.lastName,
					dateOfBirth: $scope.dateOfBirth
			};

			$http.post("http://localhost:8080/users", user, config).then(function (response){
				console.log("Successful!");
			}, function(response){
				console.log("Failed!");
			});
	    $scope.firstName = "";
			$scope.lastName = "";
			$scope.dateOfBirth = "";

	    $location.path("/result")
	 
	  }
	}

app.config(function($routeProvider){
	$routeProvider.when("/", {
		controller: 'MyCtrl',
		templateUrl: "form.html"
		})
		.when("/result", {
		controller: 'MyCtrl',
		templateUrl: "chart.html"
		})
})
