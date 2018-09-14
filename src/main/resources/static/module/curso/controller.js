'use strict';

    angular.module('curso', ['ngRoute', 'ngResource'])
     
    .config(function($routeProvider) {
     
      $routeProvider
        .when('/curso', {
          controller:'CursoListController as cursoListCtrl',
          templateUrl:'module/curso/list.html'
        })
        .when('/curso/edit/:id', {
          controller:'CursoEditController as cursoEditCtrl',
          templateUrl:'module/curso/form.html'
        })
        .when('/novoCurso', {
          controller:'CursoNewController as cursoEditCtrl',
          templateUrl:'module/curso/form.html'
        })
        
        .otherwise({
          redirectTo:'/'
        });
    })
     
    .controller('CursoListController', function($scope, $location, cursoResource) {
    	cursoResource.query(function (data) {
            $scope.cursos = data;
        });
    })
     
    .controller('CursoNewController', function($location, $scope, $http, cursoResource, instituicaoResource) {
     
    	instituicaoResource.query(function (data) {
    		$scope.instituicoes = data;
    	});
    	
    	$scope.salvar = function() {
			
    		cursoResource.save($scope.curso,
					function() { $location.path('/curso');
					},
					function(){ alert('Erro!'); });
		};
		
    })
     
    .controller('CursoEditController',
      function($scope, $location, $routeParams, $http, cursoResource, instituicaoResource) {
    	
    	if($routeParams.id != undefined) {
    		cursoResource.get({id:$routeParams.id}, function(curso) {
				$scope.curso = curso;
				$scope.acao = "Edição";
			});	
		}
    	
    	instituicaoResource.query(function (data) {
    		$scope.instituicoes = data;
    	});
    	
    	$scope.salvar = function() {
			
    		cursoResource.save($scope.curso,
  					function() { $location.path('/curso');
  					},
  					function(){ alert('Erro!'); });
  		};
  		
  		$scope.excluir = function(id) {
  			cursoResource.delete({id: id},
				function() {
					$location.path('/curso');
				});
		};
    })
    
    .factory('cursoResource', function ($resource) {
    	return $resource('resources/cursos/:id');
    });
