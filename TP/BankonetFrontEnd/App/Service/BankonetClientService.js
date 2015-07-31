"use strict"

angular.module("BankonetClient")

	.factory('BankonetClientService', function($http){
				return {
				
				getAllEmployes : function (){
						return $http.get('http://localhost:8080/spring/rest/listclients/')
							.then( function (resulte) {
								return resulte.data
							})
						},
				};
	})