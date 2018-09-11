'use strict';

    angular.module('integrante', ['ngRoute', 'ngResource', 'checklist-model'])
     
    .config(function($routeProvider) {
     
      $routeProvider
        .when('/integrantes', {
          controller:'IntegranteListController as integranteListCtrl',
          templateUrl:'module/integrante/list.html'
        })
        .when('/integrantes/edit/:id', {
          controller:'IntegranteEditController as integranteEditCtrl',
          templateUrl:'module/integrante/form.html'
        })
        .when('/novoIntegrante', {
        	controller:'IntegranteEditController as integranteEditCtrl',
            templateUrl:'module/integrante/form.html'
        })
        
        .otherwise({
          redirectTo:'/'
        });
    })
     
    .controller('IntegranteListController', function($scope, $http) {    	
    	$http.get('resources/integrantes/all').success(function(integrantes) {			
			$scope.integrantes = integrantes;
		});
    })
     
    .controller('IntegranteEditController', function($scope, $location, $routeParams, $http, integranteResource) {
    	
    	$scope.etapa = 'Inserindo';
    	
    	$scope.roles = [];
    	$scope.cursos = [];
    	$scope.orientadores = [];
    	$scope.integrante = {};
    	$scope.integrante.roles = [];
    	$scope.integrante.cursos = [];
    	$scope.integrante.orientadores = [];
    	
    	$http.get('resources/integrantes/roles').success(function(roles) {			
			$scope.roles = roles;
		});
    	
    	$http.get('resources/integrantes/cursos').success(function(cursos) {			
			$scope.cursos = cursos;
		});
    	
    	$http.get('resources/integrantes/orientadores').success(function(orientadores) {			
			$scope.orientadores = orientadores;
		});
    	
    	if($routeParams.id == undefined) {
    		$scope.integrante.enable = true;
    	}
    	
    	if($routeParams.id != undefined) {
    		integranteResource.get({id:$routeParams.id}, function(integrante) {
				$scope.integrante = integrante;
				$scope.etapa = 'Editando';
			});
		}
    	
    	$scope.onChangeFoto = function(inputElement) {
    		
    		onChangeURLDaFotoNoGoogleDrive(inputElement);
    	};
    	
    	$scope.salvar = function() {
    		integranteResource.save($scope.integrante,
				function() {
					alert('Operação realizada com sucesso!');
					$scope.voltar();
				},
				function() {
					alert('Erro!'); 
				});
  		};
  		
  		$scope.excluir = function(id) {
  			
  			if (confirm('Deseja realmente excluir? A exclusão não poderá ser desfeita!')) { 
  				integranteResource.delete({id: id},
					function() {
	  					$scope.voltar();
					});
  			}
		};
		
		$scope.cancelar = function() {
			$scope.voltar();
    	};
    	
    	$scope.voltar = function() {
    		$location.path('/integrantes');
    	};
    })
    
    .factory('integranteResource', function ($resource) {
    	return $resource('resources/integrantes/:id');
    });
