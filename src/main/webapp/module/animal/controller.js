'use strict';

    angular.module('animal', ['ngRoute', 'ngResource'])
     
    .config(function($routeProvider) {
     
      $routeProvider
        .when('/animais', {
          controller:'AnimalListController as animalListCtrl',
          templateUrl:'module/animal/list.html'
        })
        .when('/animais/edit/:id', {
          controller:'AnimalEditController as animalEditCtrl',
          templateUrl:'module/animal/form.html'
        })
        .when('/novoAnimal', {
          controller:'AnimalEditController as animalEditCtrl',
          templateUrl:'module/animal/form.html'
        })
        
        .otherwise({
          redirectTo:'/'
        });
    })
     
    .controller('AnimalListController', function($scope, $http) {
    	$http.get('resources/animais/all').success(function(animais) {
    		$scope.animais = animais;
		});
    })
     
    .controller('AnimalEditController', function($scope, $location, $routeParams, $http, animalResource) {
    	
    	$scope.etapa = 'Inserindo';
    	
    	$scope.animal = {};    	
    	$scope.arquivo = {};
        $scope.arquivos = [];
        $scope.tiposArquivos = [];
        
    	if($routeParams.id != undefined) {
    		animalResource.get({id:$routeParams.id}, function(animal) {
				$scope.animal = animal;
				$scope.arquivos = animal.arquivos;
				$scope.etapa = 'Editando';
			});	
		}
    	
    	$http.get('resources/animais/especies').success(function(especies) {
			$scope.especies = especies;
		});
    	
    	$http.get('resources/animais/localizacoes').success(function(localizacoes) {
			$scope.localizacoes = localizacoes;
		});
    	
    	$http.get('resources/animais/sexos').success(function(sexos) {
			$scope.sexos = sexos;
		});
    	
    	$http.get('resources/animais/situacoes').success(function(situacoes) {
    		$scope.situacoes = situacoes;
    	});
    	
    	$scope.onChangeFoto = function(inputElement) {
    		
    		onChangeURLDaFotoNoGoogleDrive(inputElement);
    	};
		
		$scope.salvar = function() {
			$scope.animal.arquivos = $scope.arquivos;
			animalResource.save($scope.animal,
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
  				animalResource.delete({id: id},
					function() {
	  					$scope.voltar();
					});
  			}
		};
		
		$scope.cancelar = function() {
			$scope.voltar();
    	};
    	
    	$scope.voltar = function() {
    		$location.path('/animais');
    	};
		
		$scope.calendarioDataNascimento = {
            aberto: false
        };
         
        $scope.abrirCalendarioDataNascimento = function() {
            $scope.calendarioDataNascimento.aberto = true;
        };
        
        //para o mini-crud de arquivos
        $http.get('resources/animais/tiposArquivos').success(function(tiposArquivos) {
			$scope.tiposArquivos = tiposArquivos;
		});
        
		$scope.adicionarArquivo = function () {
			
			if ($scope.arquivo.id == null) {
				$scope.arquivos.push($scope.arquivo);				
			}
			
			$scope.arquivo = {};
		};
		
		$scope.editarArquivo = function(arquivo) {
			$scope.arquivo = arquivo;
		};
		
		$scope.excluirArquivo = function(index) {
			if (confirm('Deseja realmente excluir? A exclusão não poderá ser desfeita!')) {
				$scope.arquivos.splice(index, 1);
			}
		};
    })
    
    .factory('animalResource', function ($resource) {
    	return $resource('resources/animais/:id');
    });
