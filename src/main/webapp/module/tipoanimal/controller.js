'use strict';

    angular.module('tipoDeAnimal', ['ngRoute', 'ngResource'])
     
    .config(function($routeProvider) {
     
      $routeProvider
        .when('/tipoDeAnimal', {
          controller:'TipoDeAnimalListController as tipoDeAnimalListCtrl',
          templateUrl:'module/tipoanimal/list.html'
        })
        .when('/tipoDeAnimal/edit/:id', {
          controller:'TipoDeAnimalEditController as tipoDeAnimalEditCtrl',
          templateUrl:'module/tipoanimal/form.html'
        })
        .when('/novoTipoDeAnimal', {
          controller:'TipoDeAnimalNewController as tipoDeAnimalEditCtrl',
          templateUrl:'module/tipoanimal/form.html'
        })
        
        .otherwise({
          redirectTo:'/'
        });
    })
     
    .controller('TipoDeAnimalListController', function($scope, tipoDeAnimalResource) {
    	tipoDeAnimalResource.query(function (data) {
            $scope.tiposDeAnimal = data;
        });
    })
     
    .controller('TipoDeAnimalNewController', function($location, $scope, $http, tipoDeAnimalResource) {
    	
    	$scope.salvar = function() {
			
    		tipoDeAnimalResource.save($scope.tipoDeAnimal,
					function() { $location.path('/tipoDeAnimal');
					},
					function(){ alert('Erro!'); });
		};
		
    })
     
    .controller('TipoDeAnimalEditController',
      function($scope, $location, $routeParams, tipoDeAnimalResource) {
    	
    	if($routeParams.id != undefined) {
    		tipoDeAnimalResource.get({id:$routeParams.id}, function(tipoDeAnimal) {
				$scope.tipoDeAnimal = tipoDeAnimal;
				$scope.acao = "Edição";
			});	
		}
    	
    	$scope.salvar = function() {
			
    		tipoDeAnimalResource.save($scope.tipoDeAnimal,
  					function() { $location.path('/tipoDeAnimal');
  					},
  					function(){ alert('Erro!'); });
  		};
  		
  		$scope.excluir = function(id) {
  			tipoDeAnimalResource.delete({id: id},
				function() {
					$location.path('/tipoDeAnimal');
				});
		};
    })
    
    .factory('tipoDeAnimalResource', function ($resource) {
    	return $resource('resources/tiposDeAnimal/:id');
    });
