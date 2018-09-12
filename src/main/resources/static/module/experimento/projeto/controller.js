'use strict';

    angular.module('projeto', ['ngRoute', 'ngResource'])
     
    .config(function($routeProvider) {
     
      $routeProvider
        .when('/projeto', {
          controller:'ProjetoListController as projetoListCtrl',
          templateUrl:'module/experimento/projeto/list.html'
        })
        .when('/projeto/edit/:id', {
          controller:'ProjetoEditController as projetoEditCtrl',
          templateUrl:'module/experimento/projeto/form.html'
        })
        .when('/novoProjeto', {
          controller:'ProjetoEditController as projetoEditCtrl',
          templateUrl:'module/experimento/projeto/form.html'
        })
        
        .otherwise({
          redirectTo:'/'
        });
    })
     
    .controller('ProjetoListController', function($scope, $http) {
    	$http.get('resources/projetosDePesquisa/all').success(function(projetos) {
    		$scope.projetos = projetos;
		});
    })
     
    .controller('ProjetoEditController', function($scope, $location, $routeParams, $http, projetoDePesquisaResource) {
    	
    	$scope.etapa = 'Inserindo';
    	
    	$scope.projeto = {};
    	$scope.projeto.pesquisadores = [];
    	$scope.projeto.animais = [];
    	
    	if($routeParams.id != undefined) {
    		projetoDePesquisaResource.get({id:$routeParams.id}, function(projeto) {    			
				$scope.projeto = projeto;
				$scope.etapa = 'Editando';
			});	
		}
    	
    	$scope.salvar = function() {
    		projetoDePesquisaResource.save($scope.projeto,
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
	  			projetoDePesquisaResource.delete({id: id},
					function() {
	  					$scope.voltar();
					});
  			}
		};
		
		$scope.cancelar = function() {
			$scope.voltar();
    	};
    	
    	$scope.voltar = function() {
    		$location.path('/projeto');
    	};
		
		//tipos de pesquisa
		$http.get('resources/projetosDePesquisa/tiposDePesquisa').success(function(data) {
    		$scope.tiposDePesquisa = data;
		});
		
		//orientadores
		$http.get('resources/projetosDePesquisa/orientadores').success(function(data) {
    		$scope.orientadores = data;
		});
		
		//pesquisadores para o picklist
		$http.get('resources/projetosDePesquisa/pesquisadores').success(function(data) {
    		$scope.pesquisadores = data;
		});
		
		$scope.adicionarPesquisador = function(index, p) {
			$scope.projeto.pesquisadores.push(p);
		    $scope.pesquisadores.splice(index, 1);
		};

		$scope.removerPesquisador = function(index, p) {
		    $scope.projeto.pesquisadores.splice(index, 1);
		    $scope.pesquisadores.push(p);
		};
		
		//animais para o picklist
		$http.get('resources/projetosDePesquisa/animais').success(function(data) {
    		$scope.animais = data;
		});
		
		$scope.adicionarAnimal = function(index, a) {
			$scope.projeto.animais.push(a);
		    $scope.animais.splice(index, 1)
		};

		$scope.removerAnimal = function(index, a) {
		    $scope.projeto.animais.splice(index, 1)
		    $scope.animais.push(a);
		};
    })
    
    .factory('projetoDePesquisaResource', function ($resource) {
    	return $resource('resources/projetosDePesquisa/:id');
    });
