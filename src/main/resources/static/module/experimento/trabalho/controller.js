'use strict';

    angular.module('trabalhoAcademico', ['ngRoute', 'ngResource'])
     
    .config(function($routeProvider) {
     
      $routeProvider
        .when('/projetos/:idProjeto/:tituloProjeto/trabalhosAcademicos', {
          controller:'TrabalhoAcademicoListController',
          templateUrl:'module/experimento/trabalho/list.html'
        })
        .when('/projetos/:idProjeto/:tituloProjeto/trabalhosAcademicos/edit/:id', {
          controller:'TrabalhoAcademicoEditController',
          templateUrl:'module/experimento/trabalho/form.html'
        })
        .when('/projetos/:idProjeto/:tituloProjeto/trabalhosAcademicos/novo', {
        	controller:'TrabalhoAcademicoEditController',
            templateUrl:'module/experimento/trabalho/form.html'
        })
        
        .otherwise({
          redirectTo:'/'
        });
    })
    
    .controller('TrabalhoAcademicoListController', function($scope, $routeParams, $http, $location) {
    	
    	$http.get('resources/trabalhosAcademicos/trabalhosAcademicosPorProjeto?idProjeto='+$routeParams.idProjeto).success(function(data) {
    		$scope.trabalhosAcademicos = data;
		});
    	
    	$scope.tituloProjeto = $routeParams.tituloProjeto;
		
		$scope.novo = function() {
			$location.path('/projetos/' + $routeParams.idProjeto + '/' + $routeParams.tituloProjeto + '/trabalhosAcademicos/novo');
		};
		
		$scope.editar = function(id) {
			$location.path('/projetos/' + $routeParams.idProjeto + '/' + $routeParams.tituloProjeto + '/trabalhosAcademicos/edit/'+id);
		};
    })
    
    .controller('TrabalhoAcademicoEditController', function($scope, $routeParams, $location, $http, trabalhoAcademicoResource){
    	
    	$scope.etapa = 'Inserindo';
    	$scope.tituloProjeto = $routeParams.tituloProjeto;
    	$scope.trabalhoAcademico = {};
    	$scope.trabalhoAcademico.idProjeto = $routeParams.idProjeto;
    	
    	$http.get('resources/trabalhosAcademicos/tiposTrabalho').success(function(tiposTrabalho) {
			$scope.tiposTrabalho = tiposTrabalho;
		});
    	
    	if($routeParams.id != undefined) {
    		trabalhoAcademicoResource.get({id:$routeParams.id}, function(trabalhoAcademico) {    			
				$scope.trabalhoAcademico = trabalhoAcademico;
				$scope.trabalhoAcademico.idProjeto = $routeParams.idProjeto;
				$scope.etapa = 'Editando';
			});	
		}
    	
    	$scope.cancelar = function() {
    		$scope.voltar();
    	};
    	
    	//volta para a listagem de trabalhos academicos
    	$scope.voltar = function() {
    		$location.path('/projetos/' + $routeParams.idProjeto + '/' + $routeParams.tituloProjeto + '/trabalhosAcademicos');
    	};
    	
    	$scope.salvar = function() {
    		trabalhoAcademicoResource.save($scope.trabalhoAcademico,
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
  				trabalhoAcademicoResource.delete({id: id},
					function() {
	  					$scope.voltar();
					});
  			}
		};
    	
    })
    
    .factory('trabalhoAcademicoResource', function ($resource) {
    	return $resource('resources/trabalhosAcademicos/:id');
    });
