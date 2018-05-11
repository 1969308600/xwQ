/**
 * 原生路由 设置controller
 */
define([], function() {

        var $controllerProvider;

        function setControllerProvider(value) {
                $controllerProvider = value;
        }

        function config(templateUrl, controllerName) {
                if (!$controllerProvider) {
                        throw new Error("$controllerProvider is not set!");
                }

                var defer,
                        routeDefinition = {};
                routeDefinition.templateUrl = templateUrl;
                //新增controller属性，
                routeDefinition.controller = controllerName;
                routeDefinition.resolve = {
                        delay: function($q, $rootScope) {
                                defer = $q.defer();
                                var dependencies = [controllerName];
                                require(dependencies, function() {
                                        var controller = arguments[0];
                                        //在这里猜测可以注入依赖。
                                        $controllerProvider.register(controllerName, controller);
                                        defer.resolve();
                                        $rootScope.$apply()
                                })
                                return defer.promise;
                        }
                }
                return routeDefinition;
        }

        return {
                setControllerProvider: setControllerProvider,
                config: config
        }
	})