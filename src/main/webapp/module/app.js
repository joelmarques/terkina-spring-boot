'use strict';

angular.module('terkinaApp', [
  'ngRoute',
  'ui.bootstrap',
  'ui.utils.masks',
  'animal',
  'tipoDeAnimal',
  'localizacao',
  'disciplina',
  'instituicao',
  'curso',
  'empresa',
  'projeto',
  'tipoDePesquisa',
  'sessaoExperimento',
  'trabalhoAcademico',
  'fichaClinica',
  'integrante'
]).

run(function($rootScope, $http){
	$http.get('resources/users/userLoggedIn').success(function(userLoggedIn) {
		$rootScope.usuarioLogado = userLoggedIn;
	});
})

.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when("/", {templateUrl: "module/templates/home.html", controller: "HomeCtrl"})
		.otherwise({redirectTo: "module/templates/404.html"});
}])

.controller('HomeCtrl', function ($scope, $http) {
	
	$scope.animais = [];
	
	$http.get('resources/animais/all').success(function(animais) {
		$scope.animais = animais;
	});

})

.constant('variaveisGlobais', {
    nomeSistema: 'Terkina'
});