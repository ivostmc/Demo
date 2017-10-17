(function (){
  var app = angular.module("myApp");
  app.service("UserDataSvc", function($http){

    var self = this;

    self.saveUser = function(user){
      return $http.post("http://localhost:8080/users", user)
      .then(function(response){
        console.log(response);
      })
    }
  })
})();
