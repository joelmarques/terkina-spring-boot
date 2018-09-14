'use strict';

    angular.module('instituicao', ['ngRoute', 'ngResource'])
     
    .config(function($routeProvider) {
     
      $routeProvider
        .when('/instituicao', {
          controller:'InstituicaoListController as instituicaoListCtrl',
          templateUrl:'module/instituicao/list.html'
        })
        .when('/instituicao/edit/:id', {
          controller:'InstituicaoEditController as instituicaoEditCtrl',
          templateUrl:'module/instituicao/form.html'
        })
        .when('/novaInstituicao', {
          controller:'InstituicaoNewController as instituicaoEditCtrl',
          templateUrl:'module/instituicao/form.html'
        })
        
        .otherwise({
          redirectTo:'/'
        });
    })
     
    .controller('InstituicaoListController', function($scope, $location, instituicaoResource) {
    	instituicaoResource.query(function (data) {
            $scope.instituicoes = data;
        });
    })
     
    .controller('InstituicaoNewController', function($location, $scope, $http, instituicaoResource) {
     
    	$scope.salvar = function() {
			
    		instituicaoResource.save($scope.instituicao,
					function() { $location.path('/instituicao');
					},
					function(){ alert('Erro!'); });
		};
		
    })
     
    .controller('InstituicaoEditController',
      function($scope, $location, $routeParams, $http, instituicaoResource) {
    	
    	if($routeParams.id != undefined) {
    		instituicaoResource.get({id:$routeParams.id}, function(instituicao) {
				$scope.instituicao = instituicao;
				$scope.acao = "Edição";
			});	
		}
    	
    	$scope.salvar = function() {
			
    		instituicaoResource.save($scope.instituicao,
  					function() { $location.path('/instituicao');
  					},
  					function(){ alert('Erro!'); });
  		};
  		
  		$scope.excluir = function(id) {
  			instituicaoResource.delete({id: id},
				function() {
					$location.path('/instituicao');
				});
		};
    })
    
    .factory('instituicaoResource', function ($resource) {
    	return $resource('resources/instituicoes/:id');
    });
