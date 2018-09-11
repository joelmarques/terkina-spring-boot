'use strict';

    angular.module('fichaClinica', ['ngRoute', 'ngResource'])
     
    .config(function($routeProvider) {
     
      $routeProvider
        .when('/animais/:idAnimal/:nomeAnimal/fichaClinica', {
          controller:'FichaClinicaEditController as fichaClinicaEditCtrl',
          templateUrl:'module/ficha/clinica/form.html'
        })
        
        .otherwise({
          redirectTo:'/'
        });
    })
     
    .controller('FichaClinicaEditController', function($scope, $location, $routeParams, $http, fichaClinicaResource) {
    	
    	$scope.nomeAnimal = $routeParams.nomeAnimal;
    	$scope.fichaClinica = {};
    	$scope.biometria = {};
    	$scope.manejo = {};
    	$scope.denticao = {};
    	$scope.dadoSanitario = {};
    	$scope.historicoClinico = {};
    	$scope.reproducao = {};
    	
    	$http.get('resources/fichasClinicas/fichaClinica?idAnimal='+$routeParams.idAnimal).success(function(fichaClinica) {
    			
    		$scope.fichaClinica = fichaClinica;
		});
    	
    	$scope.voltar = function() {
    		$location.path('/animais');
    	};
    	
    	//para o mini-crud de peso e biometria
		$scope.editarBiometria = function(biometria) {
			$scope.biometria = biometria;
		};
		
		$scope.salvarBiometria = function () {
			
			$scope.biometria.idAnimal = $routeParams.idAnimal;
			
			$http.put('resources/fichasClinicas/salvarBiometria', $scope.biometria).success(function(biometria) {
				
				if ($scope.biometria.id == null) {
					$scope.fichaClinica.biometrias.push(biometria);				
				}
				
				$scope.biometria = {};
			});
		};
		
        $scope.calendarioDataBiometria = {
            aberto: false
        };
         
        $scope.abrirCalendarioDataBiometria = function() {
            $scope.calendarioDataBiometria.aberto = true;
        };
        //fim biometria
        
        //para o mini-crud de manejo
		$scope.editarManejo = function(manejo) {
			$scope.manejo = manejo;
		};
		
		$scope.salvarManejo = function () {
			
			$scope.manejo.idAnimal = $routeParams.idAnimal;
			
			$http.put('resources/fichasClinicas/salvarManejo', $scope.manejo).success(function(manejo) {
				
				if ($scope.manejo.id == null) {
					$scope.fichaClinica.manejos.push(manejo);				
				}
				
				$scope.manejo = {};
			});
		};
		
        $scope.calendarioDataManejo = {
            aberto: false
        };
         
        $scope.abrirCalendarioDataManejo = function() {
            $scope.calendarioDataManejo.aberto = true;
        };
        //fim manejo
        
        //para o mini-crud de denticao
		$scope.editarDenticao = function(denticao) {
			$scope.denticao = denticao;
		};
		
		$scope.salvarDenticao = function () {
			
			$scope.denticao.idAnimal = $routeParams.idAnimal;
			
			$http.put('resources/fichasClinicas/salvarDenticao', $scope.denticao).success(function(denticao) {
				
				if ($scope.denticao.id == null) {
					$scope.fichaClinica.denticoes.push(denticao);				
				}
				
				$scope.denticao = {};
			});
		};
		
        $scope.calendarioDataDenticao = {
            aberto: false
        };
         
        $scope.abrirCalendarioDataDenticao = function() {
            $scope.calendarioDataDenticao.aberto = true;
        };
        //fim denticao
        
        //para o mini-crud de dados sanitarios
		$scope.editarDadoSanitario = function(dadoSanitario) {
			$scope.dadoSanitario = dadoSanitario;
		};
		
		$scope.salvarDadoSanitario = function () {
			
			$scope.dadoSanitario.idAnimal = $routeParams.idAnimal;
			
			$http.put('resources/fichasClinicas/salvarDadoSanitario', $scope.dadoSanitario).success(function(dadoSanitario) {
				
				if ($scope.dadoSanitario.id == null) {
					$scope.fichaClinica.dadosSanitarios.push(dadoSanitario);				
				}
				
				$scope.dadoSanitario = {};
			});
		};
		
        $scope.calendarioDataDadoSanitario = {
            aberto: false
        };
         
        $scope.abrirCalendarioDataDadoSanitario = function() {
            $scope.calendarioDataDadoSanitario.aberto = true;
        };
        
        $scope.calendarioDataVermifugacao = {
            aberto: false
        };
         
        $scope.abrirCalendarioDataVermifugacao = function() {
            $scope.calendarioDataVermifugacao.aberto = true;
        };
        //fim dado sanitario
        
        //para o mini-crud de historico clinico
		$scope.editarHistoricoClinico = function(historicoClinico) {
			$scope.historicoClinico = historicoClinico;
		};
		
		$scope.salvarHistoricoClinico = function () {
			
			$scope.historicoClinico.idAnimal = $routeParams.idAnimal;
			
			$http.put('resources/fichasClinicas/salvarHistoricoClinico', $scope.historicoClinico).success(function(historicoClinico) {
				
				if ($scope.historicoClinico.id == null) {
					$scope.fichaClinica.historicosClinicos.push(historicoClinico);				
				}
				
				$scope.historicoClinico = {};
			});
		};
		
        $scope.calendarioDataHistoricoClinico = {
            aberto: false
        };
         
        $scope.abrirCalendarioDataHistoricoClinico = function() {
            $scope.calendarioDataHistoricoClinico.aberto = true;
        };
        //fim historico clinico
        
        //para o mini-crud de reproducao
		$scope.editarReproducao = function(reproducao) {
			$scope.reproducao = reproducao;
		};
		
		$scope.salvarReproducao = function () {
			
			$scope.reproducao.idAnimal = $routeParams.idAnimal;
			
			$http.put('resources/fichasClinicas/salvarReproducao', $scope.reproducao).success(function(reproducao) {
				
				if ($scope.reproducao.id == null) {
					$scope.fichaClinica.reproducoes.push(reproducao);				
				}
				
				$scope.reproducao = {};
			});
		};
		
        $scope.calendarioDataReproducao = {
            aberto: false
        };
         
        $scope.abrirCalendarioDataReproducao = function() {
            $scope.calendarioDataReproducao.aberto = true;
        };
        //fim reproducao
        
    })
    
    .factory('fichaClinicaResource', function ($resource) {
    	return $resource('resources/fichasClinicas/:id');
    });
