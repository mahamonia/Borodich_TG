angular.module('app').service('ApplicationService', function($http) {

	 this.getrubrics = function getrubrics() {
		return $http.get('/webservice/rubrics');
	};

});
