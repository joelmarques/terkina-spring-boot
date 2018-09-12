'use strict';

    angular.module('empresa', ['ngRoute', 'ngResource'])
     
    .config(function($routeProvider) {
     
      $routeProvider
        .when('/empresas/edit', {
          controller:'EmpresaEditController as empresaEditCtrl',
          templateUrl:'module/empresa/form.html'
        })
                
        .otherwise({
          redirectTo:'/'
        });
    })
     
    .controller('EmpresaEditController', function($scope, $http, $location, empresaResource) {
    	
    	$scope.empresa = {};
    	$scope.arquivo = {};
        $scope.arquivos = [];
        $scope.tiposArquivos = [];
        
        startEmpresaFormController();
        
        function startEmpresaFormController() {
        	$scope.arquivo = {};
            $scope.arquivos = [];
            
        	$http.get('resources/empresas/empresaDoUsuarioLogado').success(function(empresa) {
        		
        		if (empresa != null) {
        			$scope.empresa = empresa;        			
        		}
        		
    			if ($scope.empresa.arquivos != null) {
        			$scope.arquivos = $scope.empresa.arquivos;
        		}
    		});
        }
    	
    	$scope.salvar = function() {
    	  $scope.empresa.arquivos = $scope.arquivos;
    	  empresaResource.save($scope.empresa,
  					function() {
      		  			alert('Operação realizada com sucesso');
      		  			startEmpresaFormController();	      		  		
  					},
  					function(){ alert('Erro!'); });
  		};
  		
  		//para o mini-crud de arquivos
        $http.get('resources/empresas/tiposArquivos').success(function(tiposArquivos) {
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
     
    .factory('empresaResource', function ($resource) {
    	return $resource('resources/empresas/:id');
    });
