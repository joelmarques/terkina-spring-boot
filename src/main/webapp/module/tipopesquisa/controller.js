'use strict';

    angular.module('tipoDePesquisa', ['ngRoute', 'ngResource'])
     
    .config(function($routeProvider) {
     
      $routeProvider
        .when('/tipoDePesquisa', {
          controller:'TipoDePesquisaListController as tipoDePesquisaListCtrl',
          templateUrl:'module/tipopesquisa/list.html'
        })
        .when('/tipoDePesquisa/edit/:id', {
          controller:'TipoDePesquisaEditController as tipoDePesquisaEditCtrl',
          templateUrl:'module/tipopesquisa/form.html'
        })
        .when('/novoTipoDePesquisa', {
          controller:'TipoDePesquisaNewController as tipoDePesquisaEditCtrl',
          templateUrl:'module/tipopesquisa/form.html'
        })
        
        .otherwise({
          redirectTo:'/'
        });
    })
     
    .controller('TipoDePesquisaListController', function($scope, tipoDePesquisaResource) {
    	tipoDePesquisaResource.query(function (data) {
            $scope.tiposDePesquisa = data;
        });
    })
     
    .controller('TipoDePesquisaNewController', function($location, $scope, $http, tipoDePesquisaResource) {
    	
    	$scope.salvar = function() {
			
    		tipoDePesquisaResource.save($scope.tipoDePesquisa,
					function() { $location.path('/tipoDePesquisa');
					},
					function(){ alert('Erro!'); });
		};
		
    })
     
    .controller('TipoDePesquisaEditController',
      function($scope, $location, $routeParams, tipoDePesquisaResource) {
    	
    	if($routeParams.id != undefined) {
    		tipoDePesquisaResource.get({id:$routeParams.id}, function(data) {
				$scope.tipoDePesquisa = data;
				$scope.acao = "Edição";
			});	
		}
    	
    	$scope.salvar = function() {
			
    		tipoDePesquisaResource.save($scope.tipoDePesquisa,
  					function() { $location.path('/tipoDePesquisa');
  					},
  					function(){ alert('Erro!'); });
  		};
  		
  		$scope.excluir = function(id) {
  			tipoDePesquisaResource.delete({id: id},
				function() {
					$location.path('/tipoDePesquisa');
				});
		};
    })
    
    .factory('tipoDePesquisaResource', function ($resource) {
    	return $resource('resources/tiposDePesquisa/:id');
    });
