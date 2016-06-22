var app = angular.module('app', [ 'ngRoute' ]);

app.config(function($routeProvider) {

	$routeProvider.when('/rubric/:id', {
		controller : 'RubricController',
		templateUrl : 'views/rubrics/currentRubric.html'
	}).otherwise({
		templateUrl: "<h1>'404 no such page'</h1>" // не знаю или надо это
		redirectTo : '/'
	});
});

app.run(function($rootScope, AuthService) {

	$rootScope.$on('$stateChangeStart', function(event, next) {
		event.preventDefault();
	})
});



