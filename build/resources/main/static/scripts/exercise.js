/**
 * Created by yoontaesup on 2015. 4. 16..
 */


var myApp = angular.module('myApp', []);

myApp.controller('FoodCourtCtrl', ['$scope', '$http', function ($scope, $http) {

    $scope.obj = {};
    $scope.editObj = {};
    $scope.is_foodcourt_name = '푸드코트';

    $scope.items = ['푸드코트', '독립매장', '푸드코트 내 독립매장'];


    $http({
        method: 'GET',
        //url: '//localhost:1450/admin/store/foodcourt'
        url: '//localhost:1450/test/store/near'
    })
    .success(function (data, status, headers, config) {
        $scope.storesResponse = data;

    })
    .error(function (data, status, headers, config) {
    });

    $scope.click = function() {
        $http({
            method: 'POST',
            params: $scope.obj,
            url: '//localhost:1450/admin/foodcourt/insert'
        })
        .success(function (data, status, headers, config) {
            $scope.storesResponse = data;

        })
        .error(function (data, status, headers, config) {
        });
    }

    $scope.select = function(selectObj) {
        //console(selectObj);
        $scope.editObj = selectObj;
        $scope.editObj.latitude = selectObj["location"][0];
        $scope.editObj.longitude = selectObj["location"][1];
    }

    $scope.onSelectChange = function() {
        var params = {};
        params.is_foodcourt_name = $scope.is_foodcourt_name;

        $http({
            method: 'GET',
            params: params,
            url: '//localhost:1450/admin/foodcourt/type'
        })
            .success(function (data, status, headers, config) {
                $scope.storesResponse = data;
            })
            .error(function (data, status, headers, config) {

            });
    }.bind($scope);

    $scope.delete = function() {

    }

}]);
