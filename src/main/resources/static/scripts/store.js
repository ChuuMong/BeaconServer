/**
 * Created by yoontaesup on 2015. 4. 15..
 */
var admin = angular.module('adminApp', [
    'ngRoute',
    'adminControllers',
    'adminFilters',
    'adminServices'
]);

phonecatApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/near', {
                templateUrl: 'test/store/near',
                controller: 'StoreListCtrl'
            }).
            otherwise({
                redirectTo: '/index.html'
            });
    }]);