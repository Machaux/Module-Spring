"use strict"

angular.module("BankonetClient")

	.controller('EmployeController', function(BankonetClientService){
				
				var employeCtrl = this;

				console.log('je suis dans le controlleur');
				

				employeCtrl.employes = [];

				

				BankonetClientService.getAllEmployes()
					.then(function(employes)
						{
							employeCtrl.employes=employes;
						}
					)				
	});