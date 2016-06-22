angular.module('app').controller('LoginController', function($scope, $rootScope, AuthService) {

	$scope.user = {
    login: '',
    password: ''
	};
	
	$scope.auth = {
	login :'',
    password:''
	};

  $scope.SignIn = function (user) {
    
	  AuthService.SignIn(user)
	  
	.then(function (res) {
    console.log('user ', user.login);
    console.log('res ', res);

    if(!res.data) 
      {alert("Server error");}
    else{

      if(!res.data.object){
        alert(res.data.message);
      }else{

      //alert(res.statusText);
        this.auth = res.data.object;
        //authent
       if (user.password !== this.auth.password) {
        alert("Invalid password")}
        else{
       $rootScope.currentUser=AuthService.getCurrentUser(this.auth)
       		.then(function(res){
              if(!res.data) 
               {alert("Server error")}
             else{
              if(!res.data.object){
             alert(res.data.message);
             }else{

       $rootScope.currentUser=res.data.object;
       console.log('currentUser', $rootScope.currentUser.profile.name);
       //Session.create(res.data.id, res.data.login);
       $rootScope.isAuthenticated=true;
              }
        }})
        	.catch(function(res){alert("Server error"); console.log('Error ', res.data);});
        }//authent

      }
    }
       })
       
	.catch(function (res) {
    alert("Server Error");
           console.log('Error', res.status, res.data);
        });
   }; 
});