'use strict';

    angular.module('sessaoExperimento', ['ngRoute', 'ngResource'])
     
    .config(function($routeProvider) {
     
      $routeProvider
        .when('/projetos/:idProjeto/:tituloProjeto/sessoes', {
          controller:'SessaoExperimentoListController',
          templateUrl:'module/experimento/sessao/list.html'
        })
        .when('/projetos/:idProjeto/:tituloProjeto/sessoes/edit/:id', {
          controller:'SessaoExperimentoEditController',
          templateUrl:'module/experimento/sessao/form.html'
        })
        .when('/projetos/:idProjeto/:tituloProjeto/sessoes/novo', {
        	controller:'SessaoExperimentoEditController',
            templateUrl:'module/experimento/sessao/form.html'
        })
        
        .otherwise({
          redirectTo:'/'
        });
    })
    
    .controller('SessaoExperimentoListController', function($scope, $routeParams, $http, $location) {
    	
    	$http.get('resources/sessoesDeExperimento/sessoes?idProjeto='+$routeParams.idProjeto).success(function(sessoes) {
    		$scope.sessoes = sessoes;
		});
    	
    	$scope.tituloProjeto = $routeParams.tituloProjeto;
		
		$scope.novo = function() {
			$location.path('/projetos/' + $routeParams.idProjeto + '/' + $routeParams.tituloProjeto + '/sessoes/novo');
		};
		
		$scope.editar = function(id) {
			$location.path('/projetos/' + $routeParams.idProjeto + '/' + $routeParams.tituloProjeto + '/sessoes/edit/'+id);
		};
    })
    
    .controller('SessaoExperimentoEditController', function($scope, $routeParams, $http, $location, sessaoExperimentoResource){
    	
    	$scope.tituloProjeto = $routeParams.tituloProjeto;
    	
    	$scope.arquivo = {};
        $scope.arquivos = [];
        $scope.tiposArquivos = [];
    	
    	$http.get('resources/sessoesDeExperimento/disciplinas').success(function(disciplinas) {
    		$scope.disciplinas = disciplinas;
		});
    	
    	$http.get('resources/sessoesDeExperimento/pesquisadores?idProjeto='+$routeParams.idProjeto).success(function(pesquisadores) {
    		$scope.pesquisadores = pesquisadores;
		});
    	
    	$http.get('resources/sessoesDeExperimento/animais?idProjeto='+$routeParams.idProjeto).success(function(animais) {
    		$scope.animais = animais;
		});
    	
    	if($routeParams.id == undefined) {    		
    		$scope.etapa = 'Inserindo';
        	$scope.sessao = {};
        	$scope.sessao.idProjeto = $routeParams.idProjeto;
        	$scope.sessao.pesquisadores = [];
        	$scope.sessao.animais = [];
    	}
    	
    	if($routeParams.id != undefined) {
    		$scope.etapa = 'Editando';
    		sessaoExperimentoResource.get({id:$routeParams.id}, function(sessao) {    			
				$scope.sessao = sessao;
				$scope.sessao.idProjeto = $routeParams.idProjeto;
				$scope.arquivos = sessao.arquivos;
			});	
		}
    	
    	$scope.adicionarPesquisador = function(index, p) {
			$scope.sessao.pesquisadores.push(p);
		    $scope.pesquisadores.splice(index, 1);
		};

		$scope.removerPesquisador = function(index, p) {
		    $scope.sessao.pesquisadores.splice(index, 1);
		    $scope.pesquisadores.push(p);
		};
		
		$scope.adicionarAnimal = function(index, a) {
			$scope.sessao.animais.push(a);
		    $scope.animais.splice(index, 1)
		};

		$scope.removerAnimal = function(index, a) {
		    $scope.sessao.animais.splice(index, 1)
		    $scope.animais.push(a);
		};
    	
    	$scope.cancelar = function() {
    		$scope.voltar();
    	};
    	
    	$scope.voltar = function() {
    		$location.path('/projetos/' +$routeParams.idProjeto +'/' + $routeParams.tituloProjeto + '/sessoes');
    	};
    	
    	$scope.salvar = function() {
    		$scope.sessao.arquivos = $scope.arquivos;
    		sessaoExperimentoResource.save($scope.sessao,
				function() {
					alert('Operação realizada com sucesso!');
					$scope.voltar();
				},
				function() {
					alert('Erro!'); 
				});
  		};
  		
  		//para o mini-crud de arquivos
        $http.get('resources/sessoesDeExperimento/tiposArquivos').success(function(tiposArquivos) {
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
    
    .factory('sessaoExperimentoResource', function ($resource) {
    	return $resource('resources/sessoesDeExperimento/:id');
    });