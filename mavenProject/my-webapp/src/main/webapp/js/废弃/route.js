define([ 'app' ], function(app) {
	debugger
	app.config(function($stateProvider) {
		setTimeout(function() {
			var scope = angular.element(
					$('div[ ng-controller="myAppController"]')).scope();
			// TemplateURl相对于index.html路径，Controller相对于route.js路径
			scope.menus.forEach(function(value) {
				if (value.urlKey) {
					$stateProvider.state(value.urlKey, {
						url : "/" + value.urlKey,
						templateUrl : value.urlHtml,
						controllerUrl : value.urlCtrl
					});
				}
			});

			app.run(function($state) {
				$state.go('menu');
			});
		}, 500);

	}); 

})