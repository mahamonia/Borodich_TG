angular.module('app').controller('RubricController',function($scope, $location, $rootScope, ApplicationService,
				RubricService) {

			$scope.currentRubric = {
				id : '',
				name : ''

			};

			$scope.selectMenu = function(elem) {
				$scope.activeMenu = $scope.activeMenu == elem.item.name ? '': elem.item.name;
				$scope.currentRubric = elem.item;
				RubricService.getThemeCurrentRubric(elem.item)
				.then(function(res){
				if (!res.data) {
					alert("Server error");
				} else {
					if (!res.data.object) {
						alert(res.data.message);
					} else {
						$scope.themes = data.object;
					}
				}
			})
			.catch(function(res){
				alert("Server error");
				console.log('Error', res.data);
			});
		
				RubricService.getThemeRubricCurrentUser($rootScope.currentUser,	elem.item)
				.then(function(res){
				if (!res.data) {
					alert("Server error");
				} else {
					if (!res.data.object) {
						alert(res.data.message);
					} else {
						$scope.themesCurrentUser = data.object;
					}
				}
			})
			.catch(function(res){
				alert("Server error");
				console.log('Error', res.data);
			});
			};


			function activateMenuItem() {
				var currentPath = $location.path();
			};

			$scope.selectTheme = function(elem, $event) {
				$scope.activeTheme = $scope.activeTheme == elem.theme.name ? '' : elem.theme.name;
			};

			function activateTheme() {
				var currentPath = $location.path();
			};

			$scope.newTheme = {
				name : '',
				date : new Date(),
				author : $rootScope.currentUser,
				rubric : null
			};

			$scope.createTheme = function(newTheme) {
				$scope.newTheme.rubric = $rootScope.currentRubric;
				RubricService.createTheme($scope.newTheme).then(
						function(response) {
							return response.data;
						})
			};
		});
