'use strict';
angular.module('app').controller('ApplicationController', function($scope, $rootScope, $location, $http, ApplicationService,AuthService) {


			$rootScope.isAuthenticated = AuthService.isAuthenticated();
			console.log('isAuthenticated ',$rootScope.isAuthenticated);

		ApplicationService.getrubrics()
			.then(function(res){
				console.log('items', res.data.object);
				if (!res.data) {
					alert("Server error");
				} else {
					if (!res.data.object) {
						alert(res.data.message);
					} else {
						$scope.items = res.data.object;
					}
				}
			})
			.catch(function(res){
				alert("Server error");
				console.log('Error', res.data);
			});

		});