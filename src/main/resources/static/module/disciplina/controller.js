'use strict';

    angular.module('disciplina', ['ngRoute', 'ngResource'])
     
    .config(function($routeProvider) {
     
      $routeProvider
        .when('/disciplina', {
          controller:'DisciplinaListController as disciplinaListCtrl',
          templateUrl:'module/disciplina/list.html'
        })
        .when('/disciplina/edit/:id', {
          controller:'DisciplinaEditController as disciplinaEditCtrl',
          templateUrl:'module/disciplina/form.html'
        })
        .when('/novaDisciplina', {
          controller:'DisciplinaNewController as disciplinaEditCtrl',
          templateUrl:'module/disciplina/form.html'
        })
        
        .otherwise({
          redirectTo:'/'
        });
    })
     
    .controller('DisciplinaListController', function($scope, $location, disciplinaResource) {
    	disciplinaResource.query(function (data) {
            $scope.disciplinas = data;
        });
    })
     
    .controller('DisciplinaNewController', function($location, $scope, $http, disciplinaResource) {
     
    	$scope.salvar = function() {
			
    	  disciplinaResource.save($scope.disciplina,
					function() { $location.path('/disciplina');
					},
					function(){ alert('Erro!'); });
		};
		
    })
     
    .controller('DisciplinaEditController',
      function($scope, $location, $routeParams, $http, disciplinaResource) {
    	
    	if($routeParams.id != undefined) {
    		disciplinaResource.get({id:$routeParams.id}, function(disciplina) {
				$scope.disciplina = disciplina;
				$scope.acao = "Edição";
			});	
		}
    	
    	$scope.salvar = function() {
			
      	  disciplinaResource.save($scope.disciplina,
  					function() { $location.path('/disciplina');
  					},
  					function(){ alert('Erro!'); });
  		};
  		
  		$scope.excluir = function(id) {
    		disciplinaResource.delete({id: id},
				function() {
					$location.path('/disciplina');
				});
		};
    })
    
    .factory('disciplinaResource', function ($resource) {
    	return $resource('resources/disciplinas/:id');
    });
