'use strict';

    angular.module('localizacao', ['ngRoute', 'ngResource'])
     
    .config(function($routeProvider) {
     
      $routeProvider
        .when('/localizacao', {
          controller:'LocalizacaoListController as localListCtrl',
          templateUrl:'module/localizacao/list.html'
        })
        .when('/localizacao/edit/:id', {
          controller:'LocalizacaoEditController as localEditCtrl',
          templateUrl:'module/localizacao/form.html'
        })
        .when('/novaLocalizacao', {
          controller:'LocalizacaoNewController as localEditCtrl',
          templateUrl:'module/localizacao/form.html'
        })
        
        .otherwise({
          redirectTo:'/'
        });
    })
     
    .controller('LocalizacaoListController', function($scope, $location, localizacaoResource) {
    	localizacaoResource.query(function (data) {
            $scope.locais = data;
        });
    })
     
    .controller('LocalizacaoNewController', function($location, $scope, $http, localizacaoResource) {
     
    	$scope.salvar = function() {
			
    	  localizacaoResource.save($scope.local,
					function() { $location.path('/localizacao');
					},
					function(){ alert('Erro!'); });
		};
		
    })
     
    .controller('LocalizacaoEditController',
      function($scope, $location, $routeParams, $http, localizacaoResource) {
    	
    	if($routeParams.id != undefined) {
    		localizacaoResource.get({id:$routeParams.id}, function(local) {
				$scope.local = local;
				$scope.acao = "Edição";
			});	
		}
    	
    	$scope.salvar = function() {
			
      	  localizacaoResource.save($scope.local,
  					function() { $location.path('/localizacao');
  					},
  					function(){ alert('Erro!'); });
  		};
  		
  		$scope.excluir = function(id) {
    		localizacaoResource.delete({id: id},
				function() {
					$location.path('/localizacao');
				});
		};
    })
    
    .factory('localizacaoResource', function ($resource) {
    	return $resource('resources/localizacoes/:id');
    });
